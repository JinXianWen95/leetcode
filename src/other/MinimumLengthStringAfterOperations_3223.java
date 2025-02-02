package other;

public class MinimumLengthStringAfterOperations_3223 {
    public int minimumLength(String s) {
        int[] lettersCount = new int[26];
        for (char c : s.toCharArray()) {
            lettersCount[c-'a']++;
        }

        int result = 0;
        for (int j : lettersCount) {
            if (j <= 2) {
                result += j;
            } else {
                if (j % 2 == 0) {
                    result += 2;
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}
