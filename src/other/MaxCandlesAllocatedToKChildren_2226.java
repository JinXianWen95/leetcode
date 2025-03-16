package other;

import java.util.Arrays;

public class MaxCandlesAllocatedToKChildren_2226 {
    public int maximumCandies(int[] candies, long k) {
        int maximum = Arrays.stream(candies).max().getAsInt();
        int minimum = 1;

        while (minimum < maximum) {
            int mid = (minimum + maximum) / 2;
            long children = 0;
            for (int candy : candies) {
                if (candy >= mid) {
                    children += candy / mid;
                }
            }

            if (children >= k) {
                minimum = mid + 1;
            } else {
                maximum = mid;
            }
        }

        return maximum;
    }
}
