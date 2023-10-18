package slidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters_03 {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_03().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        // base case
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        // initialize pointer for sliding window
        int leftPointer = 0;
        int rightPointer = 1;
        int maxLength = 1;
        Set<Character> helper = new HashSet<>();
        helper.add(s.charAt(0));
        // sliding window
        while (rightPointer < s.length()) {
            Character currentChar = s.charAt(rightPointer);
            // clean up helper if needed
            while (helper.contains(currentChar)) {
                helper.remove(s.charAt(leftPointer++));
            }
            helper.add(currentChar);
            rightPointer++;
            maxLength = Math.max(maxLength, rightPointer - leftPointer);
        }
        return maxLength;
    }
}
