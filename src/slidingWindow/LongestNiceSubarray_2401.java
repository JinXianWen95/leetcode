package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class LongestNiceSubarray_2401 {
  public static void main(String[] args) {
    new LongestNiceSubarray_2401().longestNiceSubarray(new int[] {1,3,8,48,10});
  }
  public int longestNiceSubarray(int[] nums) {
    int result = 1;
    int leftPointer = 0;
    int rightPointer = 1;

    while (leftPointer < nums.length && rightPointer < nums.length) {
      boolean validNumber = true;
      int index;
      for (index = leftPointer; index <= rightPointer; index++) {
        if (index != rightPointer && (nums[index] & nums[rightPointer]) != 0) {
          validNumber = false;
          break;
        }
      }

      if (validNumber) {
        rightPointer++;
        result = Math.max(result, rightPointer - leftPointer);
      } else {
        leftPointer = index == leftPointer ? index + 1 : index;
      }
    }
    return result;
  }
}
