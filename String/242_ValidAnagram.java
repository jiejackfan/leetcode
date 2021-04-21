// April 20, 2021

class Solution {
    
    // Anagram of a word is a reformating using the same characters.
    // "anagram" -> "nangram"
    // may contain more spaces, but not considered in this problem.
    // HashMap solution. Use hash table when trying to count or find unique.
    // O(n) O(1)
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> record = new HashMap<>();
        
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) return false;
        
        // add character from s in hashmap
        // delete characters from t in hashmap
        for (int i = 0; i < Math.max(slen, tlen); i++) {
            record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0) + 1);
            record.put(t.charAt(i), record.getOrDefault(t.charAt(i), 0) - 1);
        }

        // loop over hashmap again to see if any character were negative and positve.
        // left over...
        for (char c : record.keySet()) {
            if (record.get(c) != 0) return false;
        } 
        return true;
    }
}