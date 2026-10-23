# Trojanized TierTagger — Optimizer11 Stage-1 Loader (Static Analysis)

- Sample: `krypton client-2.4.0+mc1.21.11 (1) (ni--aware).jar`
- Date: 2026-10-03
- Method: static only (no execution, no network). `javap -p -c`, ZIP inventory, string extraction.
- Artifacts: `optimizer11_loader.yar` (companion, tested against sample)

## 1. Summary

Verdict: **malicious — trojanized Fabric mod acting as stage-1 downloader / spreader / session-steam prep**. Confidence: **high**.

Basis:

- Legit `TierTagger 2.4.0+mc1.21.11` cover (`com.kevin.tiertagger.*`, 20 assets, `fabric.mod.json` id `tier-tagger`) with an extra malicious client entrypoint `com.example.loader.LoaderMod`.
- `LoaderMod` (16,442 bytes, Java 21, `LoaderMod.java`) reads embedded `A.txt`, builds a JSON bundle with Minecraft session (`username`, `uuid`, `accessToken`), downloads a second-stage JAR, loads it in-memory via `MemoryClassLoader`, and invokes `com.example.optimizer.LoaderEntry#initialize(String,...)`.
- Same loader enumerates CurseForge / Prism / Modrinth / Feather / GDLauncher / vanilla `.minecraft` locations and copies itself as `fabric-utils.0.12.jar` + `modmenus.0.1.jar` into any `mods/` folder found (worm-like spreader, thread `P-Worker`).
- After stage-2 load it spawns `DirectPlayerDetector`: waits up to ~60s for a world join, then reflectively calls stage-2 `SessionUtil.sendMinecraft(7x String)` and `DataUtil.performFullTheft()`.
- C2 URL is stored reversed: `raj.11rezimitpo/daolnwod/ipa/ur.erawaggin//:sptth` → `https://niggaware.ru/api/download/optimizer11.jar`. Dead at analysis time, so stage-2 (`optimizer11.jar` / `com.example.optimizer.*`) was **not** recovered; all stage-2 behavior below is *inferred from stage-1 references*, not observed.

What this report does **not** claim: contents of `optimizer11.jar`, actual exfiltration success, or full stealer capability. That requires the missing stage-2 or sandbox detonation (out of scope).

## 2. Classification

- Type: trojanized mod / stage-1 loader + spreader.
- Cover: TierTagger (PvP tier nametag mod, MPL-2.0, authors `uku`, `netiyiy`). TierTagger code itself looks benign (Modrinth update check `https://api.modrinth.com/v2/project/dpkYdLu5/...`, `https://mctiers.com/api`, `https://subtiers.net/api`).
- Malicious package: `com.example.loader.*` — generic placeholder namespace, typical for builder-generated payloads.
- Manifest markers: `Optimizer-Loader: true`, `Optimizer-Loader-Version: 1.0`, `.optimizer-loader` file containing `1.0`.
- Log disguise: `performance-tweaks` logger, `Performance Tweaks initializing... (v3)`, `Downloading optimization module...`, `Optimization module initialized successfully`.
- No public hash match attempted (no upload per handling rules). Treat `A.txt` value below as campaign/build ID, not a hash.

File identity:

| Field | Value |
|---|---|
| File name | `krypton client-2.4.0+mc1.21.11 (1) (ni--aware).jar` |
| Size | 184,328 bytes |
| ZIP entries | 57 |
| SHA256 | `88B870964CC6230D12BD9DA6EE91B9692ACD8C349C657CAACF635361D6592BF3` |
| SHA1 | `D82BDDB7F126CEEBC10DD11693195CC9B39E6B28` |
| MD5 | `7FC0CF02AB7574203DCA70ACB13C8D56` |
| Java | major 65 = Java 21 |
| Fabric | Loader `0.18.2`, MC `1.21.11`, Mixin `0.16.5` |
| `A.txt` | `olm5HKCSfpWk7Y5Zri3YrA` (22 chars, trimmed, rejected if empty/`PLACEHOLDER`) |
| `.optimizer-loader` | `1.0` |

