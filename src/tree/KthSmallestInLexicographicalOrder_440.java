package tree;

public class KthSmallestInLexicographicalOrder_440 {
    // imaging traversing a tree [1,10,11,12,13,2,3,4,5,6,7,8,9] with n = 13 and k = 2
    public int findKthNumber(int n, int k) {
        long num = 1;
        for (int i = 1; i < k;) {
            // find the number between num and num+1. e.g. 1 and 2 there are 4 numbers
            int gap = findNumberOfGap(num, num + 1, n);
            if (i + gap > k) {
                // go to deep
                i++;
                num *= 10;
            } else {
                // go to next sibling
                num++;
                i += gap;
            }
        }
        return (int) num;
    }

    private int findNumberOfGap(long start, long end, int max) {
        int gap = 0;
        while (start <= max) {
            gap += Math.min(max + 1, end) - start;
            start *= 10;
            end *= 10;
        }
        return gap;
    }
}
