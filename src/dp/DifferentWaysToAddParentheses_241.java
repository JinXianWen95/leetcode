package dp;

import java.util.*;

public class DifferentWaysToAddParentheses_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return helper(expression, memo);
    }

    public List<Integer> helper(String expression, Map<String, List<Integer>> memo) {
        if (Objects.isNull(expression)) {
            return new ArrayList<>();
        }
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> values = new ArrayList<>();
        if (!hasOperator(expression)) {
            values.add(Integer.parseInt(expression));
        } else {
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (!Character.isDigit(c)) {
                    List<Integer> leftPart = helper(expression.substring(0, i), memo);
                    List<Integer> rightPart = helper(expression.substring(i + 1), memo);
                    for (int left : leftPart) {
                        for (int right : rightPart) {
                            values.add(compute(left, right, c));
                        }
                    }
                }
            }
        }
        memo.put(expression, values);
        return values;
    }

    private boolean hasOperator(String expression) {
        if (expression.contains("+") || expression.contains("-") || expression.contains("*")) {
            return true;
        }
        return false;
    }

    private int compute(int left, int right, char c) {
        switch (c) {
            case '+':
                return left + right;
            case  '-':
                return left - right;
            case  '*':
                return left * right;
        }
        System.out.println("unexpected operator");
        return 0;
    }
}
