package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = Arrays.stream(days).max().getAsInt();
        int[] dp = new int[maxDay+1];

        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        for (int i = 1; i <= maxDay; i++) {
            if (daySet.contains(i)) {
                // there's chance that 7 or 30-days tickets are cheaper than 1-day ticket
                dp[i] = costs[0] + dp[i - 1];
                dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
                dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[maxDay];
    }
}
