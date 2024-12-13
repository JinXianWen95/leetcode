package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile_2558 {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int leftGifts = (int) Math.floor(Math.sqrt(pq.poll()));
            pq.offer(leftGifts);
        }

        long result = 0L;
        for (int gift : pq) {
            result += gift;
        }
        return result;
    }
}
