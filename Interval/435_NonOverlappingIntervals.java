class Solution {
    // Approach 1: Greedy Sorting by Ending
    // O(nlogn)
    // O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        // base case empty input so return 0
        if (intervals.length == 0) 
            return 0;
        
        // sort based on end
        Arrays.sort(intervals, new myComparator());
        
        int end = intervals[0][1];
        int count = 1; // count of good intervals
        for (int i = 1; i < intervals.length; i++) {
            // if intervals don't overlap, move on to next interval
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
            // if intervals overlap, discard the current and keep the previous interval
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}