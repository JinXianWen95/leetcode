package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfAllSubsetXorTotals_1863 {
    public static void main(String[] args) {
        new SumOfAllSubsetXorTotals_1863().subsetXORSum(new int[] {5,1,6});
    }
    public int subsetXORSum(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), sums);
        int result = 0;
        for (int sum : sums) {
            result += sum;
        }
        return result;
    }

    private void backtracking(int[] nums, int startIndex, List<Integer> subset, List<Integer> sumXor) {
        sumXor.add(computeXor(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, i+1, subset, sumXor);
            subset.remove(subset.size()-1);
        }
    }

    private int computeXor(List<Integer> subset) {
        int sum = 0;
        for (Integer integer : subset) {
            sum ^= integer;
        }

        return sum;
    }
}
