package array;

public class MaximumScoreAfterSplittingString_1422 {
    public int maxScore(String s) {
        int zeros = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        int result = 0;
        // empty string not allowed, so if the last char is 0 we do not count it, if it is one we already count
        // in the previous for cycle
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            result = Math.max(result, zeros+ones);
        }
        return result;
    }
}
