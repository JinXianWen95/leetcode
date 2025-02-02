package array;

import java.util.HashSet;
import java.util.Set;

public class FindTheCommonPrefixOfTwoArrays_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> a = new HashSet<>(n);
        Set<Integer> b = new HashSet<>(n);

        int[] result = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            a.add(A[i]);
            b.add(B[i]);
            if (a.contains(B[i]) && b.contains(A[i]) && B[i] != A[i]) {
                count += 2;
            } else if (a.contains(B[i]) || b.contains(A[i])) {
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
