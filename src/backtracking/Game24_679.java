package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Game24_679 {
    public boolean judgePoint24(int[] cards) {
        List<Double> numbers = new ArrayList<>(cards.length);
        for (int card : cards) {
            numbers.add((double) card);
        }
        return solve(numbers);
    }

    private boolean solve(List<Double> numbers) {
        if (numbers.size() == 1) {
            return Math.abs(numbers.get(0) - 24.0) < 1e-6;
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {

                List<Double> nextList = new ArrayList<>();
                for (int k = 0; k < numbers.size(); k++) {
                    if (k != i && k != j) {
                        nextList.add(numbers.get(k));
                    }
                }

                List<Double> intermediateResults = new ArrayList<>();
                double number1 = numbers.get(i);
                double number2 = numbers.get(j);

                intermediateResults.add(number1 + number2);
                intermediateResults.add(number1 - number2);
                intermediateResults.add(number2 - number1);
                intermediateResults.add(number1 * number2);
                if (Math.abs(number1) > 1e-5) {
                    intermediateResults.add(number2 / number1);
                }

                if (Math.abs(number2) > 1e-5) {
                    intermediateResults.add(number1 / number2);
                }

                for (double result : intermediateResults) {
                    nextList.add(result);
                    if (solve(nextList)) {
                        return true;
                    }
                    nextList.remove(result);
                }
            }
        }
        return false;
    }
}
