package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValue2_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }

        int result = 0;

        while (!pq.isEmpty()) {
            long x = pq.poll();
            if (x >= k) {
                break;
            }
            long y = pq.poll();
            long computedValue = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(computedValue);
            result++;
        }
        return result;
    }
}
