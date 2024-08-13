package hashTable;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumPushesToTypeWord2_3016 {
    public int minimumPushes(String word) {
        final int keyNumber = 8;
        Map<Character, Integer> helper = frequencyCounter(word)
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int minPushes = 0;
        int multiplyFactor = 1;
        int counter = 0;
        for (Map.Entry<Character, Integer> entry : helper.entrySet()) {
            minPushes += entry.getValue() * multiplyFactor;
            counter++;
            if (counter == keyNumber) {
                counter = 0;
                multiplyFactor++;
            }
        }
        return minPushes;
    }

    private Map<Character, Integer> frequencyCounter(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : word.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }
        return result;
    }
}
