/*
 * Decompiled with CFR 0.152.
 */
package core;

import core.meow;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ttsjcnocknendlub.muaijwxryatoplqf;

public final class JnaDebugTools {
    private static final Object JNA_SEQUENCE_LOCK;
    private static int camRDSfZWc = 0;
    private transient int Xsy7AtrnGc = 1997839546;
    private static String[] nothing_to_see_here;

    private JnaDebugTools() {
        int n = 0x5BDF79E5 ^ 0x6E1FB9DE;
        JnaDebugTools jnaDebugTools = this;
        n = 0x2617955 ^ n;
        n = 0x1996F5CE ^ (0x617ACA2F ^ Integer.parseInt("1330480783"));
        this.Xsy7AtrnGc = 0x77149CBA ^ camRDSfZWc;
        n = JnaDebugTools.sszvdrlyrizasxms(n, 2128709589);
        n = 0x6597ED07 ^ n;
    }

    public static void enableJnaDebugLoad() {
        int n = 0x382D203A ^ (0x27A69012 ^ 0x107BB7CD);
        n = 0x4D5D8C70 ^ n;
        String string = JnaDebugTools.yhiiihgwgk(JnaDebugTools.fzzuohcnzfkyjiz(), JnaDebugTools.gdqvulcrolkrvxu(), n);
        String string2 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.dcshdyjzllvzzdg(), JnaDebugTools.gdqvulcrolkrvxu(), n);
        String string3 = System.setProperty(string, string2);
        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 359423146) {
            n = 0x41C22A5E ^ n;
            String string4 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.tdeezlszuiqtcfu(), JnaDebugTools.gdqvulcrolkrvxu(), n);
            String string5 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ktxbwyushuevrof(), JnaDebugTools.gdqvulcrolkrvxu(), n);
            String string6 = System.setProperty(string4, string5);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 461180504) {
                n = 0x5F295370 ^ n;
                PrintStream printStream = System.out;
                String string7 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.lvbwxcbgtdxmkzp(), JnaDebugTools.gdqvulcrolkrvxu(), n);
                printStream.println(string7);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -499673638) {
                    n = 0x2423919A ^ n;
                    PrintStream printStream2 = System.out;
                    printStream2.flush();
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1020585717) {
                        n = 0x162FAB0C ^ n;
                        return;
                    }
                }
            }
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -499673638 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x57DE53E1 ^ n)) {
                continue;
            }
            int cfr_ignored_0 = 0x2954A2D5 ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1020585717 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x4327390F ^ n)) continue;
            int cfr_ignored_1 = 0x27943FF ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 461180504 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6F771C95 ^ n)) continue;
            int cfr_ignored_2 = 0x5D445F86 ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1918255467 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2ABE57AB ^ n)) continue;
            int cfr_ignored_3 = 0x23E9389B ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 359423146 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x511A73C9 ^ n)) break;
        }
        int cfr_ignored_4 = 0x1F47F5BF ^ n;
        throw new IllegalAccessException();
    }

    /*
     * Unable to fully structure code
     */
    public static void printRuntimeEnvironment() {
        block11: {
            var67 = 1941561782 ^ (0x282D222D ^ 276543437);
            var67 = 995736500 ^ var67;
            var0_1 = System.out;
            var1_2 = new StringBuilder();
            var41_3 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ukgjerejwabffyd(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var10_4 = var1_2.append(var41_3);
            var42_5 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.rekfqwgzvtsbmin(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var43_6 = System.getProperty(var42_5);
            var11_7 = var10_4.append(var43_6);
            var12_8 = var11_7.toString();
            var0_1.println(var12_8);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != -2051637485) ** GOTO lbl119
            var67 = 2075998853 ^ var67;
            var2_9 = System.out;
            var13_10 = new StringBuilder();
            var44_11 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.kiuyxlurtxtplgz(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var14_12 = var13_10.append(var44_11);
            var45_13 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ihthxxtsqruowin(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var46_14 = System.getProperty(var45_13);
            var15_15 = var14_12.append(var46_14);
            var16_16 = var15_15.toString();
            var2_9.println(var16_16);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 1482664760) ** GOTO lbl-1000
            var67 = 798968878 ^ var67;
            var3_17 = System.out;
            var17_18 = new StringBuilder();
            var47_19 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.fehkdcvdbviedch(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var18_20 = var17_18.append(var47_19);
            var48_21 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.oothynteiixvuta(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var49_22 = System.getProperty(var48_21);
            var19_23 = var18_20.append(var49_22);
            var20_24 = var19_23.toString();
            var3_17.println(var20_24);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 614845001) break block11;
            var67 = 675604544 ^ var67;
            var4_25 = System.out;
            var21_26 = new StringBuilder();
            var50_27 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.cwihlyfongwcjvy(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var22_28 = var21_26.append(var50_27);
            var51_29 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.kbtckvtcaslngpm(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var52_30 = System.getProperty(var51_29);
            var23_31 = var22_28.append(var52_30);
            var24_32 = var23_31.toString();
            var4_25.println(var24_32);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 1719830600) ** GOTO lbl114
            var67 = 1783732636 ^ var67;
            var5_33 = System.out;
            var25_34 = new StringBuilder();
            var53_35 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.tuhdmytegkuztmy(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var26_36 = var25_34.append(var53_35);
            var54_37 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ufsuxfsaqyxssks(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var55_38 = System.getProperty(var54_37);
            var27_39 = var26_36.append(var55_38);
            var28_40 = var27_39.toString();
            var5_33.println(var28_40);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 873350315) ** GOTO lbl-1000
            var67 = 1348797314 ^ var67;
            var6_41 = System.out;
            var29_42 = new StringBuilder();
            var56_43 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.mgndvlbcggpqpoy(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var30_44 = var29_42.append(var56_43);
            var57_45 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.hiooklyghconyxo(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var58_46 = System.getProperty(var57_45);
            var31_47 = var30_44.append(var58_46);
            var32_48 = var31_47.toString();
            var6_41.println(var32_48);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != -1222223687) ** GOTO lbl-1000
            var67 = 109162426 ^ var67;
            var7_49 = System.out;
            var33_50 = new StringBuilder();
            var59_51 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ojudrcdjqxmvsxi(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var34_52 = var33_50.append(var59_51);
            var60_53 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.bnhplkofkhpdnfu(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
            var61_54 = System.getProperty(var60_53);
            var35_55 = var34_52.append(var61_54);
            var36_56 = var35_55.toString();
            var7_49.println(var36_56);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) == -2094324375) {
                var67 = 1462521118 ^ var67;
                var8_57 = System.out;
                var37_58 = new StringBuilder();
                var62_59 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.olvwtxyksnvwslh(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
                var38_60 = var37_58.append(var62_59);
                var63_61 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.mbhiumwkjwhlolo(), JnaDebugTools.gdqvulcrolkrvxu(), var67);
                var64_62 = System.getProperty(var63_61);
                var39_63 = var38_60.append(var64_62);
                var40_64 = var39_63.toString();
                var8_57.println(var40_64);
                ** if (muaijwxryatoplqf.huhowxzlzevtonoz((int)var67) != 977882523) goto lbl-1000
lbl-1000:
                // 1 sources

                {
                    var67 = 1094467658 ^ var67;
                    var9_65 = System.out;
                    var9_65.flush();
                    if (muaijwxryatoplqf.huhowxzlzevtonoz((int)var67) == 866865097) {
                        var67 = 1694757623 ^ var67;
                        return;
                    } else {
                        ** GOTO lbl96
                    }
lbl96:
                    // 2 sources

                    ** GOTO lbl129
                }
            }
            ** GOTO lbl119
lbl-1000:
            // 4 sources

            {
                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 1482664760 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (1745047225 ^ var67)) {
                        continue;
                    }
                    1927328818 ^ var67;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 873350315 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (830578574 ^ var67)) continue;
                    386862075 ^ var67;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 977882523 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (1791400983 ^ var67)) continue;
                    333489083 ^ var67;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) == -1222223687 && muaijwxryatoplqf.huhowxzlzevtonoz(var67) == (1100307191 ^ var67)) break;
                }
                1085164876 ^ var67;
                throw new IOException();
lbl114:
                // 2 sources

                while (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 1719830600 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (1621523445 ^ var67)) {
                }
                134132560 ^ var67;
                throw new IOException("double");
lbl119:
                // 2 sources

                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != -2094324375 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (1511239845 ^ var67)) {
                        continue;
                    }
                    1814089672 ^ var67;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var67) == -2051637485 && muaijwxryatoplqf.huhowxzlzevtonoz(var67) == (1877127421 ^ var67)) break;
                }
                8828098 ^ var67;
                throw new IOException("double");
            }
lbl129:
            // 2 sources

            while (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 866865097 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (2050031900 ^ var67)) {
            }
            1582496432 ^ var67;
            throw new RuntimeException("double");
        }
        while (muaijwxryatoplqf.huhowxzlzevtonoz(var67) != 614845001 || muaijwxryatoplqf.huhowxzlzevtonoz(var67) != (340868819 ^ var67)) {
        }
        565075393 ^ var67;
        throw new IOException("double");
    }

    /*
     * Unable to fully structure code
     */
    public static void prewarmStartupInfo() {
        block14: {
            var25 = 1770522384 ^ (2135070302 ^ 276543437);
            var25 = 1622499983 ^ var25;
            var0_1 = System.out;
            var1_2 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.qynbsjmvunbkbxq(), JnaDebugTools.gdqvulcrolkrvxu(), var25);
            var0_1.println(var1_2);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 807542883) ** GOTO lbl72
            var25 = 331872793 ^ var25;
            var3_3 = System.out;
            var3_3.flush();
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != -1373769557) ** GOTO lbl72
            var25 = 1949801681 ^ var25;
            var2_5 = var4_4 = new meow.STARTUPINFO();
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 262215200) break block14;
            var25 = 235847719 ^ var25;
            var5_6 = System.out;
            var12_7 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.wuavbpajansrydt(), JnaDebugTools.gdqvulcrolkrvxu(), var25);
            var5_6.println(var12_7);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 2144802584) ** GOTO lbl-1000
            var25 = 778784729 ^ var25;
            var6_8 = System.out;
            var6_8.flush();
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 210594257) ** GOTO lbl82
            var25 = 754626017 ^ var25;
            var7_9 = System.out;
            var13_10 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.hcsdkwfhibwpytm(), JnaDebugTools.gdqvulcrolkrvxu(), var25);
            var7_9.println(var13_10);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 1800931032) ** GOTO lbl82
            var25 = 1756935402 ^ var25;
            var8_11 = System.out;
            var8_11.flush();
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == 782082443) {
                var25 = 1261648207 ^ var25;
                var9_12 = var2_5;
                var14_13 = var2_5;
                var9_12.cb = var15_14 = var14_13.size();
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == 1996778481) {
                    var25 = 1399968939 ^ var25;
                    var10_15 = System.out;
                    var16_16 = new StringBuilder();
                    var20_17 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.yimgebauazffnhk(), JnaDebugTools.gdqvulcrolkrvxu(), var25);
                    var17_18 = var16_16.append(var20_17);
                    var21_19 = var2_5;
                    var22_20 = var21_19.cb;
                    var18_21 = var17_18.append(var22_20);
                    var19_22 = var18_21.toString();
                    var10_15.println(var19_22);
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == -326447445) {
                        var25 = 440528854 ^ var25;
                        var11_23 = System.out;
                        var11_23.flush();
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == 1048948763) {
                            var25 = 1966438957 ^ var25;
                            return;
                        }
                    } else {
                        while (true) {
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != -326447445 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (141561899 ^ var25)) {
                                continue;
                            }
                            1420894662 ^ var25;
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == -1758568080 && muaijwxryatoplqf.huhowxzlzevtonoz(var25) == (1420022401 ^ var25)) break;
                        }
                        177082231 ^ var25;
                        throw new RuntimeException("double");
                    }
                } else {
                    ** GOTO lbl66
                }
            }
            break block14;
lbl66:
            // 2 sources

            ** GOTO lbl82
lbl-1000:
            // 2 sources

            {
                while (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 2144802584 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (1620969913 ^ var25)) {
                }
                22745741 ^ var25;
                throw new IllegalAccessException("double");
lbl72:
                // 2 sources

                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 807542883 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (892020656 ^ var25)) {
                        continue;
                    }
                    1182184387 ^ var25;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == -1373769557 && muaijwxryatoplqf.huhowxzlzevtonoz(var25) == (1015071093 ^ var25)) break;
                }
                1076066408 ^ var25;
                throw new RuntimeException("double");
