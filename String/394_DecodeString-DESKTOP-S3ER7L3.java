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
        
    // Approach 2: Using 2 stacks
    // 1 stack for k, 1 stack for letters
    // O(maxK * n) traverse strig of size n a max of k times
    // O(m * n) m=#of letters, n = # of digits
    public String decodeString(String s) {
        Stack<Integer>countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
    
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } 
            else if (ch == '[') {
                // push the number k to countStack
                // push the currentString to stringStack
                // reset currentString and k
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            }
            else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
            else {// its a char
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
    
    // Approach 3: recursion
    // Recur when build the inner brackets and join result when going back up
    // O(maxK * n)
    // O(n)
    int index = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        
        // loop until encounter ] or reach the end
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            
            else {
                int k = 0;
                // build k while the next char is still a digit
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                
                // ignore opening bracket
                index++;
                String decodedString = decodeString(s);
                
                // ignore closing bracket
                index++;
                
                // build k[decodedString] and append to the result
                while (k-- > 0) {
                    result.append(decodedString);
                }
            }
        }
        return new String(result);
    }
}