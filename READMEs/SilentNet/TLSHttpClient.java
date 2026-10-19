/*
 * Decompiled with CFR 0.152.
 */
package net.fabric;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class lDYyOSFGzNWbBC {
    private static final Map<String, zek_rqbfns_ve> jGyfonhg = new ConcurrentHashMap<String, zek_rqbfns_ve>();
    private static SSLSocketFactory wExpAwbYTJt;

    public lDYyOSFGzNWbBC() {
        lDYyOSFGzNWbBC e6;
    }

    public static tmpDfpsfslfu get(String i3) throws IOException {
        return lDYyOSFGzNWbBC.IWVPOjcC4iBBhP("GET", i3, null, null, null);
    }

    public static tmpDfpsfslfu get(String ihrgxpYpmCuaJcht, Map<String, String> wkl_lernjc_ozhc_yc) throws IOException {
        return lDYyOSFGzNWbBC.IWVPOjcC4iBBhP("GET", ihrgxpYpmCuaJcht, null, null, wkl_lernjc_ozhc_yc);
    }

    public static tmpDfpsfslfu qo_uricmz(String xf_yf_eql, String nsiSitnHuosvEdfqy, String oannabZxeqDpcl) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('P');
        stringBuilder.append('O');
        stringBuilder.append('S');
        stringBuilder.append('T');
        return lDYyOSFGzNWbBC.IWVPOjcC4iBBhP(stringBuilder.toString(), xf_yf_eql, nsiSitnHuosvEdfqy, oannabZxeqDpcl, null);
    }

    public static tmpDfpsfslfu qoqh_lxsd_ial(String iNhdc4_1w, String tailPtr, String nYBXA1VK7Z, Map<String, String> ltgsk_ejhb) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('P');
        stringBuilder.append('O');
        stringBuilder.append('S');
        stringBuilder.append('T');
        return lDYyOSFGzNWbBC.IWVPOjcC4iBBhP(stringBuilder.toString(), iNhdc4_1w, tailPtr, nYBXA1VK7Z, ltgsk_ejhb);
    }

    public static tmpDfpsfslfu put(String boDceg, String xIdx, String refLen, Map<String, String> WzKw_USrw_QSpl_auoq) throws IOException {
        return lDYyOSFGzNWbBC.IWVPOjcC4iBBhP("PUT", boDceg, xIdx, refLen, WzKw_USrw_QSpl_auoq);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static tmpDfpsfslfu IWVPOjcC4iBBhP(String rlenkq_unsl, String nameStr, String lpnq_yhy_yidnr_huzuy, String jAux, Map<String, String> gZBb_oODp_Plaz_LdtF) throws IOException {
        Socket VBF;
        String Y0rL;
        URL ZzEA_Ktyn_DLUZ_aTXl = URI.create(nameStr).toURL();
        String xbm_gwaoq = ZzEA_Ktyn_DLUZ_aTXl.getHost();
        int LL__f_54 = ZzEA_Ktyn_DLUZ_aTXl.getPort();
        char[] cArray = new char[]{'h', 't', 't', 'p', 's'};  // 'https'
        boolean gdgBoHqxsglYqdyc = ZzEA_Ktyn_DLUZ_aTXl.getProtocol().equalsIgnoreCase("https");
        if (LL__f_54 == -1) {
            int n = LL__f_54 = gdgBoHqxsglYqdyc ? 443 : 80;
        }
        if ((Y0rL = ZzEA_Ktyn_DLUZ_aTXl.getPath()) == null || Y0rL.isEmpty()) {
            Y0rL = "/";
        }
        if (ZzEA_Ktyn_DLUZ_aTXl.getQuery() != null) {
            String string = ZzEA_Ktyn_DLUZ_aTXl.getQuery();
            String string2 = Y0rL;
            Y0rL = string2 + "?" + string;
        }
        String AWXE_PtGc_taNB_IxUu = lDYyOSFGzNWbBC.tcegu_fd_dcjzdo(xbm_gwaoq);
        Socket lenIdx = new Socket();
        lenIdx.setReceiveBufferSize(524288);
        lenIdx.connect(new InetSocketAddress(AWXE_PtGc_taNB_IxUu, LL__f_54), 10000);
        lenIdx.setSoTimeout(30000);
        if (gdgBoHqxsglYqdyc) {
            SSLSocket ejiibkRurbp = (SSLSocket)wExpAwbYTJt.createSocket(lenIdx, xbm_gwaoq, LL__f_54, true);
            SSLParameters vStr = ejiibkRurbp.getSSLParameters();
            vStr.setServerNames(List.of(new SNIHostName(xbm_gwaoq)));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('H');
            stringBuilder.append('T');
            stringBuilder.append('T');
            stringBuilder.append('P');
            stringBuilder.append('S');
            vStr.setEndpointIdentificationAlgorithm(stringBuilder.toString());
            ejiibkRurbp.setSSLParameters(vStr);
            ejiibkRurbp.startHandshake();
            SSLSocket mfodiz_ec_hve_zgnqht = ejiibkRurbp;
        } else {
            VBF = lenIdx;
        }
        try {
            OutputStream tyllErnsmSknd = VBF.getOutputStream();
            InputStream fn_ractom_emdzz = VBF.getInputStream();
            StringBuilder TJhtFdEEM = new StringBuilder();
            int n = 449057211;
            if ((n ^ 0x1AC411BB) == 0) {
                long l = -1937027109L;
                l *= 118L;
                l ^= 0xFFFFFFFF95858D67L;
                long l2 = 9032461311499353824L;
                l2 &= 0x8F7E4FCCBE3F2EACL;
                l2 |= 0xC4AFDE3120296C2BL;
            }
            StringBuilder stringBuilder = TJhtFdEEM.append(rlenkq_unsl).append(" ").append(Y0rL);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(' ');
            stringBuilder2.append('H');
            stringBuilder2.append('T');
            stringBuilder2.append('T');
            stringBuilder2.append('P');
            stringBuilder2.append('/');
            stringBuilder2.append('1');
            stringBuilder2.append('.');
            stringBuilder2.append('1');
            stringBuilder2.append('\r');
            stringBuilder2.append('\n');
            stringBuilder.append(stringBuilder2.toString());
            char[] cArray2 = new char[]{'H', 'o', 's', 't', ':', ' '};  // 'Host: '
            TJhtFdEEM.append("Host: ").append(xbm_gwaoq);
            if (gdgBoHqxsglYqdyc && LL__f_54 != 443 || !gdgBoHqxsglYqdyc && LL__f_54 != 80) {
                TJhtFdEEM.append(":").append(LL__f_54);
            }
            TJhtFdEEM.append("\r\n");
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append('C');
            stringBuilder3.append('o');
            stringBuilder3.append('n');
            stringBuilder3.append('n');
            stringBuilder3.append('e');
            stringBuilder3.append('c');
            stringBuilder3.append('t');
            stringBuilder3.append('i');
            stringBuilder3.append('o');
            stringBuilder3.append('n');
            stringBuilder3.append(':');
            stringBuilder3.append(' ');
            stringBuilder3.append('c');
            stringBuilder3.append('l');
            stringBuilder3.append('o');
            stringBuilder3.append('s');
            stringBuilder3.append('e');
            stringBuilder3.append('\r');
            stringBuilder3.append('\n');
            TJhtFdEEM.append(stringBuilder3.toString());
            boolean sozlyx_bb_uki_aiu = false;
            boolean ro_whgh_nj_xgvex = false;
            if (gZBb_oODp_Plaz_LdtF != null) {
                for (Map.Entry<String, String> Vr_6 : gZBb_oODp_Plaz_LdtF.entrySet()) {
                    String fP07S = Vr_6.getKey();
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append('H');
                    stringBuilder4.append('o');
                    stringBuilder4.append('s');
                    stringBuilder4.append('t');
                    if (fP07S.equalsIgnoreCase(stringBuilder4.toString())) continue;
                    char[] cArray3 = new char[]{'C', 'o', 'n', 'n', 'e', 'c', 't', 'i', 'o', 'n'};  // 'Connection'
                    if (fP07S.equalsIgnoreCase("Connection")) continue;
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append('C');
                    stringBuilder5.append('o');
                    stringBuilder5.append('n');
                    stringBuilder5.append('t');
                    stringBuilder5.append('e');
                    stringBuilder5.append('n');
                    stringBuilder5.append('t');
                    stringBuilder5.append('-');
                    stringBuilder5.append('L');
                    stringBuilder5.append('e');
                    stringBuilder5.append('n');
                    stringBuilder5.append('g');
                    stringBuilder5.append('t');
                    stringBuilder5.append('h');
                    if (fP07S.equalsIgnoreCase(stringBuilder5.toString())) continue;
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append('A');
                    stringBuilder6.append('c');
                    stringBuilder6.append('c');
                    stringBuilder6.append('e');
                    stringBuilder6.append('p');
                    stringBuilder6.append('t');
                    if (fP07S.equalsIgnoreCase(stringBuilder6.toString())) {
                        sozlyx_bb_uki_aiu = true;
                    }
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append('U');
                    stringBuilder7.append('s');
                    stringBuilder7.append('e');
                    stringBuilder7.append('r');
                    stringBuilder7.append('-');
                    stringBuilder7.append('A');
                    stringBuilder7.append('g');
                    stringBuilder7.append('e');
                    stringBuilder7.append('n');
                    stringBuilder7.append('t');
                    if (fP07S.equalsIgnoreCase(stringBuilder7.toString())) {
                        ro_whgh_nj_xgvex = true;
                    }
                    TJhtFdEEM.append(fP07S).append(": ").append(Vr_6.getValue()).append("\r\n");
                }
            }
            if (!sozlyx_bb_uki_aiu) {
                char[] cArray4 = new char[]{'A', 'c', 'c', 'e', 'p', 't', ':', ' ', '*', '/', '*', '\r', '\n'};  // 'Accept: */*\r\n'
                TJhtFdEEM.append("Accept: */*\r\n");
            }
            if (!ro_whgh_nj_xgvex) {
                StringBuilder stringBuilder8 = new StringBuilder();
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append('U');
                stringBuilder9.append('s');
                stringBuilder9.append('e');
                stringBuilder9.append('r');
                stringBuilder9.append('-');
                stringBuilder9.append('A');
                stringBuilder9.append('g');
                stringBuilder9.append('e');
                stringBuilder9.append('n');
                stringBuilder9.append('t');
                stringBuilder9.append(':');
                stringBuilder9.append(' ');
                stringBuilder9.append('M');
                stringBuilder9.append('o');
                stringBuilder9.append('z');
                stringBuilder9.append('i');
                stringBuilder8.append(stringBuilder9.toString());
                StringBuilder stringBuilder10 = new StringBuilder();
                stringBuilder10.append('l');
                stringBuilder10.append('l');
                stringBuilder10.append('a');
                stringBuilder10.append('/');
                stringBuilder10.append('5');
                stringBuilder10.append('.');
                stringBuilder10.append('0');
                stringBuilder10.append(' ');
                stringBuilder10.append('(');
                stringBuilder10.append('W');
                stringBuilder10.append('i');
                stringBuilder10.append('n');
                stringBuilder8.append(stringBuilder10.toString());
                char[] cArray5 = new char[]{'d', 'o', 'w', 's', ' ', 'N', 'T', ' ', '1', '0', '.', '0', ';'};  // 'dows NT 10.0;'
                stringBuilder8.append("dows NT 10.0;");
                char[] cArray6 = new char[]{' ', 'W', 'i', 'n', '6', '4', ';', ' ', 'x', '6', '4', ')', ' ', 'A'};  // ' Win64; x64) A'
                stringBuilder8.append(" Win64; x64) A");
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append('p');
                stringBuilder11.append('p');
                stringBuilder11.append('l');
                stringBuilder11.append('e');
                stringBuilder11.append('W');
                stringBuilder11.append('e');
                stringBuilder11.append('b');
                stringBuilder11.append('K');
                stringBuilder11.append('i');
                stringBuilder11.append('t');
                stringBuilder11.append('/');
                stringBuilder11.append('5');
                stringBuilder11.append('3');
                stringBuilder11.append('7');
                stringBuilder11.append('.');
                stringBuilder11.append('3');
                stringBuilder11.append('6');
                stringBuilder11.append('\r');
                stringBuilder11.append('\n');
                stringBuilder8.append(stringBuilder11.toString());
                TJhtFdEEM.append(stringBuilder8.toString());
            }
            byte[] qomLV = null;
            if (lpnq_yhy_yidnr_huzuy != null) {
                qomLV = lpnq_yhy_yidnr_huzuy.getBytes(StandardCharsets.UTF_8);
                if (jAux != null) {
                    StringBuilder stringBuilder12 = new StringBuilder();
                    stringBuilder12.append('C');
                    stringBuilder12.append('o');
                    stringBuilder12.append('n');
                    stringBuilder12.append('t');
                    stringBuilder12.append('e');
                    stringBuilder12.append('n');
                    stringBuilder12.append('t');
                    stringBuilder12.append('-');
                    stringBuilder12.append('T');
                    stringBuilder12.append('y');
                    stringBuilder12.append('p');
                    stringBuilder12.append('e');
                    stringBuilder12.append(':');
                    stringBuilder12.append(' ');
                    TJhtFdEEM.append(stringBuilder12.toString()).append(jAux).append("\r\n");
                }
                char[] cArray7 = new char[]{'C', 'o', 'n', 't', 'e', 'n', 't', '-', 'L', 'e', 'n', 'g', 't', 'h', ':', ' '};  // 'Content-Length: '
                TJhtFdEEM.append("Content-Length: ").append(qomLV.length).append("\r\n");
            }
            TJhtFdEEM.append("\r\n");
            tyllErnsmSknd.write(TJhtFdEEM.toString().getBytes(StandardCharsets.ISO_8859_1));
            if (qomLV != null) {
                tyllErnsmSknd.write(qomLV);
            }
            tyllErnsmSknd.flush();
            tmpDfpsfslfu tmpDfpsfslfu2 = lDYyOSFGzNWbBC.rPC5wfbk(fn_ractom_emdzz);
            return tmpDfpsfslfu2;
        }
        finally {
            VBF.close();
        }
    }

    private static tmpDfpsfslfu rPC5wfbk(InputStream objRaw) throws IOException {
        byte[] lITY_sXUE_ZZsR_mxGB;
        int Kgqp_Ayhy_sWrf_wTCd;
        String cx_smlio_gwv_qnkl;
        String[] F6_lf1_S;
        int UGDo_x_Z_2;
        BufferedInputStream mbY1AU3vOPeZ0 = new BufferedInputStream(objRaw);
        ByteArrayOutputStream kn_feh_zxid_dxkiq = new ByteArrayOutputStream();
        int refRef = -1;
        while ((UGDo_x_Z_2 = mbY1AU3vOPeZ0.read()) != -1) {
            kn_feh_zxid_dxkiq.write(UGDo_x_Z_2);
            if (refRef == 13 && UGDo_x_Z_2 == 10) {
                int pjqajw_ywqnmo = kn_feh_zxid_dxkiq.size();
                byte[] mpwep_xfvxx = kn_feh_zxid_dxkiq.toByteArray();
                if (pjqajw_ywqnmo >= 4 && mpwep_xfvxx[pjqajw_ywqnmo - 4] == 13 && mpwep_xfvxx[pjqajw_ywqnmo - 3] == 10) break;
            }
            refRef = UGDo_x_Z_2;
        }
        String vStr = (F6_lf1_S = (cx_smlio_gwv_qnkl = kn_feh_zxid_dxkiq.toString(StandardCharsets.ISO_8859_1)).split("\r\n")).length > 0 ? F6_lf1_S[0] : "";
        int ptrOut = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('H');
        stringBuilder.append('T');
        stringBuilder.append('T');
        stringBuilder.append('P');
        stringBuilder.append('/');
        if (vStr.startsWith(stringBuilder.toString()) && (Kgqp_Ayhy_sWrf_wTCd = vStr.indexOf(32)) > 0) {
            int nvfQyhozEkmWjkiwm = vStr.indexOf(32, Kgqp_Ayhy_sWrf_wTCd + 1);
            String crhGueuwFcaAizabm = nvfQyhozEkmWjkiwm > 0 ? vStr.substring(Kgqp_Ayhy_sWrf_wTCd + 1, nvfQyhozEkmWjkiwm) : vStr.substring(Kgqp_Ayhy_sWrf_wTCd + 1);
            try {
                ptrOut = Integer.parseInt(crhGueuwFcaAizabm.trim());
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        LinkedHashMap<String, String> rdluuEjwdvHfbuzu = new LinkedHashMap<String, String>();
        int kleTzkzaeQndKljhd = -1;
        boolean sA4P8Hq = false;
        for (int nmoh_xxll_on = 1; nmoh_xxll_on < F6_lf1_S.length; ++nmoh_xxll_on) {
            String flQk = F6_lf1_S[nmoh_xxll_on];
            int str5 = flQk.indexOf(58);
            if (str5 <= 0) continue;
            String qsk_wvckto_lxxm_jkav = flQk.substring(0, str5).trim().toLowerCase();
            String cmqzyeNrpmchJzawh = flQk.substring(str5 + 1).trim();
            rdluuEjwdvHfbuzu.put(qsk_wvckto_lxxm_jkav, cmqzyeNrpmchJzawh);
            char[] cArray = new char[]{'c', 'o', 'n', 't', 'e', 'n', 't', '-', 'l', 'e', 'n', 'g', 't', 'h'};  // 'content-length'
            if (qsk_wvckto_lxxm_jkav.equals("content-length")) {
                try {
                    kleTzkzaeQndKljhd = Integer.parseInt(cmqzyeNrpmchJzawh);
                }
                catch (NumberFormatException numberFormatException) {}
                continue;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('t');
            stringBuilder2.append('r');
            stringBuilder2.append('a');
            stringBuilder2.append('n');
            stringBuilder2.append('s');
            stringBuilder2.append('f');
            stringBuilder2.append('e');
            stringBuilder2.append('r');
            stringBuilder2.append('-');
            stringBuilder2.append('e');
            stringBuilder2.append('n');
            stringBuilder2.append('c');
            stringBuilder2.append('o');
            stringBuilder2.append('d');
            stringBuilder2.append('i');
            stringBuilder2.append('n');
            stringBuilder2.append('g');
            if (!qsk_wvckto_lxxm_jkav.equals(stringBuilder2.toString())) continue;
            char[] cArray2 = new char[]{'c', 'h', 'u', 'n', 'k', 'e', 'd'};  // 'chunked'
            if (!cmqzyeNrpmchJzawh.toLowerCase().contains("chunked")) continue;
            sA4P8Hq = true;
        }
        if (sA4P8Hq) {
            byte[] Ns8fkQNgF = lDYyOSFGzNWbBC.dsrqmkzOovnt(mbY1AU3vOPeZ0);
        } else if (kleTzkzaeQndKljhd >= 0) {
            int PXxwJude;
            byte[] b0HyR_ss1nf = new byte[kleTzkzaeQndKljhd];
            for (int bcVilMsnFqz = 0; bcVilMsnFqz < kleTzkzaeQndKljhd && (PXxwJude = mbY1AU3vOPeZ0.read(b0HyR_ss1nf, bcVilMsnFqz, kleTzkzaeQndKljhd - bcVilMsnFqz)) != -1; bcVilMsnFqz += PXxwJude) {
            }
        } else {
            int BgnlzO;
            ByteArrayOutputStream IXwX_wUMF_dnQL_CNpG = new ByteArrayOutputStream(0x100000);
            byte[] iFqo_iIGG_FRzk_nYWU = new byte[131072];
            while ((BgnlzO = mbY1AU3vOPeZ0.read(iFqo_iIGG_FRzk_nYWU)) != -1) {
                int n = 1576426;
                if (n >= 1576426 && n < 4726293) {
                    n = 27710;
                    n ^= 0x5C;
                    int n2 = 699208202;
                    n2 <<= 4;
                    n2 >>>= 21;
                }
                IXwX_wUMF_dnQL_CNpG.write(iFqo_iIGG_FRzk_nYWU, 0, BgnlzO);
            }
            lITY_sXUE_ZZsR_mxGB = IXwX_wUMF_dnQL_CNpG.toByteArray();
        }
        return new tmpDfpsfslfu(ptrOut, vStr, rdluuEjwdvHfbuzu, lITY_sXUE_ZZsR_mxGB);
    }

    private static byte[] dsrqmkzOovnt(InputStream ccR_cdV) throws IOException {
        ByteArrayOutputStream entryItem = new ByteArrayOutputStream(0x100000);
        StringBuilder gswkRqstFtuz = new StringBuilder();
        while (true) {
            int uWzr_KOXX_XtQc_kRAI;
            int XOXT_ddlH_QEdo_xroM;
            int bLen;
            String iowg_isbvy;
            int bdouYsbgSttdlRoyu;
            int utFZJ;
            gswkRqstFtuz.setLength(0);
            while ((utFZJ = ccR_cdV.read()) != -1 && utFZJ != 13) {
                gswkRqstFtuz.append((char)utFZJ);
            }
            if (utFZJ == 13) {
                ccR_cdV.read();
            }
            if ((bdouYsbgSttdlRoyu = (iowg_isbvy = gswkRqstFtuz.toString()).indexOf(59)) >= 0) {
                iowg_isbvy = iowg_isbvy.substring(0, bdouYsbgSttdlRoyu);
            }
            if (iowg_isbvy.isEmpty() || (bLen = Integer.parseInt(iowg_isbvy.trim(), 16)) == 0) break;
            byte[] ubkdelWhyltpNh = new byte[bLen];
            for (uWzr_KOXX_XtQc_kRAI = 0; uWzr_KOXX_XtQc_kRAI < bLen && (XOXT_ddlH_QEdo_xroM = ccR_cdV.read(ubkdelWhyltpNh, uWzr_KOXX_XtQc_kRAI, bLen - uWzr_KOXX_XtQc_kRAI)) != -1; uWzr_KOXX_XtQc_kRAI += XOXT_ddlH_QEdo_xroM) {
            }
            entryItem.write(ubkdelWhyltpNh, 0, uWzr_KOXX_XtQc_kRAI);
            ccR_cdV.read();
            ccR_cdV.read();
        }
        return entryItem.toByteArray();
    }

    public static String tcegu_fd_dcjzdo(String YtdH_kRoK_OZTt_hXal) throws IOException {
        if (lDYyOSFGzNWbBC.pggzEr(YtdH_kRoK_OZTt_hXal)) {
            return YtdH_kRoK_OZTt_hXal;
        }
        zek_rqbfns_ve y5 = jGyfonhg.get(YtdH_kRoK_OZTt_hXal);
        if (y5 != null && !y5.isExpired()) {
            return y5.ip;
        }
        byte[] imhkUiKytcrPjbhng = lDYyOSFGzNWbBC.lvczEd(YtdH_kRoK_OZTt_hXal);
        byte[] hbockk_nmafx = lDYyOSFGzNWbBC.szq_wzc_ubs_qxux(imhkUiKytcrPjbhng);
        String limit3 = lDYyOSFGzNWbBC.lewDf(hbockk_nmafx);
        if (limit3 != null) {
            jGyfonhg.put(YtdH_kRoK_OZTt_hXal, new zek_rqbfns_ve(limit3, System.currentTimeMillis() + 300000L));
        }
        return limit3;
    }

    private static boolean pggzEr(String ejuGapjyAgtnWi) {
        if (ejuGapjyAgtnWi == null || ejuGapjyAgtnWi.isEmpty()) {
            return false;
        }
        for (int mk__DZpR = 0; mk__DZpR < ejuGapjyAgtnWi.length(); ++mk__DZpR) {
            char IyEc_rUUT_FEPt_wStx = ejuGapjyAgtnWi.charAt(mk__DZpR);
            if (IyEc_rUUT_FEPt_wStx == '.' || IyEc_rUUT_FEPt_wStx >= '0' && IyEc_rUUT_FEPt_wStx <= '9') continue;
            return false;
        }
        return ejuGapjyAgtnWi.contains(".");
    }

    private static byte[] lvczEd(String g0i6CfVH_j7p) {
        ByteArrayOutputStream zsmz_vwfdpo_lnf = new ByteArrayOutputStream();
        DataOutputStream tailPtr = new DataOutputStream(zsmz_vwfdpo_lnf);
        try {
            short k1 = (short)(System.nanoTime() & 0xFFFFL);
            tailPtr.writeShort(k1);
            tailPtr.writeShort(256);
            tailPtr.writeShort(1);
            tailPtr.writeShort(0);
            tailPtr.writeShort(0);
            tailPtr.writeShort(0);
            for (String BexA_qWDq_wcmq_tCti : g0i6CfVH_j7p.split("\\.")) {
                tailPtr.writeByte(BexA_qWDq_wcmq_tCti.length());
                tailPtr.writeBytes(BexA_qWDq_wcmq_tCti);
            }
            tailPtr.writeByte(0);
            tailPtr.writeShort(1);
            tailPtr.writeShort(1);
        }
        catch (IOException nlqfqLkyUenxxyUt) {
            throw new RuntimeException(nlqfqLkyUenxxyUt);
        }
        return zsmz_vwfdpo_lnf.toByteArray();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] szq_wzc_ubs_qxux(byte[] Icep_dcIH_Szgm_lpyl) throws IOException {
        Socket objNum = new Socket();
        char[] cArray = new char[]{'1', '.', '1', '.', '1', '.', '1'};  // '1.1.1.1'
        objNum.connect(new InetSocketAddress("1.1.1.1", 443), 10000);
        objNum.setSoTimeout(30000);
        char[] cArray2 = new char[]{'c', 'l', 'o', 'u', 'd', 'f', 'l', 'a', 'r', 'e', '-', 'd', 'n', 's', '.', 'c', 'o', 'm'};  // 'cloudflare-dns.com'
        SSLSocket ojdiy_ojri_qwkhcs_je = (SSLSocket)wExpAwbYTJt.createSocket(objNum, "cloudflare-dns.com", 443, true);
        SSLParameters FKUI_Edqs_mlnQ_mIUC = ojdiy_ojri_qwkhcs_je.getSSLParameters();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('c');
        stringBuilder.append('l');
        stringBuilder.append('o');
        stringBuilder.append('u');
        stringBuilder.append('d');
        stringBuilder.append('f');
        stringBuilder.append('l');
        stringBuilder.append('a');
        stringBuilder.append('r');
        stringBuilder.append('e');
        stringBuilder.append('-');
        stringBuilder.append('d');
        stringBuilder.append('n');
        stringBuilder.append('s');
        stringBuilder.append('.');
        stringBuilder.append('c');
        stringBuilder.append('o');
        stringBuilder.append('m');
        FKUI_Edqs_mlnQ_mIUC.setServerNames(List.of(new SNIHostName(stringBuilder.toString())));
        ojdiy_ojri_qwkhcs_je.setSSLParameters(FKUI_Edqs_mlnQ_mIUC);
        ojdiy_ojri_qwkhcs_je.startHandshake();
        try {
            OutputStream elapsed3 = ojdiy_ojri_qwkhcs_je.getOutputStream();
            InputStream uFI4Ei_384qqbN = ojdiy_ojri_qwkhcs_je.getInputStream();
            String data2 = Base64.getUrlEncoder().withoutPadding().encodeToString(Icep_dcIH_Szgm_lpyl);
            StringBuilder mttY_Posc_yPdl_NeFX = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('G');
            stringBuilder2.append('E');
            stringBuilder2.append('T');
            stringBuilder2.append(' ');
            stringBuilder2.append('/');
            stringBuilder2.append('d');
            stringBuilder2.append('n');
            stringBuilder2.append('s');
            stringBuilder2.append('-');
            stringBuilder2.append('q');
            stringBuilder2.append('u');
            stringBuilder2.append('e');
            stringBuilder2.append('r');
            stringBuilder2.append('y');
            stringBuilder2.append('?');
            stringBuilder2.append('d');
            stringBuilder2.append('n');
            stringBuilder2.append('s');
            stringBuilder2.append('=');
            StringBuilder stringBuilder3 = mttY_Posc_yPdl_NeFX.append(stringBuilder2.toString()).append(data2);
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(' ');
            stringBuilder4.append('H');
            stringBuilder4.append('T');
            stringBuilder4.append('T');
            stringBuilder4.append('P');
            stringBuilder4.append('/');
            stringBuilder4.append('1');
            stringBuilder4.append('.');
            stringBuilder4.append('1');
            stringBuilder4.append('\r');
            stringBuilder4.append('\n');
            stringBuilder3.append(stringBuilder4.toString());
            StringBuilder stringBuilder5 = new StringBuilder();
            char[] cArray3 = new char[]{'H', 'o', 's', 't', ':', ' ', 'c', 'l', 'o', 'u', 'd', 'f', 'l', 'a'};  // 'Host: cloudfla'
            stringBuilder5.append("Host: cloudfla");
            char[] cArray4 = new char[]{'r', 'e', '-', 'd', 'n', 's', '.', 'c', 'o', 'm', '\r', '\n'};  // 're-dns.com\r\n'
            stringBuilder5.append("re-dns.com\r\n");
            mttY_Posc_yPdl_NeFX.append(stringBuilder5.toString());
            StringBuilder stringBuilder6 = new StringBuilder();
            char[] cArray5 = new char[]{'A', 'c', 'c', 'e', 'p', 't', ':', ' ', 'a', 'p'};  // 'Accept: ap'
            stringBuilder6.append("Accept: ap");
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append('p');
            stringBuilder7.append('l');
            stringBuilder7.append('i');
            stringBuilder7.append('c');
            stringBuilder7.append('a');
            stringBuilder7.append('t');
            stringBuilder6.append(stringBuilder7.toString());
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append('i');
            stringBuilder8.append('o');
            stringBuilder8.append('n');
            stringBuilder8.append('/');
            stringBuilder8.append('d');
            stringBuilder8.append('n');
            stringBuilder8.append('s');
            stringBuilder8.append('-');
            stringBuilder8.append('m');
            stringBuilder8.append('e');
            stringBuilder8.append('s');
            stringBuilder8.append('s');
            stringBuilder8.append('a');
            stringBuilder8.append('g');
            stringBuilder8.append('e');
            stringBuilder8.append('\r');
            stringBuilder8.append('\n');
            stringBuilder6.append(stringBuilder8.toString());
            mttY_Posc_yPdl_NeFX.append(stringBuilder6.toString());
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append('C');
            stringBuilder9.append('o');
            stringBuilder9.append('n');
            stringBuilder9.append('n');
            stringBuilder9.append('e');
            stringBuilder9.append('c');
            stringBuilder9.append('t');
            stringBuilder9.append('i');
            stringBuilder9.append('o');
            stringBuilder9.append('n');
            stringBuilder9.append(':');
            stringBuilder9.append(' ');
            stringBuilder9.append('c');
            stringBuilder9.append('l');
            stringBuilder9.append('o');
            stringBuilder9.append('s');
            stringBuilder9.append('e');
            stringBuilder9.append('\r');
            stringBuilder9.append('\n');
            mttY_Posc_yPdl_NeFX.append(stringBuilder9.toString());
            mttY_Posc_yPdl_NeFX.append("\r\n");
            elapsed3.write(mttY_Posc_yPdl_NeFX.toString().getBytes(StandardCharsets.ISO_8859_1));
            elapsed3.flush();
            tmpDfpsfslfu opts4 = lDYyOSFGzNWbBC.rPC5wfbk(uFI4Ei_384qqbN);
            byte[] byArray = opts4.body;
            return byArray;
        }
        finally {
            ojdiy_ojri_qwkhcs_je.close();
        }
    }

    private static String lewDf(byte[] zlmZ_iGer_SZsd_YwzS) {
        if (zlmZ_iGer_SZsd_YwzS == null || zlmZ_iGer_SZsd_YwzS.length < 12) {
            return null;
        }
        ByteBuffer bCbU_RxbM_iUPX_YSAU = ByteBuffer.wrap(zlmZ_iGer_SZsd_YwzS);
        bCbU_RxbM_iUPX_YSAU.getShort();
        short vpkZxahAsuj = bCbU_RxbM_iUPX_YSAU.getShort();
        if ((vpkZxahAsuj & 0x8000) == 0) {
            return null;
        }
        int c2 = vpkZxahAsuj & 0xF;
        if (c2 != 0) {
            return null;
        }
        int yimoWdxos = bCbU_RxbM_iUPX_YSAU.getShort() & 0xFFFF;
        int IZH8 = bCbU_RxbM_iUPX_YSAU.getShort() & 0xFFFF;
        bCbU_RxbM_iUPX_YSAU.getShort();
        bCbU_RxbM_iUPX_YSAU.getShort();
        for (int hNav = 0; hNav < yimoWdxos; ++hNav) {
            lDYyOSFGzNWbBC.pENNbahMCEAOF(bCbU_RxbM_iUPX_YSAU);
            bCbU_RxbM_iUPX_YSAU.getShort();
            bCbU_RxbM_iUPX_YSAU.getShort();
        }
        for (int msgMax = 0; msgMax < IZH8; ++msgMax) {
            lDYyOSFGzNWbBC.pENNbahMCEAOF(bCbU_RxbM_iUPX_YSAU);
            int resMax = bCbU_RxbM_iUPX_YSAU.getShort() & 0xFFFF;
            bCbU_RxbM_iUPX_YSAU.getShort();
            bCbU_RxbM_iUPX_YSAU.getInt();
            int IKgD = bCbU_RxbM_iUPX_YSAU.getShort() & 0xFFFF;
            if (resMax == 1 && IKgD == 4) {
                byte[] rzzefwGa = new byte[4];
                bCbU_RxbM_iUPX_YSAU.get(rzzefwGa);
                int n = rzzefwGa[3] & 0xFF;
                int n2 = rzzefwGa[2] & 0xFF;
                int n3 = rzzefwGa[1] & 0xFF;
                int n4 = rzzefwGa[0] & 0xFF;
                return n4 + "." + n3 + "." + n2 + "." + n;
            }
            bCbU_RxbM_iUPX_YSAU.position(bCbU_RxbM_iUPX_YSAU.position() + IKgD);
        }
        return null;
    }

    private static void pENNbahMCEAOF(ByteBuffer eAvg) {
        while (eAvg.hasRemaining()) {
            int ntwInnsguCwk;
            int n = 1952486108;
            if ((n | 0x746092DC) == 1952486108) {
                n = 213321540;
                n ^= 0xB6122838;
            }
            if ((ntwInnsguCwk = eAvg.get() & 0xFF) == 0) break;
            if ((ntwInnsguCwk & 0xC0) == 192) {
                eAvg.get();
                break;
            }
            eAvg.position(eAvg.position() + ntwInnsguCwk);
        }
    }

    static {
        try {
            SSLContext entryOut = SSLContext.getInstance("TLS");
            entryOut.init(null, new TrustManager[]{new avgNhhbkck()}, new SecureRandom());
            wExpAwbYTJt = entryOut.getSocketFactory();
        }
        catch (Exception yxy_kkut_ak) {
            wExpAwbYTJt = (SSLSocketFactory)SSLSocketFactory.getDefault();
        }
    }

    public static class tmpDfpsfslfu {
        public final int statusCode;
        public final String statusLine;
        public final Map<String, String> headers;
        public final byte[] body;

        tmpDfpsfslfu(int limitAux, String KoQb_nIxc_Pbbg_CuRM, Map<String, String> str3, byte[] rkjHrLarfBoda) {
            tmpDfpsfslfu INKm_eXbM_mUEP_RdKf;
            INKm_eXbM_mUEP_RdKf.statusCode = limitAux;
            INKm_eXbM_mUEP_RdKf.statusLine = KoQb_nIxc_Pbbg_CuRM;
            INKm_eXbM_mUEP_RdKf.headers = str3;
            INKm_eXbM_mUEP_RdKf.body = rkjHrLarfBoda;
        }

        public String bodyString() {
            tmpDfpsfslfu ZeqB_bity_OoMX_XHiz;
            return new String(ZeqB_bity_OoMX_XHiz.body, StandardCharsets.UTF_8);
        }

        public String header(String rznc_vlpv_sh_mj) {
            tmpDfpsfslfu qCAJmP;
            return qCAJmP.headers.get(rznc_vlpv_sh_mj.toLowerCase());
        }
    }

    private static class zek_rqbfns_ve {
        final String ip;
        final long expiresAt;

        zek_rqbfns_ve(String pf_rQ82_pTS, long zyqcaqVspThqId) {
            zek_rqbfns_ve VN_v_llWe_pl7;
            VN_v_llWe_pl7.ip = pf_rQ82_pTS;
            VN_v_llWe_pl7.expiresAt = zyqcaqVspThqId;
        }

        boolean isExpired() {
            zek_rqbfns_ve currSum;
            return System.currentTimeMillis() > currSum.expiresAt;
        }
    }

    private static class avgNhhbkck
    implements X509TrustManager {
        private avgNhhbkck() {
            avgNhhbkck HnFG_AXsl_opQq_mkio;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] zm_swl_khe, String nrbTdhqne) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] paramMax, String ToLE_MQKL_NnFc_Lqpa) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}

