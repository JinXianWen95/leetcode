package array;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion_3487 {

    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num < 0) {
                continue;
            }
            if (!set.contains(num)) {
                set.add(num);
                result += num;
            }
        }

        // when 0 is an element of array and all numbers are negative, we should return the maximum negative number not 0
        if (set.contains(0)) {
            return Math.max(result, max);
        }

        return result == 0 ? max : result;
    }
}
