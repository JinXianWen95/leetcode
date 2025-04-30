package array;

public class CountSubarraysOfLength3WithCondition_3392 {
    public int countSubarrays(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i-1] + nums[i+1]) == nums[i] / 2.0) {
                result++;
            }
        }
        return result;
    }
}
