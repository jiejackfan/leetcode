class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force: O(n^2) O(1)
        // double for loop to add elements one by one
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] ==target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        
        // Two pass  O(n) O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        // go through the array once to store each element in a hashtable
        // the hashtable key=number value=index
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // go through array one more time, check if hashtable has the correct element that can
        // add to target. Check also if it is adding itself.
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        
        // One pass O(n) O(n)
        // Go through array once, check if the complement is already in the hashtable,
        // if not then put the current element in.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No tow sum");
    }
}