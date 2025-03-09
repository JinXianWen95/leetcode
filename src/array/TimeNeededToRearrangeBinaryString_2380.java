package array;

public class TimeNeededToRearrangeBinaryString_2380 {
    public static void main(String[] args) {
        new TimeNeededToRearrangeBinaryString_2380().secondsToRemoveOccurrences("001011");
    }
    public int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        while (true) {
            StringBuilder transformedSb = new StringBuilder();
            boolean terminate = true;
            for (int i = 0; i < sb.length(); i++) {
                if (i < sb.length() - 1 && sb.charAt(i) == '0' && sb.charAt(i+1) == '1') {
                    transformedSb.append("10");
                    i++;
                    terminate = false;
                } else {
                    transformedSb.append(sb.charAt(i));
                }
            }
            if (terminate) {
                break;
            }
            result++;
            sb = transformedSb;
        }

        return result;
    }
}
