package other;

import java.util.Map;
import java.util.TreeMap;

public class FindingPairsWithCertainSum_1865 {

    public static void main(String[] args) {
        FindingPairsWithCertainSum_1865 tester = new FindingPairsWithCertainSum_1865(
                new int[] {1, 1, 2, 2, 2, 3},
                new int[] {1, 4, 5, 2, 5, 4}
        );
        tester.count(7);
        tester.add(3, 2);
        tester.count(8);
    }

    private Map<Integer, Integer> numberAndFrequency1;
    private Map<Integer, Integer> numberAndFrequency2;
    private int[] nums2;

    public FindingPairsWithCertainSum_1865(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        numberAndFrequency1 = createMap(nums1);
        numberAndFrequency2 = createMap(nums2);
    }

    public void add(int index, int val) {
        if (numberAndFrequency2.getOrDefault(nums2[index], 0 ) > 1) {
            numberAndFrequency2.compute(nums2[index], (k, v) -> v-1);
        } else {
            numberAndFrequency2.remove(nums2[index]);
        }
        nums2[index] += val;
        numberAndFrequency2.compute(nums2[index], (k, v) -> (v == null) ? 1 : v+1);
    }

    public int count(int tot) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : numberAndFrequency1.entrySet()) {
            Integer occurrence = numberAndFrequency2.get(tot - entry.getKey());
            if (occurrence != null) {
                result = result + entry.getValue() * occurrence;
            }
        }
        return result;
    }

    private Map<Integer, Integer> createMap(int[] nums) {
        Map<Integer, Integer> returnMap = new TreeMap<>();
        for (int num : nums) {
            returnMap.compute(num, (k, v) -> (v == null) ? 1 : v+1);
        }
        return returnMap;
    }
}
