package other;


import tree.TreeNode;

import java.util.*;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, "");
        return  result;
    }

    public void helper(TreeNode node, List<String> list, String path) {
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            list.add(path + node.val);
            return;
        }
        path = path + node.val + "->";
        if (Objects.nonNull(node.left)) {
            helper(node.left, list, path);
        }
        if (Objects.nonNull(node.right)) {
            helper(node.right, list, path);
        }
    }
}
