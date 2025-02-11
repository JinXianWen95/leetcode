package array;

public class CheckIfOneSwapMakeStringsEqual_1790 {
    public static void main(String[] args) {
        new CheckIfOneSwapMakeStringsEqual_1790().areAlmostEqual("bank", "kanb");
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int differenceCount = 0;
        Character c1 = null;
        Character c2 = null;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differenceCount++;
                if (differenceCount > 2 || (differenceCount == 2 && (s1.charAt(i) != c2 || s2.charAt(i) != c1))) {
                    return false;
                }
                c1 = s1.charAt(i);
                c2 = s2.charAt(i);
            }
        }

        return differenceCount != 1;
    }
}
