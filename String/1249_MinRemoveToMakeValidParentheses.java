class Solution {
    
    // Approach 1: Two pass greedy
    // O(n) 3 loops
    // O(n) stack and hashset
    public String minRemoveToMakeValid(String s) {
        // set to keep track of which index to remove
        Set<Integer> indexesToRemove = new HashSet<>();
        
        // stack to keep track of parenthesis. Deque can be used for both stack and queue
        Deque<Integer> stack = new ArrayDeque<>();
        
        // first iteration is to identify all parenthesis to remove
        // remove the ) if there are no ( left in the stack
        // remove the ( if at the end no matching ) are found
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    indexesToRemove.add(i);
                else
                    stack.pop();
            }
            else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        
        // put remaining in stack into our hashset
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        
        // second iteration build string from stringbuilder and don't include those within hashset
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) 
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    // Approach 2: Two Pass reverse string
    // O(n)
    // O(n)
    // remove extra closing brackets, reverse the modified string and remove extra closing brackets again
    // helper to remove extra closing bracket
    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            // if it is a open char we add 1 to balance
            if (c == open) {
                balance++;
            }
            // if it is close char, we check balance, if 0 we skip if not we add this to the string to return
            else if (c == close) {
                if (balance == 0)
                    continue;
                else 
                    balance--;
            }
            sb.append(c);
        }
        return sb;
    }
    
    public String minRemoveToMakeValid(String s) {
        // remove extra closing bracket
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        // reverse string and remove extra closing bracket. This removes the extra opening bracket when string is not reversed
        result = removeInvalidClosing(result.reverse(), ')', '(');
        // return the original string
        return result.reverse().toString();
    }
    
    // Approach 3: Revised version of approach 1
    // Remove extra closing in first pass, then second pass iterate from the back to remove right most opening bracket.
    // this way we don't need stack
    public String minRemoveToMakeValid(String s) {
        // pass 1: remove all invalid ')'
        // record open brackets seen 
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            }
            else if (c == ')') {
                if (balance == 0)
                    continue;
                    balance --;
            }
            sb.append(c);
        }
        
        // pass 2: remove rightmost (
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c= sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }
        
        return result.toString();
    }
}   