lbl82:
                // 3 sources

                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 1996778481 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (2066257689 ^ var25)) {
                        continue;
                    }
                    287162050 ^ var25;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 1800931032 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (361631890 ^ var25)) continue;
                    370371910 ^ var25;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == 210594257 && muaijwxryatoplqf.huhowxzlzevtonoz(var25) == (2020755410 ^ var25)) break;
                }
                1720142908 ^ var25;
                throw new IllegalAccessException();
            }
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 262215200 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (1039991372 ^ var25)) {
                continue;
            }
            1593086326 ^ var25;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) != 1048948763 || muaijwxryatoplqf.huhowxzlzevtonoz(var25) != (1330062927 ^ var25)) continue;
            1827194489 ^ var25;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var25) == 782082443 && muaijwxryatoplqf.huhowxzlzevtonoz(var25) == (1498555015 ^ var25)) break;
        }
        637719622 ^ var25;
        throw new RuntimeException("double");
    }

    /*
     * Unable to fully structure code
     */
    public static void prewarmKernel32() {
        block8: {
            block7: {
                var15 = 1968308096 ^ (1810519848 ^ 276543437);
                var15 = 1710878265 ^ var15;
                var0_1 = System.out;
                var1_2 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.jddnlssdujcufmw(), JnaDebugTools.gdqvulcrolkrvxu(), var15);
                var0_1.println(var1_2);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) != 1506773731) break block7;
                var15 = 711637964 ^ var15;
                var3_3 = System.out;
                var3_3.flush();
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) != 177886338) break block8;
                var15 = 137185654 ^ var15;
                var2_5 = var4_4 = meow.Kernel32.INSTANCE;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) == 1274027826) {
                    var15 = 1972934189 ^ var15;
                    var5_6 = System.out;
                    var7_7 = new StringBuilder();
                    var11_8 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ggsigincreobhxs(), JnaDebugTools.gdqvulcrolkrvxu(), var15);
                    var8_9 = var7_7.append(var11_8);
                    var12_10 = var2_5;
                    var9_11 = var8_9.append(var12_10);
                    var10_12 = var9_11.toString();
                    var5_6.println(var10_12);
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) == -415977895) {
                        var15 = 401471513 ^ var15;
                        var6_13 = System.out;
                        var6_13.flush();
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) == 1482387089) {
                            var15 = 1557537076 ^ var15;
                            return;
                        } else {
                            ** GOTO lbl31
                        }
                    } else {
                        ** GOTO lbl31
                    }
                }
                break block7;
