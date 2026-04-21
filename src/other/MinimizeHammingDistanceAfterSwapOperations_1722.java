package other;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations_1722 {
    private int[] fa;
    private int[] rank;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int size = source.length;
        fa = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            fa[i] = i;
        }

        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int f = find(i);
            map.computeIfAbsent(f, k -> new HashMap<>())
                .merge(source[i], 1, Integer::sum);
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            int f = find(i);
            Map<Integer, Integer> cnt = map.get(f);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                cnt.merge(target[i], -1, Integer::sum);
            } else {
                result++;
            }
        }
        return result;
    }

    private int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }

        return fa[x];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }

        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[y] = x;
        if (rank[x] == rank[y]) {
            rank[x]++;
        }
    }
}
