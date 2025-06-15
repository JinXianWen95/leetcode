package other;

public class MaximumDifferenceByRemappingDigit_2566 {
    public int minMaxDifference(int num) {
        String number = String.valueOf(num);
        char firstNoNineChar = number.charAt(0);
        int i = 0;
        while (i < number.length() - 1 && firstNoNineChar == '9') {
            firstNoNineChar = number.charAt(++i);
        }
        return Integer.parseInt(number.replace(firstNoNineChar, '9')) -
                Integer.parseInt(number.replace(number.charAt(0), '0'));
    }
}
