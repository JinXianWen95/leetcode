package other;

import java.util.PriorityQueue;

public class MaxScoreAfterApplyingKOperations_2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int n : nums) {
            pq.offer(n);
        }

        long score = 0L;

        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            score += max;
            pq.offer((int) Math.ceil(max / 3.0));
        }

        return score;
    }
}
