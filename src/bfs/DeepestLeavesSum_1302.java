package bfs;

import tree.TreeNode;

import java.util.Objects;

public class DeepestLeavesSum_1302 {
    int SUM = 0;
    public int deepestLeavesSum(TreeNode root) {
        int treeHeight = findHeight(root);
        sum(root, 1, treeHeight);
        return SUM;
    }

    private int findHeight(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        if (Objects.nonNull(root.left) || Objects.nonNull(root.right)) {
            return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
        }
        // if root does not have any descendent
        return 1;
    }

    private void sum(TreeNode root, int level, int height) {
        if (Objects.isNull(root)) {
            return;
        }

        if (level == height) {
            SUM += root.val;
            return;
        }

        sum(root.right, level+1, height);
        sum(root.left, level+1, height);

    }

}
