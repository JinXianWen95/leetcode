package array;

public class MaximumMatrixSum_1975 {
    public long maxMatrixSum(int[][] matrix) {
        // if there are even numbers of negative integers return sum of all numbers (converted to positive),
        // otherwise it's sum - minimumNumber

        int minimum = Integer.MAX_VALUE;
        long sum = 0;
        int negativeCounts = 0;

        for (int[] numbers : matrix) {
            for (int number : numbers) {
                if (number <= 0) {
                    negativeCounts++;
                }
                int positive = Math.abs(number);
                minimum = Math.min(minimum, positive);
                sum += positive;
            }
        }

        if (negativeCounts % 2 == 0) {
            return sum;
        }
        return sum - 2L * Math.abs(minimum);
    }
}
