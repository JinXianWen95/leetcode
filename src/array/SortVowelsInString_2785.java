package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortVowelsInString_2785 {
    public static void main(String[] args) {
        new SortVowelsInString_2785().sortVowels("lEetcOde");
    }

    public String sortVowels(String s) {
        // we can also use counting sort since the number of vowels is always 10
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        char[] result = new char[s.length()];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) {
                result[j] = vowels.get(i++);
            } else {
                result[j] = s.charAt(j);
            }
        }

        return String.valueOf(result);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
