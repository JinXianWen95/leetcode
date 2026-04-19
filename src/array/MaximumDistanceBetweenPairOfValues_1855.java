package array;

public class MaximumDistanceBetweenPairOfValues_1855 {
    public static void main(String[] args) {
        new MaximumDistanceBetweenPairOfValues_1855().maxDistance(
                new int[]{2, 2, 2},
                new int[]{10, 10, 1});
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = findMaxIndexWithValueGreaterThan(nums1[i], i, nums2);
            result = Math.max(result, j - i);
        }
        return result;
    }

    // more concise way
    public int maxDistance1(int[] nums1, int[] nums2) {
        int i, j;

        for (i = 0, j = 0; i < nums1.length && j < nums2.length; j++) { // j increases every iteration
            if (nums1[i] > nums2[j]) {
                i++; // increase i only when necessary
            }
        }
        return Math.max(0, j - i - 1); // -1 because last loop j has increased by 1 to break the condition.
    }

    private int findMaxIndexWithValueGreaterThan(int target, int startIndex, int[] nums) {
        if (startIndex >= nums.length) {
            return -1;
        }

        int left = startIndex;
        int right = nums.length - 1;

        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
