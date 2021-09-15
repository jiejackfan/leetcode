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
        
        // Approach 1: Binary Search
        // Adopt the general binary search frame, if bad version, search the left part
        // if good version, search the right part
        // O(logn) O(1)
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    ans = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }