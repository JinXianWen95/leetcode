package dfs;

import list.linkedList.ListNode;
import tree.TreeNode;

public class LinkedListInBinaryTree_1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return callDfs(head, root);
    }

    private boolean callDfs(ListNode head, TreeNode root) {
        // if the path starting from head node matches root
        if (dfs(head, root)) {
            return true;
        }
        // go ahead with left and right nodes
        if (root != null) {
            if (callDfs(head, root.left) || callDfs(head, root.right)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null || head.val != root.val) {
            return false;
        }

        if (dfs(head.next, root.left) || dfs(head.next, root.right)) {
            return true;
        }

        return false;
    }
}
