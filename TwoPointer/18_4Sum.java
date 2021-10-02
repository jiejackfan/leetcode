//10/02/2021

class Solution {
    // Approach 1: Generic ksum solution 
    // O(n^3)
    // O(n) recursion
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        // ending condition and early stopping
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k) 
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        
        for (int i = start; i < nums.length; i++) {
            // skip if the ith number is the same as the one before (we already found duplicate solution)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> subset : kSum(nums, target - nums[i], i+1, k-1)) {
                    // build 1 solution list:
                    // add nums[i] in then add its subset
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
        }
        
        return res;
    }
    
    // two sum 2 pointer solution 
    public List<List<Integer>> twoSum (int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            // skip duplicate answers
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi+1] )) 
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        
        return res;
    }
}