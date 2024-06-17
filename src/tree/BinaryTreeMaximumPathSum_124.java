package tree;

public class BinaryTreeMaximumPathSum_124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }

    public int maxPathSumHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        // the compare between left and right is done implicitly by Math.max(ans, max)
        int max = Math.max(root.val, Math.max(Math.max(root.val+left, root.val+right), root.val+left+right));
        ans = Math.max(ans, max);

        return Math.max(root.val, Math.max(root.val+left, root.val+right));
    }
}
