# SilentNet MaaS — Java/Fabric loader static analysis

**Status:** static analysis only. No sample code was executed, imported, initialized, or allowed to make network connections.

**Family attribution:** “SilentNet MaaS (public)” was supplied by the analyst. Public reporting was not reachable from this environment, so the attribution is **not independently verified** here. The technical findings below are derived directly from the sample.

---

## 1. Sample identity

| Field | Value |
|---|---|
| Original path | `/home/l702x/Desktop/work/sample.jar.bin` |
| Isolated raw copy | `/tmp/opencode/malware-static-20261019/raw/sample.jar.bin` |
| Size | 65,217 bytes |
| SHA-256 | `eecbe61734299f04603369a9917f3938c8f9af97d2a51608a95a5eaf7af04e1d` |
| Format | Java archive / JAR (ZIP) |
| Class version | Java SE 21 (major 65) |
| Manifest main class | `net.fabric.gtI` |
| Fabric entrypoint | `net.fabric.PxibF0` |
| Fabric mod id | `library` (`fabric.mod.json`) |

Archive entries:

```text
META-INF/MANIFEST.MF
fabric.mod.json
net/fabric/gtI.class
net/fabric/PxibF0.class
net/fabric/pumkdmXmuofa.class
net/fabric/lDYyOSFGzNWbBC.class
net/fabric/emnnr_sxvzsk.class
net/fabric/lDYyOSFGzNWbBC$tmpDfpsfslfu.class
net/fabric/lDYyOSFGzNWbBC$zek_rqbfns_ve.class
net/fabric/lDYyOSFGzNWbBC$avgNhhbkck.class
```

There is **no PE file, no PyInstaller CArchive, no `.pyc`, and no Nuitka onefile payload inside this JAR**. It is a Java loader; the Python stealer is downloaded later.

---

## 2. Safety contract

These rules were followed and are enforced by the scripts:

1. Analysis is confined to `/tmp/opencode/malware-static-20261019`.
2. `raw/` is mode `0400`, contains only the sample, and is mounted **read-only** inside bubblewrap.
3. No `java -jar`, `javaw`, `python <sample>`, `xdg-open`, `open`, `start`, or file-association launch was used.
4. Java decompilers are started with `java -cp <tool.jar> <tool-main-class> <input>`; the input is always treated as data.
5. Python analysis uses `python3 -I`; parsers are restricted to `scripts/` or `tools/`, and inputs to `raw/` or `extracted/`.
6. Decompiled Java is read as text and is **never executed**.
7. The sandbox has no network namespace. No sample-derived code contacted the RPC endpoints, C2, or blockchain contract.
8. Extracted/decompiled output is separate from `raw/`.
9. If a command’s effect is ambiguous, it is refused.

The workflow deliberately has **no execute-sample target**.

---

## 3. Directory layout

```text
/tmp/opencode/malware-static-20261019/
├── raw/                         # original bytes, read-only
│   └── sample.jar.bin
├── extracted/
│   ├── sample.jar               # .jar-suffixed copy, identical hash
│   └── archive/                 # unzipped class/metadata files
├── decompiled/
│   ├── javap/                   # per-class javap disassembly
│   ├── cfr/                     # CFR Java source
│   ├── deobfuscated/            # constant-folded, readable source
│   ├── recovered/               # second run: role-renamed copies + manifest
│   │   │                        # (2026-10-19: relocated to /home/l702x/Desktop/work/silentnet-deobfuscated/recovered)
│   │   ├── manifest.md          # original class -> recovered file -> role
│   │   ├── PxibF0__fabric_entrypoint.java
│   │   ├── gtI__process_spawner.java
│   │   ├── pumkdmXmuofa__stealer_chain.java
│   │   ├── lDYyOSFGzNWbBC__tls_http_client.java
│   │   └── emnnr_sxvzsk__minecraft_context.java
├── reports/
│   ├── identity.txt
│   ├── archive-listing.txt
│   ├── extracted-types.txt
│   ├── cfr-method-index.txt
│   ├── decoded-interesting.txt
│   ├── strings/                 # strings output per raw/extracted file
│   └── deobfuscated/            # recovered string tables per class
├── tools/
│   ├── cfr-user.jar             # analyst-supplied CFR 0.152
│   └── parsers/
│       └── deobfuscate_java.py  # no eval/exec; integer expression parser
├── scripts/                     # fixed-purpose static wrappers
├── yara/
│   └── silentnet_java_loader.yar
└── logs/
```

