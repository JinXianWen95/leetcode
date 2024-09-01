package array;

import java.util.Arrays;

public class Convert1dArrayInto2dArray_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length == 0 || m*n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        int originalIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[originalIndex++];
            }
        }

        // we could use also the approach of copying by row
//        int i = 0;
//        while (i < m) {
//            result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
//            i++;
//        }
        return result;
    }
}
