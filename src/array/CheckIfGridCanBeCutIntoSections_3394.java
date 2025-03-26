package array;

import java.util.Arrays;
import java.util.Comparator;

public class CheckIfGridCanBeCutIntoSections_3394 {
    public static void main(String[] args) {
        new CheckIfGridCanBeCutIntoSections_3394().checkValidCuts(5, new int[][]{
                //{0,0,1,4},{1,0,2,3},{2,0,3,3},{3,0,4,3},{1,3,4,4}}
                {1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}}
        );
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(rectangle -> rectangle[0]));

        int count = 0;
        int latestEnd = rectangles[0][2];
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][0] >= latestEnd) {
                count++;
            }
            latestEnd = Math.max(rectangles[i][2], latestEnd);
        }

        if (count >= 2) {
            return true;
        }

        Arrays.sort(rectangles, Comparator.comparingInt(rectangle -> rectangle[1]));
        count = 0;
        latestEnd = rectangles[0][3];
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][1] >= latestEnd) {
                count++;
            }
            latestEnd = Math.max(rectangles[i][3], latestEnd);
        }

        return count >= 2;
    }
}
