package graph;

import java.util.Arrays;

public class MinimumCostWalkinWeightedGraph_3108 {
  int[] depth;
  int[] root;
  public int[] minimumCost(int n, int[][] edges, int[][] query) {
    // Since the AND operation can only turn bits off (changing 1 to 0, but never 0 to 1),
    // the result can never have more 1s than the smallest number.
    // This means the result is always less than or equal to the smallest number

    // find and union
    root = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = -1; // the root of a node is itself at the start
    }

    depth = new int[n];

    int[] componentCost = new int[n]; // worst case each node is component-alone
    Arrays.fill(componentCost, Integer.MAX_VALUE);

    for (int[] edge : edges) {
      union(edge[0], edge[1]);
    }

    for (int[] edge : edges) {
      int root = find(edge[0]);
      componentCost[root] &= edge[2];
    }

    int[] result = new int[query.length];
    int index = 0;
    for (int[] q : query) {
      int rootSource = find(q[0]);
      int rootDest = find(q[1]);

      if (rootSource != rootDest) {
        result[index++] = -1;
      } else {
        result[index++] = componentCost[rootSource];
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

    if (depth[root1] < depth[root2]) {
      int temp = root1;
      root1 = root2;
      root2 = temp;
    }

    root[root2] = root1;

    if (depth[root1] == depth[root2]) {
      depth[root1]++;
    }

  }
}
