package other;

public class CountingWordsWithGivenPrefix_2185 {
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.length() >= pref.length() && word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
