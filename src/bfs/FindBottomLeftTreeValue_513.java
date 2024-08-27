package bfs;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // dfs
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int result = 0;
        while (!deque.isEmpty()) {
            int currentLevelSize = deque.size();
            result = deque.peekFirst().val;
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode curr = deque.pollFirst();
                if (curr.left != null) {
                    deque.offerLast(curr.left);
                }
                if (curr.right != null) {
                    deque.offerLast(curr.right);
                }
            }
        }
        return result;
    }
}