## 3. Technical details

### 3.1 Container layout

`fabric.mod.json` entrypoints:

```json
"main": ["com.kevin.tiertagger.TierTagger"],
"client": ["com.example.loader.LoaderMod"]
```

`TierTagger.mixins.json` only lists legit `com.kevin.tiertagger.mixin.*` (4 mixins). The extra `com/example/loader/mixin/ClientMixin.class` is **not** registered there — dormant stub (see 3.5).

Malicious entries (all others are cover/assets):

```text
A.txt (22)
.optimizer-loader (3)
com/example/loader/LoaderMod.class (16442)
com/example/loader/MemoryClassLoader.class (1895)
com/example/loader/mixin/ClientMixin.class (864)
```

### 3.2 `LoaderMod.onInitializeClient()` — stage-1 flow

1. Log `Performance Tweaks initializing... (v3)`.
2. `getResourceAsStream("A.txt")` → trim. Abort on missing/empty/`PLACEHOLDER`.
3. Build `JsonObject { aTxtContent, executionEnvironment: "Fabric", minecraftInfo: {username, uuid, accessToken} }` via `class_310.method_1551()` (MinecraftClient) → `method_1548()` (Session) → `method_1676/44717/1674`. Failures only warn; loader continues.
4. `Gson.toJson()` → spawn download thread + spawn `P-Worker` (`setupPersistence()`). Returns immediately (non-blocking).

`downloadJar(String)`:

- `HttpClient.newBuilder().followRedirects(ALWAYS)`, `GET` with `User-Agent: Java/<java.version>`.
- Non-200 → log `Download failed with status:` + return null. `<100,000` bytes → log `Download failed - too small:` + abort (anti-sandbox/placeholder check).
- Success → `JarInputStream`: `.class` entries → `classData` map (`/ `→`.`, strip `.class`), others → `resourceData` map. Log `Parsed X classes, Y resources`.
- `new MemoryClassLoader(classData, resourceData)` (parent = context CL, `findClass` → `defineClass`, `getResourceAsStream` with `/`-strip fallback).
- `loadClass("com.example.optimizer.LoaderEntry")`, scan `getMethods()` for name `equals("initialize")` or `startsWith("initialize")` with first param `String`. If none → `Could not find initialize method!`.
- Invoke in new `Thread`: 1-arg → `(json)`; 2-arg with second `int` → `(json, 0)`; else pad with `getDefaultValue()` (0/false/null) for remaining params. This tolerant dispatch suggests stage-2 `initialize` signature varies by build.
- On success: log `Optimization module initialized successfully` + `Starting direct player detection...` → start `DirectPlayerDetector` thread.

### 3.3 `DirectPlayerDetector` (`lambda$onInitializeClient$0`)

- Log `Waiting for player to join world...`, loop 120×500 ms.
- Per tick: `MinecraftClient.field_1724` (player), `method_5477().getString()` (display name), `method_5845()` (profile name?), `Session.method_1674()` (token). Log `Player detected: <name> UUID: <...>`, `Token length: N`.
- Reflect `SessionUtil.sendMinecraft(String×7)` with `(displayName, profileName, sessionToken, "loader_direct", "0.0.0.0", System.getProperty("user.name"), getenv("USERNAME")||user.name)`. Log result.
- Reflect `DataUtil.performFullTheft()` (no args). Log `Calling performFullTheft... / started`.
- All reflection failures are caught, logged, and `printStackTrace()` — noisy, good for hunting in `.minecraft/logs`.

Inferred intent (not confirmed): session-token + OS-user exfil then full stealer. `0.0.0.0` looks like a server-IP placeholder for a loader that normally also handles multiplayer joins.

### 3.4 `setupPersistence()` / `scanAndInfect()` / `copyTo()` (`P-Worker`)

