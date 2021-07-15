// 7/15/2021

class Solution {
    // Approach 1: brute force
    // O(n^2)
    // O(1)
    // check all combinations in pairs and make sure there are no intercepts
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (!overlap(intervals[i], intervals[j])) return false;
            }
        }
        return true;
    }
    
    // helper function that checks if there are overlap between 2 meeting times
    // two intervals overlap if min end of 1 interval is greater than max start of another interval.
    private boolean overlap(int[] int1, int[] int2) {
        return (Math.max(int1[0], int2[0]) < Math.min(int1[1], int2[1]));
    }
    
    // Approach 2: sort and find interval
    // O(n)
    // O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort based on start time
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        
        // check if any end time is greater than the next interval's start time
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) 
                return false;
        }
        
        return true;
    }
}