package other;

public class ShiftingLetters2_2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        /* TLE
        int[] shiftsByIndex = new int[s.length()];

        for (int[] shift : shifts) {
            for (int j = shift[0]; j <= shift[1]; j++) {
                if (shift[2] == 0) { // backward
                    shiftsByIndex[j]--;
                } else {
                    shiftsByIndex[j]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (shiftsByIndex[i] >= 0) {
                sb.append((char) ((s.charAt(i) - 'a' + shiftsByIndex[i]) % 26 + 'a'));
            } else {
                sb.append((char) ((s.charAt(i) - 'a' + 26 + shiftsByIndex[i] % 26) % 26 + 'a'));
            }
        }
        return sb.toString();

         */

        int[] shiftsPrefixSum = buildShifts(shifts, s.length());
        StringBuilder sb = new StringBuilder(s.length());
        int shift = 0;
        for (int i = 0; i < s.length(); i++) {
            shift = (shift + shiftsPrefixSum[i]) % 26;
            if (shift < 0) {
                shift += 26;
            }
            sb.append((char) ((s.charAt(i) - 'a' + shift) % 26 + 'a'));
        }
        return sb.toString();
    }

    private int[] buildShifts(int[][] shifts, int n) {
        int[] shiftsPrefixSum = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 0) { // backward
                shiftsPrefixSum[shift[0]]--;
                if (shift[1] + 1 < n) {
                    shiftsPrefixSum[shift[1]+1]++;
                }
            } else {
                shiftsPrefixSum[shift[0]]++;
                if (shift[1] + 1 < n) {
                    shiftsPrefixSum[shift[1]+1]--;
                }
            }
        }
        return shiftsPrefixSum;
    }
}
