package hashTable;

import java.util.*;

public class MinimumPushesToTypeWord2_3016 {
    public int minimumPushes(String word) {
        // Solution 1: using map
        /*
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

         */

        // Solution 2: using array
        int[] frequencyCharacter = frequencyCounter(word);
        Arrays.sort(frequencyCharacter);
        int minPushes = 0;
        int multiplyFactor = 1;
        int counter = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequencyCharacter[i] == 0) {
                break;
            }
            minPushes += frequencyCharacter[i] * multiplyFactor;
            counter++;
            if (counter == 8) {
                counter = 0;
                multiplyFactor++;
            }
        }
        return minPushes;

    }

//    private Map<Character, Integer> frequencyCounter(String word) {
//        Map<Character, Integer> result = new HashMap<>();
//        for (char c : word.toCharArray()) {
//            result.merge(c, 1, Integer::sum);
//        }
//        return result;
//    }

    private int[] frequencyCounter(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a'] += 1;
        }
        return frequency;
    }
}
