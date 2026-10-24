/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 *  net.fabricmc.loader.api.MappingResolver
 */
package aurora;

import aurora.quake;
import aurora.sherbet;
import aurora.stumble;
import java.lang.invoke.CallSite;
import java.lang.reflect.Method;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public final class sardine {
    private static final MappingResolver slate = sardine.lunar();

    private sardine() {
    }

    private static MappingResolver lunar() {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        try {
            return sherbet.mobile("cypress", "net/fabricmc/loader/api/FabricLoader|getMappingResolver|()Lnet/fabricmc/loader/api/MappingResolver;", 226953927, 1, (FabricLoader)sherbet.mobile("cypress", "net/fabricmc/loader/api/FabricLoader|getInstance|()Lnet/fabricmc/loader/api/FabricLoader;", 281065747, 0));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static Object kangaroo() {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        return sherbet.mobile("slate", "net/fabricmc/loader/api/FabricLoader|getGameInstance|()Ljava/lang/Object;", 332056492, 1, (FabricLoader)sherbet.mobile("osprey", "net/fabricmc/loader/api/FabricLoader|getInstance|()Lnet/fabricmc/loader/api/FabricLoader;", 2144323102, 0));
    }

    public static Object nephew(Object object, String string, String string2, String string3, String string4) throws ReflectiveOperationException {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        if (object == null) {
            return null;
        }
        try {
            return sherbet.mobile("fossil", "java/lang/reflect/Method|invoke|(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", 25205121, 1, (Method)((Object)sherbet.mobile("apple", "java/lang/Class|getMethod|(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", 116831660, 1, (Class)((Object)sherbet.mobile("clever", "java/lang/Object|getClass|()Ljava/lang/Class;", 300947400, 1, (Object)object)), (String)string2, (Class[])new Class[0])), (Object)object, (Object[])new Object[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            String string5 = sardine.spring(string, string3, string4);
            CallSite callSite = sherbet.mobile("banjo", "java/lang/Class|getMethod|(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", 30320287, 1, (Class)((Object)sherbet.mobile("napkin", "java/lang/Object|getClass|()Ljava/lang/Class;", 283244456, 1, (Object)object)), (String)string5, (Class[])new Class[0]);
            return sherbet.mobile("modern", "java/lang/reflect/Method|invoke|(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", 411893434, 1, (Method)((Object)callSite), (Object)object, (Object[])new Object[0]);
        }
    }

    public static Object pastel(Object object, String ... stringArray) throws ReflectiveOperationException {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        if (object == null) {
            return null;
        }
        NoSuchMethodException noSuchMethodException = null;
        for (String string : stringArray) {
            try {
                CallSite callSite = sherbet.mobile("quake", "java/lang/Class|getMethod|(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", 497014956, 1, (Class)((Object)sherbet.mobile("stingray", "java/lang/Object|getClass|()Ljava/lang/Class;", 162582201, 1, (Object)object)), (String)string, (Class[])new Class[0]);
                return sherbet.mobile("spark", "java/lang/reflect/Method|invoke|(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", 43616168, 1, (Method)((Object)callSite), (Object)object, (Object[])new Object[0]);
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                noSuchMethodException = noSuchMethodException2;
            }
        }
        throw noSuchMethodException;
    }

    private static String spring(String string, String string2, String string3) {
        if (stumble.marina() != 0) {
            stumble.dune();
        }
        if (slate == null) {
            return string2;
        }
        try {
            CallSite callSite = sherbet.mobile("banjo", "net/fabricmc/loader/api/MappingResolver|mapMethodName|(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 146921187, 1, (MappingResolver)slate, (String)"intermediary", (String)string, (String)string2, (String)string3);
            return callSite == null || sherbet.mobile("nimble", "java/lang/String|isBlank|()Z", 317514169, 1, (String)((Object)callSite)) != false ? string2 : callSite;
        }
        catch (RuntimeException runtimeException) {
            return string2;
        }
    }
}

