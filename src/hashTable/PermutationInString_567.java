package hashTable;

public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // A string is a permutation of another string if their char frequencies is the same

        int[] frequenciesS1 = getFrequencies(s1);
        int[] frequencies = getFrequencies(s2.substring(0, s1.length()));

        int left = 0;
        int right = s1.length();
        while (right < s2.length()) {
            if (isEqual(frequenciesS1, frequencies)) {
                return true;
            }
            left++;
            right++;
            frequencies[s2.charAt(left-1) - 'a']--;
            if (right < s2.length()) {
                frequencies[s2.charAt(right) - 'a']++;
            }
        }
        return false;
    }

    private int[] getFrequencies(String s) {
        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }

    private boolean isEqual(int[] frequency1, int[] frequency2) {
        if (frequency1.length != frequency2.length) {
            return false;
        }

        for (int i = 0; i < frequency1.length; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        return true;
    }
}
