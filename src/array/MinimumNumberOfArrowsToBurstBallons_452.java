package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBallons_452 {
    public static void main(String[] args) {
        new MinimumNumberOfArrowsToBurstBallons_452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
    }
    public int findMinArrowShots(int[][] points) {
        // the question is find the interval adn narrow it
        if (points.length == 0) {
            return 0;
        }
        Integer[][] input = convert(points);
        Arrays.sort(input, new Comparator());
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
    }

    private Integer[][] convert(int[][] points) {
        Integer[][] result = new Integer[points.length][points[0].length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                result[i][j] = points[i][j];
            }
        }
        return result;
    }

    private static class Comparator implements java.util.Comparator<Integer[]> {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return 1;
            }
        }
    }
}
