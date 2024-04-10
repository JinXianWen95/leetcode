package array;

import java.util.Arrays;

public class HIndex_274 {
    // solution 1: O(nLog(n)) for sort
    // solution 2: O(n) if we use counting sort
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = citations.length-1; i >= 0 ; i--) {
            if (citations[i] >= hIndex+1) {
                hIndex++;
            }
        }
        return hIndex;
    }
}
