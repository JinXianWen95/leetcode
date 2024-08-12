package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumOfSortedSubarraysSums_1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            sums.add(sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }

        sums.sort(Integer::compareTo);

        int rangeSum = 0;
        int mod = 1000000007;
        for (int i = left; i <= right; i++) {
            rangeSum = (rangeSum + sums.get(i - 1)) % mod;
        }

        return rangeSum;
    }
}
