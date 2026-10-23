# Krypton 1.21.11 Fabric Loader (Defender-Flagged) — Static Analysis

- Sample: `C:\MALWARE\Krypton-1.21.11.jar`
- Date: 2026-10-03
- Method: static only (no execution, no network). `javap -p -c -classpath`, ZIP inventory, Python string extraction, custom reimplementation of the `Helper.load` string decryptor.
- Companion: `krypton_loader.yar` (Rule 1 tested: 15/15 hits on raw JAR)

## 1. Summary

Verdict: **malicious — Fabric mod loader with encrypted strings, blockchain dead-drop C2 resolution, session beacon, and in-memory stage-2**. Confidence: **high**.

Basis:

- `com/example/*` loader (Entrypoint / ExampleMod / Helper / FabricAdapter / ExampleMixin) inside a `krypton 1.21.11` "Best DonutSMP cheat mod" cover. JAR is **STORED (uncompressed)**, 702,525 bytes, 286 entries (mostly bundled Gson).
- Dual execution: Fabric `ModInitializer` (`ExampleMod`) **and** `Main-Class: com.example.Entrypoint` for double-click runs (relaunch via `<java.home>/bin/javaw.exe -jar <self> --jw`, hidden console).
- Both paths beacon the Minecraft session (`username`, `uuid`, `accessToken`, `minecraftInfo`, `executionEnvironment` = `Fabric`/`DoubleClick`) via HTTP POST, then call `Helper.stageWithContext(json)`.
- C2 has **no hardcoded domain**. `FabricAdapter.getVerifiedText(id)` fans out across ~32 hardcoded Ethereum public RPCs with an `eth_call` (`0xce6d41de`) against on-chain data at `0x1280a841Fbc1F883365d3C83122260E0b2995B74`, splits `message|signature`, verifies RSA/SHA256 against a hardcoded 2048-bit key, and decodes the URL. Paths: `/api/delivery/handler` (beacon POST) and `/files/jar/module` (stage-2 GET).
- Stage-2 is fetched with plain GET (`Helper.dl`), parsed via `JarInputStream`, loaded with in-memory `ExampleMixin` ClassLoader (same pattern as the prior Optimizer11 `MemoryClassLoader`), instantiated via no-arg constructor, and invoked in a new Thread: `dev.majanito.Main#initializeWeedhack(...)`.
- All sensitive strings are encrypted with `Helper.load(int[],int[],int,int)` (interleave + affine sbox + chained xor + rotate + xor); recovered by reimplementation (full list in §3.6). Stage-2 (`dev.majanito.Main`) was **not** recovered.

## 2. Classification

- Type: trojanized cheat-mod loader / session stealer prep + second-stage downloader.
- Cover: `krypton` Fabric example template (`LICENSE_examplemod`, `ExampleMod`/`ExampleMixin` names, `fabric.mod.json` pointing at `github.com/FabricMC/fabric-example-mod`).
- String protection: custom `Helper.load` cryptor, uniform params `(p2=187, p3=67)` across all call sites observed.
- C2 resilience: on-chain dead-drop + RSA pinning + 32-way RPC redundancy. No DNS/IP to block except public RPCs (shared infrastructure — do not block).
- Defender flag is plausible (in-memory class loading + session exfil + hidden `javaw` relaunch), but the exact signature is unknown.

File identity:

| Field | Value |
|---|---|
| Path | `C:\MALWARE\Krypton-1.21.11.jar` |
| Size | 702,525 bytes, ZIP STORED |
| Entries | 286 (5 loader classes + bundled Gson) |
| SHA256 | `9557C0E00E5EC2E6689D5A69D98EF7D2B08380A1B3632FE6E0708BEB29F4E20C` |
| SHA1 | `FC7D3C464E59DA49118CD8AFF4348FDFC5E9A727` |
| MD5 | `EB603A2D99BD66CAB5125F9C5BCBCF7E` |
| Java | 21 (`Fabric-Loader 0.18.4`, MC `1.21`) |
| Mod | `krypton 1.21.11`, entry `com.example.ExampleMod`, `Main-Class: com.example.Entrypoint` |
| Config | `fabric.api.json` = `{"api_version": "ebb30233-08a9-4241-b91c-9712582410b7"}` |