- Resolve own JAR via `ProtectionDomain.getCodeSource().getLocation().toURI()`. Abort if not existing `*.jar`.
- Roots: `user.home` + `%APPDATA%` fallback:
  `curseforge/minecraft/Instances`, `PrismLauncher/instances`, `com.modrinth.theseus/profiles`, `.minecraft/mods`, `Feather/user-profiles`, `GDLauncher/instances`.
- Recursive `scanAndInfect(dir, sourceJar)`: if `dir.getName().equals("mods") && isDirectory` → `copyTo(source, <mods>/fabric-utils.0.12.jar)` + `copyTo(source, <mods>/modmenus.0.1.jar)` (skip if dest exists). Else recurse `listFiles()` directories only.
- `copyTo`: 1024-byte stream copy, try-with-resources style, silent on exception.
- Effect: any launcher instance with a `mods/` folder gets two trojan copies under plausible utility names. No registry/scheduled-task persistence — relies on Fabric loading `mods/*.jar` next launch.

### 3.5 `MemoryClassLoader` + `ClientMixin`

- `MemoryClassLoader.java`: trivial `HashMap<String,byte[]>` class/resource store. No disk write — classic reflective in-memory load (see ATT&CK `T1620`).
- `ClientMixin.java`: `@Mixin(net.minecraft.class_310)` (MinecraftClient), `@Inject(at=@At("HEAD"), method="tick()V") void onTick(CallbackInfo)` with empty body (`return`). Currently a no-op stub: possibly a placeholder for stage-2 to patch, or leftover template. Not registered in `TierTagger.mixins.json`, so inert unless stage-2 registers it.

### 3.6 Obfuscation / evasion notes

- Only obfuscation is the reversed C2 (`new StringBuilder(<rev>).reverse().toString()` in `<clinit>`). Everything else is plaintext.
- Size gate (`<100k` reject), `PLACEHOLDER` check, swallowed exceptions, and benign log lures hinder quick triage.
- `User-Agent: Java/<version>` + `followRedirects(ALWAYS)` is distinctive for network hunting.

### 3.7 MITRE ATT&CK (inferred from static)

| Technique | Evidence |
|---|---|
| T1656 Impersonation / T1584 Compromise Infrastructure (trojanized mod) | Legit TierTagger + hidden `client` entrypoint |
| T1105 Ingress Tool Transfer | `HttpClient` GET `.../optimizer11.jar`, `JarInputStream` in-memory |
| T1620 Reflective Code Loading | `MemoryClassLoader.defineClass` + `LoaderEntry.initialize` reflection |
| T1528 Steal Application Access Token | `Session.method_1674()` (`accessToken`), `uuid`, `username` bundled into JSON |
| T1555 Credentials from Password Stores (inferred, via `performFullTheft`) | Method name + `DirectPlayerDetector` context; needs stage-2 to confirm |
| T1083 File and Directory Discovery | Launcher-path enumeration + recursive `listFiles` |
| T1547 Boot/Logon Autostart (via mod autoload) + T1570 Lateral Tool Transfer | Self-copy as `fabric-utils.0.12.jar` / `modmenus.0.1.jar` into every `mods/` |
| T1027 Obfuscated Files | Reversed C2 string |
| T1071.001 Web Protocols | Java `HttpClient` beacon/download |
| T1497 Sandbox Evasion (inferred) | `<100k` + `PLACEHOLDER`/empty config gates |

## 4. IOCs

Defensive only. `mctiers.com`, `subtiers.net`, `api.modrinth.com` are **legit TierTagger** traffic — do **not** block. `user.name`/`USERNAME` and `0.0.0.0` are placeholders, not IOCs.

