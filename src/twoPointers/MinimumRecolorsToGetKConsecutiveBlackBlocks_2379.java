package twoPointers;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks_2379 {
    public static void main(String[] args) {
        new MinimumRecolorsToGetKConsecutiveBlackBlocks_2379().minimumRecolors("WBWBBBW", 2);
    }
    public int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k) {
            return -1;
        }

        int blackCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
        }

        int result = k - blackCount;

        for (int i = 1; i + k - 1 < blocks.length(); i++) {
            if (blocks.charAt(i-1) == 'B') {
                blackCount--;
            }
            if (blocks.charAt(i+k-1) == 'B') {
                blackCount++;
            }
            result = Math.min(result, k-blackCount);

            if (result == 0) {
                return 0;
            }
        }

        return result;
    }
}
