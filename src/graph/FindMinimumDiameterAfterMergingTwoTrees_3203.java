package graph;

import java.util.*;

public class FindMinimumDiameterAfterMergingTwoTrees_3203 {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = findDiameter(edges1);
        int diameter2 = findDiameter(edges2);
        // Calculate the longest path that spans across both trees
        int combinedDiameter =
                (int) Math.ceil(diameter1 / 2.0) +
                        (int) Math.ceil(diameter2 / 2.0) +
                        1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    private int findDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        if (edges.length == 1) {
            return 1;
        }
        Map<Integer, Set<Integer>> tree = buildTree(edges);
        Queue<Integer> queue = new LinkedList<>();
        // insert the leaves into queue
        for (Map.Entry<Integer, Set<Integer>> entry : tree.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.offer(entry.getKey());
            }
        }
        int layerRemoved = 0;
        int remainingNodes = edges.length + 1;
        while (remainingNodes > 2) {
            int currentLevelSize = queue.size();
            remainingNodes -= currentLevelSize;
            for (int i = 0; i < currentLevelSize; i++) {
                int currentNode = queue.poll();
                int neighbour = findNeighbor(currentNode, tree);
                if (neighbour != -1) {
                    tree.get(neighbour).remove(currentNode);
                    tree.get(currentNode).remove(neighbour);
                }
                if (tree.get(neighbour) != null && tree.get(neighbour).size() == 1) {
                    queue.offer(neighbour);
                }
            }
            layerRemoved++;
        }
        // If exactly two nodes remain, return the diameter as twice the number of layers of leaves removed + 1
        if (remainingNodes == 2) {
            return 2 * layerRemoved + 1;
        }

        return 2 * layerRemoved;
    }

    private Map<Integer, Set<Integer>> buildTree(int[][] edges) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], (key) -> new HashSet<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], (key) -> new HashSet<>()).add(edge[0]);
        }
        return tree;
    }

    private int findNeighbor(int node, Map<Integer, Set<Integer>> tree) {
        // there's only one neighbour since we consider only leaves
        if (tree.get(node) != null && !tree.get(node).isEmpty()) {
            return tree.get(node).iterator().next();
        }
        return -1;
    }
}
