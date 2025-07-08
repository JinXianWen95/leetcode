package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII_2901 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        // dp
        int[] dp = new int[words.length];
        int[] prev = new int[words.length];
        Arrays.fill(dp, 1); // at least word at index i can be added to result for each index i
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    dp[j] + 1 > dp[i] &&
                    valid(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(words[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private boolean valid(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int hammingDistance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                hammingDistance++;
                if (hammingDistance > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
