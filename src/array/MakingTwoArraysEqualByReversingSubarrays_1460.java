package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MakingTwoArraysEqualByReversingSubarrays_1460 {
    // the question is the two arrays have the same element regardless the order?
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.merge(target[i], 1, Integer::sum);
            map.merge(arr[i], -1, Integer::sum);
        }

        return map.values().stream().allMatch(e -> e == 0);
    }
}
