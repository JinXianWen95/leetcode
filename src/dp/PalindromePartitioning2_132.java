package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PalindromePartitioning2_132 {
    Map<String, Integer> dictionary = new HashMap<>();
    public int minCut(String s) {
        /* Top-down solution, time exceed */
        /*
        // base case
        if (isPalindrome(s)) {
            return 0;
        }

        if (dictionary.containsKey(s)) {
            return dictionary.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            int currentMinCut = dictionary.getOrDefault(s, Integer.MAX_VALUE);
            String left = s.substring(0, i);
            String right = s.substring(i);
            int minCutLeft = minCut(left);
            dictionary.put(left, minCutLeft);
            if (minCutLeft >= currentMinCut) {
                break;
            }
            int minCutRight = minCut(right);
            dictionary.put(right, minCutRight);
            if (minCutRight >= currentMinCut) {
                break;
            }
            dictionary.put(s, Math.min(minCutLeft + minCutRight + 1, currentMinCut));
        }
        return dictionary.get(s);
        */

        /*
            bottom-up solution
         */
        // base case
        if (isPalindrome(s)) {
            return 0;
        }

        int length = s.length();
        // stores the minCut of substring of s
        int[] minCuts = new int[length];
        // stores if a substring [j,...., i] is a palindrome
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            // the max minCut of a string is its length - 1
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j+1 > i-1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    // j == 0 because String from j to i is a palindrome, and it starts from first character so means no cuts needed
                    // Else I need a cut at jth location, and it will be cuts encountered till j-1 + 1
                    minCut = j == 0 ? 0 : Math.min(minCut, minCuts[j-1] + 1);
                }
            }
            minCuts[i] = minCut;
        }
        return minCuts[length-1];
    }

    private boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.isEmpty() || s.length() == 1) {
            return true;
        }
        // check if palindrome using two pointer
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
