package array;

import java.util.Arrays;

public class MaxChuckToMakeSorted_769 {
    public int maxChunksToSorted(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] += prefixSum[i-1] + arr[i];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (prefixSum[i] == i*(i+1)/2) {
                result++;
            }
        }
        return result;
    }
}
