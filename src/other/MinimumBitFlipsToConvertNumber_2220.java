package other;

public class MinimumBitFlipsToConvertNumber_2220 {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;

        int result = 0;
        while (xor > 0) {
            result += xor & 1;

            xor >>= 1;
        }
        return result;
    }
}
