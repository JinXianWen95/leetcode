package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations1_3264 {
    public static void main(String[] args) {
        new FinalArrayStateAfterKMultiplicationOperations1_3264().getFinalState(new int[]{2,1,3,5,6}, 5, 2);
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<NumberInArray> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new NumberInArray(nums[i], i));
        }

        for (int i = 0; i < k; i++) {
            NumberInArray temp = minHeap.poll();
            minHeap.offer(new NumberInArray(temp.num * multiplier, temp.index));
        }

        for (NumberInArray numberInArray : minHeap) {
            nums[numberInArray.index] = numberInArray.num;
        }

        return nums;

    }

    private class NumberInArray implements Comparable<NumberInArray> {
        int num;
        int index;

        public NumberInArray(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(NumberInArray o) {
            if (this.num < o.num) {
                return -1;
            } else if (this.num > o.num) {
                return 1;
            } else {
                return this.index - o.index;
            }
        }
    }
}
