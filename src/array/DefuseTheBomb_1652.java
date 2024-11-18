package array;

import java.util.Arrays;

public class DefuseTheBomb_1652 {

    public static void main(String[] args) {
        new DefuseTheBomb_1652().decrypt(new int[] {2,4,9,3}, -2);
    }
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) return result;

        int wSum = 0;
        // initial window
        int start = (k > 0) ? 1 : n + k;
        int end = (k > 0) ? k : n - 1;

        for (int i = start; i <= end; i++) {
            wSum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            result[i] = wSum;
            // slide window by 1
            wSum -= code[(start + i) % n];
            wSum += code[(end + i + 1) % n];
        }

        return result;
    }
}
