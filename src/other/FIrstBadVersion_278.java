package other;

public class FIrstBadVersion_278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    // Binary search
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (isBadVersion(mid) && isBadVersion(mid-1) == Boolean.FALSE) {
                    return mid;
                } else if (isBadVersion(mid)) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            return 0;
        }
    }
}
