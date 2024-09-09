package array;

import list.linkedList.ListNode;

import java.util.Arrays;

public class SpiralMatrix4_2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = m-1;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }

        while (head != null) {
            for (int i = left; i <= right && head != null; i++) {
                result[top][i] = head.val;
                head = head.next;
            }
            top++;

            for (int i = top; i <= down && head != null; i++) {
                result[i][right] = head.val;
                head = head.next;
            }
            right--;

            for (int i = right; i >= left && head != null; i--) {
                result[down][i] = head.val;
                head = head.next;
            }
            down--;

            for (int i = down; i >= top && head != null; i--) {
                result[i][left] = head.val;
                head = head.next;
            }
            left++;
        }
        return result;
    }
}
