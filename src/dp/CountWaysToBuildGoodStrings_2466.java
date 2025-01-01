package dp;

public class CountWaysToBuildGoodStrings_2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1000000007;
        int[] dp = new int[high+1];
        dp[0] = 1;
        for (int i = 0; i <= high; i++) {
            if (dp[i] > 0) {
                if (i+zero <= high) {
                    dp[i + zero] = (dp[i] + dp[i+zero]) % MOD;
                }
                if (i+one <= high) {
                    dp[i + one] = (dp[i] + dp[i+one]) % MOD;
                }
            }
        }

        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }
        return result;
    }
}
