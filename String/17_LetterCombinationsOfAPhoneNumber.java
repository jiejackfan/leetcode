// 6/21/2021
class Solution {
    
    // Generate all combinations: this should use backtracking
    // Approach: Backtracking
    // O(4^N * N) where N=number of digits. 4=max amount of letter in a single digit
    // O(N) recursion callstack for backtracking
    // Save each number's corresponding letter into a hashtable. Then use standard backtracking template
    // to generate all possible combinations. This problem does not need us to worry about taking out any combinations.
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        // If the input is empty, return empty answer
        if (digits.length() == 0) return combinations;
        
        // Initiate backtracking algorithm with empty path and index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        
        return combinations;
    }
    
    public void backtrack(int index, StringBuilder sb) {
        // base case: if index is the same length as phone digits then we stop and add current string
        // into combinations
        if (index == phoneDigits.length()) {
            combinations.add(sb.toString());
            return;
        }
        
        // get the letters that current digits map to and loop through each. Recur on the way, remember to delete.
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            sb.append(letter);
            backtrack(index+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}