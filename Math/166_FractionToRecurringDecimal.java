// 8/12/2021
class Solution {
    
    // Approach 1: Hashtable
    // O(n)
    // O(len(divisor))
    // Edge case question: needs to consider a lot of them
    // 1. numerator is 0: answer is 0
    // 2. denominator is 0: ignore
    // 3. either or both num and denom are negative
    // 4. overflow if cast to positive : (-2147483648) if changed to positive will overflow to 0
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        
        StringBuilder ans = new StringBuilder();
        
        // use xor to find out sign of the answer
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }
        
        // convert from int to long to avoid overflow
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        
        // find the integer part of answer, long / long will be long with no decimals
        ans.append(String.valueOf(dividend / divisor));
        
        // find remainder, if none then we return answer 
        long remainder = dividend % divisor;
        if (remainder == 0)
            return ans.toString();
        ans.append(".");
        
        // now we have the first remainder, we need to add this remainder into hashtable to see the first occurance
        // key=remainder, value = position of this digit in fraction string
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            // if we see repeat of a number, we will build the reoccuring sequence within bracket
            if (map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
            
            // if we don't see a repeat, save this number in hashtable
            // calculate the next remainder
            map.put(remainder, ans.length());
            remainder *= 10;
            ans.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }
        
        return ans.toString();
    }
}