package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalkingRobotSimulation2_2069 {
  /* Simulating -> timeout
  class Robot {

    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int x;
    int y;
    int index;

    int width;
    int height;

    public Robot(int width, int height) {
      this.width = width;
      this.height = height;
      x = 0;
      y = 0;
      index = 1; // east
    }

    public void step(int num) {
      int tempX = x;
      int tempY = y;
      while (num > 0) {
        int nx = tempX + direction[index][0];
        int ny = tempY + direction[index][1];
        while (nx >= width || nx < 0 || ny < 0 || ny >= height) {
          index = (index+3) % 4;
          nx = tempX + direction[index][0];
          ny = tempY + direction[index][1];
        }
        tempX = nx;
        tempY = ny;
        num--;
      }
      x = tempX;
      y = tempY;
      System.out.println("x: " + x + " y: " + y);
    }

    public int[] getPos() {
      return new int[] {x, y};
    }

    public String getDir() {
      return switch (index) {
        case 0 -> "North";
        case 1 -> "East";
        case 2 -> "South";
        case 3 -> "West";
        default -> null;
      };
    }
  }

   */

  // since the path is cyclic along the outermost layer of the grid
  class Robot {

    private boolean moved = false;
    private int idx = 0;
    private List<int[]> pos = new ArrayList<>();
    private List<Integer> dir = new ArrayList<>();
    private Map<Integer, String> toDir = new HashMap<>();

    public Robot(int width, int height) {
      toDir.put(0, "East");
      toDir.put(1, "North");
      toDir.put(2, "West");
      toDir.put(3, "South");

      for (int i = 0; i < width; ++i) {
        pos.add(new int[] { i, 0 });
        dir.add(0);
      }
      for (int i = 1; i < height; ++i) {
        pos.add(new int[] { width - 1, i });
        dir.add(1);
      }
      for (int i = width - 2; i >= 0; --i) {
        pos.add(new int[] { i, height - 1 });
        dir.add(2);
      }
      for (int i = height - 2; i > 0; --i) {
        pos.add(new int[] { 0, i });
        dir.add(3);
      }
      dir.set(0, 3);
    }

    public void step(int num) {
      moved = true;
      idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
      return pos.get(idx);
    }

    public String getDir() {
      if (!moved) {
        return "East";
      }
      return toDir.get(dir.get(idx));
    }
  }
}
