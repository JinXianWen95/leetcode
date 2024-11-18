package other;

import java.util.ArrayList;
import java.util.List;

public class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        char startChar = s.charAt(0);
        List<Integer> startIndexes = new ArrayList<>();


        for (int i = 0; i < goal.length(); i++) {
            if (goal.charAt(i) == startChar) {
                startIndexes.add(i);
            }
        }

        if (startIndexes.isEmpty()) {
            return false;
        }

        for (int startIndex : startIndexes) {
            if (check(s, goal, startIndex)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(String s, String goal, int startIndex) {
        int i = 1;
        int j = (startIndex + 1) % goal.length();

        while (i < s.length()) {
            if (s.charAt(i) != goal.charAt(j)) {
                return false;
            }
            i++;
            j = (j+1) % goal.length();
        }

        return true;
    }
}
