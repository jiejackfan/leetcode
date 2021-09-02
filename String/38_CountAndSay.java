class Solution {
    // Approach 1: Brute force
    // Build the answer step by step.
    // O(n^2)
    // O(n)
    public String countAndSay(int n) {
        if (n <= 0) return "-1";
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        
        return result;
    }
    
    // build helper function
    private String build(String result) {
        StringBuilder build = new StringBuilder();
        
        int p = 0;
        
        // loop every char in the previous string
        while (p < result.length()) {
            char val = result.charAt(p);
            
            // count how many times an identical char is present
            int count = 0;
            while (p < result.length() && result.charAt(p) == val) {
                p++;
                count++;
            }
            
            build.append(String.valueOf(count));
            build.append(val);
        }
        return build.toString();
    }
}