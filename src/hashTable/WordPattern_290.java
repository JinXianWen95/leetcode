package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> helper = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return  false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character key = pattern.charAt(i);
            if (helper.containsKey(key) && !helper.get(key).equals(words[i])) {
                return false;
            }
            helper.put(key, words[i]);
        }
        // each char must correspond to one word and vice-versa.
        return new HashSet<>(helper.values()).size() == helper.keySet().size();
    }
}
