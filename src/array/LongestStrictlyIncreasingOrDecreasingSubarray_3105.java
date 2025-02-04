package array;

public class LongestStrictlyIncreasingOrDecreasingSubarray_3105 {
    public static void main(String[] args) {
        new LongestStrictlyIncreasingOrDecreasingSubarray_3105().longestMonotonicSubarray(new int[]{1,9,7,1});
    }
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int currentSize = 1;
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                currentSize++;
                result = Math.max(currentSize, result);
            } else {
                currentSize = 1;
            }
        }

        currentSize = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                currentSize++;
                result = Math.max(currentSize, result);
            } else {
                currentSize = 1;
            }
        }
        return result;
    }
}
