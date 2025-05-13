package other;

import java.util.HashMap;
import java.util.Map;

public class TotalCharactersAfterTransformationsI_3335 {
    public static void main(String[] args) {
        new TotalCharactersAfterTransformationsI_3335().lengthAfterTransformations("abcyy", 2);
    }
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] nxt = new int[26];
            nxt[0] = chars[25]; // a comes from z
            nxt[1] = (chars[25] + chars[0]) % mod; // b comes from a and z
            for (int j = 2; j < 26; j++) {
                nxt[j] = chars[j-1];
            }
            chars = nxt;
        }

        int result = 0;
        for (int count : chars) {
            result = (result + count) % mod;
        }

        return result;
    }
}
