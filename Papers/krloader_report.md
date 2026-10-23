# Malware Static Analysis Report — KrLoader-1.0.jar

| Field | Value |
|---|---|
| Sample | `KrLoader-1.0.jar` (363,524 bytes) |
| MD5 | `67B23CD61E2C32E51D91CBF2C5F18B52` |
| SHA-1 | `296DEB26CBC2955FB652BF92CD4E103B461E001F` |
| SHA-256 | `D3A580362B0D649997C2A9BEE32E20ABEE65EA7B6F9ED7BED9181F24E81C8C77` |
| True type | ZIP / Java JAR (Fabric mod, MC 1.21, Java ≥21) + 2 embedded PE DLLs |
| Date analyzed | 2026-08-22 |
| Analyst | ox-alpha (static analysis only) |

## Verdict

**MALICIOUS — high confidence.** Stage-1 credential stealer / loader of the **WeedHack MaaS ("Weedhack"/Majanito) operation**, matching the variant publicly described as "**LoaderClient**" (v2-style: JNIC native protection + blockchain C2). Disguised as a Fabric mod ("Best Donut Mod"), it steals the Minecraft session token, exfiltrates it to attacker infrastructure resolved via an Ethereum smart contract, and loads a fileless stage-2 RAT/stealer (`dev.majanito.Main`).

Confidence basis: complete decompilation of the Java layer; both obfuscation layers (seeded table cipher + invokedynamic call-hider) reversed and every hidden string/API call decoded; all core indicators byte-match the same operator's other builds (identical contract address, selector, RSA public key, endpoints).

## Key finding — JNIC native protection

The entire malicious logic is compiled to native code with **JNIC** (jnic.dev):

- Entrypoint `pedroisgayv` (registered for preLaunch + main + client): `onInitialize`/`onPreLaunch`/`onInitializeClient` are **native methods**; a large set of native helpers replaces reflection/classloading/string ops.
- Loader class `a.b39773609aebe8e59.a`: extracts `native/39773609aebe8e59/{arch}-{os}` from the JAR to `%TEMP%\jvmtp-39773609aebe8e59-*.dll` and calls `System.load()` in a static initializer.
- Embedded natives: `x86_64-windows` (509,440 B) and `aarch64-windows` (530,944 B), both valid PEs exporting only `Java_a_b39773609aebe8e59_a_init`, importing only `VirtualProtect`/`VirtualQuery` (+ CRT), with an encrypted `.data` section at exactly **7.00 entropy**. Fake old timestamps (2001/2002). The encrypted Java bytecode lives inside these DLLs.

Despite this, enough survived in the Java layer (bootstrap metadata, string decryptor inputs, invokedynamic signatures) to fully reconstruct behavior — see below.

## Reconstructed behavior (from decoded Java layer)

1. Fabric `preLaunch` triggers JNIC native init (earliest possible stage).
2. `kewc.besf5.t3ontcz.DulKv.onInitialize()`: obtains Minecraft session → harvests **username, UUID, accessToken**.
3. Builds JSON context: `{"executionEnvironment":"Fabric","minecraftInfo":{"username":...,"uuid":...,"accessToken":...},"userId":"cdd17c3f-5a54-4c2e-8172-6c22f4f52b91"}`.
4. Resolves C2 domain via Ethereum dead-drop resolver `EPRf` (see below); POSTs credentials to `https://<C2>/api/delivery/handler`.
5. Spawns thread → `AvRxqi` downloads JAR from `https://<C2>/files/jar/module`, parses it **in-memory** (`JarInputStream`, never written to disk), loads classes through custom ClassLoader `kewc.besf5.t3ontcz.kz`, reflectively invokes **`dev.majanito.Main.initializeWeedhack(String)`** with the context.
6. Standalone path (manifest Main-Class `kJsn`): if `--jw` absent, relaunches self via `{java.home}\bin\javaw.exe -jar <self> --jw` and exits (console suppression + anti-analysis gate); then runs stage-2 fetch without session context (`executionEnvironment: DoubleClick`).
7. Network layer `YQ` = raw-socket HTTP(S) client: **trust-all TrustManager**, DNS-over-HTTPS pre-resolution (Cloudflare/Google), chunked-transfer support — identical design to the operator's other builds.

### C2 resolution (Ethereum dead-drop resolver)
- ~30 hardcoded public ETH mainnet RPC endpoints (llamarpc, publicnode, flashbots, mevblocker variants, etc. — full list in appendix).
- `eth_call {to: 0x1280a841Fbc1F883365d3C83122260E0b2995B74, data: 0xce6d41de}` → ABI string `<C2_URL>|<RSA_SIGNATURE>`.
- Signature verified against embedded RSA-2048 key (`SHA256withRSA`) — **same key as Prestige/Krypton builds**, pinning one operator across campaigns.
- Per public reporting (McAfee, DarkAtlas, 0xresetti), this contract has rotated C2 domains repeatedly (whnewreceive[.]ru → fucktermedfir[.]st → …); do not treat any single domain as a durable block.

### Stage-2 capabilities (from public analysis of Module.jar — NOT confirmed by execution here)
Windows Defender exclusion tampering, CMSTP UAC bypass (`.xdmf`), scheduled-task persistence, telemetry exfil, and premium RAT features (keylogger, webcam, screen share) delivered as later stages; the operator is also documented backdooring its own customers' builds with PureLogs/HVNC payloads.

