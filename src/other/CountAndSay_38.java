package other;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = generateNextSay(s);
        }
        return s;
    }

    public String generateNextSay(String s) {
        String nextString = "";
        int i = 0;
        int length = s.length();
        while (i < length) {
            char c = s.charAt(i++);
            int count = 1;
            while (i < length && s.charAt(i) == c) {
                count++;
                i++;
            }
            nextString += count + "" + c;
        }
        return nextString;
    }
}
