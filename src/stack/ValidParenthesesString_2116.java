package stack;

import java.util.Stack;

public class ValidParenthesesString_2116 {
    public boolean canBeValid(String s, String locked) {
        // odd string cannot have balanced parentheses
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Integer> openParentheses = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // if unlocked
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openParentheses.push(i);
            } else { // locked ')'
                if (!openParentheses.isEmpty()) { // pair with locked '('
                    openParentheses.pop();
                } else if (!unlocked.isEmpty()) { // pair with unlocked char
                    unlocked.pop();
                } else { // there's unpair locked ')'
                    return false;
                }
            }
        }

        // pair the remaining locked open parentheses with
        while (!openParentheses.isEmpty() && !unlocked.isEmpty()
                && openParentheses.peek() < unlocked.peek()) { // '(' should be left over its pair
            openParentheses.pop();
            unlocked.pop();
        }

        return openParentheses.isEmpty();
    }
}
