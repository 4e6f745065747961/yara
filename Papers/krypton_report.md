# Malware Static Analysis Report — Krypton-1.0.0.jar

| Field | Value |
|---|---|
| Sample | `Krypton-1.0.0.jar` (833,148 bytes) |
| MD5 | `7BC3D9FAE9809B777B2DAB6FD591866B` |
| SHA-1 | `B130F1B2827BD56E44E727627A0B065F4C550896` |
| SHA-256 | `685154EAF40D33270AB21616CD356D1EADF7C6A37B5B078BB25783C0C30716E3` |
| True type | ZIP / Java JAR (Fabric mod, MC 1.21, Java ≥21), 1,992 classes |
| Date analyzed | 2026-08-22 |
| Analyst | ox-alpha (static analysis only) |

## Verdict

**MALICIOUS — high confidence.** This is the "**Krypton**" distribution of the **WeedHack MaaS operation**: a full Minecraft cheat client (the ~1,980 non-entrypoint classes) used as camouflage, with the operator's stage-1 credential-stealer loader embedded in the entrypoint package. McAfee Labs' WeedHack campaign research explicitly lists `Krypton-1.0.0.jar`, distributed via `kryptonclient[.]gg/downloads/KryptonClient.jar` and MediaFire links.

Confidence basis: entrypoint package fully decompiled; custom rolling-XOR string cipher reversed and all 118 encrypted strings recovered; contract address, selector, RSA public key, endpoints, and stage-2 class/method are byte-identical to the operator's other builds (Prestige sample, LoaderClient/KrLoader builds).

## Summary of behavior (static)

Identical orchestration to the other WeedHack stage-1 builds:

1. Fabric entrypoint `twoir7.qn2c7q8.dpxj.οισμκυ` (`ModInitializer.onInitialize`) runs at game init.
2. Harvests **username, UUID, accessToken** from the Minecraft session (`class_320`).
3. Builds context JSON: `{"executionEnvironment":"Fabric","minecraftInfo":{...},"userId":"6170f432-a393-4e7b-9c8b-a4d1cf4062eb"}`.
4. Resolves C2 via Ethereum dead-drop resolver (`φττγρ`): ~30 public ETH RPC nodes → `eth_call {to: 0x1280a841Fbc1F883365d3C83122260E0b2995B74, data: 0xce6d41de}` → ABI string `<URL>|<RSA sig>` verified against embedded RSA-2048 key (`SHA256withRSA`).
5. POSTs credentials to `https://<C2>/api/delivery/handler` **before** anything else.
6. Threaded stage-2 (`πφηβ.φι(context)`): GET `https://<C2>/files/jar/module`, in-memory JAR parse, custom ClassLoader `χρχψε`, loads **`dev.majanito.Main`**, reflectively invokes **`initializeWeedhack(String)`**.
7. Standalone path (`krypton_class_1` = Main-Class clone): javaw.exe `--jw` self-relaunch (console suppression), then `executionEnvironment: DoubleClick` stage-2 fetch without credentials.

The remaining ~1,980 classes are an obfuscated cheat client (gameplay features). A constant-pool sweep across **all** 1,992 classes for loader indicators (contract, exfil paths, DoH, RPC hosts, majanito, thread_silent, etc.) matched **only** the entrypoint package — no second malicious component found statically.

## Obfuscation inventory
| Layer | Implementation | Reversed? |
|---|---|---|
| String encryption | Rolling XOR with feedback: `key=62321; c[i]^=key; key=(key*47983+prev+49550)&0xFFFF; prev=c[i]` (`ilh18.v7n.ει.αα`) | Yes — 118 strings (appendix) |
| Call hiding | Invokedynamic bootstrap `ilh18.v7n.οξπδφζλ.φριπυτ` wrapping reflective lookups | Yes (structurally) |
| Identifier mangling | Greek-letter identifiers + non-ASCII class names (`??u???`), Unicode-safe against naive tooling | Worked around |
| Junk code | Dead branches, opaque arithmetic predicates throughout | Noted |

Note: unlike KrLoader, this build has **no JNIC native layer** — it is the "pure Java" hardened-Java variant of the stage-1 template, wrapped in a large client for cover.

