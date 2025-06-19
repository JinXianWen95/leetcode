package greedy;

import java.util.Arrays;

public class PartitionArraySuchThatTheMaxDifferenceIsK_2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            while (i+1 < nums.length && nums[i+1]-min <= k) {
                i++;
            }
            result++;
        }

        return result;
    }
}
