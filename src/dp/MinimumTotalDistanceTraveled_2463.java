package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTotalDistanceTraveled_2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // sort robot and factory according to position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        long[][] memo = new long[robot.size()][factoryPositions.size()];
        for (long[] row : memo) {
            Arrays.fill(row, -1L);
        }

        return computeDistance(0, 0, robot, factoryPositions, memo);
    }

    private long computeDistance(
            int robotIdx,
            int factoryIdx,
            List<Integer> robot,
            List<Integer> factory,
            long[][] memo
    ) {
        if (robotIdx == robot.size()) {
            return 0; // all robots are assigned to a factory
        }

        if (factoryIdx == factory.size()) {
            return (long) 1e12; // we have not enough factory to assign all robots
        }

        if (memo[robotIdx][factoryIdx] != -1) {
            return memo[robotIdx][factoryIdx];
        }

        long assign = Math.abs(robot.get(robotIdx) - factory.get(factoryIdx)) +
                computeDistance(robotIdx+1,
                        factoryIdx+1,
                        robot,
                        factory,
                        memo);

        long skip = computeDistance(robotIdx,
                factoryIdx+1,
                robot,
                factory,
                memo);

        memo[robotIdx][factoryIdx] = Math.min(assign, skip);
        return memo[robotIdx][factoryIdx];
    }
}
