package other;

public class CountTotalNumberOfColoredCells_2579 {
  public long coloredCells(int n) {
    if (n == 1) {
      return 1L;
    }
    // at each minute there's  4(n-1) colored cells added
    return 4L * (n - 1) + coloredCells(n - 1);
  }
}
