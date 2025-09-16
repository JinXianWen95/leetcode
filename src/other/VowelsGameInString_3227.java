package other;

public class VowelsGameInString_3227 {
    public boolean doesAliceWin(String s) {
        // alice loses only if the initial string has no vowel
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}