## Obfuscation inventory
| Layer | Implementation | Reversed? |
|---|---|---|
| String encryption | Seeded per-caller cipher `TeHbUex.HvbxU(seed, str)` — caller-class-hash ^ seed ^ 0x849D7639 keyed 256-byte table XOR on UTF-16 halves | Yes — 116 strings recovered (appendix) |
| Call hiding | Invokedynamic bootstrap `iR.MKOjc` — XOR 0x9891 / 0x40 encoded class/method/descriptor resolved reflectively | Yes |
| Native protection | JNIC — bytecode moved into encrypted `.data` of embedded DLLs | Partially (behavior reconstructed from surviving layer) |
| Junk code | Dead arithmetic branches, opaque predicates throughout | Noted |

## MITRE ATT&CK mapping
| Technique | ID |
|---|---|
| Steal Application Access Token | T1528 |
| Exfiltration Over C2 Channel | T1041 |
| Dead Drop Resolver (Ethereum contract) | T1102.001 |
| Encrypted channel / cert validation disabled | T1573 |
| Fileless in-memory stage loading | T1620 variant |
| System process: javaw relaunch w/ console suppression | T1218-adjacent |
| Virtualization/sandbox evasion: native-compiled logic | T1497-adjacent |
| Masquerading as benign mod | T1036 |

## Indicators of Compromise

| Type | Value | Context |
|---|---|---|
| sha256 (JAR) | `D3A580362B0D649997C2A9BEE32E20ABEE65EA7B6F9ED7BED9181F24E81C8C77` | this sample |
| sha256 (DLL x86_64) | `41D438916B379C6F8960767D656C1DA24580980D0B3E0890A597EE9F9793C375` | embedded native, single export `Java_a_b39773609aebe8e59_a_init` |
| sha256 (DLL aarch64) | `B134A19D561F319C9E7BEA64BE59BA29CBAA886EBCCFCBB23797FA0E11E08C5F` | embedded native |
| md5 (JAR) | `67B23CD61E2C32E51D91CBF2C5F18B52` | |
| eth-contract | `0x1280a841Fbc1F883365d3C83122260E0b2995B74` / selector `0xce6d41de` | shared across ALL observed builds of this operator |
| campaign GUID | `cdd17c3f-5a54-4c2e-8172-6c22f4f52b91` | MaaS buyer/victim-tracking UUID sent to C2 |
| license string | `KKOCQSKR8Z7SVE3UUOIEJI6WX8EUL` | embedded `licenseKey` file (buyer license) |
| uri-paths | `/api/delivery/handler` (POST exfil), `/files/jar/module` (GET stage-2) | |
| temp artifact | `%TEMP%\jvmtp-39773609aebe8e59-*.dll` | dropped native library |
| class/method | `dev.majanito.Main` / `initializeWeedhack` | stage-2 entrypoint |
| behavior | child proc `javaw.exe -jar <self> --jw`; DoH queries to cloudflare-dns.com/1.1.1.1/dns.google from java processes | |

## Limitations
- Method bodies behind JNIC natives were not decrypted/emulated; behavior was reconstructed from the surviving Java orchestration layer plus exact indicator matches. Confirming live C2 resolution or stage-2 delivery requires sandbox detonation (out of scope).
- The aarch64 DLL was structurally triaged only.

## YARA rules (drafted; verify syntax before deployment)

```yara
rule WeedHack_LoaderClient_KrLoader_stage1 {
    meta:
        family = "weedhack MaaS stage1 (LoaderClient v2, JNIC)"
        sample_sha256 = "d3a580362b0d649997c2a9bee32e20abee65ea7b6f9ed7bed9181f24e81c8c77"
        date = "2026-08-22"
    strings:
        $zip = { 50 4B 03 04 }
        $jnic_dir = "native/39773609aebe8e59/" ascii
        $guid = "cdd17c3f-5a54-4c2e-8172-6c22f4f52b91" ascii
        $contract = "0x1280a841Fbc1F883365d3C83122260E0b2995B74" ascii nocase
        $exfil = "/api/delivery/handler" ascii
        $module = "/files/jar/module" ascii
        $stage2 = "initializeWeedhack" ascii
        $tmpdll = "jvmtp-" ascii
    condition:
        $zip at 0 and ($jnic_dir or $tmpdll) and 2 of ($guid, $contract, $exfil, $module, $stage2)
}

rule WeedHack_shared_RSA_config_key {
    meta:
        description = "RSA pubkey verifying blockchain-delivered C2 config across weedhack-operator builds"
        note = "matches DER SubjectPublicKeyInfo prefix; also hits Prestige/Krypton builds"
    strings:
        $der = { 30 82 01 22 30 0D 06 09 2A 86 48 86 F7 0D 01 01 01 05 00 03 82 01 0F 00 30 82 01 0A 02 82 01 01 00 B2 66 37 }
    condition:
        $der
}
```

## Recommendations
- Block/alert on Ethereum RPC POST bodies containing `"method":"eth_call"` originating from `java.exe`/`javaw.exe`; this is the highest-signal network detection regardless of C2 rotation.
- Alert on `javaw.exe` spawning itself with `--jw`, and on `%TEMP%\jvmtp-*.dll` loads.
- If executed: revoke Minecraft/Microsoft session tokens (re-login everywhere), scan for `%TEMP%` artifacts and scheduled tasks per stage-2 reporting, consider credentials on the host compromised.
