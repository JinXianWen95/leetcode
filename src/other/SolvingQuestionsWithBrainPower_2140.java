package other;

import java.util.Arrays;

public class SolvingQuestionsWithBrainPower_2140 {
    public static void main(String[] args) {
        new SolvingQuestionsWithBrainPower_2140().mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}});
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return mostPoints(questions, dp, 0);
    }

    private long mostPoints(int[][] questions, long[] dp, int startIndex) {
        if (startIndex >= questions.length) {
            return 0;
        }

        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }

        long take = questions[startIndex][0] + mostPoints(questions, dp, startIndex + questions[startIndex][1]+1);
        long skip = mostPoints(questions, dp, startIndex+1);

        dp[startIndex] = Math.max(take, skip);

        return dp[startIndex];
    }

    // recursive time exceeded
    /*
    private long mostPoints(int[][] questions, int startIndex, long earnedPoints) {
        if (startIndex >= questions.length) {
            return earnedPoints;
        }

        return Math.max(mostPoints(questions, startIndex + 1, earnedPoints), // skip current question
                mostPoints(questions, startIndex + questions[startIndex][1]+1,
                        earnedPoints + questions[startIndex][0]));
    }
     */

}
