package other;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox_1769 {
    public int[] minOperations(String boxes) {
        /* acceptable solution
        int[] prefixSum = new int[boxes.length()];
        int[] suffixSum = new int[boxes.length()];
        suffixSum[boxes.length()-1] = boxes.charAt(boxes.length()-1) - '0';
        prefixSum[0] = boxes.charAt(0) - '0';

        for (int i = 1; i < boxes.length(); i++) {
            prefixSum[i] = prefixSum[i-1] + boxes.charAt(i) - '0';
            suffixSum[boxes.length()-i-1] = suffixSum[boxes.length()-i] + boxes.charAt(boxes.length()-i-1) - '0';
        }

        int[] result = new int[boxes.length()];
        int fromStartValue = prefixSum[0];
        int fromEndValue = suffixSum[boxes.length()-1];
        for (int i = 1; i < boxes.length(); i++) {
            result[i] += fromStartValue;
            fromStartValue += prefixSum[i];

            result[boxes.length()-1-i] += fromEndValue;
            fromEndValue += suffixSum[boxes.length()-i-1];
        }
        return result;

         */

        // Space improved
        int movesFromStart = 0;
        int movesFromEnd = 0;
        int ballsFromStart = 0;
        int ballsFromEnd = 0;

        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            result[i] += movesFromStart;
            ballsFromStart += boxes.charAt(i) - '0';
            movesFromStart += ballsFromStart;

            result[boxes.length()-i-1] += movesFromEnd;
            ballsFromEnd += boxes.charAt(boxes.length()-i-1) - '0';
            movesFromEnd += ballsFromEnd;
        }
        return result;
    }
}
