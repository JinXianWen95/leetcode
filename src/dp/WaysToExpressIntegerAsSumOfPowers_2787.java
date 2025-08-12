package dp;

public class WaysToExpressIntegerAsSumOfPowers_2787 {
    final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;
        // j is the target
        for (int i = 1; i <= n; i++) {
            int power = (int) Math.pow(i, x);

            for (int j = 0; j <= n; j++) {
                // do not select i
                dp[i][j] = dp[i-1][j];
                if (j >= power) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-power]) % MOD;
                }
            }
        }

        return dp[n][n];
    }
}
