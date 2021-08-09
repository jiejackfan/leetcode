// 8/9/2021

class Solution {
    // Approach 1: brute force
    // O(nlogn) sorting algo time complexity
    // O(1) sorting in place
    // Sort and count 1 by 1 consecutively
    // if a number appears twice we will skip this number
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        // sorts from small to big
        Arrays.sort(nums);
        
        int longestStreak = 1;
        int currentStreak = 1;
        
        for (int i = 0; i < nums.length-1; i++) {
            // check if this number is a duplicate to skip
            if (nums[i] != nums[i+1]) {
                // if we find consequtive, we add to current streak
                if (nums[i] == nums[i+1] - 1) {
                    currentStreak+= 1;
                }
                // if no consequtive, reset current streak and update longest streak
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(currentStreak, longestStreak);
    }
    
    // Approach 2: Hashset
    // O(n) loop through all elements once
    // O(n) hashset
    // Add numbers to a hashset and check the longest consequtive streak
    // hashset's get() is O(1)
    public int longestConsecutive(int[] nums) {
        // Init hashset and add all numbers in
        // will not add duplicate number
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num: nums) {
            // if there is a number 1 smaller than current in the set we skip to next int
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
            
        }
        return longestStreak;
    }
}