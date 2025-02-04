package array;

public class MaximumAscendingSubarraySum_1800 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                currentSum += nums[i];
                result = Math.max(result, currentSum);
            } else {
                currentSum = nums[i];
            }
        }
        return result;
    }
}
