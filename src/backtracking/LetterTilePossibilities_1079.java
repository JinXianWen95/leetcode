package backtracking;

import java.util.*;

public class LetterTilePossibilities_1079 {

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Set<String> set = new HashSet<>();
        backtrack(set, "", chars, new boolean[tiles.length()]);
        return set.size();
    }

    private void backtrack(Set<String> set, String s, char[] chars, boolean[] used) {
        if (!s.isEmpty()) {
            set.add(s);
        }
        for(int i = 0; i < chars.length; i++){
            if (!used[i]) {
                used[i] = true;
                backtrack(set, s + chars[i], chars, used);
                used[i] = false;
            }
        }
    }
}
