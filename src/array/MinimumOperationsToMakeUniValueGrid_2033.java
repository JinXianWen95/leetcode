package array;

import java.util.Arrays;

public class MinimumOperationsToMakeUniValueGrid_2033 {
    public int minOperations(int[][] grid, int x) {
        int[] flattenGrid = new int[grid.length * grid[0].length];

        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                flattenGrid[index++] = grid[i][j];
            }
        }

        Arrays.sort(flattenGrid);

        int result = 0;
        int medianValue = flattenGrid[flattenGrid.length/2];
        for (int num : flattenGrid) {
            if (num % x!=medianValue % x) {
                return -1;
            }

            result += Math.abs(num - medianValue) / x;
        }

        return result;
    }
}
