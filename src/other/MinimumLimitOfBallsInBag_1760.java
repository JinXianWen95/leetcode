package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumLimitOfBallsInBag_1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        // example: 9/4 = 2.25 -> ceil - 1, two operations to have the biggest ball equals to 4
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int result = right;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(nums, maxOperations, mid)) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }

    private boolean isValid(int[] nums, int maxOperations, int maxBalls) {
        int operations = 0;
        for (int num : nums) {
            operations += (int) (Math.ceil((double) num / maxBalls) - 1);
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
