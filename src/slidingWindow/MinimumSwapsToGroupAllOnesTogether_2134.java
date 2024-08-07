package slidingWindow;

public class MinimumSwapsToGroupAllOnesTogether_2134 {
    public int minSwaps(int[] nums) {
        // the number of swaps is the minimum number of 0's
        int n = nums.length;

        // window size is number of ones
        int windowSize = 0;
        for (int num : nums) {
            windowSize += num;
        }

        int ones = 0;
        // find the ones in the first window
        for (int i = 0; i < windowSize; i++) {
            ones += nums[i];
        }

        int maxOnes = ones;
        for (int i = windowSize; i < n + windowSize; i++) {
            // slide window
            ones += nums[i % n] - nums[(i - windowSize + n) % n];
            maxOnes = Math.max(maxOnes, ones);
        }
        return windowSize - maxOnes;
    }
}
