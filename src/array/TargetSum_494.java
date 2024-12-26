package array;

import java.util.Arrays;

public class TargetSum_494 {
    /* brute force 2^n
    int RESULT = 0;
    public int findTargetSumWays(int[] nums, int target) {
        isTarget(nums, target, 0);
        return RESULT;
    }

    private void isTarget(int[] nums, int target, int startIndex) {
        if (startIndex == nums.length) {
            if (target == 0) {
                RESULT++;
            }
            return;
        }

        int num = nums[startIndex];
        isTarget(nums, target + num, startIndex + 1);
        isTarget(nums, target - num, startIndex + 1);
    }

     */

    // memo top-down
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2*sum+1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return calculateWays(nums, target, 0, 0, memo, sum);
    }

    private int calculateWays(int[] nums, int target, int currentIndex, int currentSum, int[][] memo, int totalSum) {
        if (currentIndex == nums.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }

        if (memo[currentIndex][currentSum+totalSum] != Integer.MIN_VALUE) {
            return memo[currentIndex][currentSum+totalSum];
        }

        int addition = calculateWays(nums, target, currentIndex+1,
                currentSum+nums[currentIndex], memo, totalSum);

        int subtraction = calculateWays(nums, target, currentIndex+1,
                currentSum-nums[currentIndex], memo, totalSum);

        memo[currentIndex][currentSum+totalSum] = addition + subtraction;
        return memo[currentIndex][currentSum+totalSum];
    }

}
