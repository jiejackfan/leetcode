// April 15, 2021

class Solution {
    // Two pointers
    // The given array is ordered so we can keep i and j as pointers.
    // i is the slow runner and j is the fast runner. 
    // As long as nums[i] == nums[j] we increment j to avoid duplicates
    // If nums[i] != nums[j] we know duplicates have ended
    // save j into nums[i+1]. i is incremented and we repeat this process til j finishes.
    // O(n) O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
    
        int p1 = 0;
        
        for (int p2 = 1; p2 < nums.length; p2++) {
            if (nums[p2] != nums[p1]) {
                nums[++p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}