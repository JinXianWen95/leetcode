package array;

import java.util.HashSet;
import java.util.Set;

public class DivideArrayIntoEqualPairs_2206 {
    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }
        return set.isEmpty();
    }
}
