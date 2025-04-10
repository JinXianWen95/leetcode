package array;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperationsToMakeArrayDistinct_3396 {
    public int minimumOperations(int[] nums) {
        int lastSameElementIndex = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length-1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                lastSameElementIndex = i;
                break;
            }
            set.add(nums[i]);
        }

        if (lastSameElementIndex == -1) {
            return 0;
        }
        return (int) Math.floor(lastSameElementIndex / 3.0 + 1);
    }
}
