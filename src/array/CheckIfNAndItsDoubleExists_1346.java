package array;

import java.util.*;

public class CheckIfNAndItsDoubleExists_1346 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            helper.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            Integer index = helper.get(2 * arr[i]);
            if (index != null && index != i) {
                return true;
            }
        }
        return false;
    }
}