lbl31:
                // 4 sources

                break block8;
            }
            while (true) {
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) != 1506773731 || muaijwxryatoplqf.huhowxzlzevtonoz(var15) != (682136000 ^ var15)) {
                    continue;
                }
                1058150077 ^ var15;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) == 1274027826 && muaijwxryatoplqf.huhowxzlzevtonoz(var15) == (1694501022 ^ var15)) break;
            }
            1351051274 ^ var15;
            throw new IOException("double");
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) != 177886338 || muaijwxryatoplqf.huhowxzlzevtonoz(var15) != (939257801 ^ var15)) {
                continue;
            }
            1385961916 ^ var15;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) != -415977895 || muaijwxryatoplqf.huhowxzlzevtonoz(var15) != (945490381 ^ var15)) continue;
            2024761068 ^ var15;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var15) == 1482387089 && muaijwxryatoplqf.huhowxzlzevtonoz(var15) == (196734932 ^ var15)) break;
        }
        1710415186 ^ var15;
        throw new IllegalAccessException();
    }

    public static void prewarmProcessInformation() {
        int n;
        block13: {
            block12: {
                block10: {
                    block11: {
                        block9: {
                            int n2;
                            meow.PROCESS_INFORMATION pROCESS_INFORMATION;
                            n = 0x13790609 ^ (0x49489671 ^ 0x107BB7CD);
                            n = 0x6E462EBF ^ n;
                            PrintStream printStream = System.out;
                            String string = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ziuuontmbloxqtv(), JnaDebugTools.gdqvulcrolkrvxu(), n);
                            printStream.println(string);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 543180881) break block9;
                            n = 0x48506010 ^ n;
                            PrintStream printStream2 = System.out;
                            printStream2.flush();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1659062483) break block10;
                            n = 0xB9B4138 ^ n;
                            meow.PROCESS_INFORMATION pROCESS_INFORMATION2 = pROCESS_INFORMATION = new meow.PROCESS_INFORMATION();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1043939603) break block11;
                            n = 0x70F773BA ^ n;
                            PrintStream printStream3 = System.out;
                            String string2 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.qjkttierjahqtgl(), JnaDebugTools.gdqvulcrolkrvxu(), n);
                            printStream3.println(string2);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1182606144) break block12;
                            n = 0x2BDB2E98 ^ n;
                            PrintStream printStream4 = System.out;
                            printStream4.flush();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -413423615) break block11;
                            n = 0x21E62D24 ^ n;
                            PrintStream printStream5 = System.out;
                            String string3 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.dixsdqafctixqut(), JnaDebugTools.gdqvulcrolkrvxu(), n);
                            printStream5.println(string3);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -395656928) break block10;
                            n = 0x39E5EAED ^ n;
                            PrintStream printStream6 = System.out;
                            printStream6.flush();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 658871881) break block9;
                            n = 0xFE8714A ^ n;
                            meow.PROCESS_INFORMATION pROCESS_INFORMATION3 = pROCESS_INFORMATION2;
                            int n3 = n2 = pROCESS_INFORMATION3.size();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1476795417) break block10;
                            n = 0x1833FDEC ^ n;
                            PrintStream printStream7 = System.out;
                            StringBuilder stringBuilder = new StringBuilder();
                            String string4 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.flvxsclwgsuxswz(), JnaDebugTools.gdqvulcrolkrvxu(), n);
                            StringBuilder stringBuilder2 = stringBuilder.append(string4);
                            int n4 = n3;
                            StringBuilder stringBuilder3 = stringBuilder2.append(n4);
                            String string5 = stringBuilder3.toString();
                            printStream7.println(string5);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1717963911) break block10;
                            n = 0x1EABD385 ^ n;
                            PrintStream printStream8 = System.out;
                            printStream8.flush();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 1825009489) {
                                n = 0x34FEB9A4 ^ n;
                                return;
                            }
                            break block13;
                        }
                        while (true) {
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 543180881 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x3ABE853F ^ n)) {
                                continue;
                            }
                            int cfr_ignored_0 = 0x10ADCB1B ^ n;
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 658871881 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x76ADECF1 ^ n)) break;
                        }
                        int cfr_ignored_1 = 0xE9D077D ^ n;
                        throw new IllegalAccessException("double");
                    }
                    while (true) {
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1043939603 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2CC49E2B ^ n)) {
                            continue;
                        }
                        int cfr_ignored_2 = 0x16528EC3 ^ n;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -413423615 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x7C5EB997 ^ n)) break;
                    }
                    int cfr_ignored_3 = 0x70349CE7 ^ n;
                    throw new RuntimeException("double");
                }
                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -395656928 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2591EDD3 ^ n)) {
                        continue;
                    }
                    int cfr_ignored_4 = 0x54E2BF9 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -885874064 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x68E166F6 ^ n)) continue;
                    int cfr_ignored_5 = 0x5E0AF91D ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1476795417 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0xAE88BB1 ^ n)) continue;
                    int cfr_ignored_6 = 0x7AA50434 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1717963911 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2E9793B9 ^ n)) continue;
                    int cfr_ignored_7 = 0x1AAB1627 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 1659062483 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0xA12E8FB ^ n)) break;
                }
                int cfr_ignored_8 = 0x58B7BDD4 ^ n;
                throw new RuntimeException();
            }
            while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1182606144 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x7A944AEA ^ n)) {
            }
            int cfr_ignored_9 = 0x16FC3BC2 ^ n;
            throw new IllegalAccessException("double");
        }
        while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1825009489 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x3651B802 ^ n)) {
        }
        int cfr_ignored_10 = 0x523DE030 ^ n;
        throw new IOException("double");
    }

    public static void prewarmAllSequential() {
        int n = 0x3E5F859B ^ (0x4CACCF16 ^ 0x107BB7CD);
        n = 0x7033098A ^ n;
        String string = JnaDebugTools.yhiiihgwgk(JnaDebugTools.ecbbkvhszsshrmp(), JnaDebugTools.gdqvulcrolkrvxu(), n);
        Runnable runnable = new Runnable(){
            private static int 25dmMbcy0o = 0;
            private transient int SuhENPabVK = 686847516;
            private static byte[] wcrcudprbl;
            private static String[] nothing_to_see_here;
            {
                int n = 0x3608E38D ^ 0x31EC2878;
                1 var1_2 = this;
                n = 1.asvlrrmfamzjdgzx(n, 1465475055);
                n = 0x7E8AD8BA ^ (0x5CB3AB8 ^ Integer.parseInt("737965592"));
                this.SuhENPabVK = 0x28F0761C ^ 25dmMbcy0o;
                n = 0x5045A043 ^ n;
            }

            @Override
            public void run() {
                int n = 0x3A9B0930 ^ (0x26BF7ADD ^ 0x2B7D5505);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1161218239) {
                    n = 0x1412AB83 ^ n;
                    JnaDebugTools.prewarmStartupInfo();
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 442264409) {
                        n = 0x1FDCB84B ^ n;
                        JnaDebugTools.prewarmProcessInformation();
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -457594623) {
                            n = 0x4013B53C ^ n;
                            JnaDebugTools.prewarmKernel32();
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -467402525) {
                                n = 0x5F2F8B77 ^ n;
                                return;
                            }
                        }
                    }
                }
                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1161218239 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x359D5877 ^ n)) {
                        continue;
                    }
                    int cfr_ignored_0 = 0x43A9A2 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -457594623 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6548664F ^ n)) continue;
                    int cfr_ignored_1 = 0x720DF348 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 442264409 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x43D7324A ^ n)) continue;
                    int cfr_ignored_2 = 0x3678371E ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 492329817 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2B1348A4 ^ n)) continue;
                    int cfr_ignored_3 = 0x29A0BE19 ^ n;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -467402525 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x133C6314 ^ n)) break;
                }
                int cfr_ignored_4 = 0x500C6368 ^ n;
                throw new IllegalAccessException();
            }

            static {
                nothing_to_see_here = new String[13];
                1.nothing_to_see_here[0] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800    ";
                1.nothing_to_see_here[1] = "\u2800\u2800\u2800\u2800\u28e0\u28f6\u287e\u280f\u2809\u2819\u2833\u28a6\u2840\u2800\u2800\u2800\u28a0\u281e\u2809\u2819\u2832\u2840\u2800    ";
                1.nothing_to_see_here[2] = "\u2800\u2800\u2800\u28f4\u283f\u280f\u2800\u2800\u2800\u2800\u2800\u2800\u28b3\u2840\u2800\u284f\u2800\u2800\u2800\u2800\u2800\u28b7     ";
                1.nothing_to_see_here[3] = "\u2800\u2800\u28a0\u28df\u28cb\u2840\u2880\u28c0\u28c0\u2840\u2800\u28c0\u2840\u28e7\u2800\u28b8\u2800\u2800\u2800\u2800\u2800 \u2847    ";
                1.nothing_to_see_here[4] = "\u2800\u2800\u28b8\u28ef\u286d\u2801\u2838\u28db\u28df\u2806\u2874\u28fb\u2872\u28ff\u2800\u28f8\u2800\u2800OK\u2800 \u2847    ";
                1.nothing_to_see_here[5] = "\u2800\u2800\u28df\u28ff\u286d\u2800\u2800\u2800\u2800\u2800\u28b1\u2800\u2800\u28ff\u2800\u28b9\u2800\u2800\u2800\u2800\u2800 \u2847    ";
                1.nothing_to_see_here[6] = "\u2800\u2800\u2819\u28bf\u28ef\u2804\u2800\u2800\u2800\u2880\u2840\u2800\u2800\u287f\u2800\u2800\u2847\u2800\u2800\u2800\u2800\u287c     ";
                1.nothing_to_see_here[7] = "\u2800\u2800\u2800\u2800\u2839\u28f6\u2806\u2800\u2800\u2800\u2800\u2800\u2874\u2803\u2800\u2800\u2818\u2824\u28c4\u28e0\u281e\u2800     ";
                1.nothing_to_see_here[8] = "\u2800\u2800\u2800\u2800\u2800\u28b8\u28f7\u2866\u28a4\u2864\u28a4\u28de\u28c1\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800    ";
                1.nothing_to_see_here[9] = "\u2800\u2800\u2880\u28e4\u28f4\u28ff\u28cf\u2801\u2800\u2800\u2838\u28cf\u28af\u28f7\u28d6\u28e6\u2840\u2800\u2800\u2800\u2800\u2800\u2800    ";
                1.nothing_to_see_here[10] = "\u2880\u28fe\u28fd\u28ff\u28ff\u28ff\u28ff\u281b\u28b2\u28f6\u28fe\u2889\u2877\u28ff\u28ff\u2835\u28ff\u2800\u2800\u2800\u2800\u2800\u2800    ";
                1.nothing_to_see_here[11] = "\u28fc\u28ff\u280d\u2809\u28ff\u286d\u2809\u2819\u28ba\u28c7\u28fc\u284f\u2800\u2800\u2800\u28c4\u28b8\u2800\u2800\u2800\u2800\u2800\u2800    ";
                1.nothing_to_see_here[12] = "\u28ff\u28ff\u28e7\u28c0\u28ff.........\u28c0\u28f0\u28cf\u28d8\u28c6\u28c0\u2800\u2800       ";
                wcrcudprbl = 1.bpzjpfrnzgbrtfj();
                int n = new Random(3542728301844981969L).nextInt();
                25dmMbcy0o = 0x504B65FB ^ n;
            }

            public static String nmcwfqonmj(byte[] byArray, int n) {
                byte[] byArray2;
                int n2;
                int n3;
                int n4;
                byte[] byArray3;
                int n5 = n;
                String string = Integer.toString(n5);
                byte[] byArray4 = byArray3 = string.getBytes();
                int n6 = n4 = 0;
                while ((n3 = n6) < (n2 = (byArray2 = byArray).length)) {
                    byte by;
                    byte by2;
                    byte[] byArray5 = byArray;
                    int n7 = n6;
                    byte by3 = byArray5[n7];
                    byte[] byArray6 = byArray4;
                    int n8 = n6;
                    byte[] byArray7 = byArray4;
                    int n9 = byArray7.length;
                    int n10 = n8 % n9;
                    byte by4 = byArray6[n10];
                    int n11 = by3 ^ by4;
                    byArray5[n7] = by2 = (byte)n11;
                    byte[] byArray8 = byArray;
                    int n12 = n6;
                    byte by5 = byArray8[n12];
                    byte[] byArray9 = wcrcudprbl;
                    int n13 = n6++;
                    byte[] byArray10 = wcrcudprbl;
                    int n14 = byArray10.length;
                    int n15 = n13 % n14;
                    byte by6 = byArray9[n15];
                    int n16 = by5 ^ by6;
                    byArray8[n12] = by = (byte)n16;
                }
                byte[] byArray11 = byArray;
                Charset charset = StandardCharsets.UTF_16;
                String string2 = new String(byArray11, charset);
                return string2;
            }

            private static byte[] bpzjpfrnzgbrtfj() {
                return new byte[]{18, 79, 21, 28, 3, 60, 126, 76, 127, 95, 96, 72, 56, 61, 88, 124, 94, 30, 60, 40, 7, 91, 56, 122, 5, 52, 49, 118, 48, 40, 62, 75, 61, 109, 13, 6, 118, 105, 64, 71, 60, 70, 67, 116, 30, 13, 28, 101, 77, 33, 109, 39, 96, 124, 67, 64, 74, 54, 13, 53, 114, 57, 64, 52, 68, 98, 111, 122, 27, 46, 31, 85, 116, 99, 4, 62};
            }

            private static int asvlrrmfamzjdgzx(int n, int n2) {
                return n ^ n2;
            }
        };
        JnaDebugTools.runSequential(string, runnable);
        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1780505008) {
            n = 0x66C8182A ^ n;
            return;
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1549834493 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x5E0F35C5 ^ n)) {
                continue;
            }
            int cfr_ignored_0 = 0x320C3EB2 ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1780505008 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x4D1AD8B8 ^ n)) break;
        }
        int cfr_ignored_1 = 0x78FFD5D3 ^ n;
        throw new IllegalAccessException();
    }

    /*
     * Exception decompiling
     */
    public static void runSequential(String var0, Runnable var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:442)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T callSequential(String var0, Callable<T> var1_1) throws Exception {
        block53: {
            var57_2 = 408919502 ^ (1772416114 ^ 276543437);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 201733003) break block53;
            var57_2 = 1396444701 ^ var57_2;
            var3_4 = var2_3 = JnaDebugTools.JNA_SEQUENCE_LOCK;
            synchronized (var2_3) {
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1780071583) break block48;
                var57_2 = 1480202516 ^ var57_2;
                var7_5 = System.out;
                var22_6 = new StringBuilder();
                var40_7 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.gfqtscgevipgkmq(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                var23_8 = var22_6.append(var40_7);
                var41_9 = var0;
                var24_10 = var23_8.append(var41_9);
                var42_11 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.dqjtgtescchosid(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                var25_12 = var24_10.append(var42_11);
                var43_13 = Thread.currentThread();
                var44_14 = var43_13.getName();
                var26_15 = var25_12.append(var44_14);
                var27_16 = var26_15.toString();
                var7_5.println(var27_16);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 1412860867) break block46;
                var57_2 = 854949195 ^ var57_2;
                var8_17 = System.out;
                var8_17.flush();
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1013096038) ** break block47
                var57_2 = 280187471 ^ var57_2;
                try {
                    var9_18 = var1_1;
                    var4_20 = var10_19 = var9_18.call();
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 1174926306) break block48;
                    var57_2 = 1995404720 ^ var57_2;
                    var11_21 = System.out;
                    var28_22 = new StringBuilder();
                }
                catch (Throwable v0) {
                    switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var57_2)) {
                        default: {
                            throw new IllegalAccessException("Error in hash");
                        }
                        case 1174926306: 
                    }
                    var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 2081992963);
                    break block50;
                }
                var45_23 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.qztcltiasreldkp(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                var29_24 = var28_22.append(var45_23);
                var46_25 = var0;
                var30_26 = var29_24.append(var46_25);
                var47_27 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.cicwxaccipwzuze(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                var31_28 = var30_26.append(var47_27);
                var48_29 = Thread.currentThread();
                var49_30 = var48_29.getName();
                var32_31 = var31_28.append(var49_30);
                var33_32 = var32_31.toString();
                var11_21.println(var33_32);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -243507615) break block48;
                var57_2 = 1908031368 ^ var57_2;
                var12_33 = System.out;
                var12_33.flush();
                var13_34 = var3_4;
                // ** MonitorExit[var13_34] (shouldn't be in output)
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == 2091754018) {
                    var57_2 = 728758255 ^ var57_2;
                    var14_35 = var4_20;
                    return var14_35;
                }
                break block49;
            }
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 201733003 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1999311922 ^ var57_2)) {
                continue;
            }
            1145869449 ^ var57_2;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == 668081499 && muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == (1905807988 ^ var57_2)) break;
        }
        48080673 ^ var57_2;
        throw new IllegalAccessException("double");
        {
            block48: {
                block51: {
                    block52: {
                        block50: {
                            block49: {
                                block46: {
                                    while (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1013096038 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (898925389 ^ var57_2)) {
                                    }
                                    1139570460 ^ var57_2;
                                    throw new RuntimeException("double");
                                    catch (Throwable v1) {
                                        switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var57_2)) {
                                            case 1174926306: {
                                                var57_2 = 1032942011 ^ var57_2;
                                                break;
                                            }
                                            case 2091754018: {
                                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 985938819);
                                                break;
                                            }
                                            default: {
                                                throw new RuntimeException("Error in hash");
                                            }
                                            case 1412860867: {
                                                var57_2 = 534208191 ^ var57_2;
                                                break;
                                            }
                                            case -1013096038: {
                                                var57_2 = 757212148 ^ var57_2;
                                                break;
                                            }
                                            case -243507615: {
                                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 1266549771);
                                                break;
                                            }
                                        }
                                        break block51;
                                    }
                                }
                                while (true) {
                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 1412860867 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1126911467 ^ var57_2)) {
                                        continue;
                                    }
                                    1578005288 ^ var57_2;
                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == -1399628040 && muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == (32449567 ^ var57_2)) break;
                                }
                                2083955403 ^ var57_2;
                                throw new IllegalAccessException("double");
                            }
                            while (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 2091754018 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1712745524 ^ var57_2)) {
                            }
                            529588639 ^ var57_2;
                            throw new IOException("double");
                        }
                        block34: while (true) {
                            try {
                                var5_37 = var18_36 = v0;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1497203719) break;
                                var57_2 = 1717220054 ^ var57_2;
                                var19_38 = System.out;
                                var34_39 = new StringBuilder();
                            }
                            catch (Throwable v0) {
                                switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var57_2)) {
                                    case -1497203719: {
                                        var57_2 = 0 ^ var57_2;
                                        continue block34;
                                    }
                                    default: {
                                        throw new RuntimeException("Error in hash");
                                    }
                                }
                            }
                            var50_40 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.zgdcqfnmrialsvl(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                            var35_41 = var34_39.append(var50_40);
                            var51_42 = var0;
                            var36_43 = var35_41.append(var51_42);
                            var52_44 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.xxrekyjqxxvofbt(), JnaDebugTools.gdqvulcrolkrvxu(), var57_2);
                            var37_45 = var36_43.append(var52_44);
                            var53_46 = Thread.currentThread();
                            var54_47 = var53_46.getName();
                            var38_48 = var37_45.append(var54_47);
                            var39_49 = var38_48.toString();
                            var19_38.println(var39_49);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == -1810371254) {
                                var57_2 = 727333699 ^ var57_2;
                                var20_50 = System.out;
                                var20_50.flush();
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == -825870509) {
                                    var57_2 = 1816833333 ^ var57_2;
                                    var21_51 = var5_37;
                                    throw var21_51;
                                }
                            }
                            break block52;
                            break;
                        }
                        while (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1497203719 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1594353388 ^ var57_2)) {
                        }
                        1316507577 ^ var57_2;
                        throw new IOException("double");
                    }
                    while (true) {
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -825870509 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1018694188 ^ var57_2)) {
                            continue;
                        }
                        964972266 ^ var57_2;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == -1810371254 && muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == (840661927 ^ var57_2)) break;
                    }
                    181025145 ^ var57_2;
                    throw new RuntimeException("double");
                }
                block37: while (true) {
                    try {
                        var6_53 = var15_52 = v1;
                        var16_54 = var3_4;
                        // ** MonitorExit[var16_54] (shouldn't be in output)
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1433633221) break block48;
                        var57_2 = 303344643 ^ var57_2;
                        var17_55 = var6_53;
                    }
                    catch (Throwable v1) {
                        switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var57_2)) {
                            case -825870509: {
                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 210323757);
                                continue block37;
                            }
                            case -1497203719: {
                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 1099546808);
                                continue block37;
                            }
                            case -1810371254: {
                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 668168814);
                                continue block37;
                            }
                            case -1433633221: {
                                var57_2 = 0 ^ var57_2;
                                continue block37;
                            }
                            case -1399628040: {
                                var57_2 = JnaDebugTools.sszvdrlyrizasxms(var57_2, 1623450648);
                                continue block37;
                            }
                        }
                    }
                    throw var17_55;
                    break;
                }
                throw new IOException("Error in hash");
            }
            while (true) {
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 975773219 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (1933730850 ^ var57_2)) {
                    continue;
                }
                1408802134 ^ var57_2;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != 1174926306 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (25711544 ^ var57_2)) continue;
                1654211753 ^ var57_2;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -243507615 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (537238816 ^ var57_2)) continue;
                441781383 ^ var57_2;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != -1780071583 || muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) != (2020779982 ^ var57_2)) continue;
                269481378 ^ var57_2;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == -1433633221 && muaijwxryatoplqf.huhowxzlzevtonoz(var57_2) == (1161693648 ^ var57_2)) break;
            }
            1569123058 ^ var57_2;
            throw new IOException();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void dumpAllThreads(String var0) {
        block54: {
            block52: {
                block51: {
                    block50: {
                        block53: {
                            block55: {
                                var77_1 = 9105937 ^ (682972897 ^ 276543437);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1038050839) break block50;
                                var77_1 = 2104384718 ^ var77_1;
                                var1_2 = System.out;
                                var2_3 = new StringBuilder();
                                var53_4 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.onaicbzilryiaqj(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                var30_5 = var2_3.append(var53_4);
                                var54_6 = var0;
                                var31_7 = var30_5.append(var54_6);
                                var55_8 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.camoagmpvmbytcf(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                var32_9 = var31_7.append(var55_8);
                                var33_10 = var32_9.toString();
                                var1_2.println(var33_10);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 693272474) break block55;
                                var77_1 = 1569826264 ^ var77_1;
                                var9_11 = Thread.getAllStackTraces();
                                var10_12 = var9_11.entrySet();
                                var4_14 = var11_13 = var10_12.iterator();
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -975220392) break block55;
                                var77_1 = 1696567965 ^ var77_1;
                                block24: while (true) {
                                    block60: {
                                        block57: {
                                            block58: {
                                                block61: {
                                                    block56: {
                                                        block59: {
                                                            if ((var13_21 = (var12_20 = var4_14).hasNext()) == (2107930806 ^ var77_1)) break block56;
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -316422733) break block50;
                                                            var77_1 = 491670199 ^ var77_1;
                                                            var14_22 = var4_14;
                                                            var5_16 = var16_24 = (var15_23 = var14_22.next());
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 122785803) break block57;
                                                            var77_1 = 404540858 ^ var77_1;
                                                            var17_25 = var5_16;
                                                            var6_17 = var19_27 = (var18_26 = var17_25.getKey());
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -944243237) break block51;
                                                            var77_1 = 825182317 ^ var77_1;
                                                            var20_28 = System.out;
                                                            var20_28.println();
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1322106546) break block52;
                                                            var77_1 = 86862470 ^ var77_1;
                                                            var21_29 = System.out;
                                                            var34_36 = new StringBuilder();
                                                            var56_54 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.wltnctqbwwwrneo(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                            var35_37 = var34_36.append(var56_54);
                                                            var57_55 = var6_17;
                                                            var58_56 = var57_55.getName();
                                                            var36_38 = var35_37.append(var58_56);
                                                            var59_57 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.vjpzuuxffqenels(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                            var37_39 = var36_38.append(var59_57);
                                                            var60_58 = var6_17;
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1738992258) break block58;
                                                            var77_1 = 188185152 ^ var77_1;
                                                            var61_59 = var60_58.getState();
                                                            var38_40 = var37_39.append((Object)var61_59);
                                                            var62_60 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.dyrxjrxcvdjvroy(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                            var39_41 = var38_40.append(var62_60);
                                                            var63_61 = var6_17;
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1042102402) break;
                                                            var77_1 = 821911729 ^ var77_1;
                                                            var64_62 = var63_61.isDaemon();
                                                            var40_42 = var39_41.append(var64_62);
                                                            var65_63 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.natlteccdxtatcx(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                            var41_43 = var40_42.append(var65_63);
                                                            var66_64 = var6_17;
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1175044853) break block52;
                                                            var77_1 = 1638821386 ^ var77_1;
                                                            var67_65 = var66_64.getPriority();
                                                            var42_44 = var41_43.append(var67_65);
                                                            var68_66 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.nxlranzdhckggwe(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                            var43_45 = var42_44.append(var68_66);
                                                            var69_67 = var6_17;
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1266332328) break block59;
                                                            var77_1 = 2080070027 ^ var77_1;
                                                            var70_68 = var69_67.getId();
                                                            var44_46 = var43_45.append(var70_68);
                                                            var45_47 = var44_46.toString();
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1801421059) break block50;
                                                            var77_1 = 225627890 ^ var77_1;
                                                            var21_29.println(var45_47);
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 13235859) break block53;
                                                            var77_1 = 1883085813 ^ var77_1;
                                                            var22_30 = var5_16;
                                                            var7_18 = var24_32 = (var23_31 = var22_30.getValue());
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -2128271048) break block54;
                                                            var77_1 = 1915504958 ^ var77_1;
                                                            var8_19 = var25_33 = (int)(1644751897 ^ var77_1);
                                                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 273113291) break block51;
                                                            var77_1 = 2074473032 ^ var77_1;
lbl85:
                                                            // 2 sources

                                                            while ((var26_34 = var8_19) < (var47_49 = (var46_48 = var7_18).length)) {
                                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -848760184) break block51;
                                                                var77_1 = 307375835 ^ var77_1;
                                                                var27_35 = System.out;
                                                                var48_50 = new StringBuilder();
                                                                var72_69 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.dfnvkndrflldbls(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                                var49_51 = var48_50.append(var72_69);
                                                                var73_70 = var7_18;
                                                                var3_15 = var8_19;
                                                                var74_71 = var73_70[var3_15];
                                                                var50_52 = var49_51.append(var74_71);
                                                                var51_53 = var50_52.toString();
                                                                var27_35.println(var51_53);
                                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1610187856) break block24;
                                                                var77_1 = 1771597244 ^ var77_1;
                                                                var8_19 += 1650941239 ^ var77_1;
                                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 322628019) break block50;
                                                                var77_1 = JnaDebugTools.sszvdrlyrizasxms(var77_1, 1062469722);
                                                                ** try [egrp 0[TRYBLOCK] [2 : 1195->1208)] { 
lbl104:
                                                                // 1 sources

                                                                ** GOTO lbl-1000
                                                            }
                                                            break block60;
                                                        }
                                                        while (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1266332328 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1181516378 ^ var77_1)) {
                                                        }
                                                        1781091649 ^ var77_1;
                                                        throw new RuntimeException("double");
                                                    }
                                                    block27: while (true) {
                                                        switch (muaijwxryatoplqf.kmnceyaxxvkbutav(var77_1)) {
                                                            case 1297744037: {
                                                                continue block27;
                                                            }
                                                            case 57594948: {
                                                                var77_1 = 862813383 ^ var77_1;
                                                            }
                                                            case 1141432772: {
                                                                var28_72 = System.out;
                                                                var52_73 = JnaDebugTools.yhiiihgwgk(JnaDebugTools.qsqrjujpyuonate(), JnaDebugTools.gdqvulcrolkrvxu(), var77_1);
                                                                var28_72.println(var52_73);
                                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == 1984439178) {
                                                                    var77_1 = 471374965 ^ var77_1;
                                                                    var29_74 = System.out;
                                                                    var29_74.flush();
                                                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == -1769160670) {
                                                                        var77_1 = 530179558 ^ var77_1;
                                                                        return;
                                                                    }
                                                                } else {
                                                                    while (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1984439178 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1305197780 ^ var77_1)) {
                                                                    }
                                                                    1918341145 ^ var77_1;
                                                                    throw new RuntimeException("double");
                                                                }
                                                                while (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1769160670 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (651623019 ^ var77_1)) {
                                                                }
                                                                871919469 ^ var77_1;
                                                                throw new IllegalAccessException("double");
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == 1036125810) ** GOTO lbl155
                                                    break block61;
lbl-1000:
                                                    // 1 sources

                                                    {
                                                        if (muaijwxryatoplqf.kmnceyaxxvkbutav(var77_1) == 76798002) throw new RuntimeException();
                                                        throw null;
                                                    }
lbl145:
                                                    // 1 sources

                                                    catch (RuntimeException v0) {
                                                        switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var77_1)) {
                                                            case -375723166: {
                                                                var77_1 = JnaDebugTools.sszvdrlyrizasxms(var77_1, 445324706);
                                                                ** GOTO lbl152
                                                            }
                                                            case -1970008015: {
                                                                var77_1 = 1995096776 ^ var77_1;
lbl152:
                                                                // 2 sources

                                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1036125810) break;
                                                                var77_1 = JnaDebugTools.sszvdrlyrizasxms(var77_1, 1578458783);
                                                                ** GOTO lbl85
                                                            }
                                                        }
                                                    }
