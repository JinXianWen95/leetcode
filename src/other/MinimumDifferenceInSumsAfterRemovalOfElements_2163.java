package other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDifferenceInSumsAfterRemovalOfElements_2163 {
    public static void main(String[] args) {
        new MinimumDifferenceInSumsAfterRemovalOfElements_2163().minimumDifference(new int[]{7,9,5,8,1,3});
    }
    public long minimumDifference(int[] nums) {
        int n3 = nums.length / 3;

        // minimize the first and maximize the second part.
        // compute the min subsequence part1 of size n^3 for i in [0, 2n^3] and save it into array
        // compute the max subsequence part2 starting from end.
        // take the minimum subtraction
        long[] sums = new long[n3 + 1];
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for (int i = 0; i < n3; i++) {
            minQueue.add(nums[i]);
            sum += nums[i];
        }

        sums[0] = sum;
        for (int i = n3; i < 2 * n3; i++) {
            minQueue.add(nums[i]);
            sums[i-n3+1] = sums[i-n3] + nums[i] - minQueue.poll();
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        long sum2 = 0;
        for (int i = 3 * n3 - 1; i >= 2 * n3; i--) {
            maxQueue.add(nums[i]);
            sum2 += nums[i];
        }

        long result = sums[n3] - sum2;

        for (int i = 2 * n3 - 1; i >= n3; i--) {
            maxQueue.add(nums[i]);
            sum2 = sum2 + nums[i] - maxQueue.poll();
            result = Math.min(result, sums[i-n3] - sum2);
        }

        return result;
    }
}
