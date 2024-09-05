package array;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation_874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0;
        int y = 0;

        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int maxDistance = 0;
        int index = 0; // north as start

        for (int command : commands) {
            if (command == -1) {
                index = (index+1) % 4;
            } else if (command == -2) {
                index = (index+3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + direction[index][0];
                    int ny = y + direction[index][1];
                    if (obstacleSet.contains(nx + " " + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }

        return maxDistance;
    }
}
