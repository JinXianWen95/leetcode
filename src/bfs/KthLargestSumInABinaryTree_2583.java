package bfs;

import tree.TreeNode;

import java.util.*;

public class KthLargestSumInABinaryTree_2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1L;
        }
        List<Long> levelSums = new ArrayList<>();

        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int currentSize = nodes.size();
            long currentLevelSum = 0L;
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = nodes.pollFirst();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    nodes.offerLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.offerLast(currentNode.right);
                }
            }
            levelSums.add(currentLevelSum);
        }

        if (levelSums.size() < k) {
            return -1;
        }

        levelSums.sort(Comparator.reverseOrder());
        return levelSums.get(k-1);
    }
}
