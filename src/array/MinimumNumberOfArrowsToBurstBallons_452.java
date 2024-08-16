package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBallons_452 {
    public static void main(String[] args) {
        new MinimumNumberOfArrowsToBurstBallons_452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
    }
    public int findMinArrowShots(int[][] points) {
        // the question is find the interval adn narrow it

        // Solution 1: ordey by start point
        /*
        if (points.length == 0) {
            return 0;
        }
        Integer[][] input = convert(points);
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        int counter = 0;
        int i = 0;
        while (i < input.length) {
            Integer[] current = input[i];
            int j = i+1;
            while (j < input.length && current[1] >= input[j][0]) {
                current = new Integer[] {
                        Math.max(current[0], input[j][0]),
                        Math.min(current[i], input[j][1])
                };
                j++;
            }
            i = j;
            counter++;
        }
        return counter;

         */

        // Solution 2: order by end point
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int counter = 1;
        int[] currentPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            if (currentPoint[1] >= points[i][0]) {
                continue;
            }
            counter++;
            currentPoint = points[i];
        }
        return counter;
    }
}
