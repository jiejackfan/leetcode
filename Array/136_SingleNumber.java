// April 17, 2021
// tags: Array, Bits, HashMap, Hashset, List

class Solution {
    // List operation
    // O(n^2) O(n)
    public int singleNumber(int[] nums) {
        List<Integer> record = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) record.remove(new Integer(nums[i]));
            else record.add(nums[i]);
        }
        return record.get(0);
    }
    
    // Hash Table
    // O(2n) O(n)
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (record.get(nums[i]) == 1) return nums[i];
        }
        return 0;
    }
    
    // Math
    // O(n) O(n/2)
    // add the numbers in a set only once each number.
    // 2 * sum of set - sum of all numbers = single number.
    public int singleNumber(int[] nums) { 
        HashSet<Integer> record = new HashSet<>();
        int sumOfSet = 0, sumOfAll = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!record.contains(nums[i])) {
                record.add(nums[i]);
                sumOfSet += nums[i];
            } 
            sumOfAll += nums[i];            
        }
        return 2*sumOfSet - sumOfAll;
    }
    
    
    // Bit manipulation??
    // O(n) O(1)
    // XOR all bits together to find out the single number
    // using the 2 following rules
    // 0 XOR 1 = 1, 1 XOR 1 = 0
    public int singleNumber(int[] nums) { 
        int ans = 0;
        for (int i:nums){
            ans ^= i;
        }
        return ans;
    }
}