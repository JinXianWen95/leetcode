package other;

public class MinDeletionsToMakeStringKSpecial_3085 {
    public int minimumDeletions(String word, int k) {
        // Note that we can make only deletions.
        // The objective is to make maxFrequency - minFrequency <= k
        int[] frequencies = new int[26];

        for (char c : word.toCharArray()) {
            frequencies[c-'a']++;
        }

        int result = Integer.MAX_VALUE;
        for (int frequency : frequencies) {
            if (frequency == 0) {
                continue;
            }

            int currentCandidate = 0;
            for (int currentFrequency : frequencies) {
                if (currentFrequency == 0) {
                    continue;
                }
                if (currentFrequency < frequency) {
                    currentCandidate += currentFrequency;
                } else if (currentFrequency > (frequency + k)){
                    currentCandidate += currentFrequency-(frequency+k);
                }
            }
            result = Math.min(result, currentCandidate);
        }
        return result;
    }
}
