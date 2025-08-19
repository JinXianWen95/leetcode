package hashTable;

import java.util.HashMap;
import java.util.Map;

public class NumberOfZeroFilledSubarrays_2348 {
    public static void main(String[] args) {
        new NumberOfZeroFilledSubarrays_2348().zeroFilledSubarray(new int[] {0,0,0,2,0,0});
    }

    public long zeroFilledSubarray(int[] nums) {
        Map<Integer, Long> sizeZeroSubarrayAndCount = new HashMap<>();

        int currentSize = 0;
        for (int num : nums) {
            if (num!=0 && currentSize > 0) {
                sizeZeroSubarrayAndCount.put(currentSize,
                        sizeZeroSubarrayAndCount.getOrDefault(currentSize, 0L) + 1L);
                currentSize = 0;
            }

            if (num==0) {
                currentSize++;
            }
        }

        if (currentSize > 0) {
            sizeZeroSubarrayAndCount.put(currentSize,
                    sizeZeroSubarrayAndCount.getOrDefault(currentSize, 0L) + 1L);
        }

        long result = 0;
        for (Map.Entry<Integer, Long> entry : sizeZeroSubarrayAndCount.entrySet()) {
            result += entry.getValue() * computeNumberSubarrays(entry.getKey());
        }

        return result;
    }

    private long computeNumberSubarrays(int n) {
        int i = 1;
        long result = 0L;
        while (n > 0) {
            result += i;
            n--;
            i++;
        }

        return result;
    }
}
