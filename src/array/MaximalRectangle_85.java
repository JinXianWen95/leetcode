package array;

public class MaximalRectangle_85 {

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] heights = new int[matrix[0].length]; // build a histogram
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        int[] lessLeft = new int[heights.length];
        int[] lessRight = new int[heights.length];
        lessLeft[0] = -1;
        lessRight[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int index = i - 1;
            while (index >= 0 && heights[index] >= heights[i]) {
                index = lessLeft[index]; // Jump to the next potential shorter bar
            }
            lessLeft[i] = index;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int index = i + 1;
            while (index < heights.length && heights[index] >= heights[i]) {
                index = lessRight[index]; // Jump to the next potential shorter bar
            }
            lessRight[i] = index;
        }
        //System.out.println(Arrays.toString(lessLeft));
        //System.out.println(Arrays.toString(lessRight));
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessRight[i] - lessLeft[i] - 1));
        }

        return maxArea;
    }

}
