package array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray_2053 {
    public String kthDistinct(String[] arr, int k) {
        // linked hash map preserves the order of insertion
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        int distinctCounter = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                distinctCounter++;
            }
            if (distinctCounter == k) {
                return entry.getKey();
            }
        }
        return "";
    }
}
