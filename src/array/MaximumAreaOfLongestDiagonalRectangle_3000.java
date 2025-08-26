package array;

public class MaximumAreaOfLongestDiagonalRectangle_3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;
        int longestDiagonal = 0;
        for (int[] dimension : dimensions) {
            int currentDiagonal = (int) (Math.pow(dimension[0], 2) + Math.pow(dimension[1], 2));
            if (longestDiagonal < currentDiagonal) {
                longestDiagonal = currentDiagonal;
                result = dimension[0] * dimension[1];
            } else if (longestDiagonal == currentDiagonal) {
                result = Math.max(result, dimension[0] * dimension[1]);
            }
        }

        return result;
    }
}
