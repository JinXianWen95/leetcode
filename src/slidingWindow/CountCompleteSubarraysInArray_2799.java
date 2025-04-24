package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountCompleteSubarraysInArray_2799 {
    public int countCompleteSubarrays(int[] nums) {

        int distinct = (int) Arrays.stream(nums).distinct().count();

        int right = 0;
        int result = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int left = 0; left < nums.length; left++) {
            if (left > 0) {
                cnt.put(nums[left-1], cnt.get(nums[left-1]) - 1);
                if (cnt.get(nums[left-1]) == 0) {
                    cnt.remove(nums[left-1]);
                }
            }
            while (right < nums.length && cnt.size() < distinct) {
                cnt.put(nums[right], cnt.getOrDefault(nums[right++], 0) + 1);
            }
            if (cnt.size() == distinct) {
                result += (nums.length-right+1);
            }
        }

        return result;
    }
}
