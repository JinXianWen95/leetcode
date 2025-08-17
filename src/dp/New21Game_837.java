package dp;

public class New21Game_837 {
    public static void main(String[] args) {
        new New21Game_837().new21Game(10, 1, 10);
    }
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n+1];
        dp[0] = 1; // at the start there's no points

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i - j >= 0 && i - j < k) { // if i-j >= k then the game should be over
                    dp[i] += dp[i - j] / maxPts;
                }
            }
        }

        double result = 0;
        for (int i = k; i <= n; i++) { // k <= i <= n is when the game is over and we hold n or less points
            result += dp[i];
        }

        return result;
    }
}
