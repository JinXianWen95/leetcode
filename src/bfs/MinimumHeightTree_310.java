package bfs;

import java.util.*;

public class MinimumHeightTree_310 {
    // the size of list is one or two: example tree
    // 1 - 2 - 3 - 4 -> 2, 3 are the result
    // 1 - 2 - 3 -> 2 is the result
    // the question is to find the central node that has the minimum path to the all leaf node
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // create the graph and count the degree of each node
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            adjList.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = leaves.size();
            // remove the leaves by layer
            for (int i = 0; i < size; i++) {
                Integer leaf = leaves.poll();
                for (Integer adjNode : adjList.get(leaf)) {
                    if (--degrees[adjNode] == 1) {
                        leaves.add(adjNode);
                    }
                }
            }
            remainingNodes -= size;
        }
        return new ArrayList<>(leaves);
    }
}
