package array;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues_2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // max id of merged array
        int len = Math.max(nums1[nums1.length-1][0], nums2[nums2.length-1][0]);
        int idx1 = 0;
        int idx2 = 0;

        List<int[]> resultList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int n1 = 0;
            int n2 = 0;
            if (idx1 < nums1.length && nums1[idx1][0] == i+1) {
                n1 = nums1[idx1++][1];
            }

            if (idx2 < nums2.length && nums2[idx2][0] == i+1) {
                n2 = nums2[idx2++][1];
            }

            if (n1 + n2 == 0) {
                continue;
            }

            resultList.add(new int[]{i+1, n1+n2});
        }
        return resultList.toArray(new int[][]{});
    }
}
