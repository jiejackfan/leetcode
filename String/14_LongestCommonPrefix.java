// April 23, 2021
// approach 2 vertical scanning is the most efficient solution
// binary search and div conq are not very intuitive with the solution...


class Solution {
    // horizontal scanning
    // O(sum of chars)
    // O(1)
    // check 2 string at a time, find their common prefix and move on to the next pair
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    
    // vertical scanning
    // O(sum of all character) O(1)
    // check one character at a time for all the strings
    public String longestCommonPrefix(String[] strs) {
        if (strs == null && strs.length == 0) return "";
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
    
    // Divide and conquer
    // O(sum of characters), best case O(minlen * n)
    // O(m * logn)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return (longestCommonPrefix(strs, 0, strs.length - 1));
    }
    
    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) return strs[left];
        else {        
            int mid = left + (right - left) / 2;
            String leftS = longestCommonPrefix(strs, left, mid);
            String rightS = longestCommonPrefix(strs, mid+1, right);
            return commonPrefix(leftS, rightS);
        }
    }
    
    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0, min);
    }
    
    // Binary search on common prefix
    // O(s * logm)
    // O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int minLen = Integer.MAX_VALUE;
        
        // find the min length of the string array to binary search
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        
        // start binary search
        int left = 1;
        int right = minLen;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isCommonPrefix(strs, middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return strs[0].substring(0, (left + right) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) return false;
        }
        return true;
    }
    
}