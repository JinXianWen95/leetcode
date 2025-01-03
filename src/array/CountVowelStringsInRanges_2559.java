package array;

public class CountVowelStringsInRanges_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        /* brute force tle
        boolean[] isVowelWord = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isVowelWord(words[i])) {
                isVowelWord[i] = true;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (isVowelWord[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;

         */

        int[] prefixSum = new int[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowelWord(words[i])) {
                count++;
            }
            prefixSum[i] = count;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefixSum[queries[i][1]] - (queries[i][0] > 0 ? prefixSum[queries[i][0] - 1] : 0);
        }
        return result;
    }

    private boolean isVowelWord(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1));
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
