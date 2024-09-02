package array;

import java.util.Arrays;

public class FindTheStudentThatWillReplaceTheChalk_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        long sum = 0;
        for (int n : chalk) {
            sum += n;
        }
        long chalksNumber = ((long) k) % sum;
        while (chalksNumber >= 0) {
            chalksNumber -= chalk[i];
            i = (i+1) % chalk.length;
        }
        return i-1 < 0 ? chalk.length - 1 : i-1;
    }
}
