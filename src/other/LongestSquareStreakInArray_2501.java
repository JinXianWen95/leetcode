package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreakInArray_2501 {
    public int longestSquareStreak(int[] nums) {
        int result = -1;
        Arrays.sort(nums);
        Map<Integer, Integer> helper = new HashMap<>();

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && helper.containsKey(sqrt)) {
                helper.put(num, helper.get(sqrt) + 1);
                result = Math.max(result, helper.get(num));
                if (result == 5) {
                    // the longest streak possible with the given input
                    return 5;
                }
            } else {
                helper.put(num, 1);
            }
        }

        return result;
    }
}
