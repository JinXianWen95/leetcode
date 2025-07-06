package greedy;

public class LongestBinarySubsequenceLessThanOrEqualToK_2311 {
    public int longestSubsequence(String s, int k) {
        int sum = 0;
        int result = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(s.length()-i-1) == '0') { // it always maintains or increases the length of subsequence
                result++;
            } else if (i < bits && sum + (1 << i) <= k) {
                sum += 1 << i;
                result++;
            }
        }

        return result;
    }
}
