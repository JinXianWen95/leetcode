package bfs;

import tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumNumberOfSwapsToSortTreeByLevel_2471 {
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(root);

        while (!helper.isEmpty()) {
            int levelSize = helper.size();
            int[] levelValues = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = helper.poll();
                levelValues[i] = node.val;
                if (Objects.nonNull(node.left)) {
                    helper.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    helper.offer(node.right);
                }
            }
            result += minimumSwap(levelValues);
        }
        return result;

    }

    private int minimumSwap(int[] values) {
        int[] sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);

        Map<Integer, Integer> valAndIndex = new TreeMap<>();
        for (int i = 0; i < values.length; i++) {
            valAndIndex.put(values[i], i);
        }

        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != sortedValues[i]) {
                int correctPosition = valAndIndex.get(sortedValues[i]);
                valAndIndex.put(values[i], correctPosition);
                values[correctPosition] = values[i];

                result++;
            }
        }
        return result;
    }
}
