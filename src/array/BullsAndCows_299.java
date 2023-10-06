package array;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char secretDigit = secret.charAt(i);
            char guessDigit = guess.charAt(i);
            if (!Character.isDigit(secretDigit) || !Character.isDigit(guessDigit)) {
                throw new IllegalArgumentException("the input is wrong");
            }
            if (secretDigit == guessDigit) {
                bull++;
            } else {
                if (nums[secretDigit - '0']++ < 0) {
                    cow++;
                }
                if (nums[guessDigit - '0']-- > 0) {
                    cow++;
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}
