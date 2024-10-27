package other;

public class MinimumStringLengthAfterRemovingSubstrings_2696 {
    public int minLength(String s) {

        StringBuilder sb = new StringBuilder(s);

        int indexOfAB = sb.indexOf("AB");
        if (indexOfAB != -1) {
            sb.delete(indexOfAB, indexOfAB + 2);
        }

        int indexOfCD = sb.indexOf("CD");
        if (indexOfCD != -1) {
            sb.delete(indexOfCD, indexOfCD + 2);
        }

        if (indexOfAB == -1 && indexOfCD == -1) {
            return sb.length();
        }

        return minLength(sb.toString());
    }
}
