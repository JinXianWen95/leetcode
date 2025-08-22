package dp;

public class CountSubmatricesWithAllOnes_1504 {
    public int numSubmat(int[][] mat) {
        int rowSize = mat.length;
        int columnSize = mat[0].length;
        int[][] dp = new int[rowSize][columnSize];

        int result = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = j == 0 ? 1 : 1 + dp[i][j-1];
                }

                int cur = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = Math.min(cur, dp[k][j]);
                    if (cur == 0) {
                        break;
                    }
                    result += cur;
                }

            }
        }
        return result;
    }

}
