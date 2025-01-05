package array;

import java.util.Arrays;

public class NumberOfWaysToSplitArray_2270 {
    public int waysToSplitArray(int[] nums) {
        long leftSum= nums[0];
        long rightSum = 0L;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            if (leftSum >= rightSum) {
                result++;
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return result;
    }
}
