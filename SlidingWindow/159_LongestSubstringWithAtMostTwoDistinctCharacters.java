// 8/27/2021
class Solution {
    // Approach 1: Hashmap and Sliding window
    // O(n) O(1)
    // Left/right pointer that moves as long as the hashtable contains only 2 distinct character
    // hashmap key=character val=last index it appears at
    // if hashmap exceeds size, we will move left pointer to the index where this char is gone
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3)
            return n;
        
        // declaration: pointers, hashmap, result 
        int left=0, right=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max_len = 2;
        
        // loop until we reach the last character
        while (right < n) {
            // when sliding window contains less than 3 characters, we put this current character into map
            // value we put the current index of this character
            map.put(s.charAt(right), right++);
            
            // now check if there are more than 2 distinct characters in hashmap
            // if there are more, we remove the leftmost distinct
            if (map.size() == 3) {
                // delete left
                int left_index = map.get(s.charAt(left));
                map.remove(s.charAt(left));
                
                // move pointer to the next distinct character
                left = left_index + 1;
            }
            
            // record new length of this 2 distinct char window
            // not right - left + 1 because we increased right pointer at the beginning of this loop
            max_len = Math.max(max_len, right - left);
        }
        
        return max_len;
    }
}