# SilentNet Infostealer — Static Analysis of "Minecraft Client" JARs

**Analyst:** opencode (static analysis only)
**Date:** 2026-08-29
**Samples:** 6 JARs in `C:\Users\ferti\Desktop\zoo`
**Classification:** MALICIOUS — SilentNet MaaS infostealer, Stage-1 Java loader (high confidence)
**Cross-reference:** `C:\Users\ferti\Downloads\silentnet-main\silentnet-main` (prior full RE of the same family)

---

## 1. Summary

All six "client" JARs are reskins of the same SilentNet Stage-1 loader: a fake Fabric mod
(`fabric.mod.json` id `package`, name `Package`, authors `Package Team`) whose entrypoints resolve the
C2 domain from a Polygon smart contract, harvest the Minecraft session, download an encrypted stealer
bundle disguised as a PNG, and spawn an embedded portable Python runtime that exfiltrates browser
credentials, Discord tokens, crypto wallets, and Minecraft sessions to `/shard/*` endpoints.

- Corz Client.jar and Cyemer 1.21.11.jar are **byte-identical** (renamed copy).
- The other four differ only in permuted class names and a per-build encrypted embedded bundle.
- All share one byte-identical core (`enw_zo`, `krisc5`, `XrE_EYd`, `swpgcqpzer` + inners) and
  identical C2 configuration.

Verdict basis: decoded string artifacts (C2 endpoints, blockchain resolver, stealer spawn chain)
matched against the independently reverse-engineered reference. No dynamic execution was performed.

## 2. File hashes

| Sample | Size | SHA256 | MD5 |
|---|---|---|---|
| Aurora Client.jar | 5,454,458 | `da048c0d5556ece53de928ed82daf9f0d729db61c41588ab89e864fba8f61afc` | `eee55398e094a1b6c15816387c50ba19` |
| Corz Client.jar | 18,365,291 | `02e6ba895e5f3c5dd928f76eda6a9ceb738cc4d698797a21ff3fcbd04cf46e7e` | `3063ce376e47ef4647cbeb96b90279a7` |
| Cyemer 1.21.11.jar | 18,365,291 | (identical to Corz) | (identical) |
| Echo Client.jar | 8,010,505 | `3c4eaa05aa1854f4e7278200ae61ca8b649957a38afb3224a4fc8f10b2d23039` | `c32e2b8accde2e83a4e36ba14a2dceb7` |
| Krypton Client.jar | 6,240,732 | `0f0386d8a33f4c2fd250b5b302a6dfd33e650b07eae56a7da3c9d2d4a94b165d` | `baaa7e9d27b7b3c674a5d3276f920ae3` |
| Prestige cracked.jar | 6,961,925 | `10f75e639ae63187d9af9e472e6bd85d357c36a9b22a9619139822b654129a09` | `1012fc0b7d39ce00f3a7c4606dac3db2` |

### Embedded encrypted bundles (AES-128-CBC stage-1 payload per reference docs; entropy 8.00)

| Sample | Entry | Size | SHA256 |
|---|---|---|---|
| Aurora | `assets/gvqtlrtc.cache` | 5,308,416 | `f404a6e8535a65f0d6fc9c7797b2a69e7796268ff856861abdfb2eff8ef61daa` |
| Corz / Cyemer | `assets/qiynmngz.dat` | 18,219,008 | `4cef6affbf2eb02bd106e32d9a708a38f7f8ca456b35ba3d481022e3fc6c35a4` |
| Echo | `assets/twdwpekz.dat` | 7,864,320 | `ff6fc2f7fb4c1bde3ea56b03d4b75362d95d113afc1a55fc147da4c058edb0df` |
| Krypton | `assets/zyhuipmh.dat` | 6,094,848 | `6075a0800c8a5e941480846dccb789f473f39a35e1f80aa913bfd917c97c67cb` |
| Prestige | `assets/jolvecno.bin` | 6,815,744 | `26f254c65225259ad40fec222867abeabd6232b2b5db4899a2b1a8facf1a2104` |

## 3. Execution flow (statically reconstructed)

1. **Trigger** — Fabric `ModInitializer.onInitialize()` (`enw_zo` + per-jar second entrypoint), or
   manifest `Main-Class` (standalone "DoubleClick" path). Both branches are present in every JAR.
2. **Self-restart trampoline** — relaunches `javaw.exe`/`java.exe` (`java.home` + `bin`) with its own
   JAR and the gate argument `-restarted` (`XrE_EYd`) to avoid infinite respawn; input redirected
   from `NUL`, output to `_spawn.log` under the staging directory.
