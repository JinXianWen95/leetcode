package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharacterInString_2707 {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        int size = s.length();
        int[] dp = new int[size+1];

        for (int i = 0; i <= size; i++) {
            dp[i] = size;
        }
        dp[0] = 0; // empty string has no extra char

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                String currentWord = s.substring(j, i);
                if (words.contains(currentWord)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1); // consider the last char as extra
        }

        return dp[size];
    }
}
