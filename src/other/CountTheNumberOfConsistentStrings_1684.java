package other;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedChars.add(c);
        }

        int result = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedChars.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                result++;
            }
        }
        return result;
    }
}
