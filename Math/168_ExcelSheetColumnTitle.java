class Solution {
    
    // Approach 1: Stringbuider
    // formula to find answer is 
    // O(n)
    // O(n)
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        
        while (columnNumber > 0) {
            // this is key to 26 base calculation
            columnNumber--;
            
            ans.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        
        return ans.reverse().toString();
    }
}