package array;

public class HIndex2_275 {
    // binary search
    public int hIndex(int[] citations) {
        int ans = 0;
        int n = citations.length;
        int leftIndex = 0;
        int rightIndex = n-1;
        while(leftIndex <= rightIndex) {
            int mid = (leftIndex+rightIndex)/2;
            // n-mid is the number of papers that have more than citations[mid] citations
            if (citations[mid] >= n-mid) {
                ans = n-mid;
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return ans;
    }
}
