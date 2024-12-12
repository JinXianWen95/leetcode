package other;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialStringThatOccurThrice1_2981 {

    public int maximumLength(String s) {
        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int index = i;
            while (index < s.length() && s.charAt(i) == s.charAt(index)) {
                dictionary.compute(s.substring(i, index+1), (k, v) -> (v == null) ? 1 : v + 1);
                index++;
            }
        }

        int result = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            if (entry.getValue() > 2) {
                result = Math.max(result, entry.getKey().length());
            }
        }
        return result == 0 ? -1 : result;
    }
}
