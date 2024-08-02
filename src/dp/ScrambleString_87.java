package dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString_87 {
    private final Map<String, Boolean> memoization = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        // base case
        if (s1.equals(s2)) {
            return true;
        }

        int length = s1.length();
        if (length != s2.length() || length == 1) {
            return false;
        }

        String key = s1 + "#" + s2;
        if (memoization.containsKey(key)) {
            return  memoization.get(key);
        }

        for (int i = 1; i < length; i++) {
            // consider no-swap case, e.g. gr/eat rg/aet
            boolean isScrambleWithoutSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i));
            if (isScrambleWithoutSwap) {
                memoization.put(key, true);
                return true;
            }

            // consider swap case, e.g. gr/eat aet/rg
            boolean isScrambleWithSwap = isScramble(s1.substring(0, i), s2.substring(length-i)) &&
                    isScramble(s1.substring(i), s2.substring(0, length-i));
            if (isScrambleWithSwap) {
                memoization.put(key, true);
                return true;
            }
        }
        memoization.put(key, false);
        return false;
    }
}
