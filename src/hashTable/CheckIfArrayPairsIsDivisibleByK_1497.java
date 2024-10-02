package hashTable;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsIsDivisibleByK_1497 {
    public boolean canArrange(int[] arr, int k) {
        // For two integers ( a ) and ( b ), their sum ( (a + b) ) is divisible by ( k )
        // if the sum of their remainders when divided by ( k ) is either ( k ) or ( 0 ).
        // This leads us to consider the remainders of each element when divided by ( k )
        int[] frequencies = new int[k];

        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            frequencies[rem]++;
        }

        // If a number has a remainder of ( 0 ), it must be paired with another number that also has a remainder of ( 0 )
        if (frequencies[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (frequencies[i] != frequencies[k-i]) {
                return false;
            }
        }

        return true;
    }
}
