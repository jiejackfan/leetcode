// March 23, 2021
class Solution {
    
    // brute force O(n^3) O(n)
    // Double for loop to loop through all combination length. Looping through 2 pointers,
    // called start and end.
    // Within the double for loop, we have a function that check if a substring contains all
    // unique characters. If we found a substring that has greater length, we update the var.
    public int lengthOfLongestSubstring(String s) {
        int currMax = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i; j < s.length(); j++) {
                if(checkUnique(s, i, j)) {
                    currMax = Math.max(currMax, j-i+1);
                }
            }
        }
        return currMax;
    }
    
    public static boolean checkUnique(String s, int i, int j) {
        HashMap<Character, Integer> appear = new HashMap<>();
        for (int k = i; k <= j; k++) {
            if (appear.containsKey(s.charAt(k))) {
                return false;
            }
            appear.put(s.charAt(k), 1);
        }
        return true;
    }
    
    // Sliding window: O(2n) O(n)
    // Last approach goes through all avaliable. We can only check the ones we dint check. Hence the sliding window
    // technique.
    // This approach has 2 pointers. Right pointer is to enlarge the window. First enlarge until encounter a duplicate 
    // character and use left to slowly shrink the set until the window has no repeating characters.
    public int lengthOfLongestSubstring(String s) {
        int[] charArr = new int[128];
        
        int left = 0;
        int right = 0;
        
        int res = 0;
        while(right < s.length()) {
            char r = s.charAt(right);
            charArr[r]++;
            
            while (charArr[r] > 1) {
                char l = s.charAt(left);
                charArr[l]--;
                left++;
            }
            
            res = Math.max(res, right-left+1);
            
            right++;
        }
        return res;
    }
    
    // Sliding window #2: O(n) O(n)
    // Improvement of the previous solution. Last solution involves moving left pointer one by one. This solution will
    // move left pointer directly to the correct location.
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charArr = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        int res = 0;
        while(right < s.length()) {
            char r = s.charAt(right);
            Integer index = charArr.get(r);
            
            if (index != null && index >= left && index < right)
                left = index +1;
            
            res = Math.max(res, right-left+1);
            charArr.put(r, right);
            right++;
        }
        return res;
    }
}