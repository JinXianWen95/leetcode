package graph;

public class PathWithMaximumProbability_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Variation of Bellman-Ford algorithm

        double[] dist = new double[n];
        dist[start_node] = 1.0; // start_node can be reached for sure

        for (int i = 0; i < n; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dst = edges[j][1];
                if (dist[src] * succProb[j] > dist[dst]) {
                    dist[dst] = dist[src] * succProb[j];
                    updated = true;
                }
                if (dist[dst] * succProb[j] > dist[src]) {
                    dist[src] = dist[dst] * succProb[j];
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return dist[end_node];
    }
}