CFR SHA-256: `f686e8f3ded377d7bc87d216a90e9e9512df4156e75b06c655a16648ae8765b2`

---

## 4. Reproduce the workflow

All wrappers print a `[STATIC]` line stating that the sample is not executed or imported.

```bash
cd /tmp/opencode/malware-static-20261019

./scripts/check-safety.sh        # verify modes, hashes, no execute bits/symlinks
./scripts/static-strings.sh      # strings + 7z listing; binwalk if present
./scripts/javap-all.sh           # javap -p -c -constants per class
./scripts/cfr-decompile.sh       # CFR -> decompiled/cfr
./scripts/deobfuscate-all.sh     # constant-fold -> decompiled/deobfuscated
./scripts/rename-recovered.sh    # role-renamed copies -> decompiled/recovered
```

For the isolated second run, point `ANALYSIS_ROOT` at the run's own tree (the scripts then operate entirely inside it):

```bash
ANALYSIS_ROOT=/tmp/opencode/malware-static-20261019/second_run ./scripts/rename-recovered.sh
```

Optional custom parser:

```bash
./scripts/python-static.sh tools/parsers/my_parser.py raw/sample.jar.bin
```

`python-static.sh` forces `python3 -I` and rejects `-c`, `-m`, parsers under `raw/`/`extracted/`, and inputs outside `raw/`/`extracted/`.

### Command effect labels

| Action | Effect on sample |
|---|---|
| `sha256sum`, `file`, `xxd`, `strings` | reads bytes |
| `unzip`, `7z x` | reads and writes decompressed copies |
| `javap` | reads/parses class data; no class initialization |
| CFR/Procyon/Jadx | reads/parses class/JAR data; does not run sample code |
| `python3 -I` static parser | reads bytes; must not import/exec sample content |
| `java -jar sample.jar` | **forbidden — executes sample** |
| `java sample.Main`, `javaw`, `python sample` | **forbidden — executes sample** |
| `xdg-open`/`open`/`start` sample | **forbidden — association may execute** |

---

## 5. Recovered behavior chain

### 5.1 Entry points and relaunch

- `fabric.mod.json` declares `net.fabric.PxibF0` as the Fabric `main` entrypoint.
- `META-INF/MANIFEST.MF` declares `Main-Class: net.fabric.gtI`.
- `gtI.main` checks for a `-restarted` argument:
  - with `-restarted`, it calls `gtI.run()`;
  - otherwise it spawns `javaw.exe` (fallback `java.exe`) as:

```text
javaw.exe -cp <current-jar> net.fabric.gtI -restarted
```

It writes `_spawn.log` under:

```text
%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\
```

- `PxibF0.onInitialize` starts a thread, collects Minecraft identity/path data through `emnnr_sxvzsk`, then spawns:

```text
javaw.exe -cp <current-jar> net.fabric.pumkdmXmuofa <Base64 JSON>
```

The JSON includes `mcInfo`, `prefireId`, `userId`, `tag`, `domain`, `gameDir`, `mcUsername`, `mcUuid`, and `env`.

### 5.2 Blockchain dead-drop domain resolution

`pumkdmXmuofa.getDomain()` builds a JSON-RPC `eth_call` request and iterates five Polygon RPC endpoints:

```text
hxxps://polygon[.]drpc[.]org
hxxps://polygon-bor-rpc[.]publicnode[.]com
hxxps://1rpc[.]io/matic
hxxps://api[.]zan[.]top/polygon-mainnet
hxxps://rpc-mainnet[.]matic[.]quiknode[.]pro
```

Call data:

```text
contract: 0x9c0a507300fd902787bb193d80fca5ce6e1bff9a
selector: 0xce6d41de
method:   eth_call
```

The returned value becomes the live C2 domain. If all RPC calls fail, it falls back to the decoy string:

```text
thisisafalsepositive.st
```

**This workflow did not query the RPC endpoints or the contract.** The live C2 domain is therefore intentionally unresolved. Resolving it would be a sample-derived network request.

### 5.3 Python runtime download and staging

After obtaining the domain, the loader fetches:

```text
https://<resolved-domain>/cdn/v2/9f4e7a2c1b8d.png
```

It:

1. verifies the PNG signature;
2. scans PNG chunks for an `hIds` marker;
3. zlib-inflates the embedded data;
4. unzips a portable Python runtime;
5. expects `python.exe` and `AppHost/main.py`;
6. writes/uses the staging directory:

```text
%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\
```

