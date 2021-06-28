// 6/27/2021
class Solution {
    
    // brute force
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }
    
    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        
        for (int i = start; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && wordBreakRecur(s, wordDict, i))
                return true;
        }
        
        return false;
    }
    
    // memoization:
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean wordBreakRecur(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        
        if (memo[start] != null) return memo[start];
        
        for (int i = start; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && wordBreakRecur(s, wordDict, i, memo))
                return memo[start] = true;
        }
        
        return memo[start] = false;
    }
    
    // DP
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}