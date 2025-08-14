package other;

public class Largest3SameDigitNumberInString_2264 {
    public String largestGoodInteger(String num) {
        if (num.length() < 3) {
            return "";
        }

        String result = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i + 1) != num.charAt(i + 2)) {
                i++;
                continue;
            }

            if (num.charAt(i) == num.charAt(i + 1)) {
                String candidate = num.substring(i, i + 3);
                result = result.compareTo(candidate) < 0 ? candidate:result;
            }
        }

        return result;
    }
}
