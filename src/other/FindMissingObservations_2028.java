package other;

import java.util.Arrays;

public class FindMissingObservations_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumMissingObservations = mean * (n + rolls.length) - Arrays.stream(rolls).sum();
        if (!isValid(sumMissingObservations, n)) {
            return new int[0];
        }

        int rollMedianValue = sumMissingObservations / n;
        int remainder = sumMissingObservations % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (remainder > 0) {
                result[i] = rollMedianValue + 1;
                remainder--;
            } else {
                result[i] = rollMedianValue;
            }
        }
        return result;
    }

    private boolean isValid(int sum, int n) {
        if (sum < n || sum > 6*n) {
            return false;
        }
        return true;
    }
}
