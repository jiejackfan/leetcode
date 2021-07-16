//7/15/2021

class Solution {
    // Approach 1: Min heap implemented using priority queue
    // Sort meeting by start time, create a min heap to keep track of all meeting rooms.
    // if top of min heap (meeting with smallest end time) can be removed, we remove it and add new meeting
    // at the end, the size of min heap will be max room used.
    // O(nlogn + n) nlogn sorting time complexity
    // O(n) priority queue space
    public int minMeetingRooms(int[][] intervals) {
        // check for edge case
        if (intervals.length == 0) return 0;
        
        // init min heap using priority queue
        // init size = length of interval, comparator interface to order min heap (small to big)
        PriorityQueue<Integer> allocator = 
            new PriorityQueue<Integer> (
                intervals.length, 
               new Comparator<Integer> (){
                   public int compare(Integer a, Integer b) {
                       return a - b;
                   }
               });

        // Sort intervals based on start time, also use comparator (small to big) 
        Arrays.sort(intervals,
                   new Comparator<int[]> (){
                       public int compare(final int[] a, final int[] b) {
                           return a[0] - b[0];
                       }
                   });
        
        //allocate the first meeting
        allocator.add(intervals[0][1]);
        
        // iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // check if we can remove the room on top of min heap for this new meeting
            if (intervals[i][0] <= allocator.peek()) {
                allocator.poll();
            }
            
            // add this meeting into min heap, for both the case of a new room or no new room
            allocator.add(intervals[i][1]);
        }
        
        return allocator.size();
    }
    
    // Approach 2: chronological order
    // O(nlogn) sorting
    // O(n) storing start and end array
    // seperate intervals into start/end arrays in chronological orders.
    // similar logic to approach 1
    public int minMeetingRooms(int[][] intervals) {
        // edge case
        if (intervals.length == 0) return 0;
        
        // create individual start/end arrays for sorting.
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        
        // fill in start/end arrays
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        // sort start/end arrays from small to big
        Arrays.sort(start, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        Arrays.sort(end, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        // create points and result variable
        int roomUsed = 0, sPtr = 0, ePtr = 0;
        
        // iterate until we finished all elements in start array
        while (sPtr < intervals.length) {
            // if a meeting has ended
            if (start[sPtr] >= end[ePtr]) {
                roomUsed -= 1;
                ePtr ++;
            }
            
            // add this new meeting
            roomUsed++;
            sPtr++;
        }
        return roomUsed;
    }
}