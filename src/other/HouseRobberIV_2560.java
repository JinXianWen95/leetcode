package other;

import java.util.Arrays;

public class HouseRobberIV_2560 {
    public int minCapability(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = 1;

        while (min < max) {
            int mid = (min + max) / 2;
            int robbedHouse = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    robbedHouse++;
                    i++; // skip the next house
                }
            }

            if (robbedHouse >= k) {
                max = mid; // we can decrease max
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
