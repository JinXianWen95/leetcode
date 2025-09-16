package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNUmberOfWordsYouCanType_1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<String> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(String.valueOf(c));
        }

        String[] words = text.split(" ");
        return (int) Arrays.stream(words).filter(
                word -> {
                    for (String letter : brokenSet) {
                        if (word.contains(letter)) {
                            return false;
                        }
                    }
                    return true;
                }
        ).count();
    }
}
