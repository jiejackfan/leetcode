class Solution {
    // Approach 1: Sliding Window
    // O(S + T) O(S + T)
    // Have a sliding window go through s, and record minimum window sizes
    public String minWindow(String s, String t) {
        // edge case check
        if (s.length() == 0 || t.length() == 0)
            return "";
    
        // dictT keeps count of all chars in t
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count+1);
        }
        
        // required = dictT size
        int required = dictT.size();
        
        // left right pointer
        int l = 0, r = 0;
        
        // formed = unique character in t
        // "AABC", when formed == 3 we know this window contains all the characters we need
        int formed = 0;
        
        // windowCount = curr window char
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        
        // ans list (window len, left, right)
        int[] ans = new int[] {-1, 0, 0};

        // while loop start
        while (r < s.length()) {
            // add 1 char of current r to windowCount
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);
            
            // increment formed if r is 
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            
            // if formed == requires, contract the window until it ceases to be desirable
            while (l <= r && formed == required) {
                // save the ans
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                // decrease formed if left pointer is no longer a part of window 
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}