package array;

public class MaximumDifferenceBetweenAdjacentElementsInCircularArray_3423 {
    public int maxAdjacentDistance(int[] nums) {
        int maxDifference = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDifference = Math.max(maxDifference, Math.abs(nums[i] - nums[i+1]));
        }

        return Math.max(maxDifference, Math.abs(nums[0] - nums[nums.length-1]));
    }
}
