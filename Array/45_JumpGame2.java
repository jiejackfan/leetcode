class Solution {
    
    // Approach 1: Greedy Algorithm
    // Jump to the tile that can provide the max new subarray to jump next
    // this solution uses the fact that there will always be a path to the end
    // O(n)
    // O(1)
    public int jump(int[] nums) {
        // records the answer of # of jumps we made
        int jumps = 0;
        // mark end of the range that we can jump to on this jump
        int currentJumpEnd = 0;
        // farthest to mark the farthest place we can read
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            // continuously find if this step can reach more farther steps
            farthest = Math.max(farthest, i + nums[i]);
            
            // if we are at the end of current jump, we extend our range and update jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}