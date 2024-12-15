package slidingWindow;

public class ContinuousArrays_2762 {
    public static void main(String[] args) {
        new ContinuousArrays_2762().continuousSubarrays(new int[]{5,4,2,4});
    }
    public long continuousSubarrays(int[] nums) {
        // time exceeds 2129/2135
        /*
        int min = nums[0];
        int max = nums[0];

        long result = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < nums.length) {
            if (rightIndex >= nums.length ||
                    Math.abs(nums[rightIndex]-max) > 2 || Math.abs(nums[rightIndex] - min) > 2) {
                leftIndex++;
                rightIndex = leftIndex;
                if (leftIndex < nums.length) {
                    min = nums[leftIndex];
                    max = nums[rightIndex];
                }
            } else {
                result++;
                max = Math.max(max, nums[rightIndex]);
                min = Math.min(min, nums[rightIndex]);
                rightIndex++;
            }
        }
        return result;

         */

        int leftIndex = 0;
        int rightIndex = 0;
        int min = nums[leftIndex];
        int max = nums[leftIndex];

        long result = 0;

        for (; rightIndex < nums.length; rightIndex++) {
            min = Math.min(min, nums[rightIndex]);
            max = Math.max(max, nums[rightIndex]);

            if (max - min > 2) {
                long windowSize = rightIndex - leftIndex;
                result += windowSize * (windowSize + 1) / 2;

                leftIndex = rightIndex;
                min = nums[leftIndex];
                max = nums[leftIndex];

                while (leftIndex > 0 && Math.abs(nums[rightIndex] -  nums[leftIndex-1]) <= 2) {
                    leftIndex--;
                }

                min = Math.min(min, nums[leftIndex]);
                max = Math.max(max, nums[leftIndex]);

                if (leftIndex < rightIndex) {
                    windowSize = rightIndex - leftIndex;
                    result -= windowSize * (windowSize+1) / 2;
                }
            }
        }

        long windowSize = rightIndex - leftIndex;
        result += windowSize * (windowSize + 1) / 2;

        return result;

    }
}
