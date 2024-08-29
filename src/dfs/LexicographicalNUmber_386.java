package dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNUmber_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(1, n, result);
        return result;
    }

    private void dfs(int start, int n, List<Integer> result) {
        if (start > n) {
            return;
        }
        result.add(start);
        dfs(start*10, n, result);
        if (start % 10 != 9) { // if start terminates with 9 than we don't go on
            dfs(start+1, n, result);
        }
    }
}
