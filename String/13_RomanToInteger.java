// May 8, 2021
// Pay close attention to the time complexity

class Solution {
    // One Pass
    // O(1) The roman number is bounded to 3999. Therefore not unlimited n.
    // O(1)
    // hardcode the roman integer table using hashmap
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    
    public int romanToInt(String s) {
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            // If it is special case of roman number
            if (i < s.length() - 1 && values.get(s.substring(i, i+1)) < values.get(s.substring(i+1, i+2)) ) {
                result = result + values.get(s.substring(i+1, i+2)) - values.get(s.substring(i, i+1));
                i = i+2;
            }
            else {
                result += values.get(s.substring(i, i+1));
                i++;
            }
        }    
        return result;
    }
    
    // One Pass w/ double char hard-coding
    // O(1)
    // O(1)
    // hardcode the roman integer table using hashmap
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }
    
    public int romanToInt(String s) {
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            // If it is special case of roman number
            if (i < s.length() - 1 && values.containsKey(s.substring(i, i+2)) ) {
                result = result + values.get(s.substring(i, i+2));
                i = i+2;
            }
            else {
                result += values.get(s.substring(i, i+1));
                i++;
            }
        }    
        return result;
    }
    
    
    // Going from right to left
    // O(1)
    // O(1)
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    
    public int romanToInt(String s) {
        String curr = "";
        int lastVal = values.get(s.substring(s.length()-1));
        int result = lastVal;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            curr = s.substring(i, i+1);
            int currVal = values.get(curr);
            if (currVal < lastVal) {
                result -= currVal;
            }
            else {
                result += currVal;
            }
            lastVal = currVal;
        }
        
        return result;
    }
}