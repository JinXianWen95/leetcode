package bfs;

import tree.Node;

import java.util.*;

public class MaximumNumberOfKDivisibleComponents_2872 {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // the input has always a solution as declared in the problem
        if (n < 2) {
            return 1;
        }

        long[] longValues = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }

        Map<Integer, Set<Integer>> tree = buildTree(edges);
        Queue<Integer> queue = new LinkedList<>();
        // insert the leaves into queue
        for (Map.Entry<Integer, Set<Integer>> entry : tree.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.offer(entry.getKey());
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            int neighbour = findNeighbor(currentNode, tree);
            if (longValues[currentNode] % k == 0) {
                result++;
            } else if (neighbour != -1) {
                longValues[neighbour] += longValues[currentNode];
            }

            if (neighbour != -1) {
                tree.get(neighbour).remove(currentNode);
                tree.get(currentNode).remove(neighbour);
            }

            if (tree.get(neighbour) != null && tree.get(neighbour).size() == 1) {
                queue.offer(neighbour);
            }
        }
        return result;
    }

    private int findNeighbor(int node, Map<Integer, Set<Integer>> tree) {
        // there's only one neighbour since we consider only leaves
        if (tree.get(node) != null && !tree.get(node).isEmpty()) {
            return tree.get(node).iterator().next();
        }
        return -1;
    }


    private Map<Integer, Set<Integer>> buildTree(int[][] edges) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], (key) -> new HashSet<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], (key) -> new HashSet<>()).add(edge[0]);
        }
        return tree;
    }
}
