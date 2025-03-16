package other;

import java.util.Arrays;

public class MinimumTimeToRepairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        // time = rank * n^2 -> n = floor(sqrt(time/rank))

        long maximum = (long) (Math.pow(cars, 2) * Arrays.stream(ranks).max().getAsInt());
        long minimum = 1;

        while (minimum < maximum) {
            long mid = (minimum + maximum) / 2;
            long repairedCars = 0;
            for (int rank : ranks) {
                repairedCars += (long) Math.sqrt((double) mid / rank);
            }

            if (repairedCars >= cars) {
                maximum = mid;
            } else {
                minimum = mid + 1;
            }
        }

        return minimum;
    }
}
