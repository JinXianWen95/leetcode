package array;

public class NumberOfSubarraysWithOddSum_1524 {
  public int numOfSubarrays(int[] arr) {
    final int MOD = 1000000007;
    int result = 0;
    int oddPrefixSum = 0;
    int evenPrefixSum = 1; // empty arr with sum 0
    int prefixSum = 0;

    // A subarray from index i to j has an odd sum
    // if the difference in the parity of the prefix sums at j and i-1 is odd.
    for (int num : arr) {
      prefixSum += num;
      // If two prefix sums have different parity (one is even, the other is odd), their difference will be odd, meaning the subarray sum is odd.
      if (prefixSum % 2 == 0) {
        evenPrefixSum++;
        //
        result = (result + oddPrefixSum) % MOD;
      } else {
        oddPrefixSum++;
        result = (result + evenPrefixSum) % MOD;
      }
    }

    return result;
  }
}
