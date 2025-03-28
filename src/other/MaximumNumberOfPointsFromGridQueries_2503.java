package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfPointsFromGridQueries_2503 {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] queryAndIndex = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            queryAndIndex[i][0] = queries[i];
            queryAndIndex[i][1] = i;
        }

        Arrays.sort(queryAndIndex, Comparator.comparingInt(q -> q[0]));

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));
        minHeap.add(new int[] {grid[0][0], 0, 0}); // add top-left

        int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int[] answer = new int[queries.length];
        int points = 0;

        for (int[] query : queryAndIndex) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < query[0]) {
                int[] current = minHeap.poll();
                points++;
                for (int[] direction : DIRECTIONS) {
                    int newRow = current[1] + direction[0];
                    int newCol = current[2] + direction[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && !visited[newRow][newCol]) {
                        minHeap.add(new int[]{grid[newRow][newCol], newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            answer[query[1]] = points;
        }
        return answer;
    }
}
