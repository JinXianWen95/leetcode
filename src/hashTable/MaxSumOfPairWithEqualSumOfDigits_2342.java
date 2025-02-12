package hashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumOfPairWithEqualSumOfDigits_2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> helper = new HashMap<>();

        for (int num : nums) {
            int sum = sumDigits(num);
            if (helper.containsKey(sum)) {
                helper.get(sum).offer(num);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                pq.offer(num);
                helper.put(sum, pq);
            }
        }

        int result = -1;
        for (PriorityQueue<Integer> entry : helper.values()) {
            if (entry.size() > 1) {
                result = Math.max(result, entry.poll() + entry.poll());
            }
        }
        return result;
    }

    private int sumDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
