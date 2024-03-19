package array;

public class Search2DMatrix2_240 {
    // brute force: iterating over all numbers
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
}
