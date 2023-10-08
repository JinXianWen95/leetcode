package hashTable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram_242().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> helper = new HashMap<>();
        s.chars().forEach(c -> helper.put((char) c, helper.getOrDefault((char) c, 0) + 1));
        for (char c : t.toCharArray()) {
            if (!helper.containsKey(c) || helper.get(c) == 0) {
                return false;
            }
            helper.put(c, helper.get(c) - 1);
            if (helper.get(c) == 0) {
                helper.remove(c);
            }
        }
        helper.forEach((key, value) -> System.out.println(value));
        return helper.isEmpty();
    }
}
