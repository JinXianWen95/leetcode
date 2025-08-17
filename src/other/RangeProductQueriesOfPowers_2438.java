package other;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesOfPowers_2438 {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1000000007;

        List<Integer> powers = new ArrayList<>();
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                powers.add(res);
            }
            n /= 2;
            res *= 2;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long queryResult = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                queryResult = (powers.get(j) * queryResult) % MOD;
            }

            result[i] = (int) queryResult;
        }

        return result;
    }
}
