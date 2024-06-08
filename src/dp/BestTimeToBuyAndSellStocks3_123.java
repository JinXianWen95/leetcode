package dp;

public class BestTimeToBuyAndSellStocks3_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 3) {
            return 0;
        }
        // dp formula: dp[k,i] = max(dp[k,i-1], prices[i]-prices[j]+dp[k-1,j-1]) where k is number of transactions
        // and j=[0,1,...,i-1]
        final int transactions = 2;
        int[][] dp = new int[transactions+1][n];
        for (int k = 1; k <= transactions; k++) {
            int min = prices[0];
            for (int j = 1; j < n; j++) {
                min = Math.min(min, prices[j]-dp[k-1][j-1]);
                dp[k][j] = Math.max(dp[k][j-1], prices[j]-min);
            }
        }
        return dp[2][n-1];
    }
}
