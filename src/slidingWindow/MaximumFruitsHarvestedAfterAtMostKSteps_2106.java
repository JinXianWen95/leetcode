package slidingWindow;

public class MaximumFruitsHarvestedAfterAtMostKSteps_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int sum = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while (left <= right && !isValidWindow(startPos, fruits[left][0], fruits[right][0], k)) {
                sum -= fruits[left++][1];
            }
            result = Math.max(result, sum);
        }

        return result;
    }

    private boolean isValidWindow(int startPoint, int left, int right, int k) {
        int goLeft = Math.abs(startPoint - left) + (right - left);
        int goRight = Math.abs(startPoint - right) + (right - left);
        return Math.min(goLeft, goRight) <= k;
    }
}
