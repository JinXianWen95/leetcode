package dfs;

import tree.TreeNode;

import java.util.Objects;

public class HouseRobber3_337 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new int[] {0, 0};
        }
        // {includingNode, excludingNode} indicates the value robbed by including current node and the value robbed by excluding
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int including = node.val + left[1] + right[1]; // by including current node, we cannot include its sons
        int excluding = left[0] + right[0];
        return new int[] {including, excluding};

    }
}
