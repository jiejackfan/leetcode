// April 20, 2021


class Solution {
    
    // Hashtable solution
    // O(n) iterate through n elements in this string
    // O(1) english char consists of 26 characters
    // use str.toCharArray() to convert
    public int firstUniqChar(String s) {
        char[] chars= s.toCharArray();
        HashMap<Character, Integer> record = new LinkedHashMap<>();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            record.put(chars[i], record.getOrDefault(chars[i], 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            if (record.get(chars[i]) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}