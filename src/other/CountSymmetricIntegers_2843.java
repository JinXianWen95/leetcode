package other;

public class CountSymmetricIntegers_2843 {
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String num = Integer.toString(i);
            if (num.length() % 2 != 0) {
                continue;
            }

            if (sumDigit(num.substring(0, num.length()/2)) == sumDigit(num.substring(num.length()/2))) {
                result++;
            }
        }
        return result;
    }

    private int sumDigit(String s) {
        int i = Integer.parseInt(s);
        int result = 0;
        while (i > 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }
}
