package dp;

public class InterleavingString_97 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        System.out.println(new InterleavingString_97().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // if the result string length is not the sum of other two then there's no way to form s3
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // initialization
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        // populate dp array
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // remember that i+j=index of s3
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private void checkAndSwap(String s1, String s2) {

    }
}
