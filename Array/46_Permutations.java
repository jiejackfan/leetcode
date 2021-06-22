// 6/22/2021

class Solution {
    // backtracking my attempt. using the standard backtracking template
    // O(n!) first level tree iterates N times, then second level N-1 times and so on. Together its n!
    // O(n!) to store all combinations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        backtrack(combinations, new ArrayList<Integer>(), nums);
        return combinations;
    }
    
    private void backtrack(List<List<Integer>> combinations, List<Integer> cur, int[] nums) {
        // base case
        if (cur.size() == nums.length) {
            combinations.add(new ArrayList<>(cur));
            return;
        }
        
        // loop through to recur on all possible combinations
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue; // this is to prevent duplicate number appearing in the same ArrayList
            cur.add(nums[i]);
            backtrack(combinations, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
    

}