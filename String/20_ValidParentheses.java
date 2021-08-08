// 08/05/2021

class Solution {
    // Approach 1: using a stack
    // O(n)
    // O(n)
    // Have a stack to keep track of order of parenthesis
    // If open bracket then put into stack, if close bracket we pop and see if they match
    // if no match then this is invalid, if at the end stack is not empty this is invalid
    public static HashMap<Character, Character> mapping;
    
    static {
        mapping = new HashMap<Character, Character>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
    } 
    
    public boolean isValid(String s) {
        // intialize stack
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // check if this character is open or close bracket
            // if this char is close bracket then we check if top of stack is the corresponding open bracket
            if (this.mapping.containsKey(c)) {
                char topOfStack = stack.empty()? '#' : stack.pop();
                if (topOfStack != this.mapping.get(c)) {
                    return false;
                }
            }
            // if char is open bracket, we put it into stack
            else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}