// March 28, 2021
// Tag: Array, Sort

class Solution {
    // Sort then LinkedList：O(nlogn) sorting， O(n)
    // sort the array in ascending order of first val, put into Linkedlist
    // one interval at a time. Convert LL back to array at the end.
    public int[][] merge(int[][] intervals) {
        //create anwser linked list
        LinkedList<int[]> answer = new LinkedList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        
        // building the linked list
        for (int[] interval : intervals) {
            if (answer.isEmpty() || answer.getLast()[1] < interval[0]) {
                answer.add(interval);
            }
            //else add to the last item in the list
            else {
                answer.getLast()[1] = Math.max(answer.getLast()[1], interval[1]);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}