// April 23, 2021
class Solution {
    
    // substring linear time slice
    // O((n-l)*l)
    // O(1)
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        
        if (n == 0) return 0;
        
        // h-n+1 need to be careful next time.
        for (int i = 0; i < h - n + 1; i++) {
            if (needle.equals(haystack.substring(i, i+n))) return i;
            
        }
        return -1;
    }
    
    // Two pointer, linear time slice
    // O((n-l)*l), best case O(n) 
    // O(1)
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        if (n == 0) return 0;
        
        int hayPtr = 0;
        while (hayPtr < h - n + 1) {
            while (hayPtr < h-n+1 && haystack.charAt(hayPtr) != needle.charAt(0)) hayPtr++;
            
            int currLen = 0, needlePtr = 0;
            while (needlePtr < n && hayPtr < h && needle.charAt(needlePtr) == haystack.charAt(hayPtr)) {
                currLen++;
                needlePtr++;
                hayPtr++;
            }
            
            // if all matches
            if (needlePtr == n) return hayPtr - needlePtr;
            
            // not full match, backtrack to previous hayPtr + 1
            hayPtr = hayPtr - needlePtr + 1;
        }
        return -1;
    }
    
    // Solution 3 uses hashing. Don't understand......
}