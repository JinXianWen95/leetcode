package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // note all elements are distinct
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            // find minimum number in a row
            int minimum = matrix[i][0];
            int minimumColumnIndex = 0;
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] < minimum) {
                    minimum = matrix[i][j];
                    minimumColumnIndex = j;
                }
            }

            // check if minimum is maximum in column
            int currentRow = 0;
            boolean isLucky = true;
            while (currentRow < row) {
                if (matrix[currentRow][minimumColumnIndex] > minimum) {
                    isLucky = false;
                    break;
                }
                currentRow++;
            }

            if (isLucky) {
                result.add(minimum);
            }
        }
        return result;
    }
}
