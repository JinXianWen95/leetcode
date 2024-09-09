package other;

public class NumberComplement_476_1009 {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int length = Integer.toBinaryString(num).length();
        int mask = (1 << length) - 1;
        return num ^ mask;
    }
}
