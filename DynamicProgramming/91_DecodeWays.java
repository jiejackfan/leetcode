// March 29, 30 2021
class Solution {
    // recursive with memoization:
    // O(n) n=length of string, because memoization only go through each index once, O(n)
    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }
    
    // hashmap storing memoization results
    // Integer 1 is the index of String this memoization begins
    // Integer 2 is the number of ways to explain this string beginning from this index.
    Map<Integer, Integer> memo = new HashMap<>();
    
    private int recursiveWithMemo(int index, String s) {
        // if the index is already in the memo, then just return that memo
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // if this index exceeded the range, return 1 solution
        if (index >= s.length()) {
            return 1;
        }
        
        // if the index starts with 0, return 0 solution
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        // if the index is on the last character, return 1 solution
        if (index+1 == s.length()) {
            return 1;
        }
        
        // use recursion to calculate total solutions from the index onwards
        // need to combine solutions for 1 digit or 2 digits.
        int ans = recursiveWithMemo(index+1, s);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26) {
            ans += recursiveWithMemo(index+2, s);
        }
        memo.put(index, ans);
        return ans;
    }
    
    // dynamic programming with dp array:
    // O(n) n=length of string, because dp only go through each index once, O(n)
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        // set index 0 to be the first baton.
        dp[0] = 1;
        
        // check index 1 if the string start at 0.
        dp[1] = s.charAt(1) == '0' ? 0:1;
        
        // start iterating and calculate for elements in dp table
        for (int i = 2; i < dp.length; i++) {
            // check single decode
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i-1];
            
            //check double decode
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
    
    // dynamic programming with prev 2 var:
    // O(n) n=length of string, because dp only go through each index once, O(1)
    public int numDecodings(String s) {
        
        // check index 1 if the string start at 0.
        if(s.charAt(0) == '0') return 0;
        
        int oneBefore = 1;
        int twoBefore = 1;
        
        // start iterating from index 1 of string
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            // check single decode
            if (s.charAt(i) != '0')
                current += oneBefore;
            
            //check double decode
            int twoDigit = Integer.valueOf(s.substring(i-1, i+1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBefore;
            }
            twoBefore = oneBefore;
            oneBefore = current;
            
        }
        
        return oneBefore;
    }
}