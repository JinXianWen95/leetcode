package other;

public class PushDominoes_838 {
    public static void main(String[] args) {
        new PushDominoes_838().pushDominoes("RR.L");
    }

    public String pushDominoes(String dominoes) {
        String oldString = dominoes;
        boolean isChanged = true;
        while (isChanged) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < dominoes.length(); index++) {
                char currentChar = oldString.charAt(index);
                if (currentChar == '.' ||
                        (currentChar == 'R' && (index + 1 >= oldString.length() || oldString.charAt(index+1) != '.')) ||
                        (currentChar == 'L' && (index - 1 < 0 || oldString.charAt(index-1) != '.'))) {
                    sb.append(currentChar);
                    continue;
                }

                if (currentChar == 'L' && (index - 2 < 0 || oldString.charAt(index-2) != 'R')) {
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(currentChar);
                    sb.append(currentChar);
                } else if (currentChar == 'R' && (index + 2 >= oldString.length() || oldString.charAt(index+2) != 'L')) {
                    sb.append(currentChar);
                    sb.append(currentChar);
                    index++;
                } else {
                    sb.append(currentChar);
                }
            }

            if (oldString.contentEquals(sb)) {
                isChanged = false;
            }

            oldString = sb.toString();
        }

        return oldString;
    }
}
