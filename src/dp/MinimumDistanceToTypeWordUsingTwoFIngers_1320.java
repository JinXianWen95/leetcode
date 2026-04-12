package dp;

import java.util.Arrays;

public class MinimumDistanceToTypeWordUsingTwoFIngers_1320 {
    public int minimumDistance(String word) {
        // At any point in time, one finger is always resting on the letter we just typed.
        // Because of this, we don't need to store the positions of both fingers. We only need to track the "other" finger.

        int[] dp = new int[26]; // represents the state of free finger after we finished typing the previous character (word[i-1])
        Arrays.fill(dp, 0);; // the starting point of finger has zero distance

        for (int i = 1; i < word.length(); i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            int d = getDistance(prev, cur); // the distance between current char and previous char

            int[] nextDp = new int[26]; // represents the state while we are typing the current character (word[i])
            Arrays.fill(nextDp, Integer.MAX_VALUE/2);

            for (int j = 0; j < 26; j++) {
                if (dp[j] == Integer.MAX_VALUE/2) { // letter not reached yet, so any finger can be here
                    continue;
                }

                // Option 1: we move the finger that was on previous letter to current letter
                // the idle finger stays on j
                nextDp[j] = Math.min(nextDp[j], dp[j] + d);

                // option2 : we move the free finger to current letter
                nextDp[prev] = Math.min(nextDp[prev], dp[j] + getDistance(j, cur));
            }
            dp = nextDp;

        }

        int ans = Integer.MAX_VALUE/2;
        for (int val : dp) {
            ans = Math.min(ans, val);
        }
        return ans;
    }

    private int getDistance(int x, int y) {
        // Translate a grid of 6 units for each row to a 1D coordinate
        return Math.abs(x/6 - y/6) + Math.abs(x%6 - y%6);
    }
}
