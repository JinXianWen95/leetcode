package graph;

import java.util.HashSet;
import java.util.Set;

public class FindChampion2_2924 {
    // find the node that does have input edge
    public int findChampion(int n, int[][] edges) {
        Set<Integer> teams = new HashSet<>();

        for (int[] edge : edges) {
            teams.add(edge[1]);
        }

        if (teams.size() != n - 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (!teams.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
