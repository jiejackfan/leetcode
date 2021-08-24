// 8/23/2021
class Solution {
    // Approach 1: Heap
    // Iterate through the array to store in hashtable an element and its frequency
    // add each hash item into heap and keep only top k
    // change heap into array and return result
    // O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        
        // iterate hashtable O(n) time 
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        //add items into min heap(custom priority queue) based on their frequency.
        // only keep the top k in the heap, drop the ones in front (smaller frequency)
        // O(nlogk)
        Queue<Integer> heap = new PriorityQueue<Integer>(
            (n1, n2) -> count.get(n1) - count.get(n2));
        for (int n : count.keySet()) {
            heap.add(n);
            // if we exceed the size of k, we will drop the lowest frequency
            if (heap.size() > k) 
                heap.poll();
        }
        
        // convert heap into a array 
        // O(klogk)
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = heap.poll();
        }
        
        return res;
    }
}