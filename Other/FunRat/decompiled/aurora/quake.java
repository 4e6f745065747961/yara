/*
 * Decompiled with CFR 0.152.
 */
package aurora;

import java.nio.charset.Charset;

public final class quake {
    private static final Charset CS = Charset.forName("UTF-8");

    private quake() {
    }

    public static String otter(String string, int n) {
        int n2 = string.length();
        byte[] byArray = new byte[n2];
        int n3 = 0;
        if (string.charAt(0) >= '\u0100') {
            for (int i = 0; i < n2; ++i) {
                byArray[n3] = (byte)((string.charAt(i) - 256 ^ n >>> (n3 & 3) * 8) & 0xFF);
                ++n3;
            }
        } else {
            int n4 = -1;
            for (int i = 0; i < n2; ++i) {
                char c = string.charAt(i);
                if (c == '-') continue;
                int n5 = c - 97;
                if (n4 < 0) {
                    n4 = n5;
                    continue;
                }
                byArray[n3] = (byte)(((n4 << 4 | n5) ^ n >>> (n3 & 3) * 8) & 0xFF);
                ++n3;
                n4 = -1;
            }
        }
        return new String(byArray, 0, n3, CS);
    }
}

