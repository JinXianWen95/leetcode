package dp;

public class MaximumAbsoluteSumOfAnySubarray_1749 {
  public int maxAbsoluteSum(int[] nums) {
    // Memory exceed
    /*
    int len = nums.length;
    int[][] dp = new int[len][len];

    int result = 0;
    for (int i = 0; i < len; i++) {
      dp[i][i] = nums[i];
      result = Math.max(result, Math.abs(dp[i][i]));
    }

    for (int i = 0; i < len; i++) {
      for (int j = i+1; j < len; j++) {
        dp[i][j] = dp[i][j-1] + nums[j];
        result = Math.max(result, Math.abs(dp[i][j]));
      }
    }

    return result;

     */

    // greedy
    int maxSum = nums[0];
    int maxEnding = nums[0];

    int minSum = nums[0];
    int minEnding = nums[0];

    for (int i = 1; i < nums.length; i++) {

      // Kadane's algorithm: Find the maximum sum ending at index i by either extending
      // the maximum sum subarray ending at index i - 1 or by
      // starting a new subarray from index i
      maxEnding = Math.max(maxEnding + nums[i], nums[i]);

      // Update res if maximum subarray sum ending at index i > res
      maxSum = Math.max(maxSum, maxEnding);

      minEnding = Math.min(minEnding + nums[i], nums[i]);
      minSum = Math.min(minSum, minEnding);
    }

    return Math.max(maxSum, Math.abs(minSum));
  }
}
