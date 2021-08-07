// 8/6/2021

class Solution {
    // Approach 1: 1 stack
    // O(maxK ^ countK    * n)
    // O(sum((maxK ^ countK    * n)))
    // Have stack that stores each character, if we encounter a closing bracket then we decode the string and put the decoded string back to the stack
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        // for each character, push the current char into the stack
        // if the current char is a closing bracket then we process the current decoding
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            }
            else {
                // if we encounter closing bracket, we take everything out until we see a open bracket
                // also take out the number in front of open bracket
                List<Character> decodedString = new ArrayList<>();
                // get the characters for decoding in reverse order 
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                
                //pop '[' from stack
                stack.pop();
                int base = 1;
                int k = 0;
                
                // get the multiplier number k
                // this while loop to prevent a multi-digit k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                // decode the current bracket by pushing the decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
        }
        
        // stack contains the result, but because of LIFO we need to reverse it and return it as a string
        StringBuilder res = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}