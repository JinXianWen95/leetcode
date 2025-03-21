package other;

public class CircularSentence_2490 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)) {
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length()-1);
    }
}
