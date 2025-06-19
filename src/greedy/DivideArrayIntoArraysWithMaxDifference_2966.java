package greedy;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference_2966 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length/3][3];

        // greedy
        Arrays.sort(nums);
        int indexResult = 0;
        for (int i = 0; i < nums.length; i=i+3) {
            if (nums[i+2] - nums[i] > k) {
                return new int[][]{};
            }
            result[indexResult][0] = nums[i];
            result[indexResult][1] = nums[i+1];
            result[indexResult++][2] = nums[i+2];
        }

        return result;
    }
}
