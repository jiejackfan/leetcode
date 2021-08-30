class Solution {
    // Approach 1 : Sliding Window + HashMap
    // similar approach 2 lc159, however, there is a slight tweak
    // now with k characters, the left pointer is not the pointer that we can delete
    // we should delete the char that has the least last seen position
    // O(kn) because we need to loop through hashmap each time we scan a char
    // O(k) hashmap space
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) return 0;
        if (n < k) return n;
        
        // declare ds and pointers
        int left = 0, right = 0;
        int max_len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        // loop until right pointer reaches end of string
        while (right < n) {
            // add new char into hashmap
            map.put(s.charAt(right), right++);
            
            // delete the char that has the least last seen index
            if (map.size() > k) {
                int lowest_index = Collections.min(map.values());
                map.remove(s.charAt(lowest_index));
                left = lowest_index + 1;
            }
            
            // update max_len at end of each change in pointer
            max_len = Math.max(max_len, right - left);
        }
        
        return max_len;
    }
    
    // Approach 2: Sliding window + Ordered Dict
    // O(n)
    // O(k)
    // Last approach we need to find the element that has the smallest value which       // is O(k). We can instead use a LinkedHashMap to put the element to remove
    // at the beginning.
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) return 0;
        if (n < k) return n;
        
        // declare DS and pointers
        int left = 0, right = 0;
        int max_len = 0;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        
        // loop until right pointer reaches the end
        while (right < n) {
            // put the current "right" char into the LHM. delete its previous                   // instance
            Character character = s.charAt(right);
            if (map.containsKey(character)) {
                map.remove(character);
            }
            map.put(character, right++);
            
            // if exceeds size k, we remove the first element in LHM
            if (map.size() > k) {
                // get the first
                Map.Entry<Character, Integer> leftmost =
                    map.entrySet().iterator().next();
                map.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }
            
            // update max_len
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}