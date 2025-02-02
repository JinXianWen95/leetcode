package array;

public class CheckIfArraySortedAndRotated_1752 {
    public boolean check(int[] nums) {
        int startIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) {
            return true;
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[(startIndex+i) % nums.length] > nums[(startIndex+i+1) % nums.length]) {
                return false;
            }
        }
        return true;
    }
}
