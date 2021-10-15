class Solution {
    // Approach 1: Group By Character
    // O(n) O(n)
    // Make groups of characters whenever we see a different number
    public int countBinarySubstrings(String s) {
        // group array stores number of characters in one group
        int[] groups = new int[s.length()];
        int t = 0;

        // initialize first character in first group
        groups[0] = 1;
        
        // loop from second character, add to group if same char, create new group if different char
        for (int i = 1; i < s.length(); i++) {
            //
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            }
            else {
                groups[t]++;
            }
        }
        
        // go through group array, 2 groups can have min(group[i-1], group[i]) combinations
        // add to ans 
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
    
    // Approach 2 : Linear Scan
    // Still count the number of groups, but don't use array, just use prev and cur
    // Update answer as we go through the string once
    // O(n) O(1)
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            // if we encounter differnt char,
            // update answer and increase prev and cur
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
            // if we meet same char, add to cur
            else {
                cur++;
            }
        }
        return ans+Math.min(prev, cur);
    }
}