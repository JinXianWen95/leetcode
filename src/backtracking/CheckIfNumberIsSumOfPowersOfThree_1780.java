package backtracking;

public class CheckIfNumberIsSumOfPowersOfThree_1780 {
  public boolean checkPowersOfThree(int n) {
    // note that 1 <= n <= 10^7 -> log_3 10^7 ~ 15
    return checkPowersOfThree(n, 0);
  }

  private boolean checkPowersOfThree(int n, int power) {
    if (n == 0) {
      return true;
    }

    if (Math.pow(3, power) > n) {
      return false;
    }

    return checkPowersOfThree((int) (n - Math.pow(3, power)), power + 1) || // take the current power
        checkPowersOfThree(n, power + 1); // skip it
  }
}
