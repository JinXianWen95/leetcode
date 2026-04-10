package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElements1_3740 {
    public int minimumDistance(int[] nums) {
        // the minimum distance D_min = abs(a-b) + abs(a-c) + abs(b-c)
        // if a < b < c then D_min = b-a + c-a + c-b = 2(c-a)
        Map<Integer, List<Integer>> numberAndIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberAndIndexes.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int result = Integer.MAX_VALUE;

        for (List<Integer> indexes : numberAndIndexes.values()) {
            if (indexes.size() < 3) {
                continue;
            }

            for (int i = 0; i + 2 < indexes.size(); i++) {
                result = Math.min(result, 2 * (indexes.get(i + 2) - indexes.get(i)));
            }

        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
