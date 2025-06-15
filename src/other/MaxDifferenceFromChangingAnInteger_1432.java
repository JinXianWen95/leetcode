package other;

public class MaxDifferenceFromChangingAnInteger_1432 {
    public static void main(String[] args) {
        new MaxDifferenceFromChangingAnInteger_1432().maxDiff(123456);
    }

    public int maxDiff(int num) {
        String number = String.valueOf(num);
        int indexOfFirstNoOneChar = getFirstCharAfterGivenChar(number, '1', true);
        int minimum = num;
        if (indexOfFirstNoOneChar != -1) {
            minimum = indexOfFirstNoOneChar == 0 ?
                    Integer.parseInt(number.replace(number.charAt(indexOfFirstNoOneChar), '1')) :
                    Integer.parseInt(number.replace(number.charAt(indexOfFirstNoOneChar), '0'));
        }

        int maximum = num;
        int indexOfFirstNoNineChar = getFirstCharAfterGivenChar(number, '9', false);
        if (indexOfFirstNoNineChar != -1) {
            maximum = Integer.parseInt(number.replace(number.charAt(indexOfFirstNoNineChar), '9'));
        }
        return maximum - minimum;
    }

    private int getFirstCharAfterGivenChar(String number, char character, boolean noZero) {
        char result = number.charAt(0);
        int i = 0;
        while (result == character && i < number.length() - 1) {
            char temp = number.charAt(++i);
            if (noZero && temp == '0') {
                continue;
            }
            result = temp;
        }
        if (result != character) {
            return i;
        }
        return -1;
    }

}
