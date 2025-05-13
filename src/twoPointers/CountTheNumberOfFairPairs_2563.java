package twoPointers;

import java.util.Arrays;

public class CountTheNumberOfFairPairs_2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // We do not need to check index i < j since nums[i] + nums[j] = nums[j] + nums[i] and we count the same pair
        // only once
        Arrays.sort(nums);
        return countFairPairs(nums, upper + 1) - countFairPairs(nums, lower);
    }

    private long countFairPairs(int[] nums, int lower) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        long count = 0;
        while (leftPointer < rightPointer) {
            // fixing leftPointer, if the sum of the nums[leftPointer] + maxNumber is less than lower then this is
            // also true for every number less than maxNumber
            if (nums[leftPointer] + nums[rightPointer] < lower) {
                count += rightPointer - leftPointer;
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return count;
    }
}
