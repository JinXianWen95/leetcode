package other;

public class ClearDigits_3174 {
  public String clearDigits(String s) {

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (isDigit(chars[i])) {
        for (int j = i - 1; j >= 0; j--) {
          if (chars[j] != 'X' && !isDigit(chars[j])) {
            chars[j] = 'X';
            chars[i] = 'X';
            break;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : chars) {
      if (c != 'X') {
        sb.append(c);
      }
    }
    return sb.toString();

  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }
}
