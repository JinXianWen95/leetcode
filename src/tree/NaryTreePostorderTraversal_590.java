package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal_590 {
    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> postorder(Node root) {
            helper(root);
            return result;
        }

        public void helper(Node node) {
            if (node == null) {
                return;
            }
            for (Node child : node.children) {
                helper(child);
            }
            result.add(node.val);

        }
    }
}
