package backtracking;

import java.util.*;

public class Combinations_77 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations_77().combine(4, 2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public void backtracking(int n, int k, int start, List<Integer> combination, List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtracking(n, k, i+1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }
}
