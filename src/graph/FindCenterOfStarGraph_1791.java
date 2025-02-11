package graph;

public class FindCenterOfStarGraph_1791 {
    public int findCenter(int[][] edges) {
        if (edges[1][0] == edges[0][0] || edges[1][1] == edges[0][0]) {
            return edges[0][0];
        }

        return edges[0][1];
    }
}
