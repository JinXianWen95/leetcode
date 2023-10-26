package twoPointers;

import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // base case
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        // using set to filter out duplicates triplet
        // another way is to check if (i > 0 && nums[i] == nums[i-1]) continue; the same for j and k
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // two pointer
            int j = i+1;
            int k = nums.length-1;
            while (k > j) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // keep looking for next triplet with same num[i]
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
