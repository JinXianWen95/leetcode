package dp;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts_1371 {
    public int findTheLongestSubstring(String s) {
        int mask = 0; // 5 bit for a,e,i,o,u -> 1 means odd, 0 means even
        int result = 0;
        Map<Integer, Integer> maskAndIndex = new HashMap<>(); // save index when all vowels are even
        maskAndIndex.put(0, -1); // -1 annotate the starting index

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    mask ^= 1;
                    break;
                case 'e':
                    mask ^= (1 << 1);
                    break;
                case 'i':
                    mask ^= (1 << 2);
                    break;
                case 'o':
                    mask ^= (1 << 3);
                    break;
                case 'u':
                    mask ^= (1 << 4);
                    break;
            }
            if (maskAndIndex.containsKey(mask)) {
                result = Math.max(result, i - maskAndIndex.get(mask));
            } else {
                maskAndIndex.put(mask, i);
            }
        }

        return result;


        /* dp solution exceeds time limit
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Boolean> vowelMap = initializeMap(); // simulating the number of vowels, [a,e,i,o,u]
            if (isVowel(s.charAt(i))) {
                vowelMap.put(s.charAt(i), !vowelMap.get(s.charAt(i)));
                dp[i][i] = false;
            } else {
                dp[i][i] = true;
                result = Math.max(result, 1);
            }

            for (int j = i+1; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (!isVowel(currentChar)) {
                    dp[i][j] = dp[i][j-1];
                    if (dp[i][j]) {
                        result = Math.max(result, j-i+1);
                    }
                } else {
                    vowelMap.put(currentChar, !vowelMap.get(currentChar));
                    if (vowelMap.values().stream().allMatch(value -> value)) {
                        dp[i][j] = true;
                        result = Math.max(result, j-i+1);
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return result;

         */

    }

    private Map<Character, Boolean> initializeMap() {
        Map<Character, Boolean> vowel = new HashMap<>();
        vowel.put('a', true);
        vowel.put('e', true);
        vowel.put('i', true);
        vowel.put('o', true);
        vowel.put('u', true);
        return vowel;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
