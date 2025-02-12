package array;

import java.util.*;
import java.util.stream.Collectors;

public class FirstCompletelyPaintedRowOrColumn_2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> indexes = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            indexes.put(arr[i], i);
        }

        int result = Integer.MAX_VALUE;

        for (int[] ints : mat) {
            int maxRowIndex = Integer.MIN_VALUE;
            for (int anInt : ints) {
                maxRowIndex = Math.max(indexes.get(anInt), maxRowIndex);
            }
            result = Math.min(maxRowIndex, result);
        }

        for (int i = 0; i < mat[0].length; i++) {
            int maxColumnIndex = Integer.MIN_VALUE;
            for (int[] ints : mat) {
                maxColumnIndex = Math.max(indexes.get(ints[i]), maxColumnIndex);
            }
            result = Math.min(maxColumnIndex, result);
        }

        return result;
    }
}
