package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString_1980 {
    String result = "";
    public String findDifferentBinaryString(String[] nums) {
        Set<String> existsBinaries = new HashSet<>(Arrays.asList(nums));
        int len = nums[0].length();
        backtrack(existsBinaries, "", len);
        return result;
    }

    private void backtrack(Set<String> set, String current, int length) {
        if (current.length() == length && !set.contains(current)) {
            result = current;
            return;
        }

        if (current.length() == length && set.contains(current)) {
            return;
        }

        backtrack(set, current + '0', length);
        backtrack(set, current + '1', length);
    }
}
