package twoPointers;

public class MakeStringSubsequenceUsingCyclicIncrement_2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetIdx = 0;
        for (char sourceChar : str1.toCharArray()) {
            if (targetIdx < str2.length()) {
                int difference = (str2.charAt(targetIdx) - sourceChar + 26) % 26;
                if (difference == 1 || difference == 0) {
                    targetIdx++;
                }
            }
        }
        return targetIdx == str2.length();
    }
}