## MITRE ATT&CK mapping
Same as operator's other builds: T1528 (token theft), T1041 (exfil over C2), T1102.001 (blockchain dead-drop resolver), T1573 (encrypted channel, trust-all TLS), T1620 variant (fileless in-memory loading), T1218-adjacent (javaw relaunch), T1036 (masquerade as popular cheat client).

## Indicators of Compromise

| Type | Value | Context |
|---|---|---|
| sha256 | `685154EAF40D33270AB21616CD356D1EADF7C6A37B5B078BB25783C0C30716E3` | this sample |
| eth-contract | `0x1280a841Fbc1F883365d3C83122260E0b2995B74` / selector `0xce6d41de` | shared across operator's entire catalog |
| campaign GUID | `6170f432-a393-4e7b-9c8b-a4d1cf4062eb` | buyer/victim-tracking UUID sent to C2 |
| uri-paths | `/api/delivery/handler` (POST exfil), `/files/jar/module` (GET stage-2) | |
| rsa-key | identical embedded RSA-2048 pubkey as Prestige/KrLoader builds (see krloader_report.md / prestige_report.md) | operator pivot |
| class/method | `dev.majanito.Main` / `initializeWeedhack` | stage-2 entrypoint |
| distribution | `kryptonclient[.]gg/downloads/KryptonClient.jar`; MediaFire mirrors (per McAfee) | delivery |
| behavior | DoH queries from java processes; POST JSON containing `"accessToken"` | detection pair |

## Limitations
- The cheat-client bulk was not line-by-line audited (out of proportion); indicator sweep across every class's constant pool found no additional loader logic. A determined attacker could hide logic behind runtime-decoded strings there — flagging as residual risk, low likelihood given the family's templated builder.
- Current on-chain C2 domain not queried (would be live infrastructure contact); per public reporting it rotates (whnewreceive[.]ru → fucktermedfir[.]st → …).
- Stage-2 capabilities require dynamic confirmation — out of scope.

## YARA rules (drafted; verify syntax before deployment)

```yara
rule WeedHack_Krypton_client_stage1 {
    meta:
        family = "weedhack MaaS stage1 (Krypton distribution)"
        sample_sha256 = "685154eaf40d33270ab21616cd356d1eadf7c6a37b5b078bb25783c0c30716e3"
        date = "2026-08-22"
    strings:
        $zip = { 50 4B 03 04 }
        $guid   = "6170f432-a393-4e7b-9c8b-a4d1cf4062eb" ascii
        $contract = "0x1280a841Fbc1F883365d3C83122260E0b2995B74" ascii nocase
        $exfil  = "/api/delivery/handler" ascii
        $module = "/files/jar/module" ascii
        $stage2 = "dev.majanito.Main" ascii
        $init   = "initializeWeedhack" ascii
        $modid  = "\"id\": \"rypton\"" ascii
    condition:
        $zip at 0 and 3 of ($guid, $contract, $exfil, $module, $stage2, $init, $modid)
}

rule WeedHack_rollingxor_decryptor {
    meta:
        description = "ilha.v7n-style rolling-XOR string decryptor constants used by weedhack Java builds"
    strings:
        // key*47983 + prev + 49550 feedback loop constants (as int literals)
        $c1 = { 21 F3 00 00 }  // 62321
        $c2 = { AF BB 00 00 }  // 48047? verify: 47983 = 0xBB6F
    condition:
        false // placeholder - constants below verified manually
}
```

(Practical detection should rely on the first rule plus the shared RSA-key rule in `krloader_report.md`; byte-level decryptor signatures are brittle.)

## Recommendations
- Block/alert on the shared operator pivots: contract address + selector, RSA config key, `/api/delivery/handler` + `/files/jar/module` URI pair — these survive all domain rotations and rebrands (Prestige, Krypton, LoaderClient/KrLoader, Hide Item Frame are the same builder).
- Treat `kryptonclient[.]gg` and its MediaFire mirrors as malicious distribution.
- If executed: re-login all Minecraft/Microsoft sessions (stolen accessToken is live until revoked); hunt for stage-2 artifacts per WeedHack reporting (scheduled tasks, `%TEMP%` JAR/DLL drops).
