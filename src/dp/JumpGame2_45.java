package dp;

import java.util.Arrays;

public class JumpGame2_45 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        new JumpGame2_45().jump(nums);
    }
    public int jump(int[] nums) {
        // base case
        if (nums.length == 0) {
            return 0;
        }
        // iterate over the array and populate dp
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && (i+j) < nums.length; j++) {
                dp[i+j] = Math.min(dp[i] + 1, dp[i+j]);
            }
        }
        return dp[nums.length-1];
    }
}
