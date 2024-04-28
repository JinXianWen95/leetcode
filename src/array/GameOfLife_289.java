package array;

import java.util.Arrays;

public class GameOfLife_289 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife_289().gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] tempBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = checkAlive(i, j, board);
            }
        }
        copy(board, tempBoard);
    }

    private int checkAlive(int i, int j, int[][] board) {
        int liveNeighbors = 0;
        int m = board.length;
        int n = board[0].length;
        for (int k = Math.max(0, i - 1); k <= Math.min(m-1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(n-1, j + 1); l++) {
                // avoid counting the current cell but only neighbors
                if (k == i && l == j) {
                    continue;
                }
                if (board[k][l] == 1) {
                    liveNeighbors++;
                }

            }
        }
        // liveliness rule
        if (board[i][j] == 1) {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return 0;
            } else {
                return 1;
            }
        } else if (board[i][j] == 0 && liveNeighbors == 3) {
            return 1;
        }
        return 0;
    }

    private void copy(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < tempBoard.length; i++) {
            int[] aMatrix = tempBoard[i];
            int aLength = aMatrix.length;
            board[i] = new int[aLength];
            System.arraycopy(aMatrix, 0, board[i], 0, aLength);
        }
    }
}
