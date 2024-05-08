package other;

public class AddDigits_258 {
    public int addDigits(int num) {
        // the sum of digits of a number is mod 9 if num is not divisible by 9
        if (num % 9 == 0 && num != 0) {
            return 9;
        }
        if (num > 9) {
            return num % 9;
        }
        return num;
    }
}
