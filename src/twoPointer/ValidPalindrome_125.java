package twoPointer;

import java.util.Objects;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome_125().isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        // base case
        if (Objects.isNull(s) || s.isEmpty() || s.length() == 1) {
            return true;
        }

        // clean up string from no-alphanumeric
        String cleanedString = clean(s);

        // check if palindrome using two pointer
        int left = 0;
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) == cleanedString.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private String clean(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= '0' & ch <= '9')
                    || (ch >= 'a' && ch <= 'z')) {
                result.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append(Character.toLowerCase(ch));
            }
        }
        return result.toString();
    }
}
