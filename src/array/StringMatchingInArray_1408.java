package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingInArray_1408 {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
