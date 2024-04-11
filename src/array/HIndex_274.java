package array;

import java.util.Arrays;

public class HIndex_274 {
    // solution 1: O(nLog(n)) for sort with O(1) space
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

    // solution 2: O(n) if we use counting sort with O(n) space
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n+1];
        for (int citation : citations) {
            // the paper with citations more than n are counted as n
            if (citation > n) {
                counts[n]++;
            } else {
                counts[citation]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0 ; i--) {
            count += counts[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
