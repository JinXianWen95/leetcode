package slidingWindow;

public class TakeKOfEachCharFromLeftAndRight_2516 {
    // the problem could be translated to "find the max subarray without such there are still at least k chars of each type"
    public int takeCharacters(String s, int k) {
        if (s.length() < k * 3) {
            return -1;
        }

        int[] dict = new int[3];

        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        if (!isValid(dict, k)) {
            return -1;
        }

        int left = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            dict[s.charAt(right) - 'a']--;
            while (!isValid(dict, k)) {
                dict[s.charAt(left) - 'a']++;
                left++;
            }
            result = Math.min(result, s.length() - (right - left + 1));
        }

        return result;
    }

    private boolean isValid(int[] dict, int k) {
        return dict[0] >= k && dict[1] >= k && dict[2] >= k;
    }
}
