package array;

public class CountHillsAndValleysInArray_2210 {
    public int countHillValley(int[] nums) {
        int nHills = 0;
        int nValleys = 0;

        int lastLeft = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == lastLeft || nums[i] == nums[i+1]) {
                continue;
            }

            if (nums[i] > lastLeft && nums[i] > nums[i+1]) {
                nHills++;
            } else if (nums[i] < lastLeft && nums[i] < nums[i+1]) {
                nValleys++;
            }
            lastLeft = nums[i];
        }

        return nHills + nValleys;
    }
}
