/*
 * Decompiled with CFR 0.152.
 */
package core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;

public class TorBridge {
    private static TorBridge instance;
    private Process torProcess;
    private int socksPort = 9050;
    private Path dataDir;
    private File torBinary;
    private boolean started;

    public static synchronized TorBridge get() {
        if (instance == null) {
            instance = new TorBridge();
        }
        return instance;
    }

    public void start() throws Exception {
        if (this.started) {
            return;
        }
        if (TorBridge.isPortOpen("127.0.0.1", 9050, 500)) {
            this.socksPort = 9050;
            this.started = true;
            System.out.println("[TorBridge] Using existing Tor on 127.0.0.1:9050");
            return;
        }
        this.startInternal(0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean isPortOpen(String string, int n, int n2) {
        try (Socket socket = new Socket();){
            socket.connect(new InetSocketAddress(string, n), n2);
            boolean bl = true;
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private void startInternal(int n) throws Exception {
        if (this.torProcess != null) {
            this.stop();
        }
        this.torBinary = this.findTorBinary();
        if (this.torBinary == null) {
            throw new IOException("Tor not found in JAR resources or system PATH.");
        }
        this.socksPort = this.findFreePort(9050);
        if (this.socksPort < 0) {
            throw new IOException("No free port in range 9050-9060");
        }
        this.startTorProcess();
        if (!this.waitForPort(60000L)) {
            this.stop();
            if (n < 1) {
                System.out.println("[TorBridge] Retrying...");
                this.startInternal(n + 1);
                return;
            }
            throw new Exception("Tor did not start within 60s");
        }
        this.started = true;
        System.out.println("[TorBridge] Ready on 127.0.0.1:" + this.socksPort);
    }

    public void stop() {
        this.started = false;
        if (this.torProcess != null) {
            this.torProcess.destroyForcibly();
            this.torProcess = null;
        }
        if (this.dataDir != null) {
            this.deleteDir(this.dataDir.toFile());
            this.dataDir = null;
        }
    }

    public Proxy socks() {
        return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", this.socksPort));
    }

    private File findTorBinary() {
        File file = this.extractFromJar();
        if (file != null) {
            return file;
        }
        file = this.findSystemTor();
        if (file != null) {
            return file;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private File extractFromJar() {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/tor/win/tor.exe");){
            if (inputStream == null) {
                File file2 = null;
                return file2;
            }
            Path path = Files.createTempFile("tor", ".exe", new FileAttribute[0]);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            File file3 = path.toFile();
            file3.deleteOnExit();
            file3.setExecutable(true);
            System.out.println("[TorBridge] Extracted tor.exe from JAR");
            File file = file3;
            return file;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private File findSystemTor() {
        File file;
        for (String string : System.getenv("PATH").split(File.pathSeparator)) {
            file = new File(string, "tor.exe");
            if (!file.exists()) continue;
            return file;
        }
        for (String string : new String[]{System.getenv("LOCALAPPDATA"), System.getenv("PROGRAMFILES"), System.getenv("PROGRAMFILES(X86)")}) {
            if (string == null || !(file = new File(string, "Tor Browser/Browser/TorBrowser/Tor/tor.exe")).exists()) continue;
            return file;
        }
        return null;
    }

    private int findFreePort(int n) {
        for (int i = n; i < n + 10; ++i) {
            try (Socket socket = new Socket();){
                socket.connect(new InetSocketAddress("127.0.0.1", i), 500);
                continue;
            }
            catch (IOException iOException) {
                return i;
            }
        }
        return -1;
    }

    private void startTorProcess() throws Exception {
        this.dataDir = Files.createTempDirectory("torbridge", new FileAttribute[0]);
        Path path = this.dataDir.resolve("torrc");
        Files.write(path, Arrays.asList("SocksPort " + this.socksPort, "DataDirectory " + this.dataDir, "Log notice stdout", "GeoIPFile /dev/null", "GeoIPv6File /dev/null"), new OpenOption[0]);
        this.torProcess = new ProcessBuilder(this.torBinary.getAbsolutePath(), "-f", path.toString()).redirectErrorStream(true).start();
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean waitForPort(long l) {
        long l2 = System.currentTimeMillis() + l;
        while (System.currentTimeMillis() < l2) {
            if (!this.torProcess.isAlive()) {
                System.out.println("[TorBridge] Process died");
                return false;
            }
            try (Socket socket = new Socket();){
                socket.connect(new InetSocketAddress("127.0.0.1", this.socksPort), 1000);
                try {
                    Thread.sleep(8000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
                boolean bl = true;
                return bl;
            }
            catch (Exception exception) {
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException throwable) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return false;
    }

    private void deleteDir(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                this.deleteDir(file2);
            }
            file2.delete();
        }
        file.delete();
    }
}
