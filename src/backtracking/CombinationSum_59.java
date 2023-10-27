package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_59 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // base case
        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, result, new ArrayList<>(), target);
        return  result;
    }

    private void backtrack(int start, int[] candidates, List<List<Integer>> result, List<Integer> currentList, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            // the start is i because we can reuse the same element
            backtrack(i, candidates, result, currentList, target-candidates[i]);
            currentList.remove(currentList.size()-1);
        }
    }
}
