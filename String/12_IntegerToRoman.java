// May 10, 2021


class Solution {
    // greedy 
    // loop from the largest roman numeral, subtract the largest value from the number until not subtractable (less than 0)
    // O(1), the roman numeral is bounded by a range of 3999, therefore constant number of iteration
    // O(1), only storing all the values
    
    // first save a table of reference between roman string and integer value
    // this can be a hashmap or two different arrays
    private final static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] symbols =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public String intToRoman(int num) {
        String result = "";
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result += symbols[i];
            }
        }
        return result;
    }
    
    // No hardcoded for double roman numbers
    private final static int[] values = {1000, 500, 100, 50, 10, 5, 1};
    private final static String[] symbols =  {"M", "D", "C", "L", "X", "V", "I"};
    
    public String intToRoman(int num) {
        String result = "";
        int i = 0;
        while (num > 0) {
            if (num < values[i]) {
                i+=1;
                continue;
            }
            String nextChar = symbols[i];
            int subtract = values[i];
            if (i > 0) {
                char firstDigit = String.valueOf(Math.abs((long)num)).charAt(0);
                if (firstDigit == '4') {
                    subtract = values[i - 1] - subtract;
                    nextChar += symbols[i - 1];
                }
                else if (firstDigit == '9') {
                    subtract = values[i - 1] - values[i + 1];
                    nextChar = symbols[i + 1] + symbols[i - 1];
                }
            }
            num -= subtract;
            result += nextChar;
        }
        return result;
    }
    
}