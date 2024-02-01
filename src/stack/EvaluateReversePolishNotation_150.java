package stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation_150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public int evalRPN(String[] tokens) {
        // base case
        if (Objects.isNull(tokens) || tokens.length == 0) {
            return 0;
        }
        // use Stack to keep number
        Stack<Integer> stackHelper = new Stack<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                stackHelper.push(Integer.parseInt(token));
            } else {
                stackHelper.push(compute(token, stackHelper.pop(), stackHelper.pop()));
            }
        }
        return stackHelper.pop();
    }

    private Integer compute(String token, Integer num1, Integer num2) {
        return switch (token) {
            case "*" -> num1 * num2;
            case "/" -> num2 / num1;
            case "+" -> num1 + num2;
            case "-" -> num2 - num1;
            default -> 0;
        };
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
