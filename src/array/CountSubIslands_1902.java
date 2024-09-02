package array;

import java.util.*;

public class CountSubIslands_1902 {
    boolean isSubIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    check(i, j, grid1, grid2);
                    if (isSubIsland) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private void check(int row, int column, int[][] grid1, int[][] grid2) {
        // floodfill algorithm
        if (row < 0 || row == grid2.length ||
                column < 0 || column == grid2[row].length ||
                grid2[row][column] == 0) {
            return;
        }

        if (grid2[row][column] != grid1[row][column]) {
            isSubIsland = false;
        }

        // mark as visited
        grid2[row][column] = 0;

        check(row-1, column, grid1, grid2);
        check(row+1, column, grid1, grid2);
        check(row, column-1, grid1, grid2);
        check(row, column+1, grid1, grid2);
    }
}
