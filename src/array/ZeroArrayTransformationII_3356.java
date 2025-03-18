package array;

import java.util.HashMap;
import java.util.Map;

public class ZeroArrayTransformationII_3356 {
  public static void main(String[] args) {
    new ZeroArrayTransformationII_3356()
        .minZeroArray(new int[]{2,0,2}, new int[][] {{0,2,1}, {0,2,1}, {1,1,3}});
  }
  public int minZeroArray(int[] nums, int[][] queries) {

    // Time exceeded
    /*
    Map<Integer, Integer> indexAndValue = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        indexAndValue.put(i, nums[i]);
      }
    }

    if (indexAndValue.isEmpty()) {
      return 0;
    }

    int result = 0;
    for (int[] query : queries) {
      for (int i = query[0]; i <= query[1]; i++) {
        Integer value = indexAndValue.get(i);
        if (value != null) {
          value -= Math.min(value, query[2]);
          if (value == 0) {
            indexAndValue.remove(i);
          } else {
            indexAndValue.put(i, value);
          }
        }
      }
      result++;

      if (indexAndValue.isEmpty()) {
        break;
      }
    }

    return indexAndValue.isEmpty() ? result : -1;

     */

    // line sweep + difference array
    // The key idea is to store the changes at the boundaries of the range rather than updating every element inside it.
    // For a query [left,right,val], we add val at index left, and subtract val at index right + 1.
    // When we later compute the prefix sum of this difference array, it reconstructs the actual values efficiently

    int k = 0;
    int[] differenceArray = new int[nums.length + 1];
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      while (sum + differenceArray[i] < nums[i]) { // sum + differenceArray = ith value after result query
        k++;

        if (k > queries.length) { // applied all queries and not satisfying the zero array
          return -1;
        }

        if (i <= queries[k-1][1]) { // right pointer
          differenceArray[Math.max(queries[k-1][0], i)] += queries[k-1][2];
          differenceArray[queries[k-1][1]+1] -= queries[k-1][2];
        }
      }

      sum += differenceArray[i];
    }
    return k;
  }
}
