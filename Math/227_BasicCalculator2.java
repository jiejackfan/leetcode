

// 7/28/2021

class Solution {
    
    // Approach 1: Stack
    // Store + - numbers into the stack first, calculate * / results and then put into stack.
    // O(n) go through every character
    // O(n) stack storage
    public int calculate(String s) {
        
        if (s == null || s.isEmpty()) 
            return 0;
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            // if this character is a digit, add to currentNumber
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            // if this character is an operator or is the last character
            // if + -, save the number into stack
            // if * /, calculate the result and put into stack
            // when iterate to last character, we need to do push number into stack first
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len-1) {
                if (operation == '-') 
                    stack.push(-currentNumber);
                else if (operation == '+')
                    stack.push(currentNumber);
                else if (operation == '*')
                    stack.push(stack.pop() * currentNumber);
                else if (operation == '/')
                    stack.push(stack.pop() / currentNumber);
                
                // reset variables for next calculation
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
                    
        // loop to do rest of + - operations
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
//         return result;
//     }
    
    // Approach 2: optimized without stack usage
    // More optimized solution without using a stack, but logic is more confusing
    // Uses a lastNumber variable to act like a stack
    // O(n)
    // O(1)
    public int calculate(String s) { 
        if (s == null || s.isEmpty())
            return 0;
        
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                }
                else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                }
                else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}