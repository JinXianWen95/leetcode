package slidingWindow;

import java.util.Arrays;

public class CountSubarraysWithMaxElementAppearsAtLeastKTimes_2962 {
    public long countSubarrays(int[] nums, int k) {
        long result = 0L;

        int max = Arrays.stream(nums).max().getAsInt();
        int start = 0;
        int maxSeen = 0;

        for (int num : nums) {
            if (num == max) {
                maxSeen++;
            }

            while (maxSeen==k) {
                if (nums[start]==max) {
                    maxSeen--;
                }
                start++;
            }
            result += start;
        }

        return result;
    }
}
