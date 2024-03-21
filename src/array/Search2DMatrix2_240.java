package array;

public class Search2DMatrix2_240 {
    // brute force: iterating over all numbers O(m*n)
    // O(m+n): starting from top-right corner at each iteration we exclude one row or column
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int n : row) {
                if (n == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }
}
