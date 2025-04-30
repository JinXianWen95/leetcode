package array;

public class FindNumbersWithEvenNumberOfDigits_1295 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
