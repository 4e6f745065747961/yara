/*
 * Decompiled with CFR 0.152.
 */
package core;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import core.Main;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class meow {
    private static final boolean INJECT_LOG = false;
    private static final int REMOTE_ARGS_SIZE_X64 = 40;
    private static final int REMOTE_ARGS_SIZE_X86 = 20;
    private static final byte[] REMOTE_LOAD_LIBRARY_X64 = new byte[]{85, 83, 72, -119, -27, 72, -125, -20, 40, 72, -119, -53, 72, -117, 67, 8, 72, -117, 11, -1, -48, 72, -119, 67, 24, 72, -123, -64, 117, 11, 72, -117, 67, 16, -1, -48, -119, 67, 32, -21, 7, -57, 67, 32, 0, 0, 0, 0, 72, -125, -60, 40, 91, 93, -61};
    private static final byte[] REMOTE_LOAD_LIBRARY_X86 = new byte[]{85, -117, -20, 83, -117, 93, 8, -1, 51, -117, 67, 4, -1, -48, -119, 67, 12, -123, -64, 117, 10, -117, 67, 8, -1, -48, -119, 67, 16, -21, 7, -57, 67, 16, 0, 0, 0, 0, 91, -117, -27, 93, -62, 4, 0};

    private static void injectLog(String string) {
    }

    private static boolean isWow64(Kernel32.HANDLE hANDLE) {
        IntByReference intByReference = new IntByReference();
        boolean bl = Kernel32.INSTANCE.IsWow64Process(hANDLE, intByReference);
        if (!bl) {
            int n = Native.getLastError();
            throw new RuntimeException("IsWow64Process failed: " + n);
        }
        return intByReference.getValue() != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static RemoteLoadResult loadLibraryRemoteWithError(Kernel32.HANDLE hANDLE, byte[] byArray, int n) {
        RemoteLoadResult remoteLoadResult;
        int n2 = 4096;
        int n3 = 8192;
        int n4 = 4;
        int n5 = 64;
        int n6 = 32768;
        int n7 = 258;
        boolean bl = Native.POINTER_SIZE == 8;
        boolean bl2 = meow.isWow64(Kernel32.INSTANCE.GetCurrentProcess());
        boolean bl3 = meow.isWow64(hANDLE);
        if (bl && bl3) {
            throw new RuntimeException("Target process is 32-bit (WOW64). Use a 32-bit injector/JVM.");
        }
        if (!bl && bl2 && !bl3) {
            throw new RuntimeException("Target process is 64-bit, but this JVM is 32-bit.");
        }
        boolean bl4 = bl && !bl3;
        byte[] byArray2 = bl4 ? REMOTE_LOAD_LIBRARY_X64 : REMOTE_LOAD_LIBRARY_X86;
        int n8 = bl4 ? 40 : 20;
        Pointer pointer = null;
        Pointer pointer2 = null;
        Pointer pointer3 = null;
        PointerType pointerType = null;
        try {
            int n9;
            long l;
            meow.injectLog("[injectDll] VirtualAllocEx len=" + n);
            pointer = Kernel32.INSTANCE.VirtualAllocEx(hANDLE, Pointer.NULL, n, n2 | n3, n4);
            if (pointer == null || Pointer.nativeValue(pointer) == 0L) {
                int n10 = Native.getLastError();
                meow.injectLog("[injectDll] VirtualAllocEx failed, lastError=" + n10);
                throw new RuntimeException("VirtualAllocEx failed: " + n10);
            }
            IntByReference intByReference = new IntByReference();
            boolean bl5 = Kernel32.INSTANCE.WriteProcessMemory(hANDLE, pointer, byArray, n, intByReference);
            meow.injectLog("[injectDll] WriteProcessMemory ret=" + bl5 + ", written=" + intByReference.getValue());
            if (!bl5 || intByReference.getValue() != n) {
                int n11 = Native.getLastError();
                throw new RuntimeException("WriteProcessMemory failed: " + n11 + ", written=" + intByReference.getValue());
            }
            Pointer pointer4 = Kernel32.INSTANCE.GetModuleHandleA("kernel32.dll");
            meow.injectLog("[injectDll] GetModuleHandleA(kernel32.dll)=" + Pointer.nativeValue(pointer4));
            if (pointer4 == null || Pointer.nativeValue(pointer4) == 0L) {
                int n12 = Native.getLastError();
                throw new RuntimeException("GetModuleHandleA failed: " + n12);
            }
            Pointer pointer5 = Kernel32.INSTANCE.GetProcAddress(pointer4, "LoadLibraryW");
            meow.injectLog("[injectDll] GetProcAddress(LoadLibraryW)=" + Pointer.nativeValue(pointer5));
            if (pointer5 == null || Pointer.nativeValue(pointer5) == 0L) {
                int n13 = Native.getLastError();
                throw new RuntimeException("GetProcAddress LoadLibraryW failed: " + n13);
            }
            Pointer pointer6 = Kernel32.INSTANCE.GetProcAddress(pointer4, "GetLastError");
            meow.injectLog("[injectDll] GetProcAddress(GetLastError)=" + Pointer.nativeValue(pointer6));
            if (pointer6 == null || Pointer.nativeValue(pointer6) == 0L) {
                int n14 = Native.getLastError();
                throw new RuntimeException("GetProcAddress GetLastError failed: " + n14);
            }
            byte[] byArray3 = new byte[n8];
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray3).order(ByteOrder.LITTLE_ENDIAN);
            if (bl4) {
                byteBuffer.putLong(0, Pointer.nativeValue(pointer));
                byteBuffer.putLong(8, Pointer.nativeValue(pointer5));
                byteBuffer.putLong(16, Pointer.nativeValue(pointer6));
                byteBuffer.putLong(24, 0L);
                byteBuffer.putInt(32, 0);
            } else {
                byteBuffer.putInt(0, (int)Pointer.nativeValue(pointer));
                byteBuffer.putInt(4, (int)Pointer.nativeValue(pointer5));
                byteBuffer.putInt(8, (int)Pointer.nativeValue(pointer6));
                byteBuffer.putInt(12, 0);
                byteBuffer.putInt(16, 0);
            }
            pointer2 = Kernel32.INSTANCE.VirtualAllocEx(hANDLE, Pointer.NULL, n8, n2 | n3, n4);
            if (pointer2 == null || Pointer.nativeValue(pointer2) == 0L) {
                int n15 = Native.getLastError();
                throw new RuntimeException("VirtualAllocEx(args) failed: " + n15);
            }
            intByReference.setValue(0);
            bl5 = Kernel32.INSTANCE.WriteProcessMemory(hANDLE, pointer2, byArray3, byArray3.length, intByReference);
            if (!bl5 || intByReference.getValue() != byArray3.length) {
                int n16 = Native.getLastError();
                throw new RuntimeException("WriteProcessMemory(args) failed: " + n16 + ", written=" + intByReference.getValue());
            }
            pointer3 = Kernel32.INSTANCE.VirtualAllocEx(hANDLE, Pointer.NULL, byArray2.length, n2 | n3, n5);
            if (pointer3 == null || Pointer.nativeValue(pointer3) == 0L) {
                int n17 = Native.getLastError();
                throw new RuntimeException("VirtualAllocEx(code) failed: " + n17);
            }
            intByReference.setValue(0);
            bl5 = Kernel32.INSTANCE.WriteProcessMemory(hANDLE, pointer3, byArray2, byArray2.length, intByReference);
            if (!bl5 || intByReference.getValue() != byArray2.length) {
                int n18 = Native.getLastError();
                throw new RuntimeException("WriteProcessMemory(code) failed: " + n18 + ", written=" + intByReference.getValue());
            }
            IntByReference intByReference2 = new IntByReference();
            pointerType = Kernel32.INSTANCE.CreateRemoteThread(hANDLE, null, 0, pointer3, pointer2, 0, intByReference2);
            meow.injectLog("[injectDll] CreateRemoteThread hThread=" + (pointerType == null ? 0L : Pointer.nativeValue(pointerType.getPointer())) + ", threadId=" + intByReference2.getValue());
            if (pointerType == null || Pointer.nativeValue(pointerType.getPointer()) == 0L) {
                int n19 = Native.getLastError();
                throw new RuntimeException("CreateRemoteThread failed: " + n19);
            }
            meow.injectLog("[injectDll] Waiting for remote LoadLibraryW stub to finish...");
            int n20 = Kernel32.INSTANCE.WaitForSingleObject((Kernel32.HANDLE)pointerType, 5000);
            meow.injectLog("[injectDll] WaitForSingleObject ret=" + n20);
            if (n20 == n7) {
                throw new RuntimeException("WaitForSingleObject timed out waiting for LoadLibraryW");
            }
            if (n20 != 0) {
                int n21 = Native.getLastError();
                throw new RuntimeException("WaitForSingleObject failed: " + n21);
            }
            byte[] byArray4 = new byte[n8];
            IntByReference intByReference3 = new IntByReference();
            boolean bl6 = Kernel32.INSTANCE.ReadProcessMemory(hANDLE, pointer2, byArray4, byArray4.length, intByReference3);
            if (!bl6 || intByReference3.getValue() != byArray4.length) {
                int n22 = Native.getLastError();
                throw new RuntimeException("ReadProcessMemory(args) failed: " + n22 + ", read=" + intByReference3.getValue());
            }
            ByteBuffer byteBuffer2 = ByteBuffer.wrap(byArray4).order(ByteOrder.LITTLE_ENDIAN);
            if (bl4) {
                l = byteBuffer2.getLong(24);
                n9 = byteBuffer2.getInt(32);
            } else {
                l = Integer.toUnsignedLong(byteBuffer2.getInt(12));
                n9 = byteBuffer2.getInt(16);
            }
            remoteLoadResult = new RemoteLoadResult(l, n9);
        }
        catch (Throwable throwable) {
            try {
                if (pointerType != null && Pointer.nativeValue(pointerType.getPointer()) != 0L) {
                    Kernel32.INSTANCE.CloseHandle((Kernel32.HANDLE)pointerType);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                if (pointer3 != null && Pointer.nativeValue(pointer3) != 0L) {
                    Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer3, 0, n6);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                if (pointer2 != null && Pointer.nativeValue(pointer2) != 0L) {
                    Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer2, 0, n6);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            try {
                if (pointer != null && Pointer.nativeValue(pointer) != 0L) {
                    Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer, 0, n6);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw throwable;
        }
        try {
            if (pointerType != null && Pointer.nativeValue(pointerType.getPointer()) != 0L) {
                Kernel32.INSTANCE.CloseHandle((Kernel32.HANDLE)pointerType);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (pointer3 != null && Pointer.nativeValue(pointer3) != 0L) {
                Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer3, 0, n6);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (pointer2 != null && Pointer.nativeValue(pointer2) != 0L) {
                Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer2, 0, n6);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (pointer != null && Pointer.nativeValue(pointer) != 0L) {
                Kernel32.INSTANCE.VirtualFreeEx(hANDLE, pointer, 0, n6);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return remoteLoadResult;
    }

    public static Main.ProcResult launchSuspendedProc(String string) {
        System.out.println(1);
        int n = 4;
        System.out.println(2);
        STARTUPINFO sTARTUPINFO = null;
        try {
            System.out.println("2.1 before STARTUPINFO");
            System.out.flush();
            sTARTUPINFO = new STARTUPINFO();
            System.out.println("3 after STARTUPINFO");
            System.out.flush();
            System.out.println("3.1 before si.size()");
            System.out.flush();
            sTARTUPINFO.cb = sTARTUPINFO.size();
            System.out.println("4 after si.size(), cb=" + sTARTUPINFO.cb);
            System.out.flush();
        }
        catch (Throwable throwable) {
            System.out.println("[fatal] failed around STARTUPINFO:");
            throwable.printStackTrace();
        }
        System.out.println("4 before PROCESS_INFORMATION");
        System.out.flush();
        PROCESS_INFORMATION pROCESS_INFORMATION = new PROCESS_INFORMATION();
        System.out.println("5 after PROCESS_INFORMATION");
        System.out.flush();
        System.out.println("[launchSuspendedProc] Calling CreateProcessW (lpApplicationName) for: " + string);
        File file = new File(string);
        WString wString = file.getParentFile() != null ? new WString(file.getParentFile().getAbsolutePath()) : null;
        boolean bl = Kernel32.INSTANCE.CreateProcessW(new WString(string), null, null, null, false, n, null, wString, sTARTUPINFO, pROCESS_INFORMATION);
        if (!bl) {
            int n2 = Native.getLastError();
            System.out.println("[launchSuspendedProc] First CreateProcessW failed (lpApplicationName), lastError=" + n2 + ". Retrying with command line...");
            String string2 = '\"' + string + '\"';
            pROCESS_INFORMATION = new PROCESS_INFORMATION();
            bl = Kernel32.INSTANCE.CreateProcessW(null, new WString(string2), null, null, false, n, null, wString, sTARTUPINFO, pROCESS_INFORMATION);
            if (!bl) {
                int n3 = Native.getLastError();
                System.out.println("[launchSuspendedProc] Second CreateProcessW failed (command line), lastError=" + n3);
                throw new RuntimeException("CreateProcessW failed: first=" + n2 + ", second=" + n3);
            }
        }
        System.out.println("[launchSuspendedProc] Created process PID=" + pROCESS_INFORMATION.dwProcessId + ", hProcess=" + Pointer.nativeValue(pROCESS_INFORMATION.hProcess.getPointer()));
        return new Main.ProcResult(pROCESS_INFORMATION.dwProcessId, pROCESS_INFORMATION.hProcess);
    }

    public static interface Kernel32
    extends StdCallLibrary {
        public static final Kernel32 INSTANCE = Kernel32Loader.access$000();

        public boolean CreateProcessW(WString var1, WString var2, Pointer var3, Pointer var4, boolean var5, int var6, Pointer var7, WString var8, STARTUPINFO var9, PROCESS_INFORMATION var10);

        public HANDLE CreateNamedPipeW(WString var1, int var2, int var3, int var4, int var5, int var6, int var7, Pointer var8);

        public boolean ConnectNamedPipe(HANDLE var1, Pointer var2);

        public boolean WriteFile(HANDLE var1, byte[] var2, int var3, IntByReference var4, Pointer var5);

        public boolean ReadFile(HANDLE var1, byte[] var2, int var3, IntByReference var4, Pointer var5);

        public Pointer VirtualAllocEx(HANDLE var1, Pointer var2, int var3, int var4, int var5);

        public boolean WriteProcessMemory(HANDLE var1, Pointer var2, byte[] var3, int var4, IntByReference var5);

        public boolean ReadProcessMemory(HANDLE var1, Pointer var2, byte[] var3, int var4, IntByReference var5);

        public boolean VirtualFreeEx(HANDLE var1, Pointer var2, int var3, int var4);

        public Pointer GetProcAddress(Pointer var1, String var2);

        public Pointer GetModuleHandleA(String var1);

        public HANDLE CreateRemoteThread(HANDLE var1, Pointer var2, int var3, Pointer var4, Pointer var5, int var6, IntByReference var7);

        public boolean CloseHandle(HANDLE var1);

        public boolean TerminateProcess(HANDLE var1, int var2);

        public int WaitForSingleObject(HANDLE var1, int var2);

        public boolean GetExitCodeThread(HANDLE var1, IntByReference var2);

        public boolean IsWow64Process(HANDLE var1, IntByReference var2);

        public HANDLE GetCurrentProcess();

        public static class HANDLE
        extends PointerType {
        }
    }

    public static class RemoteLoadResult {
        public final long moduleHandle;
        public final int lastError;

        public RemoteLoadResult(long l, int n) {
            this.moduleHandle = l;
            this.lastError = n;
        }
    }

    public static class STARTUPINFO
    extends Structure {
        public int cb;
        public Pointer lpReserved;
        public Pointer lpDesktop;
        public Pointer lpTitle;
        public int dwX;
        public int dwY;
        public int dwXSize;
        public int dwYSize;
        public int dwXCountChars;
        public int dwYCountChars;
        public int dwFillAttribute;
        public int dwFlags;
        public short wShowWindow;
        public short cbReserved2;
        public Pointer lpReserved2;
        public Kernel32.HANDLE hStdInput;
        public Kernel32.HANDLE hStdOutput;
        public Kernel32.HANDLE hStdError;

        public STARTUPINFO() {
            STARTUPINFO.debugStartupInfo("constructor body entered");
        }

        @Override
        protected List<String> getFieldOrder() {
            STARTUPINFO.debugStartupInfo("getFieldOrder called");
            return Arrays.asList("cb", "lpReserved", "lpDesktop", "lpTitle", "dwX", "dwY", "dwXSize", "dwYSize", "dwXCountChars", "dwYCountChars", "dwFillAttribute", "dwFlags", "wShowWindow", "cbReserved2", "lpReserved2", "hStdInput", "hStdOutput", "hStdError");
        }

        private static void debugStartupInfo(String string) {
            Thread thread = Thread.currentThread();
            ClassLoader classLoader = STARTUPINFO.class.getClassLoader();
            System.out.println("[STARTUPINFO] " + string + ", thread=" + thread.getName() + ", state=" + (Object)((Object)thread.getState()) + ", classLoader=" + classLoader + ", java.version=" + System.getProperty("java.version") + ", jna.tmpdir=" + System.getProperty("jna.tmpdir") + ", java.io.tmpdir=" + System.getProperty("java.io.tmpdir"));
            System.out.flush();
        }

        static {
            STARTUPINFO.debugStartupInfo("static init entered");
        }
    }

    public static class PROCESS_INFORMATION
    extends Structure {
        public Kernel32.HANDLE hProcess;
        public Kernel32.HANDLE hThread;
        public int dwProcessId;
        public int dwThreadId;

        public PROCESS_INFORMATION() {
            PROCESS_INFORMATION.debugProcessInfo("constructor body entered");
        }

        @Override
        protected List<String> getFieldOrder() {
            PROCESS_INFORMATION.debugProcessInfo("getFieldOrder called");
            return Arrays.asList("hProcess", "hThread", "dwProcessId", "dwThreadId");
        }

        private static void debugProcessInfo(String string) {
            Thread thread = Thread.currentThread();
            ClassLoader classLoader = PROCESS_INFORMATION.class.getClassLoader();
            System.out.println("[PROCESS_INFORMATION] " + string + ", thread=" + thread.getName() + ", state=" + (Object)((Object)thread.getState()) + ", classLoader=" + classLoader + ", java.version=" + System.getProperty("java.version") + ", jna.tmpdir=" + System.getProperty("jna.tmpdir") + ", java.io.tmpdir=" + System.getProperty("java.io.tmpdir"));
            System.out.flush();
        }

        static {
            PROCESS_INFORMATION.debugProcessInfo("static init entered");
        }
    }

    private static final class Kernel32Loader {
        private Kernel32Loader() {
        }

        private static Kernel32 load() {
            System.out.println("[Kernel32] before Native.load(kernel32)");
            System.out.flush();
            Kernel32 kernel32 = Native.load("kernel32", Kernel32.class);
            System.out.println("[Kernel32] after Native.load(kernel32)");
            System.out.flush();
            return kernel32;
        }

        static /* synthetic */ Kernel32 access$000() {
            return Kernel32Loader.load();
        }
    }
}
