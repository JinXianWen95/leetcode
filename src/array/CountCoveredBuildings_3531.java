package array;

import java.util.Arrays;

public class CountCoveredBuildings_3531 {
  public int countCoveredBuildings(int n, int[][] buildings) {
    int[] minRow = new int[n+1];
    int[] maxRow = new int[n+1];
    int[] minColumn = new int[n+1];
    int[] maxColumn = new int[n+1];

    Arrays.fill(minRow, n+1);
    Arrays.fill(minColumn, n+1);

    for (int[] building : buildings) {
      int x = building[0];
      int y = building[1];

      maxRow[y] = Math.max(maxRow[y], x);
      minRow[y] = Math.min(minRow[y], x);
      maxColumn[x] = Math.max(maxColumn[x], y);
      minColumn[x] = Math.min(minColumn[x], y);
    }

    int result = 0;

    for (int[] building : buildings) {
      int x = building[0];
      int y = building[1];
      if (x > minRow[y] && x < maxRow[y] && y > minColumn[x] && y < maxColumn[x]) {
        result++;
      }
    }

    return result;
  }
}
