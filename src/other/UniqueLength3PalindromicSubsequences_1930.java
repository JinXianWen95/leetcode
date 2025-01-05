package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences_1930 {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            if (first[current] ==  -1) {
                first[current] = i;
            }
            last[current] = i;
        }

        Set<Character> chars = new HashSet<>();
        int result = 0;
        for (int i = 0; i < 26; i++) {
            int startIndex = first[i];
            if (startIndex == -1) {
                continue;
            }

            chars.clear();
            for (int j = startIndex+1; j < last[i]; j++) {
                chars.add(s.charAt(j));
            }
            result += chars.size();

        }
        return result;
    }
}
