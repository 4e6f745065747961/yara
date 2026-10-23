# Malware Static Analysis Report — Prestige-1.21.x.jar

| Field | Value |
|---|---|
| Sample | `Prestige-1.21.x.jar` (845,482 bytes) |
| MD5 | `B2296D108BB252C24E6351198988D775` |
| SHA-1 | `582AF10F4F401105E11EA4BA4829725964BACAAD` |
| SHA-256 | `1E4F261F09175EAF2C4A7A7FD6840792BF1DE8245EF761C52F026D87D7E53307` |
| True type | ZIP / Java JAR (Fabric mod), magic `50 4B 03 04` |
| Target | Minecraft 1.21.x, Fabric Loader ≥0.16.5, Java ≥21 |
| Date analyzed | 2026-08-22 |
| Analyst | ox-alpha (static analysis only) |

## Verdict

**MALICIOUS — high confidence.** Disguised as a benign "Prestige Points" Fabric mod, the sample is a **stage-1 credential stealer and in-memory loader** belonging to the Minecraft mod malware campaign publicly documented as the *weedhack* / "GriftClient" operation. It steals the victim's Minecraft session credentials, exfiltrates them to attacker infrastructure, resolves its C2 domain through an **Ethereum smart-contract dead-drop resolver**, then downloads and executes an in-memory stage-2 payload (`dev.majanito.Main`).

Confidence basis: fully decompiled and manually reviewed code; every indicator below was read directly from the decompiled logic; loader components byte-match public reporting on the same campaign (identical contract address, function selector, RSA public key, endpoints, and stage-2 class/method names).

## Summary of behavior (static)

1. Loaded by Fabric as mod id `prestigemod`; entrypoint `org.transport.MixedEngine` runs at game init.
2. Harvests from the active Minecraft session: **username, UUID, and session accessToken** (`net.minecraft.class_320` calls).
3. Resolves the C2 domain via Ethereum: iterates ~30 hardcoded public ETH mainnet RPC endpoints, sends `eth_call {to: 0x1280a841Fbc1F883365d3C83122260E0b2995B74, data: 0xce6d41de}`, decodes the ABI string `<C2_URL>|<RSA_SIGNATURE>`, verifies the signature against an embedded RSA-2048 public key (`SHA256withRSA`). The attacker can rotate C2 domains with one on-chain transaction.
4. Immediately POSTs stolen credentials as JSON to `https://<C2>/api/delivery/handler`.
5. On a background thread, downloads a JAR from `https://<C2>/files/jar/module`, loads it **entirely in-memory** via a custom `ClassLoader` (`org.transport.ExampleMixin` — no disk artifact), reflectively instantiates `dev.majanito.Main`, and invokes `initializeWeedhack(String)` passing the credential JSON.
6. Standalone path (manifest `Main-Class: org.transport.ExternalChannel`, i.e. double-click execution): relaunches itself via `{java.home}\bin\javaw.exe -jar <self> --jw` (console-less, evades casual `java -jar` analysis; real logic gated behind the `--jw` flag), then performs steps 3–5 without Minecraft session context (`executionEnvironment: DoubleClick`).
7. Network layer (`PayloadHandler`) uses raw sockets instead of standard HTTP clients, **accepts any TLS certificate** (empty trust manager), and pre-resolves hostnames through **DNS-over-HTTPS** (Cloudflare `1.1.1.1`, Google) to evade local DNS monitoring/logging.

## Technical details

### Obfuscation
- All sensitive strings XOR-encrypted: first hex byte = key, remainder = key-XORed UTF-8 (`switchInput.d()`). 78 encoded constants decoded (see appendix file `prestige_appendix_decoded_strings.txt`).
- All identifiers renamed post-compilation to meaningless camelCase noise (`wrapper38`, `receiverPosition`, `nodeSink`…). Original source filenames survive in class debug info: `CloudflareDNS.java`, `Helper.java`, `Entrypoint.java`, `FabricAdapter.java`, `ExampleMod.java`.
- `fabric.mod.json` description text is copied boilerplate describing a legitimate "Prestige Points" gameplay mod — pure camouflage.

### Embedded configuration (reconstructed)
- Campaign ID GUID: `f5e6d7b2-499e-462d-907e-12b4a93f25a7` (present in both entry classes; sent to C2).
- Ethereum contract/wallet: `0x1280a841Fbc1F883365d3C83122260E0b2995B74`; selector `0xce6d41de` (returns signed C2 URL string).
- RSA-2048 public key for C2-config verification (SHA256withRSA), Base64:
  `MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmNzDf4737/iYWvscWg6vQg9dHa/yUchfQY9r5htNTLZ3ZDAbrqzN93I0ctZHa27oRnkpB7XpowI4NH8eIRmaMThgpTYYRzIzLxVpjyrFFPkIOo/HI1gZF5IV7/XmvYWqgEsSpxl0iesOUlaWO5A8QlTu0QLsZAzJtzIyTL/v1XbYP02rTvZkuRaE6nzpUR4GN3Jp4Bn8zQAWdFDe17PWXZOi19uUTMPzgFj9n3h7DprwBmE3fR7INsbiFacAoSHfqkTpEwY7A8ArK1DR1yJXPog/PQ4aTFU9gU38WC207tct796ImZiuRYdNWcSzHda5ZbvZdvpw6RHh0zQqGVhRQIDAQAB`
- ~30 hardcoded Ethereum RPC endpoints incl. `eth.llamarpc.com`, `ethereum-rpc.publicnode.com`, `rpc.flashbots.net`, `eth-mainnet.public.blastapi.io`, `rpc.mevblocker.io/*`, `eth.drpc.org`, etc. (full list in appendix).
- DoH resolvers: `https://cloudflare-dns.com/dns-query?name=%s&type=A`, `https://1.1.1.1/dns-query?...`, `https://dns.google/resolve?name=%s&type=A`.

