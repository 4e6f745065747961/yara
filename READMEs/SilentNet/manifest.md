# Recovered classes — cleaned / renamed

Source of truth: `second_run/decompiled/deobfuscated/` in the isolated tree
(CFR output, deobfuscated). Relocated 2026-10-19 to
`/home/l702x/Desktop/work/silentnet-deobfuscated/` — the obfuscated-class-named
originals now live adjacent in `../deobfuscated/`, these role-named copies in `./`.
This directory holds role-named **copies**; the original obfuscated-class files are
left untouched for traceability.

| Original class file | Renamed recovered file | Confirmed role |
|---|---|---|
| `net/fabric/PxibF0.java` | `PxibF0__fabric_entrypoint.java` | Fabric mod entrypoint (ModInitializer); builds `_spawn.log` redirect and elevates to the loader chain via `LOCALAPPDATA` |
| `net/fabric/gtI.java` | `gtI__process_spawner.java` | ProcessBuilder spawner; re-executes from `%LOCALAPPDATA%` and resolves the next stage via `getDomain()` |
| `net/fabric/pumkdmXmuofa.java` | `pumkdmXmuofa__stealer_chain.java` | Main payload chain — C2 (`https://polygon...`, `.drpc.org`), ECDSA-verified payload fetch, deploys `AppHost/main.py` + `python.exe`, writes `_stealer.log`, beacon `/shard/prefireMc` |
| `net/fabric/lDYyOSFGzNWbBC.java` | `lDYyOSFGzNWbBC__tls_http_client.java` | TLS/HTTP networking client (3 inner classes: `avgNhhbkck`, `tmpDfpsfslfu`, `zek_rqbfns_ve`) |
| `net/fabric/emnnr_sxvzsk.java` | `emnnr_sxvzsk__minecraft_context.java` | Minecraft session / runtime context collector feeding stage-2 |

## Notes
- No class was executed; all identifiers above were confirmed by reading decompiled text only.
- Outer/inner-class layout for `lDYyOSFGzNWbBC` is preserved (single renamed file),
  matching the 3 anonymous/inner classes listed in the JAR central directory.
- Reference the original class names (left column) in YARA and IR reports:
  the raw JAR contains those obfuscated names, not the role names.
