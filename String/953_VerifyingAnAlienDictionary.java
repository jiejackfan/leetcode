// 7/28/2021

class Solution {
    
    // Approach: single pass dict
    // Store lexi order into an array, index is character, storing the lexi order
    // Iterate through every word and compare each character between two neighbor nodes
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
        
        // for every word, look through every character
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                // if this word is longer than next word and have the same characters before this character, then out of order
                if (j >= words[i+1].length())
                    return false;
                
                // if this char at this word and next word is different, check lexi order 
                // if not, we iterate next character
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    int curWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i+1].charAt(j) - 'a';
                    if (orderMap[curWordChar] > orderMap[nextWordChar])
                        return false;
                    // if we find the first different letter are sorted, no need to check the ramaining characters.
                    else
                        break;
                }
            }
        }
        
        return true;
    }
}