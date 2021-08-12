// 8/11/2021
class Solution {
    
    // Approach 1: Sorting
    // Sort the array and the majority element will always be at index N/2 no matter if it is
    // a even or odd sized array
    // O(nlogn) quick sort
    // O(1) sorted in place
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    // Approach 2: Boyer-Moore Voting Algorithm
    // Have a count variable. If count is 0 then we reset and current number becomes the most frequent
    // Increase the count if we see more candidate or decrease otherwise.
    // O(n)
    // O(1)
    public int majorityElement(int[] nums) {
        
        int count = 0;
        Integer candidate = null;
        
        for (int num : nums) {
            if (count == 0) 
                candidate = num;
            count += (candidate == num)? 1:-1;
        }
        return candidate;
    }
}