package array;

import java.util.Arrays;

public class SpecialArray2_3152 {
    public static void main(String[] args) {
        new SpecialArray2_3152().isArraySpecial(new int[] {4,3,1,6}, new int[][]{{2, 3}});
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // Time exceeds
        /*
        boolean[] result = new boolean[queries.length];
        Arrays.fill(result, true);
        int index= 0;
        for (int[] query : queries) {
            boolean isEven = nums[query[0]] % 2 == 0;
            for (int i = query[0]+1; i <= query[1]; i++) {
                if ((nums[i] % 2 == 0) == isEven) {
                    result[index] = false;
                    break;
                } else {
                    isEven = !isEven;
                }
            }
            index++;
        }
        return result;
         */

        // dp exceeds memory
        /*
        boolean[][] dp = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (!dp[i][j-1]) {
                    dp[i][j] = false;
                    // all subsequence cannot be true
                    break;
                } else {
                    dp[i][j] = nums[j] % 2 != nums[j-1] % 2;
                }
            }
        }

        boolean[] result = new boolean[queries.length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = dp[query[0]][query[1]];
        }

        return result;

         */

        // prefix: when two number are not equal in parity increase by 1

        int[] prefix = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1];
            if (nums[i] % 2 == nums[i-1] % 2) {
                prefix[i]++;
            }
        }

        boolean[] result = new boolean[queries.length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = prefix[query[1]] - prefix[query[0]] == 0;
        }
        return result;
    }
}
