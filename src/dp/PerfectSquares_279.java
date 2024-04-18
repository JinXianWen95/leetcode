package dp;

import java.util.Arrays;

public class PerfectSquares_279 {
    // time O(n sqrt(n))
    public int numSquares(int n) {
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n+1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            // the minimum is i = 1^2 + 1^2 + ... i times
            dp[i] = i;
            for (int j = 1; i-j*j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
