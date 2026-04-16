package hashTable;

import java.util.*;

public class ClosestEqualElementQueries_3488 {
    public static void main(String[] args) {
        new ClosestEqualElementQueries_3488().solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5});
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> numberAndIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberAndIndexes.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>(queries.length);
        for (int index : queries) {
            int queryNum = nums[index];
            List<Integer> indexes = numberAndIndexes.get(queryNum);
            if (indexes == null || indexes.size() == 1) {
                result.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(indexes, index);
            int d1 = Math.abs(index - indexes.get((pos - 1 + indexes.size()) % indexes.size()));
            int d2 = Math.abs(index - indexes.get((pos + 1) % indexes.size()));
            result.add(Math.min(
                    Math.min(d1, nums.length - d1),
                    Math.min(d2, nums.length - d2)));
        }

        return result;
    }
}
