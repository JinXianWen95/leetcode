package array;

public class PartitionArrayAccordingToPivot_2161 {
  public int[] pivotArray(int[] nums, int pivot) {
    int lessThanCount = 0;
    int equalThanCount = 0;

    for (int num : nums) {
      if (num == pivot) {
        equalThanCount++;
      } else if (num < pivot) {
        lessThanCount++;
      } else {
      }
    }

    int[] result = new int[nums.length];
    int lessThanIdx = 0;
    int equalThanIdx = lessThanIdx + lessThanCount;
    int greaterThanIdx = equalThanIdx + equalThanCount;

    for (int num : nums) {
      if (num == pivot) {
        result[equalThanIdx++] = num;
      } else if (num < pivot) {
        result[lessThanIdx++] = num;
      } else {
        result[greaterThanIdx++] = num;
      }
    }

    return result;
  }
}
