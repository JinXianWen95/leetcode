package other;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid_921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> helper = new Stack<>();

        for (char c : s.toCharArray()) {
            if (helper.isEmpty()) {
                helper.push(c);
            } else if (c == ')' && helper.peek() == '(') {
                helper.pop();
            } else {
                helper.push(c);
            }
        }

        return helper.size();
    }
}
