package tree;

import java.util.Objects;
import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class BSTIterator {
        Stack<TreeNode> helper = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = helper.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext() {
            return !helper.isEmpty();
        }

        private void pushAll(TreeNode node) {
            while (Objects.nonNull(node)) {
                helper.push(node);
                node = node.left;
            }
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
