package array;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (nums.length < 2 || sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[nums.length][sum/2+1];
        return canPartition(nums, 0, sum/2, dp);
    }

    private boolean canPartition(int[] nums, int index, long target, long partition1, long partition2) {
        // Time exceeded
        if (index == nums.length && partition2 == target && partition1 == target) {
            return true;
        }

        if (partition1 > target || partition2 > target) {
            return false;
        }

        return canPartition(nums, index + 1, target, partition1+nums[index], partition2)||
                canPartition(nums, index+1, target, partition1, partition2+nums[index]);
    }

    private boolean canPartition(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == nums.length || target < 0) {
            return false;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        for (int i = index; i < nums.length; i++) {
            boolean take = canPartition(nums, i+1, target-nums[index], dp);
            boolean skip = canPartition(nums, i+1, target, dp);
            dp[i][target] = take || skip;
            if (dp[i][target]) {
                return true;
            }
        }

        return false;
    }
}
