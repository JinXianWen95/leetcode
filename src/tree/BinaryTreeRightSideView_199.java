package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeRightSideView_199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 1);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        if (maxLevel < level) {
            result.add(node.val);
            maxLevel++;
        }
        helper(node.right, result, level+1);
        helper(node.left, result, level+1);
    }

}
