package other;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String s : dictionary) {
                if (maxTwoEdits(query, s)) {
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    private boolean maxTwoEdits(String query, String word) {
        int editCount = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != word.charAt(i)) {
                editCount++;
            }

            if (editCount > 2) {
                return false;
            }
        }
        return true;
    }
}
