package other;

public class UglyNumber_263 {
    public boolean isUgly(int n) {
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
}