## 3. Technical details

### 3.1 Container

Relevant entries (rest is Gson + proguard/maven metadata):

```text
com/example/Entrypoint.class   (3397, Main-Class, --jw/javaw relaunch)
com/example/ExampleMod.class   (7426, ModInitializer, beacon POST)
com/example/FabricAdapter.class(16867, ETH dead-drop resolver + RSA verify)
com/example/Helper.class       (9703, Helper.load cryptor + stageWithContext + dl)
com/example/ExampleMixin.class (1805, in-memory ClassLoader)
fabric.api.json                (55, api_version UUID)
fabric.mod.json                (460, krypton cover)
```

### 3.2 Execution paths

- **Fabric**: `ExampleMod.onInitialize()` prints `Mod init state: M0..M4`, collects `MinecraftClient.method_1551()` → Session (`method_1676/44717/1674`), builds the session JSON, resolves beacon URL = `getVerifiedText("0x1280...") + "/api/delivery/handler"`, POSTs JSON with `Content-Type: application/json` (response discarded, prints `[EFN] ern`), then starts Thread → `Helper.stageWithContext(json)`.
- **Double-click**: `Entrypoint.main()` → `checkJVMLauncher(args)`: if `--jw` (case-insensitive) present, continue; else `ProcessBuilder(<java.home>/bin/javaw.exe, -jar, <self>, --jw).start()` + `System.exit(0)`. Then builds JSON with `executionEnvironment=DoubleClick` and same `Helper.stageWithContext` thread. Effect: visible `java.exe` run is replaced by hidden `javaw.exe`.

### 3.3 `FabricAdapter.getVerifiedText` (dead-drop resolver)

- Iterates `CLIENTS` (~32 URLs, §3.6) → `callGetText(rpc, id)` → POST `{"jsonrpc":"2.0","method":"eth_call","params":[{"to":"%s","data":"%s"},"latest"],"id":1}` (timeouts set, `connectTimeout` 10s scale).
- `callGetText` returns `"result":"<hex>"` contents; first `len>3` result with a `|` separator wins: `message = before('|')`, `sig = after('|')`.
- `verify(message, sig)`: Base64-decode hardcoded RSA-2048 key → `KeyFactory(RSA)` → `Signature(SHA256withRSA).initVerify/verify`. On success `decode(message)`: require `0x` prefix handling, hex-length framing (`substring(64,128)` → `parseInt(16)`), return inner text (the URL/base).
- Failure mode is silent fallthrough to next RPC (resilient to single-RPC takedown).

### 3.4 `Helper.stageWithContext` (stage-2 fetch + exec)

1. Read `fabric.api.json` → `api_version` (`ebb30233-...`, used as build tag).
2. `url = getVerifiedText("0x1280...") + "/files/jar/module"`, `json.addProperty("userId", api_version)`.
3. `dl(url)` (plain GET, 200-only, prints `Resource state: D/D0`); null → `Resource state: S1` + return.
4. `JarInputStream`: `.class` → `classMap` (path `/`→`.`, strip `.class`), else `resourceMap` (`S2/S3/S4` logs).
5. Empty map → `S5-{}`/`S7-{}` + return. Else `new ExampleMixin(classMap, resourceMap)`.
6. `loadClass("dev.majanito.Main")` → no-arg `newInstance()` → new Thread → `lambda$stageWithContext$0`: `getMethod("initializeWeedhack", ...)` + `Gson.toJson(json)` + `Method.invoke` (`S6-{}` log). All exceptions print `Resource state:`/`getMessage()` lines — useful log hunt.

`ExampleMixin` itself is a minimal `ClassLoader` (`findClass`→`defineClass`, `getResourceAsStream` with `/`-strip), functionally identical to the prior case's `MemoryClassLoader`.

### 3.5 `Helper.load` cryptor (for repro)

