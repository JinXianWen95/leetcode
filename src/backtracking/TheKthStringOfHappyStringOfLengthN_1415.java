package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TheKthStringOfHappyStringOfLengthN_1415 {
    public String getHappyString(int n, int k) {
        List<String> set = new ArrayList<>();
        for (char i = 'a'; i <= 'c'; i++) {
            backtrack(String.valueOf(i), set, n);
        }
        if (set.size() < k) {
            return "";
        }

        return set.get(k-1);
    }

    private void backtrack(String current, List<String> set, int n) {
        if (current.length() == n) {
            set.add(current);
            return;
        }

        for (char i = 'a'; i <= 'c'; i++) {
            char lastChar = current.charAt(current.length()-1);
            if (lastChar == i) {
                continue;
            }
            backtrack(current + i, set, n);
        }
    }
}
