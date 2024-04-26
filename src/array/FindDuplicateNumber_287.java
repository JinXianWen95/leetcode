package array;

import java.util.Arrays;

public class FindDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // using hare & tortoise method
    public int findDuplicate_2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            // create a kind of graph
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // cycle detected. move hare back to starting point
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast; // or slow
    }
}
