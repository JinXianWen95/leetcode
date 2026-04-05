package array;

public class RobotReturnToOrigin_657 {
    public boolean judgeCircle(String moves) {
        int nLeft = 0, nRight = 0, nUp = 0, nDown = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    nLeft++;
                    break;
                case 'R':
                    nRight++;
                    break;
                case 'U':
                    nUp++;
                    break;
                case 'D':
                    nDown++;
                    break;
            }
        }

        return nLeft == nRight && nUp == nDown;
    }
}
