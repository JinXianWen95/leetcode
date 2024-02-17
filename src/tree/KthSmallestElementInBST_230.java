package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KthSmallestElementInBST_230 {
    // first idea: convert bst to ordered array and return kth element
    // second idea: don't need to convert all bst but stop to kth element
    // third idea: don't need to save bst values just search with counter;
    Integer result;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (Objects.nonNull(root.left)) {
            dfs(root.left);
        }
        if (--count == 0) {
            result = root.val;
            return;
        }
        if (Objects.nonNull(root.right)) {
            dfs(root.right);
        }
    }
}
