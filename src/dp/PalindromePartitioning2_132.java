package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PalindromePartitioning2_132 {
    Map<String, Integer> dictionary = new HashMap<>();
    public int minCut(String s) {
        /* Top-down solution, time exceed */
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
