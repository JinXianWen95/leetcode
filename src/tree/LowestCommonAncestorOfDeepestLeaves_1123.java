package tree;

public class LowestCommonAncestorOfDeepestLeaves_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return postOrder(root, 0);
    }

    private TreeNode postOrder(TreeNode node, int currentDepth) {
        int leftDepth = findDepth(node.left, currentDepth+1);
        int rightDepth = findDepth(node.right, currentDepth+1);

        if (leftDepth == rightDepth) {
            return node;
        } else if (leftDepth > rightDepth) {
            return postOrder(node.left, currentDepth+1);
        } else {
            return postOrder(node.right, currentDepth+1);
        }

    }

    private int findDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return currentDepth;
        }

        return Math.max(findDepth(node.left, currentDepth+1), findDepth(node.right, currentDepth+1));
    }
}
