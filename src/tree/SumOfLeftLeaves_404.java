package tree;

public class SumOfLeftLeaves_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return sum;
    }

    public void sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }

        sumOfLeftLeaves(node.left, true);
        sumOfLeftLeaves(node.right, false);
    }
}
