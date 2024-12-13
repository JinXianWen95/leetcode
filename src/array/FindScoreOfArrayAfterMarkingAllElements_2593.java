package array;

import java.util.Arrays;
import java.util.Comparator;

public class FindScoreOfArrayAfterMarkingAllElements_2593 {
    public static void main(String[] args) {
        new FindScoreOfArrayAfterMarkingAllElements_2593().findScore(new int[]{2, 1, 3, 4, 5, 2});
    }

    public long findScore(int[] nums) {
        int[][] helper = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            helper[i][0] = nums[i];
            helper[i][1] = i;
        }

        Arrays.sort(helper, Comparator.comparingInt(a -> a[0]));

        boolean[] marked = new boolean[nums.length];
        long result = 0L;
        for (int i = 0; i < helper.length; i++) {
            int currentIndex = helper[i][1];
            if (marked[currentIndex]) {
                continue;
            }

            marked[currentIndex] = true;
            result += helper[i][0];

            if (currentIndex > 0) {
                marked[currentIndex - 1] = true;
            }
            if (currentIndex < nums.length - 1) {
                marked[currentIndex + 1] = true;
            }
        }
        return result;
    }
}
