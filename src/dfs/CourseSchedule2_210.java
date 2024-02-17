package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule2_210 {
    public static void main(String[] args) {
        new CourseSchedule2_210().findOrder(2, new int[][]{new int[]{1, 0}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[]{0};
        }
        List<List<Integer>> adiancentList = buildTopology(numCourses, prerequisites);
        List<Integer> result = new ArrayList<>();
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adiancentList, i, visited, visiting, result)) {
                return new int[0];
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private List<List<Integer>> buildTopology(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adiancentList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adiancentList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adiancentList.get(prerequisite[0]).add(prerequisite[1]);
        }
        return adiancentList;
    }

    private boolean dfs(List<List<Integer>> adiancentList, int current, boolean[] visited, boolean[] visiting, List<Integer> result) {
        if (visited[current]) {
            return true;
        }
        if (visiting[current]) {
            return false;
        }
        visiting[current] = true;
        for (Integer neighbors : adiancentList.get(current)) {
            if (!dfs(adiancentList, neighbors, visited, visiting, result)) {
                return false;
            }
        }
        visiting[current] = false;
        visited[current] = true;
        result.add(current);
        return true;
    }
}