### 5.4 Stealer launch

The loader runs:

```text
python.exe AppHost\main.py -u <userId> --env <environment>
  [--tag <mcUuid>]
  [--mcInfo <mc-info>]
  [--prefireId <prefire-id>]
```

It redirects output to `_stealer.log` and records a runtime banner including Java version, OS name, and user name.

### 5.5 Prefire and log submission

- `prefire()` POSTs JSON to:

```text
https://<resolved-domain>/shard/prefireMc
```

and reads `prefireId` from the response.

- After the stealer runs, it reads `.minecraft/logs/latest.log` (truncating very large logs to the first and last 2.5 MB) and POSTs a JSON body to:

```text
https://<resolved-domain>/shard/submitMinecraftLog
```

The body includes `userId`, log `content`, `filename: combined.log`, `mcUsername`, `mcUuid`, and `executionEnvironment`.

### 5.6 HTTP/TLS behavior

- Custom `SSLContext("TLS")` with a permissive `X509TrustManager` (`avgNhhbkck`), i.e. certificate validation is not enforced.
- Hard-coded browser User-Agent:

```text
Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
(KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36
```

- Adds cache-control headers such as `X-Edge-Cache-Revalidate: stale-if-error` and `X-Runtime-Env: jre-embedded`.

### 5.7 String obfuscation

Most strings are built from integer-arithmetic char expressions, e.g.:

```java
stringBuilder.append((char)(54036 - 53932)); // 'h'
```

`tools/parsers/deobfuscate_java.py` evaluates only integer constant expressions with a recursive-descent parser. It uses no `eval`, `exec`, `compile`, or sample imports. It then folds local `char[]` arrays and constant `StringBuilder` chains into readable source and string tables.

---

## 6. Static indicators

Defanged where appropriate.

### Hashes

```text
eecbe61734299f04603369a9917f3938c8f9af97d2a51608a95a5eaf7af04e1d
```

### Class / method identifiers

```text
net/fabric/gtI
net/fabric/PxibF0
net/fabric/pumkdmXmuofa
net/fabric/lDYyOSFGzNWbBC
net/fabric/emnnr_sxvzsk

EMXRhrYigjZLl
IWVPOjcC4iBBhP
ixVfBihjHD
ybtzDbydsxGjcmxil
qoqh_lxsd_ial
ecs_opzxgv_aqf_tudmnx
RN3ITMI
disposeBxknkgwhg
```

### Paths and artifacts

```text
%LOCALAPPDATA%\Microsoft\Windows\NtProfileIndex\
_spawn.log
_stealer.log
%APPDATA%\.minecraft
.minecraft\logs\latest.log
AppHost\main.py
python.exe
```

### Network / blockchain

```text
hxxps://polygon[.]drpc[.]org
hxxps://polygon-bor-rpc[.]publicnode[.]com
hxxps://1rpc[.]io/matic
hxxps://api[.]zan[.]top/polygon-mainnet
hxxps://rpc-mainnet[.]matic[.]quiknode[.]pro

0x9c0a507300fd902787bb193d80fca5ce6e1bff9a
0xce6d41de
/cdn/v2/9f4e7a2c1b8d.png
/shard/prefireMc
/shard/submitMinecraftLog
thisisafalsepositive.st
```

### Other recovered constants

```text
0f80364d-d645-42fb-a112-e4f4f692683e
jre-embedded
X-Edge-Cache-Revalidate
X-Runtime-Env
```

---

## 7. YARA

Rule file: `/home/l702x/Desktop/yara/silentnet_java_loader.yar` (relocated 2026-10-19; originally `yara/silentnet_java_loader.yar` in the isolated tree) — rewritten on 2026-10-19 (second run) in the style of the analyst's `OLD_silentnet.yar` reference ruleset: lowercase snake-case rule names, `meta` with `family`/`stage`/`confidence`/`description`/`reference`, semantically named strings, and paired/`3 of` style conditions.

