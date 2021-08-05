class Solution {
    
    // Approach 1: brute force
    // O(n * k) n # of sliding window each contain k elements
    // O(N - k + 1) store output array
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        // if given argument is 0 return empty array
        if (n * k == 0) return new int[0];
        
        int[] output = new int[n - k + 1];
        
        // loop every window to find max in each
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        
        return output;
    }
    
    // Approach 2: deque
    // O(n)
    // O(n) output array
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;
    
    // Helper:
    // remove the element not in window (the first element) if exceeds max size
    // not always sliding window size, can be 1 element if it is max
    public void clean_deque(int i, int k) {
        // remove index of element not in sliding window
        // only when the window exceeds max size
        if (!deq.isEmpty() && deq.getFirst() == i - k) 
            deq.removeFirst();
        
        // remove all elements smaller than current elemnts
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) 
            deq.removeLast();
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) { 
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        
        // init deque and out
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            
            //compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];
        
        // build output 1 by 1. Add 1 element to sliding window each time
        // this time we are sure all elements at front will be max
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        
        return output;  
    }
}