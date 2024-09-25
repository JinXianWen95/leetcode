package hashTable;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix_3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> numberPrefixes = new HashSet<>();

        for (int num : arr1) {
            int temp = num;
            while (temp > 0) {
                numberPrefixes.add(temp);
                temp /= 10;
            }
        }

        int result = -1;
        for (int num : arr2) {
            int temp = num;
            int length = String.valueOf(temp).length();
            while (temp > 0) {
                if (numberPrefixes.contains(temp)) {
                    break;
                }
                temp /= 10;
                length--;
            }
            result = Math.max(result, length);
        }

        return result;
    }
}
