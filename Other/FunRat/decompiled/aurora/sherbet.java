/*
 * Decompiled with CFR 0.152.
 */
package aurora;

import aurora.quake;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class sherbet {
    private sherbet() {
    }

    public static CallSite mobile(Object object, String string, Object object2, String string2, int n, int n2) {
        MethodHandles.Lookup lookup = (MethodHandles.Lookup)object;
        MethodType methodType = (MethodType)object2;
        try {
            String string3 = quake.otter(string2, n);
            int n3 = string3.indexOf(0);
            int n4 = string3.indexOf(0, n3 + 1);
            String string4 = string3.substring(0, n3).replace('/', '.');
            String string5 = string3.substring(n3 + 1, n4);
            String string6 = string3.substring(n4 + 1);
            Class<?> clazz = lookup.findClass(string4);
            MethodType methodType2 = sherbet.descriptor(lookup, string6);
            MethodHandle methodHandle = n2 == 0 ? lookup.findStatic(clazz, string5, methodType2) : (n2 == 1 ? lookup.findVirtual(clazz, string5, methodType2) : (n2 == 2 ? lookup.findConstructor(clazz, methodType2) : (n2 == 3 ? lookup.findSpecial(clazz, string5, methodType2, lookup.lookupClass()) : (n2 == 4 ? lookup.findStaticGetter(clazz, string5, (Class<?>)methodType2.returnType()) : (n2 == 5 ? lookup.findStaticSetter(clazz, string5, (Class<?>)methodType2.parameterType(0)) : (n2 == 6 ? lookup.findGetter(clazz, string5, (Class<?>)methodType2.returnType()) : lookup.findSetter(clazz, string5, (Class<?>)methodType2.parameterType(1))))))));
            return new ConstantCallSite(methodHandle.asType(methodType));
        }
        catch (Throwable throwable) {
            throw new RuntimeException(string + String.valueOf(methodType), throwable);
        }
    }

    private static MethodType descriptor(MethodHandles.Lookup lookup, String string) throws Throwable {
        ArrayList arrayList = new ArrayList();
        int n = 1;
        while (string.charAt(n) != ')') {
            n = sherbet.parse(lookup, string, n, arrayList);
        }
        ArrayList arrayList2 = new ArrayList(1);
        sherbet.parse(lookup, string, n + 1, arrayList2);
        return MethodType.methodType((Class)arrayList2.get(0), arrayList);
    }

    private static int parse(MethodHandles.Lookup lookup, String string, int n, List<Class<?>> list) throws Throwable {
        int n2;
        Class<Object> clazz;
        int n3 = 0;
        while (string.charAt(n) == '[') {
            ++n3;
            ++n;
        }
        char c = string.charAt(n);
        switch (c) {
            case 'Z': {
                clazz = Boolean.TYPE;
                n2 = n + 1;
                break;
            }
            case 'B': {
                clazz = Byte.TYPE;
                n2 = n + 1;
                break;
            }
            case 'C': {
                clazz = Character.TYPE;
                n2 = n + 1;
                break;
            }
            case 'S': {
                clazz = Short.TYPE;
                n2 = n + 1;
                break;
            }
            case 'I': {
                clazz = Integer.TYPE;
                n2 = n + 1;
                break;
            }
            case 'J': {
                clazz = Long.TYPE;
                n2 = n + 1;
                break;
            }
            case 'F': {
                clazz = Float.TYPE;
                n2 = n + 1;
                break;
            }
            case 'D': {
                clazz = Double.TYPE;
                n2 = n + 1;
                break;
            }
            case 'V': {
                clazz = Void.TYPE;
                n2 = n + 1;
                break;
            }
            default: {
                int n4 = string.indexOf(59, n);
                clazz = lookup.findClass(string.substring(n + 1, n4).replace('/', '.'));
                n2 = n4 + 1;
            }
        }
        if (n3 > 0) {
            clazz = Array.newInstance(clazz, new int[n3]).getClass();
        }
        list.add(clazz);
        return n2;
    }
}