### Encrypted blob
`assets/thread_silent.dat` — 820,224 bytes, entropy exactly 8.000 bits/byte, no recognizable magic → encrypted/compressed payload or resource reserved for stage 2. No reference to it exists anywhere in this JAR's code; it is presumably consumed by the downloaded stage-2 module. Contents could not be recovered statically.

### MITRE ATT&CK mapping
| Technique | ID |
|---|---|
| Steal Application Access Token (Minecraft/Microsoft session token) | T1528 |
| Exfiltration Over C2 Channel (HTTP POST of credentials) | T1041 |
| Dynamic Resolution: Dead Drop Resolver (Ethereum smart contract) | T1102.001 |
| Encrypted/encoded channel (XOR strings, raw TLS w/o validation) | T1573 |
| System Binary Proxy-ish Execution / console-less relaunch via javaw | T1218-adjacent |
| In-memory payload loading via custom ClassLoader (fileless stage 2) | T1620 (in-memory execution variant) |
| Masquerading: disguised Fabric mod name/description | T1036 |

## Indicators of Compromise

| Type | Value | Context |
|---|---|---|
| sha256 | `1E4F261F09175EAF2C4A7A7FD6840792BF1DE8245EF761C52F026D87D7E53307` | this sample |
| eth-contract | `0x1280a841Fbc1F883365d3C83122260E0b2995B74` | dead-drop C2 resolver (also selector `0xce6d41de`) |
| guid | `f5e6d7b2-499e-462d-907e-12b4a93f25a7` | campaign ID sent to C2 |
| uri-path | `/api/delivery/handler` | credential exfil endpoint (POST, application/json) |
| uri-path | `/files/jar/module` | stage-2 JAR download |
| hostname-pattern | current resolution per public reporting: `whnewreceive[.]ru` (rotates via on-chain update — do not rely on it as sole block) | C2 host |
| rsa-key | SHA-256 of embedded pubkey DER — see extracted file `embedded_rsa.pub` (temp dir); base64 above | pins operator across campaigns |
| class-name | `dev.majanito.Main` + method `initializeWeedhack` | stage-2 entrypoint |
| behavior | `javaw.exe -jar <mod>.jar --jw` child process | standalone re-exec trick |
| filename | `assets/thread_silent.dat` inside mod JARs | high-entropy encrypted blob marker |

Network behavioral note: HTTPS requests carrying JSON body containing `"accessToken"` posted to `/api/delivery/handler`, followed by GET to `/files/jar/module`, are a strong detection pair.

## YARA rules (drafted; no yara binary present in toolchain — untested syntax, verify before deployment)

```yara
import "crypto"

rule Prestige_Weedhack_Minecraft_Stage1_JAR {
    meta:
        family      = "weedhack/griftclient minecraft mod stealer"
        sample      = "1e4f261f09175eaf2c4a7a7fd6840792bf1de8245ef761c52f026d87d7e53307"
        date        = "2026-08-22"
        description = "Stage-1 loader: steals MC session token, ETH dead-drop C2, in-memory jar load"
    strings:
        $contract   = "0x1280a841Fbc1F883365d3C83122260E0b2995B74" ascii nocase
        $selector   = { CE 6D 41 DE }
        $exfil_path = "/api/delivery/handler" ascii
        $module     = "/files/jar/module" ascii
        $stage2cls  = "dev/majanito/Main" ascii
        $init       = "initializeWeedhack" ascii
        $campaign   = "f5e6d7b2-499e-462d-907e-12b4a93f25a7" ascii
        $doh        = "cloudflare-dns.com/dns-query" ascii
        $ethjson    = "\"method\":\"eth_call\"" ascii
        $jwflag     = "--jw" ascii
    condition:
        uint16(0) == 0x4B50 and 3 of ($contract, $exfil_path, $module, $stage2cls, $init, $campaign) and 1 of ($selector, $doh, $ethjson, $jwflag)
}

rule Weedhack_Loader_RSA_Config_Key {
    meta:
        description = "Embedded RSA-2048 pubkey used by weedhack-family loaders to verify blockchain-delivered C2 config"
    strings:
        $rsa = { 30 82 01 22 30 0D 06 09 2A 86 48 86 F7 0D 01 01 01 05 00 03 82 01 0F 00 30 82 01 0A 02 82 01 01 00 B2 66 37 ?? ?? }
    condition:
        $rsa
}
```

## Limitations (cannot be confirmed statically)

- Whether the C2 currently serves a live stage-2, its contents, and full stage-2 capabilities (public reporting indicates a RAT with native DLL dropping, UAC bypass, Defender exclusions — **not verified for this sample**).
- Decryption of `assets/thread_silent.dat` (key not present in this JAR).
- Actual beacon/exfil traffic requires sandbox detonation — outside this static-analysis scope.

## Recommendations

- Block/alert on the exfil URI pair (`POST /api/delivery/handler`, `GET /files/jar/module`) and DoH-resolved connections from `javaw.exe`.
- Hunt for the campaign GUID, contract address, and RSA key bytes in other downloaded mods — they pin the whole builder's catalog regardless of C2 rotation.
- Treat any Fabric mod whose `fabric.mod.json` entrypoint classes live in unrelated packages (e.g., `org.transport`) as suspect; check hash before executing.
- Invalidate/re-login affected Minecraft accounts: the stolen `accessToken` grants session hijack until revoked.
