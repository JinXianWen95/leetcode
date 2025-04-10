package array;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayValuesEqualToK_3375 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> numbers = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            }

            if (!numbers.contains(num) && num != k) {
                result++;
            }
            numbers.add(num);
        }

        return result;
    }
}