3. **Session theft** — `Minecraft.getInstance().getSession()` (Yarn `class_310.method_1551()` /
   `method_1548()`), reading username, session token (`method_1676`), UUID (`method_44717`).
4. **C2 resolution** — hardcoded Polygon RPC list → `eth_call` to contract
   `0x9c0a507300fd902787bb193d80fca5ce6e1bff9a`, selector `0xce6d41de` (`getDomain()`); hardcoded
   fallback `sltnnt.ru`; DNS-over-HTTPS fallback via `1.1.1.1` / `cloudflare-dns.com`
   (`/dns-query?dns=`, `application/dns-message`).
5. **Beacon** — POST `/shard/prefireMc` with headers `X-Runtime-Env: jre-embedded`,
   `X-Edge-Cache-Revalidate: stale-if-error`, Chrome 131 UA; response parsed for `prefireId`.
6. **Payload delivery** — GET `https://<domain>/cdn/v2/9f4e7a2c1b8d.png` (3 retries; "Downloaded N
   bytes, extracting from image...", "PNG extraction failed") — PNG-stego bundle; extracts a portable
   Python runtime ("Portable runtime ready") to
   `%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\`; embedded fallback bundle in `assets/*`
   (see hashes above).
7. **Stealer launch** — `python.exe -u main.py --env <b64> --tag <b64> --mcInfo <b64> --prefireId <id>`
   (env values include `"env":"Fabric"` or `"DoubleClick"`); logs to `_stealer.log`; submits game log
   (`logs/latest.log`, truncated) and runtime info (`user.name`, `os.name`, `java.version`) via
   `/shard/submitMinecraftLog` as `{"...","filename":"combined.log","mcUsername":...,"env":"Fabric-Detached"}`.
8. **Stealer capabilities** (per reference Stage-2 RE): Chromium/Firefox credentials + cookies, Discord
   tokens, crypto wallets + browser-extension seeds, SSH/FTP/VPN configs, `.minecraft` scraping,
   screenshots, system info; DLL injection via named pipe `\\.\pipe\NtProfileSync`.

## 4. MITRE ATT&CK mapping (static)

| Technique | ID | Evidence |
|---|---|---|
| Obfuscated Files or Information | T1027 | char-array XOR/SUB string encoding, opaque predicates |
| Steganography | T1027.003 | payload as `/cdn/v2/*.png` |
| Deobfuscate/Decode Files or Information | T1140 | runtime string decoding, runtime extraction |
| Masquerading: Match Legitimate Name/Location | T1036.005 | `%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex`, fake `Package` mod |
| Command and Scripting Interpreter: Python | T1059.006 | `python.exe -u main.py ...` spawn |
| System Owner/User Discovery | T1033 | `user.name` collection |
| System Information Discovery | T1082 | `os.name`, `java.version` |
| Credentials from Password Stores (Stage-2, per reference) | T1555 | browser credential theft |
| Steal Application Access Token | T1528 | Minecraft session token theft |
| Data from Local System | T1005 | `latest.log`, filesystem scanning (Stage-2) |
| Ingress Tool Transfer | T1105 | runtime/bundle download |
| Application Layer Protocol: Web Protocols | T1071.001 | custom HTTP/1.1 client, `/shard/*` |
| Application Layer Protocol: DNS (DoH) | T1071.004 | Cloudflare DoH fallback |
| Web Service: Dead Drop Resolver | T1102.001 | Polygon smart contract C2 rotation |
| Exfiltration Over C2 Channel | T1041 | `/shard/submit*` |

## 5. IOCs

### Network
| Indicator | Type | Note |
|---|---|---|
| `sltnnt.ru` | Domain | hardcoded fallback C2 (decoded in all builds) |
| `thisisafalsepositive.st` | Domain | blockchain-rotated C2 (reference, 2026-07-20) |
| `185.178.208.191` / `185.178.208.165` | IP | C2 / MaaS portal (reference) |
| `https://<c2>/cdn/v2/9f4e7a2c1b8d.png` | URL | payload download (this campaign) |
| `/cdn/e/[a-f0-9]{12}` | URL pattern | payload path (reference campaign) |
| `/shard/prefireMc` | URL | beacon |
| `/shard/submitMinecraftLog`, `/shard/submitData`, `/shard/submitFile`, `/shard/submitLogs` | URL | exfil |
| `X-Runtime-Env: jre-embedded` | HTTP header | beacon marker |
| `X-Edge-Cache-Revalidate: stale-if-error` | HTTP header | beacon marker |
| `x-cdn-origin-verify: trusted-upstream` | HTTP header | CDN header (reference) |
| `1.1.1.1`, `cloudflare-dns.com` | DoH | C2 DNS resolution fallback |
| `polygon-bor-rpc.publicnode.com`, `1rpc.io/matic`, `polygon.drpc.org`, `api.zan.top/polygon-mainnet`, `rpc-mainnet.matic.quiknode.pro`, `polygon-rpc.com`, `polygon.llamarpc.com`, `polygon-mainnet.public.blastapi.io` | Domains | Polygon RPC fallback list |
| Chrome 131 `Mozilla/5.0 (Windows NT 10.0; Win64; x64) ... Chrome/131.0.0.0 Safari/537.36` | UA | beacon UA |

### Blockchain / crypto
| Indicator | Note |
|---|---|
| Contract `0x9c0a507300fd902787bb193d80fca5ce6e1bff9a` | C2 domain resolver (`getDomain()`, selector `0xce6d41de`), Polygon mainnet |
| Wallet `0x6767c6496541b530a5d1d0eb9b80bd5c7bf56767` | operator wallet (reference) |
| Fernet key `74af664f79d1ef1436a4bf301788c7eb207570de60034b19d76df8e7aefc69b7` | all CDN payloads (reference VULN-05) — redact if sharing externally |

### Host
| Indicator | Note |
|---|---|
| `%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\` | staging dir; `python.exe`, `main.py`, `_spawn.log`, `_stealer.log` |
| `fabric.mod.json` with `"id":"package"`, `"Package Team"` | fake-mod masquerade |
| `d147602c-54bf-46aa-94dc-513e20869b7e` | build/prefireId fallback UUID (decoded) |
| `javaw.exe ... -restarted` | trampoline gate |
| `\\.\pipe\NtProfileSync` | Stage-2 DLL-injection pipe (reference) |

## 6. Detection rules

YARA (apply to extracted class files or unpacked JARs — entries are DEFLATE-compressed, so raw
on-disk JAR scans will miss constant-pool strings; for JARs, scan after `jar xf` or via archive
inspection):

```yara
rule SilentNet_Stage1_Java_Loader {
    meta:
        family = "SilentNet"
        type = "infostealer_loader"
        date = "2026-08-29"
    strings:
        $cls_shared1 = "com/github/krisc5" ascii
        $cls_shared2 = "com/github/XrE_EYd" ascii
        $cls_shared3 = "com/github/swpgcqpzer" ascii
        $cls_shared4 = "com/github/enw_zo" ascii
        $marker1 = "NtProfileIndex" ascii
        $marker2 = "jre-embedded" ascii
        $marker3 = "prefireMc" ascii
        $cf_magic = { CA FE BA BE }
    condition:
        uint32(0) == 0x04034b50 or $cf_magic at 0
        and 2 of ($cls_shared*) and 1 of ($marker*)
}
```

Sigma / hunting queries for host and proxy telemetry are in the reference README (`NtProfileIndex`
file events, `python.exe` under `Microsoft\Windows`, Polygon RPC outbound from non-browsers,
`NtProfileSync` pipe creation) and apply unchanged to this campaign.

## 7. Limitations

- Static analysis only: no detonation, so beaconing, actual payload content served today
  (`/cdn/v2/9f4e7a2c1b8d.png`), and the decrypted embedded bundles were not observed/extracted.
  Decryption of the embedded bundles (AES-128-CBC, per reference) is possible with the recovered key
  method but was not required for verdict.
- The live C2 domain cannot be confirmed statically beyond the hardcoded fallback; blockchain
  resolution is dynamic (reference PoC `poc_06_blockchain_resolver.py`).
- Stage-2 capabilities are attributed from the reference analysis, not re-derived here.

## 8. Recommendations

1. Treat all six JARs as malicious; do not run in any Minecraft profile (they execute on both Fabric
   load and plain double-click via manifest Main-Class).
2. Block network IOCs (Section 5) at DNS/proxy; monitor the Polygon contract for domain rotation.
3. Hunt for `%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\`, `_spawn.log`, `_stealer.log`,
   `-restarted` javaw child processes, and outbound `X-Runtime-Env: jre-embedded`.
4. If executed on a system: assume Minecraft session token, browser credentials, Discord tokens, and
   crypto wallet seeds are compromised — rotate credentials, invalidate sessions, re-image if EDR
   confirms Stage-2 activity.

## Appendix

- `appendix_decoded_strings.txt` — full decoded string dump (2,921 lines, all 6 samples), in this folder.
- Decompiled trees: `C:\Users\ferti\AppData\Local\Temp\opencode\zoo\decompiled\<sample>\` (CFR).
- Reference analysis: `C:\Users\ferti\Downloads\silentnet-main\silentnet-main\README.md`.
