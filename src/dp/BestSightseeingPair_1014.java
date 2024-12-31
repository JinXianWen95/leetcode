package dp;

public class BestSightseeingPair_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        /* brute force tle
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                result = Math.max(values[i] + values[j] + i - j, result);
            }
        }

        return result;

         */

        int maxPair = values[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, values[i] - i + maxPair);
            maxPair = Math.max(maxPair, values[i] + i);
        }
        return result;
    }
}
