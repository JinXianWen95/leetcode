package tree;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseOddLevelsOfBinaryTree_2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Queue<TreeNode> currentLevelNodes = new LinkedList<>();
        currentLevelNodes.add(root);
        Stack<Integer> oddTreeNodeValues = new Stack<>();
        // since the tree is perfect we just need to check either it has left or right to understand if we reach the end.
        while (!currentLevelNodes.isEmpty()) {
            int currentLevelSize = currentLevelNodes.size();
            System.out.println(new ArrayList<>(oddTreeNodeValues));
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode temp = currentLevelNodes.poll();
                if (level % 2 == 0) {
                    if (temp.left != null) {
                        oddTreeNodeValues.push(temp.left.val);
                        oddTreeNodeValues.push(temp.right.val);
                    }
                } else {
                    temp.val = oddTreeNodeValues.pop();
                }

                if (temp.left != null) {
                    currentLevelNodes.offer(temp.left);
                    currentLevelNodes.offer(temp.right);
                }
            }
            level++;
        }
        return root;
    }
}
