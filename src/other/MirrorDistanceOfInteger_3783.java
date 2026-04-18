package other;

public class MirrorDistanceOfInteger_3783 {
    public int mirrorDistance(int n) {
        int reverseNum = Integer.parseInt(reverse(String.valueOf(n)));
        return Math.abs(n - reverseNum);
    }

    private String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] word = s.toCharArray();
        while (left < right) {
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;

            left++;
            right--;
        }

        return new String(word);
    }
}
