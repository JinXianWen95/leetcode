package other;

public class SumOfDigitsOfStringAfterConvert_1945 {
    public int getLucky(String s, int k) {
        String number = convert(s);
        for (int i = 0; i < k; i++) {
            number = sumDigit(number);
        }
        return Integer.parseInt(number);
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c-'a'+1);
        }
        return sb.toString();
    }

    private String sumDigit(String number) {
        long result = 0;
        for (char c : number.toCharArray()) {
            result += c - '0';
        }
        return String.valueOf(result);
    }
}
