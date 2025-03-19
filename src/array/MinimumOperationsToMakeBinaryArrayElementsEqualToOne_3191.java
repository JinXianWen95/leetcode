package array;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOne_3191 {
  public static void main(String[] args) {
    new MinimumOperationsToMakeBinaryArrayElementsEqualToOne_3191().minOperations(new int[] {1,0,0,1,1,1,0,1,1,1});
  }

  public int minOperations(int[] nums) {
    // greedy
    int currentIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        currentIndex = i;
        break;
      }
    }

    if (currentIndex == -1) {
      return 0;
    }

    int result = 0;

    while (currentIndex < nums.length - 2) {
      result++;
      nums[currentIndex] = nums[currentIndex] == 0 ? 1 : 0;
      nums[currentIndex + 1] = nums[currentIndex+1] == 0 ? 1 : 0;
      nums[currentIndex + 2] = nums[currentIndex+2] == 0 ? 1 : 0;

      while(currentIndex < nums.length && nums[currentIndex] == 1) {
        currentIndex++;
      }
    }

    if (nums[nums.length-1] == 0 || nums[nums.length-2] == 0) {
      return -1;
    }
    return result;
  }
}
