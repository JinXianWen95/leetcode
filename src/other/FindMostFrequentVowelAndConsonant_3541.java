package other;

public class FindMostFrequentVowelAndConsonant_3541 {
    public int maxFreqSum(String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        int maxFreqVowel = 0;
        int maxFreqConsonant = 0;

        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 'e' - 'a' || i == 'i' - 'a' || i == 'o' - 'a' || i == 'u' - 'a') {
                maxFreqVowel = Math.max(maxFreqVowel, frequencies[i]);
            } else {
                maxFreqConsonant = Math.max(maxFreqConsonant, frequencies[i]);
            }
        }

        return maxFreqVowel + maxFreqConsonant;
    }
}
