package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow_1007 {
    public static void main(String[] args) {
        new MinimumDominoRotationsForEqualRow_1007().minDominoRotations(
                new int[] {2,1,2,4,2,2}, new int[] {5,2,6,2,3,2});
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> topMap = count(tops);
        Map<Integer, Integer> bottomMap = count(bottoms);

        int candidate = 0;
        boolean isTop = false;
        for (int i = 1; i <= 6; i++) {
            if (topMap.getOrDefault(i, 0) + bottomMap.getOrDefault(i, 0) >= tops.length) {
                isTop = topMap.get(i) >= bottomMap.get(i);
                candidate = i;
                break;
            }
        }

        if (candidate == 0) {
            return -1;
        }
        int count = 0;
        boolean found = true;
        for (int i = 0; i < tops.length; i++) {
            if (isTop) {
                if (tops[i] == candidate) {
                    continue;
                }
                if (bottoms[i] == candidate) {
                    count++;
                } else {
                    found = false;
                    break;
                }
            } else {
                if (bottoms[i] == candidate) {
                    continue;
                }
                if (tops[i] == candidate) {
                    count++;
                } else {
                    found = false;
                    break;
                }
            }
        }

        if (found) {
            return count;
        }
        return  -1;
    }

    private Map<Integer, Integer> count(int[] row) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : row) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
