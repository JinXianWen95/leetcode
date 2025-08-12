package dp;

import java.util.Arrays;
import java.util.function.Supplier;

public class FindTheMaximumNumberOfFruitsCollected_3363 {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fruits[i][i];
        }

        Supplier<Integer> dp = () -> {
            int[] prev = new int[n];
            int[] curr = new int[n];
            Arrays.fill(prev, Integer.MIN_VALUE);
            Arrays.fill(curr, Integer.MIN_VALUE);
            prev[n - 1] = fruits[0][n - 1];
            for (int i = 1; i < n - 1; ++i) {
                // (i+1) is needed since the children cannot cross the diagonal, otherwise he cannot reach the
                // destination within n-1 steps
                for (int j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                    // find the maximum from the previous reachable path
                    int best = prev[j];
                    if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                    if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                    // sum the maximum to the fruits collected in the room (i, j)
                    curr[j] = best + fruits[i][j];
                }
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }
            return prev[n - 1];
        };

        result += dp.get();

        // transpose the matrix and reuse the logic
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }

        result += dp.get();
        return result;
    }
}
