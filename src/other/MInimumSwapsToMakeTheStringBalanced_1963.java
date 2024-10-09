package other;

public class MInimumSwapsToMakeTheStringBalanced_1963 {
    public int minSwaps(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else if (c == ']' && open > 0) {
                open--;
            }
        }
        return (open + 1) / 2;
    }
}
