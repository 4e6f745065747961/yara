# Static Analysis Report — WXSGrabber ("Krypton Client" / "my-mod" Fabric mod)

- **Analyst:** opencode (automated static analysis)
- **Date:** 2026-08-22
- **Sample analyzed:** Decompiled contents of `C:\Users\ferti\Desktop\dec` (a Fabric Minecraft mod JAR that was unpacked/decompiled). The original artifact's internal name is **`Krypton Client.jar`** (per JADX headers in every `.class`), declared in `fabric.mod.json` as mod **`my-mod` v1.0.0**, license file `LICENSE_wxsgrabber-mod`.
- **Verdict:** **MALICIOUS** — confirmed information stealer + persistent RAT disguised as a Minecraft mod. Confidence: **High** (full source recovered, logic reviewed end-to-end).

> Note: This is a *decompiled* sample, not the original byte-for-byte JAR. Hashes below are for the decompiled artifacts only and are **not** the attacker's distribution hash. The original `Krypton Client.jar` should be obtained for definitive IOCs.

---

## 1. Summary

The mod is a **trojanized Minecraft Fabric client mod**. Its real payload is hidden in a package named `net.fabricmc.core.impl` (masquerading as Fabric internals) and is executed automatically because `fabric.mod.json` lists `NetworkPacketCodec` (main) and `LightingUpdateHelper` (client) as entry points. On launch it:

