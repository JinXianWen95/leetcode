package graph;

import java.util.*;

public class CountTheNumberOfCompleteComponents_2685 {
    public static void main(String[] args) {
        new CountTheNumberOfCompleteComponents_2685().countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4}});
    }

    int[] root;
    Map<Integer, Integer> rootSize;
    public int countCompleteComponents(int n, int[][] edges) {
        // BFS
//        return BFS(n, edges);

        // Find & Union
        root = new int[n];
        Arrays.fill(root, -1);

        rootSize = new HashMap<>();
        for (int i = 0; i < root.length; i++) {
            rootSize.put(i, 1);
        }

        Map<Integer, Integer> edgesCount = new HashMap<>();

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = find(edge[0]);
            edgesCount.put(root, edgesCount.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            int parent = find(vertex);
            if (parent == vertex &&
                    edgesCount.getOrDefault(parent, 0) == (rootSize.get(parent) * (rootSize.get(parent) - 1)) / 2) { // if it's root
                result++;
            }
        }
        return result;
    }

    private int find(int node) {
        if (root[node] == -1) {
            return node;
        }
        return find(root[node]);
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        int newRootSize = rootSize.get(root2) + rootSize.get(root1);
        if (rootSize.get(root1) < rootSize.get(root2)) {
            root[root1] = root2;
            rootSize.put(root2, newRootSize);
        } else {
            root[root2] = root1;
            rootSize.put(root1, newRootSize);
        }

    }

    private int BFS(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // build graph
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(vertex);
                visited[vertex] = true;

                // build component
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    component.add(node);
                    for (int neighbor : graph[node]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }

                if (isComplete(component, graph)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isComplete(List<Integer> component, List<Integer>[] graph) {
        boolean isComplete = true;
        for (int node : component) {
            if (graph[node].size() != component.size() - 1) {
                isComplete = false;
                break;
            }
        }
        return isComplete;
    }
}
