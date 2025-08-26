package slidingWindow;

public class LongestSubarrayOfOnesAfterDeletingOneElement_1493 {
    public static void main(String[] args) {
        new LongestSubarrayOfOnesAfterDeletingOneElement_1493().longestSubarray(new int[] {0,1,1,1,0,1,1,0,1});
    }
    public int longestSubarray(int[] nums) {
        int zeroInCurrentWindowSize = 0;
        int maxWindowSize = -1;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroInCurrentWindowSize += nums[i] == 0 ? 1 : 0;

            while (zeroInCurrentWindowSize > 1) {
                zeroInCurrentWindowSize -= nums[start] == 0 ? 1 : 0;
                start++;
            }
            maxWindowSize = Math.max(maxWindowSize, i - start);
        }

        return maxWindowSize;
    }
}