1. Establishes **persistence** (hidden `%APPDATA%\.sys-cache\` folder, registry Run keys, self-reinstalling "restorer" scripts).
2. Drops and launches a **PowerShell RAT** (`listener.ps1`/`listener.vbs`) that connects to a **Firebase Realtime Database** C2 and waits for live commands.
3. **Steals** browser credentials (Chrome/Chromium via DPAPI+AES-GCM, Firefox via NSS), **Discord tokens**, **crypto wallets**, **browser extensions**, **Minecraft/Microsoft account** data, and **system info**, then exfiltrates everything as JSON to `https://api.x-grabber.com` over HTTP.

The code is obfuscated with custom XOR string decoders, Base64 blobs, and benign class/method names (e.g. `BiomeSourceManager`, `ChunkDataSerializer`). It bundles **JNA 5.14.0** (native Windows API / NSS access) and **SQLite JDBC 3.45.1.0** (reading browser databases).

---

## 2. Technical Details

### 2.1 Entry point & loader
- `NetworkPacketCodec.onInitialize()` → logs `"Hello Fabric world!"`, then calls `BiomeSourceManager.BossBarTracker()` (persistence).
- `LightingUpdateHelper` is the client entrypoint; `ScreenHandlerFactory.FurnaceSmeltTracker()` registers a `ClientPlayConnectionEvents.JOIN` handler that, once the player joins a server, triggers the stealer (cookie/password collection + system info) and the RAT drop.
- All real strings live in per-class XOR-encoded `String[]` arrays (decoder pattern `i2 = (K ^ i); ... cArr[i3] ^= i2`). Decoded strings confirmed below.

### 2.2 Persistence (`BiomeSourceManager`)
- Creates hidden dir `%APPDATA%\\.sys-cache` (`dos:hidden`).
- Copies the mod JAR to `.sys-cache\fabric-api-runtime.jar`.
- Writes `.sys-cache\restorer.ps1` (PowerShell loop that re-copies the JAR if removed) and `restorer.vbs` (WScript.Shell Run of `powershell.exe -ExecutionPolicy Bypass -WindowStyle Hidden -File restorer.ps1`).
- Adds **registry Run key** `HKCU\Software\Microsoft\Windows\CurrentVersion\Run\FabricRuntimeInit` → `wscript.exe "...restorer.vbs"`.
- Writes `.sys-cache\listener.ps1` (the RAT, see 2.5) + `listener.vbs`, adds Run key `FabricListenerInit` → `wscript.exe "...listener.vbs"`, and **launches it immediately** via `ProcessBuilder("wscript.exe", "...listener.vbs")`.
- Hardcoded C2 API: `RecipeBookController = "https://api.x-grabber.com"` (Base64 `aHR0cHM6Ly9hcGkueC1ncmFiYmVyLmNvbQ==`).

### 2.3 Browser credential theft (`ScreenRenderOverlay`, `DamageSourceFactory`)
- **Chrome / Chromium / OperaGX** cookies & logins:
  - Reads `Local State`, extracts `encrypted_key`, strips `"DPAPI"` prefix, **DPAPI-decrypts** it via `CryptUnprotectData` (JNA) to obtain the AES master key.
  - Reads SQLite `Login Data` / `Cookies` (`jdbc:sqlite:`), decrypts values with **AES/GCM/NoPadding** (`SecretKeySpec` + `GCMParameterSpec`).
  - Also handles Firefox/Opera cookie DBs (`opera_cookies_`, `cookies.sqlite`).
- **Firefox** saved passwords:
  - Loads `nss3.dll` / `libnss3.so` / `libnss3.dylib` via JNA, initializes NSS (`NSS_Init`), and decrypts `logins.json` `encryptedUsername`/`encryptedPassword` with `PK11SDR_Decrypt` (cross-platform: Windows `PROGRAMFILES(X86)`/`PROGRAMFILES`, Linux `/usr/lib`, `snap`, macOS `/Applications/Firefox.app`, `/Library/Application Support/Firefox`).
- Collects cookies via SQL `SELECT host, name, value FROM ...` and stores results in a `List` for exfil.

### 2.4 Other harvested data
From `ScreenHandlerFactory.NoteBlockPitchCalc` exfil JSON schema (`MapDecorationRenderer` array):
`sessionId, uuid, os, pcName, username, publicIp, minecraft (playerUuid/username/refreshToken), discordTokens, wallets, browsers (cookies/passwords), firefox, operagx, extensions`. Wallets and browser extensions are enumerated (logs `"Wallets found:"`, `"Extensions found in ..."`). Public IP is fetched from an external service (field `publicIp`).

### 2.5 RAT — `listener.ps1` (decoded from `BiomeSourceManager.ChunkLoadDispatcher`)
Dropped PowerShell payload (full source recovered, 298 lines). Capabilities:
- **C2 channel:** Firebase Realtime Database at `https://wxsgrabber-default-rtdb.europe-west1.firebasedatabase.app/sessions/<victimUuid>.json`, read as a `text/event-stream` (SSE) long-poll loop, reconnects every 3s on drop.
- **Beacon:** pings every **20s** (`System.Timers.Timer(20000)`) to maintain "online" status and resolve session ID.
- **Remote commands** (executed only if `timestamp` is newer than last):
  - Arbitrary shell: `cmd.exe /c "<cmd>"` and returns output.
  - `mouse_click` (uses `user32.dll` `mouse_event`/`SetCursorPos` InputSimulator), `key_press` (`SendKeys::SendWait`).
  - `start_stream` / `stop_stream` — **live screen capture** (~0.33 fps, 1024px JPEG, base64) streamed back.
  - `list_directory`, `get_processes`, `kill_process`.
  - `download` (via `Invoke-WebRequest`, optional auto-run) and `upload_file` (exfiltrates a local file via HTTP PUT).
- Output sent back to C2 via `Invoke-RestMethod` POST with `uuid` + `victim_id`.

### 2.6 Exfiltration (`ScreenHandlerFactory.NoteBlockPitchCalc`)
- `HttpClient` POST to `GameProfileResolver.ChunkLoadDispatcher` (the `api.x-grabber.com` endpoint), headers `Content-Type: application/json` and **`X-WXS-Build-Token`** (value `GameProfileResolver.ScreenRenderOverlay`).
- Payload is a JSON object containing the full stolen dataset described in 2.4.

---

## 3. MITRE ATT&CK Mapping

| Technique | ID | Evidence |
|---|---|---|
| Deobfuscate/Decode Files or Info | T1140 | XOR string decoders, Base64 blobs |
| Hijack Execution Flow / Persistence via Registry Run | T1547.001 | `HKCU\...\Run\FabricRuntimeInit`, `FabricListenerInit` |
| Hidden Files and Directories | T1564.001 | `.sys-cache` with `dos:hidden` |
| Scheduled Task/Job (misuse of wscript/ps1) | T1053 / T1059.001 | `wscript.exe`, `powershell.exe -WindowStyle Hidden` |
| Command and Scripting Interpreter: PowerShell | T1059.001 | `listener.ps1` RAT |
| Application Layer Protocol: Web Service / Cloud | T1071.001 / T1102 | Firebase RTDB, `api.x-grabber.com` |
| Input Capture (GUI, keylogging, screenshot) | T1056 | mouse/key SendKeys, screen streaming |
| Credentials from Web Browsers | T1555.003 | Chrome DPAPI/AES-GCM, Firefox NSS |
| Credentials from Password Stores | T1555.004 | `logins.json`, `Login Data` |
| Unsecured Credentials (Discord/Minecraft tokens) | T1552 | `discordTokens`, `refreshToken`, `playerUuid` |
| Data from Local System / Exfil over Web | T1005 / T1041 | JSON POST exfil |
| Query Registry / System Info Discovery | T1012 / T1082 | `os.name`, `pcName`, `publicIp` |

---

## 4. Indicators of Compromise (IOCs)

### Network
| Type | Value |
|---|---|
| C2 API (exfil) | `https://api.x-grabber.com` (path filled at runtime, header `X-WXS-Build-Token`) |
| C2 RAT (command/beacon) | `https://wxsgrabber-default-rtdb.europe-west1.firebasedatabase.app` (Firebase RTDB, `/sessions/<uuid>.json`) |
| DNS domains | `api.x-grabber.com`, `*.firebasedatabase.app` |

### Host — files / paths
| Type | Value |
|---|---|
| Hidden staging dir | `%APPDATA%\\.sys-cache\\` |
| Dropped JAR copy | `%APPDATA%\\.sys-cache\\fabric-api-runtime.jar` |
| Persistence scripts | `%APPDATA%\\.sys-cache\\restorer.ps1`, `restorer.vbs`, `listener.ps1`, `listener.vbs` |
| Registry Run keys | `HKCU\Software\Microsoft\Windows\CurrentVersion\Run\FabricRuntimeInit` (→ `wscript.exe "...restorer.vbs"`), `...\Run\FabricListenerInit` (→ `wscript.exe "...listener.vbs"`) |
| Mod package | `net.fabricmc.core.impl.*` (masquerades as Fabric internals) |
| Bundled libs | `jna-5.14.0.jar`, `jna-platform-5.14.0.jar`, `sqlite-jdbc-3.45.1.0.jar` |

### Host — behavioral / process (inferred, not executed)
- `wscript.exe` launching `*.vbs` from `%APPDATA%\.sys-cache`
- `powershell.exe -ExecutionPolicy Bypass -WindowStyle Hidden -File ...listener.ps1`
- Outbound SSE/long-poll HTTPS to `*.firebasedatabase.app`; POST to `api.x-grabber.com`
- `cmd.exe /c` spawned by `listener.ps1` under attacker control

### Sample identity
- Internal JAR name: `Krypton Client.jar`
- `fabric.mod.json`: id `my-mod`, version `1.0.0`, external JARs jna/jna-platform/sqlite-jdbc
- Logger identity string: `wxsgrabber-persistence`

---

## 5. YARA draft

```yara
rule WXSGrabber_FabricMod_RAT_Stealer {
    meta:
        author = "opencode-static-analysis"
        date = "2026-08-22"
        description = "WXSGrabber / Krypton Client Fabric mod stealer+RAT"
        family = "wxsgrabber"
    strings:
        $a = "wxsgrabber-persistence" ascii wide
        $b = "X-WXS-Build-Token" ascii wide
        $c = "FabricRuntimeInit" ascii wide
        $d = "FabricListenerInit" ascii wide
        $e = ".sys-cache" ascii wide
        $f = "wxsgrabber-default-rtdb" ascii wide
        $g = "api.x-grabber.com" ascii wide
        $h = "Krypton Client.jar" ascii wide
        $i = "PK11SDR_Decrypt" ascii wide
        $j = "NSS_Init" ascii wide
        // Base64 of https://api.x-grabber.com
        $k = "aHR0cHM6Ly9hcGkueC1ncmFiYmVyLmNvbQ==" ascii
        // Base64 of wscript.exe / powershell.exe / cmd.exe
        $l = "d3NjcmlwdC5leGU=" ascii
        $m = "cG93ZXJzaGVsbC5leGU=" ascii
    condition:
        3 of them
}
```

---

## 6. Limitations
- Analysis is **static only**; dynamic behaviors (actual C2 beaconing, exact exfil path, runtime `{{c2_url}}`/`{{secret}}`/`{{victim_uuid}}` substitution) were **not** executed and are inferred from code.
- The original `Krypton Client.jar` binary was not provided — only its decompiled output. Definitive file hashes and the live C2 `secret` require the packed sample.
- Some obfuscated `.class` files had no corresponding `.java` (decompiler skipped them); their string arrays were partially recovered via the embedded XOR decoders that were present in source.

## 7. Recommendations
- **Containment:** Remove the mod from any Minecraft `mods/` folder; delete `%APPDATA%\.sys-cache\*`; delete registry Run values `FabricRuntimeInit` and `FabricListenerInit`; kill any `wscript.exe`/`powershell.exe` running `listener.ps1`.
- **Credentials:** Treat all Chrome/Firefox saved passwords, **Discord tokens**, **Minecraft/Microsoft account** sessions, and **crypto wallets** on affected hosts as **compromised** — rotate immediately and enable 2FA.
- **Detection:** Deploy the YARA rule above on endpoints/EDR; alert on egress to `api.x-grabber.com` and `*.firebasedatabase.app`; alert on `powershell.exe -WindowStyle Hidden -File` from `%APPDATA%\.sys-cache`.
- **Blocking:** Block the two domains at DNS/Proxy/firewall.
