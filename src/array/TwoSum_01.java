package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookUp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lookUp.containsKey(target - nums[i])) {
                return new int[] {lookUp.get(target - nums[i]), i};
            }
            lookUp.put(nums[i], i);
        }

        return new int[] {};
    }
}
