// April 17, 2021

class Solution {
    // Naive linear search 
    // O(n^2) O(1)
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
    
    // Sort and check consecutive equal
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    
    // Hashtable
    // O(n) O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(nums[i])) return true;
            record.put(nums[i], 1);
        }
        return false;
    }
}