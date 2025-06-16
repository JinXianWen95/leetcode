package other;

import java.util.Arrays;

public class MaximumDifferenceBetweenIncreasingElements_2016 {
    public static void main(String[] args) {
        new MaximumDifferenceBetweenIncreasingElements_2016().maximumDifference(new int[] {9,4,3,2,2,10});
    }
    public int maximumDifference(int[] nums) {
        int[] prefixMin = new int[nums.length];

        prefixMin[0] = nums[0];
        int result = -1;
        for (int i = 1; i < nums.length; i++) {
            prefixMin[i] = Math.min(prefixMin[i-1], nums[i]);
            result = Math.max(result, nums[i] - prefixMin[i-1]);
        }

        return result == 0 ? -1 : result;
    }
}
