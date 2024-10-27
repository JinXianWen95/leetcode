package array;

import java.util.*;

public class RankTransformOfAnArray_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] helper = Arrays.stream(arr).distinct().sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>(helper.length);
        for (int i = 0; i < helper.length; i++) {
            map.put(helper[i], i+1);
        }

        int[] rank = new int[arr.length];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = map.get(arr[i]);
        }

        return rank;
    }
}
