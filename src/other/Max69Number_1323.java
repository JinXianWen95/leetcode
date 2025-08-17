package other;

public class Max69Number_1323 {
    public int maximum69Number (int num) {
        char[] number = String.valueOf(num).toCharArray();

        for (int i = 0; i < number.length; i++) {
            if (number[i] == '6') {
                number[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(number));
    }
}
