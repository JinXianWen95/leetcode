package array;

public class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += computeCellPerimeter(i, j, grid);
                }
            }
        }
        return result;
    }

    private int computeCellPerimeter(int row, int column, int[][] grid) {
        int result = 0;

        if (row-1 < 0 || grid[row-1][column] == 0) {
            result++;
        }

        if (row+1 > grid.length-1 || grid[row+1][column] == 0) {
            result ++;
        }

        if (column-1 < 0 || grid[row][column-1] == 0) {
            result++;
        }

        if (column+1 > grid[row].length-1 || grid[row][column+1] == 0) {
            result ++;
        }

        return result;
    }
}
