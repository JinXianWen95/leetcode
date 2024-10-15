package other;

public class SeparateBlackAndWhiteBalls_2938 {
    public long minimumSteps(String s) {
        // Every 1 in the string s should be swapped with every 0 on its right side.
        long result = 0;
        int zeros = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                result += zeros;
                zeros = 0;
            } else {
                zeros++;
            }
        }
        return result;
    }
}
