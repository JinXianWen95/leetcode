package greedy;

import java.util.*;

public class RearrangingFruits_2561 {
    public static void main(String[] args) {
        new RearrangingFruits_2561().minCost(
                new int[] {84,80,43,8,80,88,43,14,100,88},
                new int[] {32,32,42,68,68,100,42,84,14,8}
        );
    }
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int minimum = Integer.MAX_VALUE;
        for (int n : basket1) {
            treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
            minimum = Math.min(minimum, n);
        }

        for (int n : basket2) {
            treeMap.put(n, treeMap.getOrDefault(n, 0) - 1);
            minimum = Math.min(minimum, n);
        }

        List<Integer> costs = new ArrayList<>();
        if (addCost(treeMap, costs)) {
            return -1L;
        }

        long result = 0L;
        Collections.sort(costs);
        for (int i = 0; i < costs.size() / 2; i++) {
            // 2 * minimum is the cost of swapping through the minimum cost
            result += Math.min(2 * minimum, costs.get(i));
        }

        return result;
    }

    private boolean addCost(TreeMap<Integer, Integer> b2, List<Integer> costs) {
        for (Map.Entry<Integer, Integer> entry : b2.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0) {
                return true;
            }

            for (int i = 0; i < Math.abs(value) / 2; i++) {
                costs.add(entry.getKey());
            }
        }
        return false;
    }
}
