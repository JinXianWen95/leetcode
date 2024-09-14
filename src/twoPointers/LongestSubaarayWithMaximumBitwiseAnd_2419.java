package twoPointers;

import java.util.Arrays;

public class LongestSubaarayWithMaximumBitwiseAnd_2419 {
    public int longestSubarray(int[] nums) {
        int counter = 0;
        int result = 0;

        int max = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & max) == max) {
                counter++;
                result = Math.max(result, counter);
            } else {
                counter = 0;
            }
        }
        return result;
    }
}
