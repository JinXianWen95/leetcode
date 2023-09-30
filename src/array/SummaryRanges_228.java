package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        // base case
        if (nums.length == 0) {
            return result;
        }
        int minRange = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i-1] + 1) {
                result.add(formatRange(minRange, nums[i-1]));
                minRange = nums[i];
            }
            i++;
        }
        result.add(formatRange(minRange, nums[nums.length-1]));
        return result;
    }

    private String formatRange(int minRange, int maxRange) {
        if (minRange == maxRange) {
            return String.valueOf(minRange);
        }
        return minRange + "->" + maxRange;
    }
}
