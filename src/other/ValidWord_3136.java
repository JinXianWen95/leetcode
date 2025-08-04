package other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidWord_3136 {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> vowelSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        boolean vowelCondition = false;
        boolean consonantCondition = false;
        for (char c : word.toCharArray()) {
            if (vowelSet.contains(c)) {
                vowelCondition = true;
            } else if (Character.isAlphabetic(c)) {
                consonantCondition = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return vowelCondition && consonantCondition;
    }
}
