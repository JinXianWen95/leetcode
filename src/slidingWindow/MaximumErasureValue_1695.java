package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue_1695 {
    public static void main(String[] args) {
        new MaximumErasureValue_1695().maximumUniqueSubarray(new int[] {4,2,4,5,6});
    }
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> valueAndIndex = new HashMap<>();

        int result = 0;
        int currentSum = 0;
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valueAndIndex.containsKey(nums[i])) {
                int endIndex = valueAndIndex.get(nums[i]);
                // subtract the elements before duplicated value from the sum
                for (int j = startIndex; j < endIndex; j++) {
                    valueAndIndex.remove(nums[j]);
                    currentSum -= nums[j];
                }
                startIndex = endIndex + 1; // update the start index of next subarray candidate
            } else {
                // unique value must be added since it's positive and increments the result
                currentSum += nums[i];
                result = Math.max(result, currentSum);
            }
            valueAndIndex.put(nums[i], i);
        }

        return result;

    }
}
