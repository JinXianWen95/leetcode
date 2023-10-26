package dp;

import java.util.Objects;

public class LongestPalindromicSubstring_05 {
    int leftIndex = 0;
    int maxPalindromeLength = 0;
    public String longestPalindrome(String s) {
        // base case
        if (Objects.isNull(s) || s.length() < 2) {
            return s;
        }
        // iterate over s to find solution
        for (int i = 0; i < s.length() - 1; i++) {
            expandFromIndex(s, i, i);
            expandFromIndex(s, i, i+1);
        }
        return s.substring(leftIndex, leftIndex + maxPalindromeLength);
    }

    public void expandFromIndex(String s, int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
            leftPointer--;
            rightPointer++;
        }
        int substringLength = rightPointer - leftPointer - 1;
        if (substringLength > maxPalindromeLength) {
            maxPalindromeLength = substringLength;
            leftIndex = leftPointer + 1;
        }
    }
}
