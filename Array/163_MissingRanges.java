//8/17/2021

class Solution {
    
    // Approach 1 : Brute force
    // If num[i] - num[i-1] != 1 then there is a range of missing number
    // 2 edge cases: the beginning and ending missing range
    // O(n)
    // O(1)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        int prev = lower - 1;
        
        // for every number in nums array
        for (int i = 0; i <= nums.length; i++) {
            
            // this also checks the last element gap with upper
            int curr = (i < nums.length) ? nums[i] : upper+1;
            
            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev+1, curr-1));
            }
            
            prev = curr;
        }
        return result;
    }
    
    private String formatRange(int lower, int upper) {
        if (lower == upper) 
            return String.valueOf(lower);
        return lower+"->"+upper;
    }
}