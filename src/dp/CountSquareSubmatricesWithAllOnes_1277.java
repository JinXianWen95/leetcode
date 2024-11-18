package dp;

import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes_1277 {

    public static void main(String[] args) {
        new CountSquareSubmatricesWithAllOnes_1277().countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        });
    }

    public int countSquares(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        // dp[i][j] represents the size of the largest square submatrix ending at position (i,j)
        int[][] dp = new int[rowSize][columnSize];
        int result = 0;

        // initialize first column
        for (int i = 0; i < rowSize; i++) {
            dp[i][0] = matrix[i][0];
            result += matrix[i][0];
        }

        // initialize first row, the [0,0] is already count
        for (int i = 1; i < columnSize; i++) {
            dp[0][i] = matrix[0][i];
            result += matrix[0][i];
        }

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < columnSize; j++) {
                if (matrix[i][j] == 1) {
                    // add 1 square and check if it can form other squares,
                    // If any of the three adjacent positions has a smaller value, we can't form a larger square
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                result += dp[i][j];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return result;
    }
}
