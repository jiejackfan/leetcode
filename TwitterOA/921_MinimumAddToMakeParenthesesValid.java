
class Solution {
    // Approach 1: Balance
    // Keep a balance param. If bal is negative, we have to add (. vice versa
    // Keep ans param to keep track of ( added. Keep track of bal so we know number of ) to add.
    // Make sure bal > -1.
    // O(n) O(1)
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // +1 if (
            // -1 if )
            bal += s.charAt(i) == '(' ? 1 : -1;
            
            // bal >= -1
            // ans tracks number of ( to add
            // bal tracks number of ) to add
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}