lbl155:
                                                    // 4 sources

                                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == 1036125810) ** GOTO lbl157
                                                    ** GOTO lbl155
                                                }
                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1265457633 ^ var77_1)) ** GOTO lbl155
                                                369256045 ^ var77_1;
                                                throw new IllegalAccessException("double");
                                                throw new IOException("Error in hash");
                                            }
                                            while (true) {
                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1738992258 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1499592944 ^ var77_1)) {
                                                    continue;
                                                }
                                                316067409 ^ var77_1;
                                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == 1782837010 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (2100515077 ^ var77_1)) break;
                                            }
                                            962902337 ^ var77_1;
                                            throw new IllegalAccessException("double");
                                        }
                                        while (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 122785803 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (2009232455 ^ var77_1)) {
                                        }
                                        728044284 ^ var77_1;
                                        throw new RuntimeException("double");
                                    }
                                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1 = 1775222859 ^ var77_1) != -2095648557) break block53;
                                    var77_1 = 254001537 ^ var77_1;
                                    try {
                                        if (muaijwxryatoplqf.kmnceyaxxvkbutav(var77_1) == 109990525) throw new RuntimeException();
                                        throw null;
                                    }
                                    catch (RuntimeException v1) {
                                        switch (muaijwxryatoplqf.jujaorjkwlwbigrx(var77_1)) {
                                            default: {
                                                throw new IOException("Error in hash");
                                            }
                                            case -100074277: {
                                                var77_1 = 1303414818 ^ var77_1;
                                                break;
                                            }
                                            case -691663199: {
                                                var77_1 = 136926829 ^ var77_1;
                                            }
                                        }
                                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1752384055) break block50;
                                    }
                                    block32: while (true) {
                                        switch (muaijwxryatoplqf.kmnceyaxxvkbutav(var77_1)) {
                                            case 704228623: {
                                                continue block32;
                                            }
                                            case 2126213997: {
                                                continue block24;
                                            }
                                            case 45360903: {
                                                var77_1 = 1331031823 ^ var77_1;
                                                continue block24;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
lbl206:
                            // 2 sources

                            while (true) {
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1042102402) ** GOTO lbl206
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1699616516 ^ var77_1)) continue;
                                1666972601 ^ var77_1;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 693272474 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (790265036 ^ var77_1)) continue;
                                666826377 ^ var77_1;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1610187856 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1927403830 ^ var77_1)) continue;
                                1203937164 ^ var77_1;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -691663199 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (523131439 ^ var77_1)) continue;
                                1505988875 ^ var77_1;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == -975220392 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (1413782297 ^ var77_1)) break;
                            }
                            1600967600 ^ var77_1;
                            throw new IOException("double");
                        }
                        while (true) {
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 13235859 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1945172119 ^ var77_1)) {
                                continue;
                            }
                            1449661543 ^ var77_1;
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == -2095648557 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (925612998 ^ var77_1)) break;
                        }
                        479279377 ^ var77_1;
                        throw new RuntimeException("double");
                    }
                    while (true) {
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 1801421059 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (57848176 ^ var77_1)) {
                            continue;
                        }
                        2014276618 ^ var77_1;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 322628019 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (2051256323 ^ var77_1)) continue;
                        1071958497 ^ var77_1;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -375723166 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1287484559 ^ var77_1)) continue;
                        568738958 ^ var77_1;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -316422733 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (2048327320 ^ var77_1)) continue;
                        874037930 ^ var77_1;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1752384055 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1401108165 ^ var77_1)) continue;
                        1453745853 ^ var77_1;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == -1038050839 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (1775756881 ^ var77_1)) break;
                    }
                    2142049123 ^ var77_1;
                    throw new IllegalAccessException();
                }
                while (true) {
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1970008015 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1293401603 ^ var77_1)) {
                        continue;
                    }
                    1279813019 ^ var77_1;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != 273113291 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1798936059 ^ var77_1)) continue;
                    75963072 ^ var77_1;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -848760184 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1981943951 ^ var77_1)) continue;
                    324677614 ^ var77_1;
                    if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == -944243237 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (435803640 ^ var77_1)) break;
                }
                25427514 ^ var77_1;
                throw new IllegalAccessException("double");
            }
            while (true) {
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -1175044853 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1552999294 ^ var77_1)) {
                    continue;
                }
                1079553561 ^ var77_1;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == 1322106546 && muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) == (953504981 ^ var77_1)) break;
            }
            591594134 ^ var77_1;
            throw new IllegalAccessException("double");
        }
        while (muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != -2128271048 || muaijwxryatoplqf.huhowxzlzevtonoz(var77_1) != (1408896452 ^ var77_1)) {
        }
        427642756 ^ var77_1;
        throw new RuntimeException("double");
    }

    public static ScheduledExecutorService scheduleThreadDump(String string, long l, TimeUnit timeUnit) {
        int n = 0x524E7579 ^ (0x35156A11 ^ 0x107BB7CD);
        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1190836949) {
            ScheduledExecutorService scheduledExecutorService;
            n = 0x56E7F577 ^ n;
            ThreadFactory threadFactory = new ThreadFactory(){
                private static int IZIFcZmPkb = 0;
                private transient int wAw6Zp16Mn = 1900992539;
                private static String[] nothing_to_see_here = new String[15];
                {
                    int n = 0x1D93EDC9 ^ 0x5214F7A8;
                    2 var1_2 = this;
                    n = 2.wayqeriwjaoojuyc(n, 1161368749);
                    n = 0x2489426C ^ (0x65739374 ^ Integer.parseInt("1262804948"));
                    this.wAw6Zp16Mn = 0x714ED81B ^ IZIFcZmPkb;
                    n = 2.wayqeriwjaoojuyc(n, 276181011);
                }

                @Override
                public Thread newThread(Runnable runnable) {
                    int n;
                    block7: {
                        block8: {
                            block6: {
                                Thread thread;
                                n = 0x53514B74 ^ (0x4FB9BB6D ^ 0x2123CD0E);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -296097607) break block6;
                                n = 0x7CD4E626 ^ n;
                                Runnable runnable2 = runnable;
                                Thread thread2 = thread = new Thread(runnable2);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 150919562) break block7;
                                n = 0x65682122 ^ n;
                                Thread thread3 = thread2;
                                String string = 2.whhzwegdyv(2.jnqrqngltlcudmx(), 2.piztxcypoouiwgj(), n);
                                thread3.setName(string);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 599773337) break block7;
                                n = 0x5FE615FD ^ n;
                                Thread thread4 = thread2;
                                boolean bl = (byte)(0x7B91EFEF ^ n);
                                thread4.setDaemon(bl);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -594575501) {
                                    n = 0x48AE8BC4 ^ n;
                                    Thread thread5 = thread2;
                                    return thread5;
                                }
                                break block8;
                            }
                            while (true) {
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1711595183 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x10ED3F52 ^ n)) {
                                    continue;
                                }
                                int cfr_ignored_0 = 0x3441C667 ^ n;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -296097607 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x6542C358 ^ n)) break;
                            }
                            int cfr_ignored_1 = 0x4F83C121 ^ n;
                            throw new RuntimeException("double");
                        }
                        while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -594575501 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6740DED ^ n)) {
                        }
                        int cfr_ignored_2 = 0x65D218C9 ^ n;
                        throw new IllegalAccessException("double");
                    }
                    while (true) {
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 599773337 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x570ED963 ^ n)) {
                            continue;
                        }
                        int cfr_ignored_3 = 0x5E6DC492 ^ n;
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 150919562 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x2A654055 ^ n)) break;
                    }
                    int cfr_ignored_4 = 0x6BEF2081 ^ n;
                    throw new IOException();
                }

                static {
                    2.nothing_to_see_here[0] = "\u2804\u2804\u2804\u28b0\u28e7\u28fc\u28ef\u2804\u28f8\u28e0\u28f6\u28f6\u28e6\u28fe\u2804\u2804\u2804\u2804\u2840\u2804\u2880\u28ff\u28ff\u2804\u2804\u2804\u28b8\u2847\u2804\u2804";
                    2.nothing_to_see_here[1] = "\u2804\u2804\u2804\u28fe\u28ff\u283f\u283f\u2836\u283f\u28bf\u28ff\u28ff\u28ff\u28ff\u28e6\u28e4\u28c4\u2880\u2845\u28a0\u28fe\u28db\u2849\u2804\u2804\u2804\u2838\u2880\u28ff\u2804";
                    2.nothing_to_see_here[2] = "\u2804\u2804\u2880\u284b\u28e1\u28f4\u28f6\u28f6\u2840\u2804\u2804\u2819\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28f4\u28ff\u28ff\u28ff\u2883\u28e4\u28c4\u28c0\u28e5\u28ff\u28ff\u2804";
                    2.nothing_to_see_here[3] = "\u2804\u2804\u28b8\u28c7\u283b\u28ff\u28ff\u28ff\u28e7\u28c0\u2880\u28e0\u284c\u28bb\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u283f\u283f\u283f\u28ff\u28ff\u28ff\u2804";
                    2.nothing_to_see_here[4] = "\u2804\u2880\u28b8\u28ff\u28f7\u28e4\u28e4\u28e4\u28ec\u28d9\u28db\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u287f\u28ff\u28ff\u284d\u2804\u2804\u2880\u28e4\u28c4\u2809\u280b\u28f0";
                    2.nothing_to_see_here[5] = "\u2804\u28fc\u28d6\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u2887\u28ff\u28ff\u2877\u2836\u2836\u28bf\u28ff\u28ff\u2807\u2880\u28e4";
                    2.nothing_to_see_here[6] = "\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28fd\u28ff\u28ff\u28ff\u2847\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28f7\u28f6\u28e5\u28f4\u28ff\u2857";
                    2.nothing_to_see_here[7] = "\u2880\u2808\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u285f\u2804";
                    2.nothing_to_see_here[8] = "\u28b8\u28ff\u28e6\u28cc\u28db\u28fb\u28ff\u28ff\u28e7\u2819\u281b\u281b\u286d\u2805\u2812\u2826\u282d\u28ed\u287b\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u287f\u2803\u2804";
                    2.nothing_to_see_here[9] = "\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2846\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2839\u2808\u288b\u28fd\u28ff\u28ff\u28ff\u28ff\u28f5\u28fe\u2803\u2804";
                    2.nothing_to_see_here[10] = "\u2804\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2804\u28f4\u28ff\u28f6\u28c4\u2804\u28f4\u28f6\u2804\u2880\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2803\u2804\u2804";
                    2.nothing_to_see_here[11] = "\u2804\u2804\u2808\u283b\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2844\u28bb\u28ff\u28ff\u28ff\u2804\u28ff\u28ff\u2840\u28fe\u28ff\u28ff\u28ff\u28ff\u28db\u281b\u2801\u2804\u2804\u2804";
                    2.nothing_to_see_here[12] = "\u2804\u2804\u2804\u2804\u2808\u281b\u28bf\u28ff\u28ff\u28ff\u2801\u281e\u28bf\u28ff\u28ff\u2844\u28bf\u28ff\u2847\u28f8\u28ff\u28ff\u283f\u281b\u2801\u2804\u2804\u2804\u2804\u2804";
                    2.nothing_to_see_here[13] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2809\u283b\u28ff\u28ff\u28fe\u28e6\u2859\u283b\u28f7\u28fe\u28ff\u2803\u283f\u280b\u2801\u2804\u2804\u2804\u2804\u2804\u2880\u28e0\u28f4";
                    2.nothing_to_see_here[14] = "\u28ff\u28ff\u28ff\u28f6\u28f6\u28ee\u28e5\u28d2\u2832\u28ae\u28dd\u287f\u28ff\u28ff\u2846\u28ff\u287f\u2803\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28e0\u28f4\u28ff\u28ff\u28ff";
                    int n = new Random(-703160230388949745L).nextInt();
                    IZIFcZmPkb = 0x9334BBF8 ^ n;
                }

                public static String whhzwegdyv(byte[] byArray, byte[] byArray2, int n) {
                    byte[] byArray3;
                    int n2;
                    int n3;
                    int n4;
                    byte[] byArray4;
                    int n5 = n;
                    String string = Integer.toString(n5);
                    byte[] byArray5 = byArray4 = string.getBytes();
                    int n6 = n4 = 0;
                    while ((n3 = n6) < (n2 = (byArray3 = byArray).length)) {
                        byte by;
                        byte by2;
                        byte[] byArray6 = byArray;
                        int n7 = n6;
                        byte by3 = byArray6[n7];
                        byte[] byArray7 = byArray5;
                        int n8 = n6;
                        byte[] byArray8 = byArray5;
                        int n9 = byArray8.length;
                        int n10 = n8 % n9;
                        byte by4 = byArray7[n10];
                        int n11 = by3 ^ by4;
                        byArray6[n7] = by2 = (byte)n11;
                        byte[] byArray9 = byArray;
                        int n12 = n6;
                        byte by5 = byArray9[n12];
                        byte[] byArray10 = byArray2;
                        int n13 = n6++;
                        byte[] byArray11 = byArray2;
                        int n14 = byArray11.length;
                        int n15 = n13 % n14;
                        byte by6 = byArray10[n15];
                        int n16 = by5 ^ by6;
                        byArray9[n12] = by = (byte)n16;
                    }
                    byte[] byArray12 = byArray;
                    Charset charset = StandardCharsets.UTF_16;
                    String string2 = new String(byArray12, charset);
                    return string2;
                }

                private static byte[] piztxcypoouiwgj() {
                    return new byte[]{102, 85, 112, 69, 55, 114, 11, 107, 122, 5, 42, 117, 110, 120, 110, 98, 61, 27, 86, 126, 13, 44, 95, 39, 94, 106, 50, 59, 92, 75, 84, 27, 81, 34, 85, 58, 39, 123, 118, 118, 79, 121, 40, 60, 56, 106, 40, 6, 57, 54, 31, 55, 109};
                }

                private static byte[] jnqrqngltlcudmx() {
                    return new byte[]{-82, -101, 65, 23, 3, 46, 62, 61, 67, 30, 27, 32, 86, 41, 92, 53, 10, 87, 96, 40, 60, 57, 107, 98, 107, 60, 11, 121, 109, 25, 108, 71, 99, 115, 98, 108, 17, 45};
                }

                private static int wayqeriwjaoojuyc(int n, int n2) {
                    return n2 ^ n;
                }
            };
            ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(threadFactory);
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 238743185) {
                n = 0x3FF268AC ^ n;
                ScheduledExecutorService scheduledExecutorService3 = scheduledExecutorService2;
                String string2 = string;
                Runnable runnable = new Runnable(string2){
                    final /* synthetic */ String val$reason;
                    private static int GfFE8NvZ0l = 0;
                    private transient int hKCpJiHRlz = 1884632137;
                    private static byte[] mqnctrmvdi;
                    private static String[] nothing_to_see_here;
                    {
                        String string2;
                        int n = 0x153CCCEF ^ 0x32886717;
                        3 var2_3 = this;
                        var2_3.val$reason = string2 = string;
                        3 var4_5 = this;
                        n = 0x3D99210A ^ n;
                        n = 0x46F5ACB3 ^ (0x1E1FFD83 ^ Integer.parseInt("1120394178"));
                        this.hKCpJiHRlz = 0x70553449 ^ GfFE8NvZ0l;
                        n = 0x6412C188 ^ n;
                    }

                    @Override
                    public void run() {
                        int n = 0x2AE08C7B ^ (0x4D72F13F ^ 0x40B0DEE7);
                        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 957685017) {
                            n = 0xB6DE74E ^ n;
                            3 var1_2 = this;
                            String string = var1_2.val$reason;
                            JnaDebugTools.dumpAllThreads(string);
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 1652172649) {
                                n = 0x47214081 ^ n;
                                return;
                            }
                        }
                        while (true) {
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 957685017 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x558512A3 ^ n)) {
                                continue;
                            }
                            int cfr_ignored_0 = 0x3BDE4F5A ^ n;
                            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 1652172649 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x4B1CDE99 ^ n)) break;
                        }
                        int cfr_ignored_1 = 0x451F5EAE ^ n;
                        throw new IllegalAccessException();
                    }

                    static {
                        nothing_to_see_here = new String[17];
                        3.nothing_to_see_here[0] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28c0\u28e0\u28e4\u28f6\u28f6\u28f6\u28e4\u28c4\u28c0\u28c0\u2804\u2804\u2804\u2804\u2804";
                        3.nothing_to_see_here[1] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28c0\u28e4\u28e4\u28f6\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28df\u28bf\u28ff\u28ff\u28ff\u28f6\u28e4\u2840\u2804";
                        3.nothing_to_see_here[2] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2880\u28fc\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28f7\u28dc\u283f\u283f\u28ff\u28ff\u28e7\u2893";
                        3.nothing_to_see_here[3] = "\u2804\u2804\u2804\u2804\u2804\u2860\u289b\u28ff\u28ff\u28ff\u285f\u28ff\u28ff\u28fd\u28cb\u283b\u28bb\u28ff\u28ff\u28ff\u28ff\u287b\u28e7\u2860\u28ed\u28ed\u28ff\u2867";
                        3.nothing_to_see_here[4] = "\u2804\u2804\u2804\u2804\u2804\u28a0\u28ff\u285f\u28ff\u28bb\u2803\u28fb\u28e8\u28fb\u283f\u2840\u28dd\u287f\u28ff\u28ff\u28f7\u28dc\u28dc\u28bf\u28dd\u287f\u287b\u2894";
                        3.nothing_to_see_here[5] = "\u2804\u2804\u2804\u2804\u2804\u28b8\u285f\u28f7\u28bf\u2888\u28da\u28d3\u2861\u28fb\u28ff\u28f6\u28ec\u28db\u28d3\u28c9\u287b\u28bf\u28ce\u2822\u283b\u28f4\u287e\u282b";
                        3.nothing_to_see_here[6] = "\u2804\u2804\u2804\u2804\u2804\u28b8\u2803\u28b9\u287c\u28b8\u28ff\u28ff\u28ff\u28e6\u28f9\u28ff\u28ff\u28ff\u283f\u283f\u283f\u2837\u28ce\u287c\u2806\u28ff\u2835\u28eb";
                        3.nothing_to_see_here[7] = "\u2804\u2804\u2804\u2804\u2804\u2808\u2804\u2838\u285f\u285c\u28e9\u2844\u2804\u28ff\u28ff\u28ff\u28ff\u28f6\u2880\u2880\u28ff\u28f7\u28ff\u28ff\u2850\u2847\u2844\u28ff";
                        3.nothing_to_see_here[8] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2801\u28b6\u28bb\u28e7\u28d6\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u284f\u28ff\u28c7\u285f\u28c7\u28f7\u28ff";
                        3.nothing_to_see_here[9] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28b8\u28c6\u28e4\u28fd\u28ff\u287f\u283f\u283f\u28ff\u28ff\u28e6\u28f4\u2847\u28ff\u28a8\u28fe\u28ff\u28b9\u28b8";
                        3.nothing_to_see_here[10] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28b8\u28ff\u280a\u285b\u28bf\u28ff\u28ff\u28ff\u28ff\u287f\u28eb\u28b1\u28ba\u2847\u284f\u28ff\u28ff\u28f8\u287c";
                        3.nothing_to_see_here[11] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28b8\u287f\u2804\u28ff\u28f7\u28fe\u284d\u28ed\u28f6\u28ff\u28ff\u284c\u28fc\u28f9\u28b1\u2839\u28ff\u28c7\u28e7";
                        3.nothing_to_see_here[12] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28fc\u2801\u28e4\u28ed\u28ed\u284c\u2881\u28fc\u28ff\u28ff\u28ff\u28b9\u2847\u28ed\u28e4\u28f6\u28e4\u285d\u287c";
                        3.nothing_to_see_here[13] = "\u2804\u28c0\u2824\u2840\u2804\u2804\u2804\u2804\u2804\u284f\u28c8\u287b\u287f\u2803\u2880\u28fe\u28ff\u28ff\u28ff\u287f\u287c\u2801\u28ff\u28ff\u28ff\u287f\u28b7\u28b8";
                        3.nothing_to_see_here[14] = "\u28b0\u28f7\u2867\u2862\u2804\u2804\u2804\u2804\u2820\u28a0\u285b\u283f\u2804\u2820\u282c\u283f\u28ff\u282d\u282d\u28b1\u28c7\u28c0\u28ed\u2845\u2836\u28fe\u28f7\u28f6";
                        3.nothing_to_see_here[15] = "\u2808\u28bf\u28ff\u28e7\u2804\u2804\u2804\u2804\u2880\u285b\u283f\u2804\u2804\u2804\u2804\u28a0\u2803\u2804\u2804\u285c\u2804\u2804\u28e4\u2880\u28f6\u28ee\u284d\u28f4";
                        3.nothing_to_see_here[16] = "\u2804\u2808\u28ff\u28ff\u2840\u2804\u2804\u2804\u28a9\u28dd\u2803\u2804\u2804\u2880\u2844\u284e\u2804\u2804\u2804\u2807\u2804\u2804\u2805\u28f4\u28f6\u28f6\u2804\u28f6";
                        mqnctrmvdi = 3.wbvzbekvapziovw();
                        int n = new Random(-6102725409544070958L).nextInt();
                        GfFE8NvZ0l = 0x56E6FC52 ^ n;
                    }

                    public static String onbgnrhmoa(byte[] byArray, int n) {
                        byte[] byArray2;
                        int n2;
                        int n3;
                        int n4;
                        byte[] byArray3;
                        int n5 = n;
                        String string = Integer.toString(n5);
                        byte[] byArray4 = byArray3 = string.getBytes();
                        int n6 = n4 = 0;
                        while ((n3 = n6) < (n2 = (byArray2 = byArray).length)) {
                            byte by;
                            byte by2;
                            byte[] byArray5 = byArray;
                            int n7 = n6;
                            byte by3 = byArray5[n7];
                            byte[] byArray6 = byArray4;
                            int n8 = n6;
                            byte[] byArray7 = byArray4;
                            int n9 = byArray7.length;
                            int n10 = n8 % n9;
                            byte by4 = byArray6[n10];
                            int n11 = by3 ^ by4;
                            byArray5[n7] = by2 = (byte)n11;
                            byte[] byArray8 = byArray;
                            int n12 = n6;
                            byte by5 = byArray8[n12];
                            byte[] byArray9 = mqnctrmvdi;
                            int n13 = n6++;
                            byte[] byArray10 = mqnctrmvdi;
                            int n14 = byArray10.length;
                            int n15 = n13 % n14;
                            byte by6 = byArray9[n15];
                            int n16 = by5 ^ by6;
                            byArray8[n12] = by = (byte)n16;
                        }
                        byte[] byArray11 = byArray;
                        Charset charset = StandardCharsets.UTF_16;
                        String string2 = new String(byArray11, charset);
                        return string2;
                    }

                    private static byte[] wbvzbekvapziovw() {
                        return new byte[]{64, 38, 80, 106, 100, 63, 69, 81, 49, 118, 105, 113, 12, 67, 104, 6, 9, 110, 73, 67};
                    }
                };
                long l2 = l;
                TimeUnit timeUnit2 = timeUnit;
                ScheduledFuture<?> scheduledFuture = scheduledExecutorService3.schedule(runnable, l2, timeUnit2);
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -240538640) {
                    n = 0x2573B87E ^ n;
                    ScheduledExecutorService scheduledExecutorService4 = scheduledExecutorService2;
                    return scheduledExecutorService4;
                }
            }
            while (true) {
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -240538640 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x4CD31671 ^ n)) {
                    continue;
                }
                int cfr_ignored_0 = 0x3DFB7753 ^ n;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -634099711 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6F1F5A4C ^ n)) continue;
                int cfr_ignored_1 = 0x318966FE ^ n;
                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 238743185 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x50C309C9 ^ n)) break;
            }
            int cfr_ignored_2 = 0x2E380E2 ^ n;
            throw new RuntimeException();
        }
        while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1190836949 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6DEB668A ^ n)) {
        }
        int cfr_ignored_3 = 0x359ED977 ^ n;
        throw new RuntimeException("double");
    }

    public static ThreadFactory namedThreadFactory(String string) {
        int n = 0xE6538E6 ^ (0x64802C52 ^ 0x107BB7CD);
        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -722134069) {
            n = 0x78F7B3BD ^ n;
            String string2 = string;
            ThreadFactory threadFactory = new ThreadFactory(string2){
                final /* synthetic */ String val$threadName;
                private static int DKd14tlviZ = 0;
                private transient int thsi5fBOYY = 1529700555;
                private static String[] nothing_to_see_here = new String[18];
                {
                    String string2;
                    int n = 0x56392E25 ^ 0x1A48D001;
                    4 var2_3 = this;
                    var2_3.val$threadName = string2 = string;
                    4 var4_5 = this;
                    {
                        switch (muaijwxryatoplqf.kmnceyaxxvkbutav(n)) {
                            case 92831180: {
                                continue block5;
                            }
                            case 68980756: {
                                n = 0x3CE96A84 ^ n;
                                break block5;
                            }
                            default: {
                                throw new IOException();
                            }
                            case 1795122388: 
                        }
                    }
                    n = 0xEAB3F93 ^ (0x3C80855A ^ Integer.parseInt("1119039081"));
                    this.thsi5fBOYY = 0x5B2D60CB ^ DKd14tlviZ;
                    n = 0x1D87BE0 ^ n;
                }

                @Override
                public Thread newThread(Runnable runnable) {
                    int n;
                    block6: {
                        block7: {
                            block5: {
                                Thread thread;
                                n = 0x3D7A4922 ^ (0xB9AF429 ^ 0x6500824A);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1627260406) break block5;
                                n = 0x1AC9EFB2 ^ n;
                                Runnable runnable2 = runnable;
                                Thread thread2 = thread = new Thread(runnable2);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1229883290) break block6;
                                n = 0x507E06D9 ^ n;
                                Thread thread3 = thread2;
                                4 var7_7 = this;
                                String string = var7_7.val$threadName;
                                thread3.setName(string);
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -893472432) {
                                    n = 0xC4215A7 ^ n;
                                    Thread thread4 = thread2;
                                    return thread4;
                                }
                                break block7;
                            }
                            while (true) {
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -1464984472 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2C788D0A ^ n)) {
                                    continue;
                                }
                                int cfr_ignored_0 = 0x506E3CD ^ n;
                                if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -1627260406 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x19F357CD ^ n)) break;
                            }
                            int cfr_ignored_1 = 0x71571E17 ^ n;
                            throw new IOException();
                        }
                        while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -893472432 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x6EF54B52 ^ n)) {
                        }
                        int cfr_ignored_2 = 0x32E700D2 ^ n;
                        throw new RuntimeException("double");
                    }
                    while (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 1229883290 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x25A1FE7C ^ n)) {
                    }
                    int cfr_ignored_3 = 0x7DD2E63C ^ n;
                    throw new IllegalAccessException("double");
                }

                static {
                    4.nothing_to_see_here[0] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28c0\u2840\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[1] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2880\u28f6\u28ff\u28ff\u28ff\u28ff\u28ff\u28c4\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[2] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2880\u28ff\u28ff\u28ff\u283f\u281f\u281b\u283b\u28ff\u2806\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[3] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28b8\u28ff\u28ff\u28ff\u28c6\u28c0\u28c0\u2800\u28ff\u2802\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[4] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28b8\u283b\u28ff\u28ff\u28ff\u2805\u281b\u280b\u2808\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[5] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2818\u28bc\u28ff\u28ff\u28ff\u28c3\u2820\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[6] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28ff\u28ff\u28df\u287f\u2803\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[7] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28db\u28db\u28eb\u2844\u2800\u28b8\u28e6\u28c0\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[8] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2880\u28e0\u28f4\u28fe\u2846\u2838\u28ff\u28ff\u28ff\u2877\u2802\u2828\u28ff\u28ff\u28ff\u28ff\u28f6\u28e6\u28e4\u28c0\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[9] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28e4\u28fe\u28ff\u28ff\u28ff\u28ff\u2847\u2880\u28ff\u287f\u280b\u2801\u2880\u2876\u282a\u28c9\u28b8\u28ff\u28ff\u28ff\u28ff\u28ff\u28c7\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[10] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2880\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u284f\u28b8\u28ff\u28f7\u28ff\u28ff\u28f7\u28e6\u2859\u28ff\u28ff\u28ff\u28ff\u28ff\u284f\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[11] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2808\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28c7\u28b8\u28ff\u28ff\u28ff\u28ff\u28ff\u28f7\u28e6\u28ff\u28ff\u28ff\u28ff\u28ff\u2847\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[12] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28a0\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2847\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[13] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28b8\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28c4\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[14] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2838\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[15] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28e0\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u287f\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[16] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2803\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    4.nothing_to_see_here[17] = "\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u28b9\u28ff\u28f5\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ef\u2841\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800\u2800";
                    int n = new Random(826409187550862366L).nextInt();
                    DKd14tlviZ = 0x90DFEF2C ^ n;
                }

                public static String jiawwutucc(byte[] byArray, byte[] byArray2, int n) {
                    byte[] byArray3;
                    int n2;
                    int n3;
                    int n4;
                    byte[] byArray4;
                    int n5 = n;
                    String string = Integer.toString(n5);
                    byte[] byArray5 = byArray4 = string.getBytes();
                    int n6 = n4 = 0;
                    while ((n3 = n6) < (n2 = (byArray3 = byArray).length)) {
                        byte by;
                        byte by2;
                        byte[] byArray6 = byArray;
                        int n7 = n6;
                        byte by3 = byArray6[n7];
                        byte[] byArray7 = byArray5;
                        int n8 = n6;
                        byte[] byArray8 = byArray5;
                        int n9 = byArray8.length;
                        int n10 = n8 % n9;
                        byte by4 = byArray7[n10];
                        int n11 = by3 ^ by4;
                        byArray6[n7] = by2 = (byte)n11;
                        byte[] byArray9 = byArray;
                        int n12 = n6;
                        byte by5 = byArray9[n12];
                        byte[] byArray10 = byArray2;
                        int n13 = n6++;
                        byte[] byArray11 = byArray2;
                        int n14 = byArray11.length;
                        int n15 = n13 % n14;
                        byte by6 = byArray10[n15];
                        int n16 = by5 ^ by6;
                        byArray9[n12] = by = (byte)n16;
                    }
                    byte[] byArray12 = byArray;
                    Charset charset = StandardCharsets.UTF_16;
                    String string2 = new String(byArray12, charset);
                    return string2;
                }

                private static byte[] rlkanlbhqppnnkt() {
                    return new byte[]{54, 95, 110, 7, 42, 113, 53, 106, 67, 70, 98, 83, 38, 125, 59, 20, 102, 64, 27, 1, 3, 62, 45, 48, 41, 105, 46, 66, 65, 39, 62, 2, 34, 53, 108, 46, 75, 81, 99, 96, 115, 18, 127, 49, 127, 110, 108, 31, 27, 18, 101, 19, 85, 58, 74, 38, 60, 26, 2, 106, 33, 98, 71, 94, 15, 6, 60, 105, 76, 58};
                }
            };
            return threadFactory;
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != 323520032 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x74557151 ^ n)) {
                continue;
            }
            int cfr_ignored_0 = 0xF1FAE11 ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -722134069 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x690B01F6 ^ n)) break;
        }
        int cfr_ignored_1 = 0x271384E7 ^ n;
        throw new IOException();
    }

    static {
        nothing_to_see_here = new String[15];
        JnaDebugTools.nothing_to_see_here[0] = "\u2804\u2804\u2804\u28b0\u28e7\u28fc\u28ef\u2804\u28f8\u28e0\u28f6\u28f6\u28e6\u28fe\u2804\u2804\u2804\u2804\u2840\u2804\u2880\u28ff\u28ff\u2804\u2804\u2804\u28b8\u2847\u2804\u2804";
        JnaDebugTools.nothing_to_see_here[1] = "\u2804\u2804\u2804\u28fe\u28ff\u283f\u283f\u2836\u283f\u28bf\u28ff\u28ff\u28ff\u28ff\u28e6\u28e4\u28c4\u2880\u2845\u28a0\u28fe\u28db\u2849\u2804\u2804\u2804\u2838\u2880\u28ff\u2804";
        JnaDebugTools.nothing_to_see_here[2] = "\u2804\u2804\u2880\u284b\u28e1\u28f4\u28f6\u28f6\u2840\u2804\u2804\u2819\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28f4\u28ff\u28ff\u28ff\u2883\u28e4\u28c4\u28c0\u28e5\u28ff\u28ff\u2804";
        JnaDebugTools.nothing_to_see_here[3] = "\u2804\u2804\u28b8\u28c7\u283b\u28ff\u28ff\u28ff\u28e7\u28c0\u2880\u28e0\u284c\u28bb\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u283f\u283f\u283f\u28ff\u28ff\u28ff\u2804";
        JnaDebugTools.nothing_to_see_here[4] = "\u2804\u2880\u28b8\u28ff\u28f7\u28e4\u28e4\u28e4\u28ec\u28d9\u28db\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u287f\u28ff\u28ff\u284d\u2804\u2804\u2880\u28e4\u28c4\u2809\u280b\u28f0";
        JnaDebugTools.nothing_to_see_here[5] = "\u2804\u28fc\u28d6\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u2887\u28ff\u28ff\u2877\u2836\u2836\u28bf\u28ff\u28ff\u2807\u2880\u28e4";
        JnaDebugTools.nothing_to_see_here[6] = "\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28fd\u28ff\u28ff\u28ff\u2847\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28f7\u28f6\u28e5\u28f4\u28ff\u2857";
        JnaDebugTools.nothing_to_see_here[7] = "\u2880\u2808\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u285f\u2804";
        JnaDebugTools.nothing_to_see_here[8] = "\u28b8\u28ff\u28e6\u28cc\u28db\u28fb\u28ff\u28ff\u28e7\u2819\u281b\u281b\u286d\u2805\u2812\u2826\u282d\u28ed\u287b\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u287f\u2803\u2804";
        JnaDebugTools.nothing_to_see_here[9] = "\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2846\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2839\u2808\u288b\u28fd\u28ff\u28ff\u28ff\u28ff\u28f5\u28fe\u2803\u2804";
        JnaDebugTools.nothing_to_see_here[10] = "\u2804\u2818\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2804\u28f4\u28ff\u28f6\u28c4\u2804\u28f4\u28f6\u2804\u2880\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2803\u2804\u2804";
        JnaDebugTools.nothing_to_see_here[11] = "\u2804\u2804\u2808\u283b\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2844\u28bb\u28ff\u28ff\u28ff\u2804\u28ff\u28ff\u2840\u28fe\u28ff\u28ff\u28ff\u28ff\u28db\u281b\u2801\u2804\u2804\u2804";
        JnaDebugTools.nothing_to_see_here[12] = "\u2804\u2804\u2804\u2804\u2808\u281b\u28bf\u28ff\u28ff\u28ff\u2801\u281e\u28bf\u28ff\u28ff\u2844\u28bf\u28ff\u2847\u28f8\u28ff\u28ff\u283f\u281b\u2801\u2804\u2804\u2804\u2804\u2804";
        JnaDebugTools.nothing_to_see_here[13] = "\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2809\u283b\u28ff\u28ff\u28fe\u28e6\u2859\u283b\u28f7\u28fe\u28ff\u2803\u283f\u280b\u2801\u2804\u2804\u2804\u2804\u2804\u2880\u28e0\u28f4";
        JnaDebugTools.nothing_to_see_here[14] = "\u28ff\u28ff\u28ff\u28f6\u28f6\u28ee\u28e5\u28d2\u2832\u28ae\u28dd\u287f\u28ff\u28ff\u2846\u28ff\u287f\u2803\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28e0\u28f4\u28ff\u28ff\u28ff";
        int n = 0x66DF18C5 ^ (0x344B8766 ^ Integer.parseInt("1330480783"));
        int n2 = new Random(-876216889397046475L).nextInt();
        camRDSfZWc = 0xF94F4BA0 ^ n2;
        if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == -288831136) {
            Object object;
            n = 0x3F612C21 ^ n;
            JNA_SEQUENCE_LOCK = object = new Object();
            return;
        }
        while (true) {
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) != -288831136 || muaijwxryatoplqf.huhowxzlzevtonoz(n) != (0x2D52B9E3 ^ n)) {
                continue;
            }
            int cfr_ignored_0 = 0x6F66602D ^ n;
            if (muaijwxryatoplqf.huhowxzlzevtonoz(n) == 365013097 && muaijwxryatoplqf.huhowxzlzevtonoz(n) == (0x27B9D290 ^ n)) break;
        }
        int cfr_ignored_1 = 0x49346294 ^ n;
        throw new IllegalAccessException();
    }

    public static String yhiiihgwgk(byte[] byArray, byte[] byArray2, int n) {
        byte[] byArray3;
        int n2;
        int n3;
        int n4;
        byte[] byArray4;
        int n5 = n;
        String string = Integer.toString(n5);
        byte[] byArray5 = byArray4 = string.getBytes();
        int n6 = n4 = 0;
        while ((n3 = n6) < (n2 = (byArray3 = byArray).length)) {
            byte by;
            byte by2;
            byte[] byArray6 = byArray;
            int n7 = n6;
            byte by3 = byArray6[n7];
            byte[] byArray7 = byArray5;
            int n8 = n6;
            byte[] byArray8 = byArray5;
            int n9 = byArray8.length;
            int n10 = n8 % n9;
            byte by4 = byArray7[n10];
            int n11 = by3 ^ by4;
            byArray6[n7] = by2 = (byte)n11;
            byte[] byArray9 = byArray;
            int n12 = n6;
            byte by5 = byArray9[n12];
            byte[] byArray10 = byArray2;
            int n13 = n6++;
            byte[] byArray11 = byArray2;
            int n14 = byArray11.length;
            int n15 = n13 % n14;
            byte by6 = byArray10[n15];
            int n16 = by5 ^ by6;
            byArray9[n12] = by = (byte)n16;
        }
        byte[] byArray12 = byArray;
        Charset charset = StandardCharsets.UTF_16;
        String string2 = new String(byArray12, charset);
        return string2;
    }

    private static byte[] gdqvulcrolkrvxu() {
        return new byte[]{111, 109, 42, 94, 125, 54, 40, 33, 56, 71, 94, 90, 82, 31, 32, 64, 118, 25, 103, 63, 30, 8, 115, 81, 1, 14, 36, 90, 3, 34, 61, 37, 61, 7, 62, 70, 116, 17, 72, 44, 52, 45, 123, 58, 123, 32, 84, 85, 69, 108, 73, 18, 115, 126, 47, 119, 10, 122, 61, 68, 16, 111, 30, 58, 74, 48, 73, 41, 34, 92, 37};
    }

    private static byte[] fzzuohcnzfkyjiz() {
        return new byte[]{-96, -93, 27, 12, 75, 110, 17, 119, 9, 94, 111, 15, 99, 66, 22, 20, 79, 91, 86, 111, 47, 102, 66, 5, 55, 87, 29, 12, 50, 113};
    }

    private static byte[] dcshdyjzllvzzdg() {
        return new byte[]{-96, -93, 27, 18, 75, 114, 17, 99, 9, 21};
    }

    private static byte[] tdeezlszuiqtcfu() {
        return new byte[]{-92, -91, 28, 0, 74, 109, 30, 115, 13, 94, 104, 10, 101, 79, 22, 17, 67, 91, 81, 108, 41, 98, 69, 14, 52, 86, 18, 15, 52, 115, 11, 56, 8, 90, 8, 28, 67, 69};
    }

    private static byte[] ktxbwyushuevrof() {
        return new byte[]{-92, -91, 28, 30, 74, 113, 30, 103, 13, 21};
    }

    private static byte[] lvbwxcbgtdxmkzp() {
        return new byte[]{-96, -89, 30, 61, 76, 105, 27, 122, 11, 23, 111, 66, 102, 67, 17, 16, 69, 78, 84, 123, 47, 90, 71, 52, 48, 27, 23, 10, 48, 125, 12, 113, 9, 93, 15, 31, 71, 65, 123, 121, 5, 56, 79, 104, 74, 123, 103, 1, 118, 115, 120, 67, 71, 35, 30, 32, 57, 58, 14, 18, 33, 5, 42, 110, 123, 106, 122, 125, 17, 9, 20, 122, 89, 115, 111, 38, 5, 121, 18, 41, 118, 1, 110, 4, 46, 116, 115, 109, 42, 50, 14, 78, 60, 41, 96, 65, 61, 118, 105, 109, 19, 100, 17, 106, 54, 106, 117, 37, 34, 87, 29, 107, 25, 45, 11, 47};
    }

    private static byte[] mgndvlbcggpqpoy() {
        return new byte[]{-88, -96, 26, 60, 75, 96, 16, 121, 11, 8, 108, 55, 107, 9, 19, 11, 64, 95, 94, 99, 46, 31, 69, 3, 57, 74, 23, 0, 49, 122, 4, 61, 14, 91, 8, 20, 77, 87, 120, 116, 2, 48, 67, 97, 72, 118, 102, 1, 124, 63, 122, 70, 69, 112};
    }

    private static byte[] hiooklyghconyxo() {
        return new byte[]{-88, -96, 26, 20, 75, 112, 16, 121, 11, 80, 108, 11, 107, 91, 19, 27, 64, 66, 94, 35, 46, 85, 69, 3, 57, 76, 23, 2, 49, 60, 4, 126, 14, 80, 8, 17, 77, 70, 120, 121};
    }

    private static byte[] olvwtxyksnvwslh() {
        return new byte[]{-96, -91, 25, 55, 69, 103, 16, 127, 13, 0, 111, 48, 97, 13, 24, 30, 78, 71, 82, 111, 47, 17, 64, 23, 57, 87, 28, 26, 54, 119, 12, 123, 14, 71, 6, 79};
    }

    private static byte[] mbhiumwkjwhlolo() {
        return new byte[]{-96, -91, 25, 6, 69, 108, 16, 112, 13, 88, 111, 25, 97, 64, 24, 4, 78, 77, 82, 103, 47, 77};
    }

    private static byte[] tuhdmytegkuztmy() {
        return new byte[]{-96, -91, 27, 60, 74, 107, 25, 122, 10, 4, 111, 48, 99, 6, 23, 23, 71, 95, 85, 36, 47, 94, 66, 26, 54, 85, 21, 7, 49, 42};
    }

    private static byte[] ufsuxfsaqyxssks() {
        return new byte[]{-96, -91, 27, 8, 74, 125, 25, 58, 10, 19, 111, 31, 99, 69, 23, 16};
    }

    private static byte[] ukgjerejwabffyd() {
        return new byte[]{-96, -86, 19, 52, 77, 97, 16, 118, 14, 3, 111, 63, 107, 14, 16, 24, 78, 65, 81, 123, 47, 81, 74, 78, 49, 74, 28, 6, 53, 98, 12, 110, 4, 95, 14, 27, 76, 70, 126, 35};
    }

    private static byte[] rekfqwgzvtsbmin() {
        return new byte[]{-96, -86, 19, 5, 77, 101, 16, 110, 14, 20, 111, 76, 107, 88, 16, 23, 78, 82, 81, 126, 47, 89, 74, 15, 49, 82};
    }

    private static byte[] fehkdcvdbviedch() {
        return new byte[]{-89, -93, 25, 50, 79, 101, 29, 124, 15, 7, 111, 52, 101, 13, 22, 26, 69, 93, 81, 32, 45, 81, 65, 6, 52, 80, 19, 9, 50, 44};
    }

    private static byte[] oothynteiixvuta() {
        return new byte[]{-89, -93, 25, 6, 79, 115, 29, 60, 15, 31, 111, 8, 101, 64, 22, 16};
    }

    private static byte[] ojudrcdjqxmvsxi() {
        return new byte[]{-87, -93, 27, 60, 72, 98, 26, 120, 15, 9, 111, 54, 107, 10, 17, 24, 65, 79, 95, 120, 47, 80, 70, 78, 51, 80, 19, 13, 50, 61, 4, 100, 12, 88, 9, 1, 76, 68, 121, 124, 1, 110, 73, 48};
    }

    private static byte[] bnhplkofkhpdnfu() {
        return new byte[]{-87, -93, 27, 13, 72, 102, 26, 96, 15, 30, 111, 69, 107, 67, 17, 29, 65, 0, 95, 122, 47, 92, 70, 16, 51, 93, 19, 11, 50, 97};
    }

    private static byte[] kiuyxlurtxtplgz() {
        return new byte[]{-96, -86, 31, 54, 78, 96, 24, 118, 13, 0, 102, 50, 97, 12, 19, 26, 79, 77, 86, 113, 43, 90, 64, 76, 49, 65, 17, 14, 59, 121, 14, 114, 14, 88, 7, 1, 69, 20};
    }

    private static byte[] ihthxxtsqruowin() {
        return new byte[]{-96, -86, 31, 7, 78, 100, 24, 110, 13, 23, 102, 65, 97, 90, 19, 21, 79, 66, 86, 99, 43, 84, 64, 16};
    }

    private static byte[] cwihlyfongwcjvy() {
        return new byte[]{-93, -93, 30, 60, 74, 107, 16, 125, 13, 3, 111, 51, 107, 8, 24, 23, 68, 95, 85, 32, 42, 71, 68, 12, 57, 78, 17, 27, 50, 127, 4, 125, 5, 81, 12, 78};
    }

    private static byte[] kbtckvtcaslngpm() {
        return new byte[]{-93, -93, 30, 8, 74, 125, 16, 61, 13, 3, 111, 11, 107, 90, 24, 11, 68, 69, 85, 97, 42, 95};
    }

    private static byte[] hcsdkwfhibwpytm() {
        return new byte[]{-93, -96, 31, 52, 76, 112, 27, 100, 1, 16, 108, 24, 99, 79, 22, 1, 65, 77, 85, 80, 43, 25, 66, 5, 50, 92, 29, 14, 49, 120, 12, 102, 11, 81, 9, 95, 70, 112, 125, 73, 5, 90, 72, 95, 66, 70, 102, 53, 116, 13, 127, 104, 68, 9, 29, 3, 63, 4, 12, 92, 35, 43, 39, 97, 120, 127, 120, 125, 20, 71, 18, 127};
    }

    private static byte[] wuavbpajansrydt() {
        return new byte[]{-93, -92, 18, 52, 77, 118, 27, 97, 11, 16, 104, 21, 99, 78, 16, 1, 68, 71, 85, 84, 38, 25, 67, 0, 50, 90, 23, 28, 53, 127, 12, 103, 13, 20, 12, 38, 70, 115, 112, 92, 4, 79, 72, 92, 72, 71, 98, 61, 116, 21, 121, 111, 65, 11, 29, 14, 50, 107, 13, 27, 35, 63, 45, 98, 124, 109, 120, 122, 18, 27, 23, 124, 95, 127, 102, 62, 6, 125, 18, 107, 116, 24, 108, 15, 46, 116};
    }

    private static byte[] qynbsjmvunbkbxq() {
        return new byte[]{-96, -91, 27, 52, 72, 115, 29, 102, 1, 20, 111, 26, 99, 79, 21, 7, 67, 65, 94, 84, 47, 31, 66, 2, 52, 94, 17, 9, 58, 123, 12, 96, 12, 83, 11, 83, 65, 119, 113, 78, 5, 91, 74, 89, 78, 65, 97, 53, 124, 10, 120, 108, 66, 1, 26, 4, 63, 0};
    }

    private static byte[] yimgebauazffnhk() {
        return new byte[]{-93, -93, 26, 51, 75, 113, 31, 100, 9, 21, 108, 28, 98, 72, 22, 5, 65, 67, 86, 85, 44, 25, 67, 52, 55, 109, 19, 44, 50, 71, 15, 64, 13, 100, 8, 33, 67, 111, 121, 85, 6, 90, 75, 67, 77, 55, 99, 13, 116, 48, 123, 15, 67, 104, 25, 35, 61, 47, 12, 78};
    }

    private static byte[] ggsigincreobhxs() {
        return new byte[]{-96, -94, 24, 52, 74, 114, 28, 102, 0, 21, 111, 29, 96, 79, 23, 6, 66, 65, 95, 85, 47, 24, 65, 43, 54, 95, 16, 29, 59, 123, 12, 112, 15, 90, 9, 65, 64, 22, 112, 59, 5, 114, 73, 96, 76, 56, 96, 64, 125, 50, 120, 76, 65, 60, 24, 55, 62, 46, 5, 29, 33, 60, 44, 110, 125, 57};
    }

    private static byte[] jddnlssdujcufmw() {
        return new byte[]{-96, -91, 19, 61, 68, 115, 17, 103, 13, 16, 111, 26, 107, 70, 25, 7, 79, 64, 82, 80, 47, 31, 74, 11, 56, 94, 29, 8, 54, 127, 12, 96, 4, 90, 7, 83, 77, 110, 125, 123, 5, 104, 66, 108, 66, 112, 109, 13, 112, 109, 120, 23, 74, 104, 22, 11, 51, 0, 8, 37, 33, 12, 39, 67, 115, 75, 112, 94, 23, 43};
    }

    private static byte[] flvxsclwgsuxswz() {
        return new byte[]{-87, -89, 18, 60, 68, 112, 27, 96, 13, 26, 107, 21, 107, 71, 22, 1, 69, 65, 95, 87, 38, 17, 74, 55, 50, 111, 17, 45, 54, 89, 4, 89, 11, 103, 13, 32, 76, 123, 112, 92, 13, 85, 72, 79, 78, 87, 97, 63, 124, 24, 127, 96, 64, 31, 23, 11, 50, 12, 4, 60, 35, 124, 43, 109, 127, 99, 112, 60, 20, 79, 22, 41, 85, 118, 102, 62, 15, 123, 18, 54};
    }

    private static byte[] ziuuontmbloxqtv() {
        return new byte[]{-89, -94, 30, 50, 75, 126, 29, 97, 10, 20, 110, 25, 101, 72, 24, 7, 68, 70, 81, 82, 42, 31, 69, 11, 52, 89, 22, 10, 51, 121, 10, 97, 5, 87, 12, 84, 66, 113, 124, 73, 2, 90, 78, 75, 73, 83, 100, 50, 114, 9, 113, 120, 65, 5, 25, 9, 62, 11, 11, 51, 37, 15, 44, 65, 122, 69, 126, 75, 26, 32, 23, 18, 91, 84};
    }

    private static byte[] qjkttierjahqtgl() {
        return new byte[]{-94, -86, 19, 53, 73, 115, 25, 103, 12, 17, 102, 20, 98, 74, 21, 3, 66, 64, 84, 90, 39, 24, 71, 5, 48, 92, 16, 29, 59, 126, 13, 99, 8, 22, 10, 34, 71, 123, 113, 83, 0, 91, 74, 75, 79, 64, 108, 63, 117, 7, 124, 106, 71, 4, 28, 9, 51, 5, 9, 35, 33, 22, 42, 72, 114, 93, 121, 84, 23, 34, 17, 21, 94, 50, 103, 34, 2, 127, 16, 102, 115, 8, 98, 8, 47, 96, 117, 103, 45, 48, 12, 84, 49, 38, 101, 85, 63, 100, 110, 85, 26, 96};
    }

    private static byte[] dixsdqafctixqut() {
        return new byte[]{-91, -86, 29, 49, 76, 117, 31, 106, 14, 22, 102, 26, 102, 79, 19, 5, 79, 66, 83, 90, 41, 28, 66, 0, 54, 82, 18, 8, 59, 122, 9, 102, 14, 85, 7, 80, 64, 121, 127, 74, 5, 81, 76, 64, 77, 81, 108, 49, 113, 14, 122, 122, 74, 1, 27, 1, 61, 8, 12, 56, 39, 4, 40, 67, 114, 70, 125, 76, 17, 34, 28, 22, 89, 92, 105, 103, 7, 104, 22, 104, 113, 16, 98, 0, 43, 57, 115, 104};
    }

    private static byte[] ecbbkvhszsshrmp() {
        return new byte[]{-94, -93, 30, 29, 77, 115, 31, 124, 14, 3, 111, 15, 97, 93, 23, 26, 78, 110, 84, 98, 42, 87};
    }

    private static byte[] mtqrwrreebdjgub() {
        return new byte[]{-88, -96, 25, 55, 69, 109, 31, 118, 14, 31, 108, 68, 96, 84, 17, 18, 79, 94, 94, 80, 45, 26, 75, 5, 54, 89, 18, 23, 49, 116, 15, 111, 12, 16};
    }

    private static byte[] kzsdhtkcnpjromq() {
        return new byte[]{-88, -96, 25, 64, 69, 39, 31, 108, 14, 22, 108, 27, 96, 66, 17, 22, 79, 75, 94, 48};
    }

    private static byte[] uvfumagwehgrwcr() {
        return new byte[]{-96, -86, 29, 48, 69, 110, 25, 120, 10, 19, 111, 79, 101, 89, 24, 23, 71, 95, 85, 87, 47, 16, 68, 1, 57, 68, 21, 4, 49, 99, 12, 61};
    }

    private static byte[] lquhruvghtraipp() {
        return new byte[]{-96, -86, 29, 71, 69, 36, 25, 98, 10, 26, 111, 16, 101, 79, 24, 19, 71, 74, 85, 55};
    }

    private static byte[] xycjwcsnslbhcje() {
        return new byte[]{-96, -86, 26, 55, 75, 104, 25, 120, 1, 18, 111, 79, 98, 94, 22, 17, 71, 95, 94, 86, 47, 16, 67, 6, 55, 66, 21, 4, 58, 98, 12, 61};
    }

    private static byte[] fjxdwouabavdufd() {
        return new byte[]{-96, -86, 26, 64, 75, 34, 25, 98, 1, 27, 111, 16, 98, 72, 22, 21, 71, 74, 94, 54};
    }

    private static byte[] qztcltiasreldkp() {
        return new byte[]{-96, -94, 30, 54, 78, 108, 27, 124, 15, 20, 111, 71, 102, 95, 19, 21, 69, 91, 80, 80, 47, 24, 71, 7, 50, 70, 23, 0, 52, 100, 12, 53};
    }

    private static byte[] cicwxaccipwzuze() {
        return new byte[]{-96, -94, 30, 65, 78, 38, 27, 102, 15, 29, 111, 24, 102, 73, 19, 17, 69, 78, 80, 48};
    }

    private static byte[] zgdcqfnmrialsvl() {
        return new byte[]{-96, -95, 18, 49, 78, 109, 30, 124, 10, 31, 111, 68, 106, 88, 19, 20, 64, 91, 85, 91, 47, 27, 75, 0, 50, 71, 18, 0, 49, 111, 12, 54};
    }

    private static byte[] xxrekyjqxxvofbt() {
        return new byte[]{-96, -95, 18, 70, 78, 39, 30, 102, 10, 22, 111, 27, 106, 78, 19, 16, 64, 78, 85, 59};
    }

    private static byte[] gfqtscgevipgkmq() {
        return new byte[]{-96, -91, 18, 50, 79, 110, 24, 124, 12, 18, 111, 64, 106, 91, 18, 23, 70, 91, 83, 86, 47, 31, 75, 3, 51, 82, 20, 29, 55, 115, 12, 96, 5, 16};
    }

    private static byte[] dqjtgtescchosid() {
        return new byte[]{-96, -91, 18, 69, 79, 36, 24, 102, 12, 27, 111, 31, 106, 77, 18, 19, 70, 78, 83, 54};
    }

    private static byte[] dfnvkndrflldbls() {
        return new byte[]{-93, -94, 27, 76, 74, 37, 28, 57, 10, 85, 110, 10, 96, 92, 19, 84};
    }

    private static byte[] onaicbzilryiaqj() {
        return new byte[]{-96, -93, 28, 83, 73, 59, 24, 36, 0, 73, 111, 86, 100, 18, 20, 77, 70, 28, 95, 49, 47, 4, 69, 65, 53, 106, 20, 42, 59, 67, 12, 81, 11, 118, 10, 50, 68, 9, 112, 91, 5, 73, 77, 71, 79, 64, 100, 87, 125, 127};
    }

    private static byte[] camoagmpvmbytcf() {
        return new byte[]{-96, -93, 28, 78, 73, 59, 24, 36, 0, 73, 111, 86, 100, 18, 20, 77, 70, 28, 95, 49, 47, 4, 69, 92};
    }

    private static byte[] dyrxjrxcvdjvroy() {
        return new byte[]{-96, -96, 26, 74, 77, 98, 28, 118, 10, 22, 111, 5, 98, 68, 16, 30, 66, 18};
    }

    private static byte[] nxlranzdhckggwe() {
        return new byte[]{-94, -91, 18, 75, 74, 102, 27, 114, 9, 73};
    }

    private static byte[] natlteccdxtatcx() {
        return new byte[]{-93, -94, 26, 78, 75, 118, 27, 99, 12, 31, 108, 5, 98, 93, 22, 25, 69, 93, 83, 119, 44, 5};
    }

    private static byte[] wltnctqbwwwrneo() {
        return new byte[]{-96, -96, 19, 59, 76, 111, 29, 107, 13, 20, 111, 9, 107, 74, 17, 75, 67, 1};
    }

    private static byte[] vjpzuuxffqenels() {
        return new byte[]{-96, -96, 19, 79, 76, 116, 29, 109, 13, 16, 111, 28, 107, 75, 17, 76};
    }

    private static byte[] qsqrjujpyuonate() {
        return new byte[]{-96, -95, 24, 82, 74, 50, 30, 43, 10, 75, 111, 84, 96, 19, 23, 68, 64, 19, 85, 51, 47, 6, 65, 64, 54, 114, 18, 35, 49, 87, 12, 54, 15, 98, 9, 55, 66, 116, 122, 88, 5, 95, 73, 79, 76, 57, 98, 38, 119, 8, 120, 108, 65, 31, 24, 110, 60, 112, 15, 72, 33, 97, 44, 54, 125, 52, 127, 35, 16, 80, 20, 97, 95, 38, 105, 121};
    }

    private static int sszvdrlyrizasxms(int n, int n2) {
        return n2 ^ n;
    }
}
