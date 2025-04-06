package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    public static void main(String[] args) {
        new LargestDivisibleSubset_368().largestDivisibleSubset(new int[] {1, 2, 3});
    }

    private List<Integer> largestSubset = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // backtracking exceeds time limit
        /*
        backtracking(nums, 0, new ArrayList<>());
        return largestSubset;

         */

        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length]; // to reconstruct the chain
        Arrays.fill(dp, 0);
        Arrays.fill(prev, -1);

        Arrays.sort(nums);

        int maxIndex = 0; // the index of the largest subset
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(nums[i]);
        }

        return result;
    }

    private void backtracking(int[] nums, int startIndex, List<Integer> currentSet) {
        for (int i = startIndex; i < nums.length; i++) {
            currentSet.add(nums[i]);
            if (currentSet.size() > largestSubset.size() && isDivisibleSubset(currentSet)) {
                largestSubset = new ArrayList<>(currentSet);
            }
            backtracking(nums, i+1, currentSet);
            currentSet.remove(currentSet.size()-1);
        }
    }

    private boolean isDivisibleSubset(List<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            for (int j = i+1; j < set.size(); j++) {
                if (set.get(i) % set.get(j) != 0 && set.get(j) % set.get(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
