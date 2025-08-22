package other;

public class FindTheMinimumAreaToCoverAllOnes1_3195 {
    public int minimumArea(int[][] grid) {
        int minX = Integer.MAX_VALUE;
        int maxX = -1;
        int minY = Integer.MAX_VALUE;
        int maxY = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                }
            }
        }

        if (minX == Integer.MAX_VALUE) {
            return 0;
        }

        return (maxX - minX + 1) * (maxY- minY + 1);

    }
}
