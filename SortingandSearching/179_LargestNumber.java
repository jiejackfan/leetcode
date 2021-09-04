// 9/3/2021
class Solution {
    
    // Approach 1: Sorting via custom comparator
    // We will write a custom comparator that can order the string into the order that will maximize our result
    // Sort of like greedy algorithm
    // The custom comparator compares 2 number in their 2 combinations to see which one should go first.
    // O(nlogn) sorting array, comparator complexity is constant
    // O(n) storing number as String
    private class LargeNumberComparator implements Comparator<String> {
        // we want custom compare function which picks the string that has the most significant digit when combined
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            // return -1 if we want to pick order 1, return 1 if we want to pick order 2
            // compareTo function will return return -1 if order2 < order1, 1 if order2 > order 1
            // matches our need
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        // change input integer into an array of Strings
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        
        // sort strings using the custom comparator we wrote
        Arrays.sort(asStrs, new LargeNumberComparator());
        
        // if most sig num is '0', we return 0 as answer
        if (asStrs[0].equals("0"))
            return "0";
        
        // build largest number from sorted array
        String ans = new String();
        for (String numAsStr : asStrs) {
            ans += numAsStr;
        }
        
        return ans;
    }
}