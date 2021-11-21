// March 28, 2021
// 10/20/2021
// Tag: Array, Sort

class Solution {
    // Approach 1: Sort then create using LinkedList：
    public int[][] merge(int[][] intervals) {
        // sort array based on the starting index of each interval
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        
        // create a linked list for the final answer
        LinkedList<int[]> ans = new LinkedList<>();
        
        // go through each interval
        for (int[] interval : intervals) {
            // add to the ans LL based on whether or not merge
            // if ans is empty || the two intervals don't overlap, just add interval to ans
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) 
                ans.addLast(interval);
            
            // else if two intervals overlap, merge the current interval with last in LL.
            else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        
        // convert linkedlist back to 2d array
        return ans.toArray(new int[ans.size()][]);
    }
}