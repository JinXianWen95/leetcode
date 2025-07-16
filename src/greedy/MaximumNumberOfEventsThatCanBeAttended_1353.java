package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {
    public static void main(String[] args) {
        new MaximumNumberOfEventsThatCanBeAttended_1353().maxEvents(new int[][]{
                {1,2},
                {1,2},
                {1,6},
                {1,2},
                {1,2}
        });
    }
    public int maxEvents(int[][] events) {
        // greedy approach: take the event that has earlier endDay

        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        for (int i = 1, j = 0; i <= maxDay; i++) {
            while (j < events.length && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }

            // remove events that cannot be longer attended
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                result++;
                pq.poll();
            }
        }
        return result;
    }
}
