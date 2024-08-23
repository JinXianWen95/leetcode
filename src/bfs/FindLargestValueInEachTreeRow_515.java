package bfs;

import tree.TreeNode;

import java.util.*;

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> helper = new ArrayDeque<>();
        helper.add(root);

        while (!helper.isEmpty()) {
            int rowSize = helper.size();
            int max = Integer.MIN_VALUE;
            while(rowSize-- > 0) {
                TreeNode node = helper.pollFirst();
                max = Math.max(max, node.val);
                if (Objects.nonNull(node.left)) {
                    helper.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    helper.addLast(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
