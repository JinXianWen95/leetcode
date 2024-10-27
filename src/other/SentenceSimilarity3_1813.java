package other;

public class SentenceSimilarity3_1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        // make sentence 1 be longer than sentence 2 if it's not already
        if (s1.length < s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int start = 0;
        int end = 0;

        // find prefix
        for (int i = 0; i < s2.length; i++) {
            if (s1[i].equals(s2[i])) {
                start++;
            } else {
                break;
            }
        }

        // find suffix
        while (end < s2.length && s1[s1.length - end - 1].equals(s2[s2.length - end -1])) {
            end++;
        }

        // in this case we could insert a sentence in s2 to make it equal to s1
        return start + end >= s2.length;
    }
}