| Rule | Stage | Target | Verified anchors |
|---|---|---|---|
| `silentnet_jar_dropper_structural` | stage1-jar | raw JAR | ZIP magic, `fabric.mod.json`, `net/fabric/PxibF0.class` + obfuscated class entries (all byte-verified contiguous) |
| `silentnet_stage1_clean_strings` | stage1-clean | deobfuscated sources / unpacked stage-1 | `AppHost`, `LOCALAPPDATA`, `_spawn.log`, `_stealer.log`, `main.py`, `python.exe`, `X-Runtime-Env`, `getDomain`, `prefire`, `0xce6d41de`, `polygon`, `drpc.org` |
| `silentnet_stage2_bundle` | stage2-python-bundle | recovered stage-2 bundle (downloaded at runtime) | `NtProfileIndex`, `NtProfileSync`, `/shard/submitData|Logs|prefireMc`, `/cdn/e/`, `python312.zip`, `staging-worker`, `74af664f…` — family-wide, carried from the reference build |
| `silentnet_c2_indicators` | c2-blockchain-crypto | paired IOC hunt (confirm before deleting) | `drpc.org`, `polygon`, `X-Runtime-Env`, `/shard/prefireMc`, selector `0xce6d41de`, plus older-build IOCs (`sltnnt.ru`, `silentnet.st`, IPs, `/cdn/e/`) — medium confidence |

Verified boundary (second run, all static byte/text reads):

- Rule 1 uses **only** anchors confirmed contiguous in the raw JAR. `"net.fabric.PxibF0"` (`Main-Class` value) is **not** contiguous there — the manifest content is compressed — so it was excluded from the structural condition.
- Rule 2's twelve strings are contiguous in the deobfuscated/recovered sources but **not** in the raw JAR (runtime obfuscation). Densest single-file set: `pumkdmXmuofa` (stealer chain) — AppHost, `_stealer.log`, `main.py`, `python.exe`, `X-Runtime-Env`, `getDomain`, `prefire`, `0xce6d41de`, `polygon`, `drpc.org`.
- Rule 3 is a port of the reference stage-2 rule; the stage-2 Python bundle is not shipped inside this JAR, so those strings are not verifiable against this sample.
- Rule 4 is intentionally the loosest: pair it with a structural or clean-strings hit before removing files.

Verification log (second run): `second_run/reports/yara-string-presence.txt` (per-string presence tables for both targets).

The YARA CLI is not installed in this environment, so the rules were not machine-compiled with `yarac`. Syntax follows YARA 4.x and mirrors the analyst's reference file — validate before production deployment and tune against a benign Fabric-mod corpus. Suggested use once YARA is available:

```bash
cd /home/l702x/Desktop/yara

yara -r silentnet_java_loader.yar /tmp/opencode/malware-static-20261019/raw/sample.jar.bin
yara -r silentnet_java_loader.yar /home/l702x/Desktop/work/silentnet-deobfuscated/recovered
yara -r silentnet_java_loader.yar <recovered-stage2-bundle-dir>
```

These rules detect the Java loader and its known family IOCs only. They do **not** execute or decode the live C2 domain, and they do **not** detect the downloaded Python payload unless the stage-2 bundle is recovered to a directory and scanned with rule 3.

---

## 8. Nuitka / PE / marshal / pickle note

The original request mentioned a “Nuitka-compiled Python” constant-pool method using `pefile` and `marshal`/`pickle`. For **this sample**, that method does not apply:

- The file is a Java JAR, not a PE.
- `pefile` would not parse it.
- There is no PyInstaller CArchive, `MEI` marker, `.pyc`, or Nuitka onefile overlay in the JAR.
- The Python payload is downloaded later as `main.py` plus a portable runtime.

If a separate PE/Nuitka sample appears:

- **Do not run the onefile bootstrapper to dump its temporary directory.** That is execution.
- Nuitka does not expose a PyInstaller-style marshal/pickle table of contents. It compiles Python to native code; onefile payloads are appended/compressed archives.
- Static alternatives: parse the PE overlay/resources with `pefile` read-only, locate and decompress the onefile archive with a dedicated parser, then use strings/YARA/disassembly. Running the binary is not required for initial triage.
- For PyInstaller, parse the CArchive TOC statically (e.g. a maintained `pyinstxtractor`), then disassemble `.pyc` with `xdis`/`dis`. Do not `pickle.load` untrusted data; inspect pickles with `pickletools.dis` only.
- If `marshal` is unavoidable, use a disposable `python3 -I` process with resource limits that only reads bytes. Never import or `exec()` sample content.

---

## 9. Deliberate gaps

1. **Live C2 domain:** returned by an `eth_call`; resolving it requires a sample-derived network request.
2. **Python stealer code:** downloaded at runtime as `main.py`; not present in the JAR.
3. **Runtime configuration:** `prefireId`, environment, and campaign values are server/contract supplied.
4. **Exact family-wide coverage:** YARA rules are variant-specific, not a complete SilentNet family signature.
