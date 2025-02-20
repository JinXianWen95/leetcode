package backtracking;

import java.util.Set;

public class ConstructSmallestNumberFromDIString_2375 {

    public static void main(String[] args) {
        new ConstructSmallestNumberFromDIString_2375().smallestNumber("IIIDIDDD");
    }
    private String result = "999999999";
    public String smallestNumber(String pattern) {
        boolean[] digits = new boolean[10];
        for (char i = '1'; i <= '9'; i++) {
            digits[i-'1'] = true;
            backtrack(String.valueOf(i), digits, pattern, 0);
            digits[i-'1'] = false;
        }
        return result;
    }

    private void backtrack(String current, boolean[] digits, String pattern, int patternIndex) {
        if (current.length() == pattern.length() + 1) {
            result = current.compareTo(result) < 0 ? current : result;
            return;
        }

        for (char i = '1'; i <= '9'; i++) {
            if (digits[i-'1']) {
                continue;
            }
            char lastDigit = current.charAt(current.length()-1);
            if ((pattern.charAt(patternIndex) == 'I' && i > lastDigit) ||
                    (pattern.charAt(patternIndex) == 'D' && i < lastDigit)) {
                digits[i - '1'] = true;
                backtrack(current + i, digits, pattern, patternIndex+1);
                digits[i - '1'] = false;
            }
        }
    }
}
