package other;

public class DivideStringIntoGroupsOfSizeK_2138 {
    public String[] divideString(String s, int k, char fill) {
        String[] result = new String[(int) Math.ceil((double) s.length() /k)];
        int index = 0;
        int sIndex = 0;
        while (sIndex+k < s.length()) {
            result[index++] = s.substring(sIndex, sIndex+k);
            sIndex += k;
        }

        if (sIndex < s.length()) {
            String last = s.substring(sIndex);
            result[index] = last + String.valueOf(fill).repeat(k-last.length());
        }
        return result;
    }
}
