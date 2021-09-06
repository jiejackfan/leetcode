// 9/5/2021
class Solution {
    
    // Approach 1: Brute force Reduce List In Place
    // We process the 2 elements to the left if we meet an operator. After that
    // we delete the 2 elements front and move on to the next operator.
    // O(n^2)
    // O(1)
    // Could use linkedlist to make O(n) O(n)
    public int evalRPN(String[] tokens) {
        int currentPosition = 0;
        int length = tokens.length;
        
        while (length > 1) {
            // move the position pointer to the next operator token
            while (!"+-*/".contains(tokens[currentPosition])) {
                currentPosition++;
            }
            
            // extract the 2 numbers right before the operator
            int number1 = Integer.parseInt(tokens[currentPosition - 2]);
            int number2 = Integer.parseInt(tokens[currentPosition - 1]);
            
            // calculate result to overwrite the operator with
            int newValue = 0;
            switch(tokens[currentPosition]) {
                case "+":
                    newValue = number1 + number2;
                    break;
                case "-":
                    newValue = number1 - number2;
                    break;
                case "*":
                    newValue = number1 * number2;
                    break;
                case "/":
                    newValue = number1 / number2;
                    break;
            }
            tokens[currentPosition] = Integer.toString(newValue);
            
            // delete numbers the previous 2 numbers 
            delete2AtIndex(tokens, currentPosition - 2, length);
            currentPosition--;
            length -= 2;
        }
        
        return Integer.parseInt(tokens[0]);
    }
    
    private void delete2AtIndex(String[] tokens, int d, int length) {
        for (int i = d; i < length - 2; i++) {
            tokens[i] = tokens[i + 2];
        }
    }
    
    // Approach 2: Evaluate with Stack
    // More logical method but the arithmetic may be tricky to deal with
    // Store number in stack and when we encounter operation we pop 2 from stack.
    // O(n)
    // O(n)
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        // iterate through all of the tokens
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            
            int number2 = stack.pop();
            int number1 = stack.pop();
            
            int result = 0;
            
            switch(token){
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            
            stack.push(result);
        }
        return stack.pop();
    }
} 