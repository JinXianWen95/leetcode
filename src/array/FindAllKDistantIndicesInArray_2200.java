package array;

import java.util.*;

public class FindAllKDistantIndicesInArray_2200 {
    public static void main(String[] args) {
        new FindAllKDistantIndicesInArray_2200().findKDistantIndices(new int[] {222,151,842,244,103,736,219,432,565,
                216,36,198,10,367,778,111,307,460,92,622,750,36,559,983,782,432,312,111,676,179,44,86,766,371,746,905,
                850,170,892,80,449,932,295,875,259,556,730,441,153,869}, 153, 19);
    }
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(0, i-k); j <= Math.min(nums.length-1, i+k); j++) {
                    result.add(j);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
