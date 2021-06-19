// 6/18/2021


class Solution {
    // Using backtracking. Problems like finding all possible combinations need to use DFS backtracking (recursion)
    // O(N^(T/M + 1))
    // O(T/M) recursion stack
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(target, comb, 0, candidates, results);
        
        return results;
    }
    
    // Recursion backtrack helper
    // 2 base case: if we found a possible comb, add to list. If remain is exceeded, return nothing
    // for loop to try all possible combinations using recursion
    protected void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {
        
        // base case:
        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        
        // for loop to try all possible combinations
        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            
            // backtrack recursion
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            
            comb.removeLast();
        }
    }
}