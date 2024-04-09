package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class UglyNumber2_264 {
    // solution 1: brute force -> time limit exceed
    /*
    public int nthUglyNumber(int n) {
        int count = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i) && ++count == n) {
                return i;
            }
        }
        System.out.printf("Not found %dth ugly number", n);
        return -1;
    }

    private boolean isUgly(int n) {
        // ugly number must be positive
        if (n < 0) {
            return false;
        }
        int denominator = 2;
        while (n > 1) {
            if (n % denominator == 0) {
                n /= denominator;
                denominator = 2;
            } else {
                denominator++;
            }
            if (denominator > 5) {
                return false;
            }
        }
        return true;
    }
     */

    // solution 2: every ugly number is multiple of 2, 3 and 5
    // Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1L);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            long uglyNumber = uglyNumbers.pollFirst();
            ans = uglyNumber;
            uglyNumbers.add(ans*2);
            uglyNumbers.add(ans*3);
            uglyNumbers.add(ans*5);
        }
        return (int) ans;
    }
}
