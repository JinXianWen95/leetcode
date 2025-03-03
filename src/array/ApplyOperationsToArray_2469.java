package array;

public class ApplyOperationsToArray_2469 {
  public int[] applyOperations(int[] nums) {
    int[] result = new int[nums.length];
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }

      if (i+1 < nums.length && nums[i] == nums[i+1]) {
        result[idx++] = nums[i] * 2;
        nums[i+1] = 0;
      } else {
        result[idx++] = nums[i];
      }
    }
    return result;
  }
}