| Type | Value | Note |
|---|---|---|
| SHA256 (sample) | `88B870964CC6230D12BD9DA6EE91B9692ACD8C349C657CAACF635361D6592BF3` | Stage-1 JAR |
| SHA1 | `D82BDDB7F126CEEBC10DD11693195CC9B39E6B28` | — |
| MD5 | `7FC0CF02AB7574203DCA70ACB13C8D56` | — |
| URL (decoded, dead) | `https://niggaware.ru/api/download/optimizer11.jar` | Stored reversed; block domain + path |
| Stored string | `raj.11rezimitpo/daolnwod/ipa/ur.erawaggin//:sptth` | Raw YARA anchor |
| Stage-2 JAR name | `optimizer11.jar` | Downloaded artifact |
| Build/key file | `A.txt` = `olm5HKCSfpWk7Y5Zri3YrA` | Campaign ID; hunt in other mods |
| Flag files | `.optimizer-loader` (`1.0`), `Optimizer-Loader: true` | Manifest/marker |
| Classes | `com.example.loader.LoaderMod`, `com.example.loader.MemoryClassLoader`, `com.example.loader.mixin.ClientMixin` | ZIP entry names |
| Stage-2 refs | `com.example.optimizer.LoaderEntry`, `com.example.optimizer.SessionUtil`, `com.example.optimizer.DataUtil` | In-memory only |
| Methods | `initialize` (first arg String), `sendMinecraft` (7×String), `performFullTheft()` | Reflection targets |
| Drop names | `fabric-utils.0.12.jar`, `modmenus.0.1.jar` | Spreader copies in any `mods/` |
| Launcher paths | `curseforge/minecraft/Instances`, `PrismLauncher/instances`, `com.modrinth.theseus/profiles`, `.minecraft/mods`, `Feather/user-profiles`, `GDLauncher/instances` | Scan roots |
| Threads/logs | `P-Worker`, `DirectPlayerDetector`, `loader_direct`, `Performance Tweaks initializing... (v3)`, `Downloading optimization module from `, `Optimization module initialized successfully` | Log/EDR hunt |
| JSON keys | `aTxtContent`, `executionEnvironment`, `minecraftInfo{username,uuid,accessToken}` | Memory/forensics |

## 5. Limitations

- C2 dead → stage-2 missing. `sendMinecraft` exfil format, `performFullTheft` scope (browser/Discord/token-wallet?), and `LoaderEntry.initialize` exact signature are **unknown**.
- No dynamic execution: persistence success, network retry, or anti-analysis beyond static gates unconfirmed.
- `ClientMixin.onTick` empty + unregistered — intent unknown (future hook vs. dead template).
- `A.txt` value could be per-victim or per-build; single sample cannot tell.
- Clean-TierTagger overlap (Fabric, Gson, HttpClient) means generic strings alone are unsafe — use the companion YARA as designed (container vs. extracted).

## 6. Recommendations

1. **Detect**: deploy `optimizer11_loader.yar` — Rule 1 on raw `mods/*.jar` (no extraction), Rules 2–3 on `unzip -p` output / memory / logs. Rule 1 needs 2 loader paths + `A.txt`/`.optimizer-loader`; Rule 2 needs reversed C2 + stage-2 ref + persistence + logs (tested: 5/5 container hits, 33 hits on extracted `LoaderMod`).
2. **Hunt**: search `mods/` for `fabric-utils.0.12.jar` / `modmenus.0.1.jar` with same SHA256 or `com/example/loader/*` entries; grep logs for `Downloading optimization module`, `DirectPlayerDetector`, `loader_direct`, `performFullTheft`.
3. **Contain**: quarantine the sample JAR + any copies; block `niggaware.ru` + `/api/download/optimizer11.jar` at proxy/DNS; treat downloaded `optimizer11.jar` as fully malicious if ever recovered.
4. **Recover**: assume Minecraft session token + OS username exfiltrated if the mod ever ran past world-join. Invalidate Minecraft/Microsoft sessions, rotate passwords stored in browsers/clients on that host, and reinstall mods from official sources (Modrinth/GitHub `mctiers-dev/TierTagger`).
5. **Prevent**: only install mods from official pages with hash checks; alert on `mods/` writes with `Optimizer-Loader` manifest or `A.txt` at JAR root.

---
*Appendix: raw `javap -c` dumps, full strings list, and `debug_yara*.py` validation kept separately; YARA file is the executable appendix to this report.*
