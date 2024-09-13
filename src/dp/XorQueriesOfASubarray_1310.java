package dp;

public class XorQueriesOfASubarray_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        /* Exceeds memory
        int size = arr.length;
        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            dp[i][i] = arr[i];
        }

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                dp[i][j] = dp[i][j-1] ^ arr[j];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dp[queries[i][0]][queries[i][1]];
        }
        return result;
         */

        int size = arr.length;
        int[] pref = new int[size];
        // xor of number till i;
        pref[0] = arr[0];
        for (int i = 1; i < size; i++) {
            pref[i] = pref[i-1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = pref[right];
            } else {
                // pre[righti] gives the XOR from the start of the array up to righti
                // and subtracting pre[lefti - 1] removes the contribution of the elements before lefti
                result[i] = pref[right] ^ pref[left-1];
            }
        }
        return result;
    }
}