Signature `static String load(int[] a, int[] b, int p2, int p3)`; observed `p2=187, p3=67` everywhere:

```text
s = interleave(a even, b odd)
sbox[i] = (i*53+97) % 256; inv[sbox[i]] = i
state = p3
for idx, v in enumerate(s):
  state = (state*37 + idx*13) % 256
  mask  = (p3 + state + idx*11) % 256
  x = v ^ (s[idx-1] if idx>0 else p3)
  rot = (idx*5 + p2) % 8
  y = x if rot==0 else ((x>>rot)|(x<<(8-rot))) & 0xFF
  emit chr(inv[y] ^ mask ^ p2)
```

Reimplemented in Python against `javap -c` dumps (parse `newarray int`/`iastore` sequences + the two int params before each `Helper.load`/`load:` call). YARA Rule 2 matches this decrypted output.

### 3.6 Decrypted strings (full)

- Config/keys: `executionEnvironment`, `Fabric`, `DoubleClick`, `username`, `uuid`, `accessToken`, `minecraftInfo`, `userId`
- On-chain pointer: `0x1280a841Fbc1F883365d3C83122260E0b2995B74`, selector `0xce6d41de`
- Paths: `/api/delivery/handler`, `/files/jar/module`
- Stage-2: `dev.majanito.Main`, `initializeWeedhack`
- RPC template + `Content-Type`/`application/json`, `"result":"`, `0x`, `RSA`, `SHA256withRSA`
- CLIENTS (~32): `eth.llamarpc.com`, `eth.api.onfinality.io/public`, `rpc.eth.gateway.fm`, `ethereum-rpc.publicnode.com`, `eth.rpc.blxrbdn.com`, `ethereum.rpc.subquery.network/public`, `ethereum-json-rpc.stakely.io`, `ethereum-public.nodies.app`, `core.gashawk.io/rpc`, `mainnet.gateway.tenderly.co`, `ethereum-mainnet.gateway.tatum.io`, `eth1.lava.build`, `eth.meowrpc.com`, `public-eth.nownodes.io`, `rpc.mevblocker.io/{fast,noreverts,fullprivacy,}`, `eth-mainnet.nodereal.io/v1/1659dfb40aa24bbb8153a677b98064d7`, `eth-mainnet.public.blastapi.io`, `ethereum.public.blockpi.network/v1/rpc/public`, `eth-mainnet.rpcfast.com?api_key=xbhWBI1...` (embedded key), `eth.drpc.org`, `eth.blockrazor.xyz`, `rpc.flashbots.net{,/fast}`, `gateway.tenderly.co/public/mainnet`, `rpc.fullsend.to`, `eth.merkle.io`, `api.zan.top/eth-mainnet`, `endpoints.omniatech.io/v1/eth/mainnet/public`, `1rpc.io/eth`
- RSA-2048 pubkey (Base64 DER): `MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmNzDf4737/iYWvscWg6vQg9dHa/yUchfQY9r5htNTLZ3ZDAbqrzN93I0ctZHa27oRnkpB7XpowI4NH8eIRmaMThggpTYRXzHzLvUjhyrFFPkIOo/HI1gZF5IV7/XmvYWqgEsSpxl0iesOUlaWO5A8QlTu0QLsZAzZtzZyLj/v1XbPT02rTvZkuRhE6nzpUR4GN3Jp4Bn8zQAWdFDe17PWZxOi19uUTMPzgFj9n3h7DprwBmE3fR7IMsbiFacAoSHfqkTpEwY7A8ArK1DQ1yJXPog/PQ4aTU9gU38WC20wtct796ImZiuRYdNWcSzHda5ZbvZdvpw6RHh0zQqGVhRQIDAQAB`

### 3.7 MITRE ATT&CK (inferred, static)

