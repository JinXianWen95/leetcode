package other;

import java.util.ArrayList;
import java.util.List;

public class ClosestPrimeNumbersInRange_2523 {

  public int[] closestPrimes(int left, int right) {
    Integer[] primes = sieveOfEratosthenes(left, right);

    int[] result = new int[] {-1, -1};

    if (primes.length < 2) {
      return result;
    }

    int minimumDifference = Integer.MAX_VALUE;
    for (int i = 1; i < primes.length; i++) {
      if (primes[i] - primes[i-1] < minimumDifference) {
        minimumDifference = primes[i] - primes[i-1];
        result[0] = primes[i-1];
        result[1] = primes[i];
      }
    }
    return result;
  }

  private Integer[] sieveOfEratosthenes(int left, int right) {
    boolean[] prime = new boolean[right + 1];
    for (int i = 0; i <= right; i++) {
      prime[i] = true;
    }

    prime[0] = false;
    prime[1] = false;
    for (int p = 2; p * p <= right; p++) {
      // If prime[p] is not changed, then it is a
      // prime
      if (prime[p]) {
        // Update all multiples of p greater than or
        // equal to the square of it numbers which
        // are multiple of p and are less than p^2
        // are already been marked.
        for (int i = p * p; i <= right; i += p)
          prime[i] = false;
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (prime[i]) {
        primes.add(i);
      }
    }

    return primes.toArray(new Integer[0]);
  }

}
