package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfValidSplit_2780 {
    public static void main(String[] args) {
        new MinimumIndexOfValidSplit_2780().minimumIndex(Arrays.asList(1,2,2,2));
    }
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> frequencyLetter = new HashMap<>();
        int dominantValue = -1;
        int maxFrequency = 0;
        for (int num : nums) {
            int frequency = frequencyLetter.getOrDefault(num, 0) + 1;
            maxFrequency = Math.max(frequency, maxFrequency);
            dominantValue = frequency == maxFrequency ? num:dominantValue;
            frequencyLetter.put(num, frequency);
        }

        int dominantValueFrequency = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == dominantValue) {
                dominantValueFrequency++;
            }

            if (maxFrequency - dominantValueFrequency >= (nums.size() - i + 1) / 2 &&
                    dominantValueFrequency > (i + 1) / 2) {
                return i;
            }
        }

        return -1;
    }
}
