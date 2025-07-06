package array;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInArray_1394 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int num : arr) {
            numbers.compute(num, (k, v) -> (v == null) ? 1 : v+1);
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (entry.getValue().equals(entry.getKey()) && entry.getKey() > result) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
