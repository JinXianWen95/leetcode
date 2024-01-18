package dp;

public class UniquePaths_62 {
    public static void main(String[] args) {
        new UniquePaths_62().uniquePaths(3, 7);
    }
    public int uniquePaths(int m, int n) {
        // base case
        if (m == 1 || n == 1) {
            return 1;
        }

        // initialize dp
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // we could reach position (i,j) from left or from top
                // populate dp from left to right, top to down.
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
