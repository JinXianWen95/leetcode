package other;

import java.util.*;

public class UncommonWordsFromTwoSentences_884 {
    public String[] uncommonFromSentences(String s1, String s2) {

        Map<String, Integer> helper1 = convertToMap(s1);
        Map<String, Integer> helper2 = convertToMap(s2);

        List<String> result = new ArrayList<>(s1.length() + s2.length());

        for (Map.Entry<String, Integer> entry : helper1.entrySet()) {
            if (!helper2.containsKey(entry.getKey()) && entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : helper2.entrySet()) {
            if (!helper1.containsKey(entry.getKey()) && entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }

    private Map<String, Integer> convertToMap(String s) {
        String[] sentence = s.split(" ");
        Map<String, Integer> helper = new HashMap<>(sentence.length);
        for (String word : sentence) {
            helper.put(word, helper.getOrDefault(word, 0) + 1);
        }
        return helper;
    }
}
