package array;

import java.util.Stack;

public class MaxWidthRamp_962 {
    public int maxWidthRamp(int[] nums) {
        /* brute force TLE
        int maxWidth = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    maxWidth = Math.max(maxWidth, j-i);
                }
            }
        }
        return maxWidth;
         */

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            }
        }

        int result = 0;

        for (int j = nums.length - 1; j >=0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                result = Math.max(result, j - stack.pop());
            }
        }

        return result;
    }
}
