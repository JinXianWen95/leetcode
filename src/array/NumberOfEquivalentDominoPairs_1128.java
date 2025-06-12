package array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberOfEquivalentDominoPairs_1128 {
    public static void main(String[] args) {
        new NumberOfEquivalentDominoPairs_1128().numEquivDominoPairs(new int[][]{{2,1},
                {1,2},{1,2},{1,2},{2,1},{1,1},{1,2},{2,2}});
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
