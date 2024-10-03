package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP_1590 {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int remainder = (int) (sum % p);
        if (remainder == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);

        long currentSum = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int currentMod = (int) (currentSum % p);
            int targetMod =  (currentMod - remainder + p) % p;
            if (prefixSum.containsKey(targetMod)) {
                result = Math.min(result, i - prefixSum.get(targetMod));
            }
            prefixSum.put(currentMod, i);
        }

        return result == nums.length ? -1 : result;
    }
}
