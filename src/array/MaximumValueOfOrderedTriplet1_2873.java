package array;

public class MaximumValueOfOrderedTriplet1_2873 {
    public long maximumTripletValue(int[] nums) {
        /*
        long result = 0L;
        if (nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    result = Math.max(result, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return result;
         */

        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        long result = 0L;
        int size = nums.length;

        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i-1]);
            rightMax[size - i - 1] = Math.max(rightMax[size-i], nums[size-i]);
        }

        for (int i = 1; i < size - 1; i++) {
            result = Math.max(result, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }

        return result;
    }
}
