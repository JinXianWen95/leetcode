package other;

public class ConstructKPalindromeStrings_1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 == 1) {
                oddCount++;
            }
        }

        // each odd char should be included in one palindrome string
        return oddCount <= k;
    }
}