| Technique | Evidence |
|---|---|
| T1656 Impersonation (trojanized cheat mod) | `krypton` DonutSMP-cheat cover over example-mod template |
| T1140 Deobfuscate/Decode | `Helper.load` cryptor for all C2 strings |
| T1105 Ingress Tool Transfer | POST beacon + GET stage-2 JAR (`dl`, `JarInputStream`) |
| T1620 Reflective Code Loading | `ExampleMixin.defineClass` + `dev.majanito.Main` reflection |
| T1528 Steal Application Access Token | `accessToken`/`uuid`/`username` in beacon JSON |
| T1071.001 Web Protocols / T1573 Encrypted Channel | HTTPS POST/GET; RSA-pinned on-chain URLs |
| T1480 Blockchain dead-drop | ETH `eth_call` C2 resolution across 32 RPCs |
| T1036 Masquerading / T1027 | `javaw --jw` hidden relaunch; `Mod/Resource state` log camouflage |
| T1555 (potential, via stage-2) | `initializeWeedhack` unknown — needs stage-2 |

## 4. IOCs

Raw-visible (scan the JAR directly):

| Type | Value |
|---|---|
| SHA256/1/MD5 | see §2 |
| Entries | `com/example/Helper.class`, `FabricAdapter.class`, `ExampleMixin.class`, `Entrypoint.class` |
| Methods | `stageWithContext`, `getVerifiedText`, `callGetText`, descriptor `([I[III)` |
| Config | `fabric.api.json`, `ebb30233-08a9-4241-b91c-9712582410b7` |
| Logs | `Mod init state:`, `Resource state:`, `[EFN] ern` |
| Exec | `--jw`, `javaw.exe` |

Decrypted (memory/decryptor output only — **not** in raw JAR):

| Type | Value |
|---|---|
| On-chain id | `0x1280a841Fbc1F883365d3C83122260E0b2995B74`, selector `0xce6d41de` |
| Paths | `/api/delivery/handler`, `/files/jar/module` |
| Stage-2 | `dev.majanito.Main`, `initializeWeedhack` |
| RSA | 2048-bit key above, `SHA256withRSA` |
| RPCs | 32 URLs above (shared infra — hunt, don't block wholesale); note embedded `rpcfast` api_key |

Do **not** treat Gson/Modrinth/Fabric strings as IOCs.

## 5. Limitations

- Stage-2 missing: `initializeWeedhack` capability unknown (name suggests cheat/stealer hybrid, unconfirmed).
- On-chain C2 content not resolved (no network queries per static-only scope); current URLs unknown and rotatable by key holder.
- Defender's exact trigger not identified (likely in-memory load + session POST + javaw spawn heuristics).
- `api_version` UUID role (build tag vs. per-campaign) unconfirmed from one sample.

## 6. Recommendations

1. **Detect**: `krypton_loader.yar` Rule 1 on raw JARs (entry names + cryptor + resolver + logs + `--jw`); Rule 2 on decryptor output/memory. Prior Optimizer11 rules do **not** match this family (verified by design — no shared markers).
2. **Hunt**: `mods/*.jar` with `com/example/FabricAdapter.class` + `stageWithContext`; logs for `Mod init state:`, `Resource state:`, `[EFN] ern`; EDR for `javaw.exe -jar *.jar --jw` and child HTTPS POSTs.
3. **Contain**: quarantine sample + any `dev.majanito.Main` artifacts; rotate Minecraft/Microsoft sessions and any secrets on hosts that ran it (assume `accessToken` exfiltrated on world join + on double-click run).
4. **Intel**: passive query of `0x1280...` via `eth_call(0xce6d41de)` across listed RPCs (sandbox only) to recover live C2 without touching the victim host; track `initializeWeedhack` naming for stage-2 clustering.
5. **Prevent**: mod allow-listing by hash; flag any Fabric JAR containing both `Main-Class` + `ModInitializer` dual-use or `([I[III)` cryptor descriptors.

---
*Appendix: `javap -c` dumps (`krypton_*.txt`), decryptor scripts (`decrypt_all*.py`), presence-check script, and `krypton_loader.yar` (compile- + match-tested) kept alongside this report. Raw decrypted-string list in §3.6 is the executable appendix for Rule 2.*
