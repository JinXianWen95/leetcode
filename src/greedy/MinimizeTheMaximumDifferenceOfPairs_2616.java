package greedy;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs_2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0]; // maxDifference
        while (left < right) {
            int mid = left + (right-left)/2;
            if (countValidPairs(nums, mid) < p) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int countValidPairs(int[] nums, int threshold) {
        int result = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] - nums[i] <= threshold) {
                result++;
                i++;
            }
        }
        return result;
    }

}
