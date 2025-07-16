package dp;

import greedy.MaximumNumberOfEventsThatCanBeAttended_1353;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventsThatCanBeAttended2_1751 {
    public static void main(String[] args) {
        new MaximumNumberOfEventsThatCanBeAttended2_1751().maxValue(new int[][]{
                {1,2,4},
                {3,4,3},
                {2,3,10}
        }, 2);
    }

    private int[][] dp;
    private int[] nextIndexes;
    public int maxValue(int[][] events, int k) {
        // top-down dp with binary search
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        nextIndexes = new int[events.length];

        for (int i = 0; i < events.length; i++) {
            nextIndexes[i] = binarySearch(events, events[i][1]);
        }

        dp = new int[k+1][events.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(events, k, 0);
    }

    private int dfs(int[][] events, int count, int index) {
        if (count == 0 || index == events.length) {
            return 0; // there's no event that we can attend
        }

        if (dp[count][index] != -1) {
            return dp[count][index];
        }

        dp[count][index] = Math.max(
                dfs(events, count, index+1), // skip current event
                events[index][2] + dfs(events, count-1, nextIndexes[index]) // take current event
        );

        return dp[count][index];
    }


    private int binarySearch(int[][] events, int target) {
        int left = 0;
        int right = events.length;
        while (left < right) {
            int mid = left - (left - right) / 2;
            if (events[mid][0] <= target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
