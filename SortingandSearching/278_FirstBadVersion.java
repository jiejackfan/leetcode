// April 9 2021

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        // linear scan
        // O(n) O(1)
        public int firstBadVersion(int n) {
            for (int i = 1; i <= n; i++) {
                if (isBadVersion(i)) {
                    return i;
                }
            }
            return n;
        }
        
        // Binary Search
        // O(ln n) O(1)
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }