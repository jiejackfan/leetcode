// 6/19/2021


class Solution {
    
    // Intuition: generate all combinations sounds like a backtracking problem
    
    // Brute force
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2*n], 0, combinations);
        return combinations;
    }
    
    // backtrack helper
    // O(2^(2n) * n)
    // O(2^(2n) * n)
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }
    
    // checking validity helper
    // O(n)
    // O(1)
    public boolean isValid(char[] current) {
        int balance = 0;
        for (char c:current) {
            if (c == '(')
                balance++;
            if (c == ')')
                balance--;
            if (balance < 0) 
                return false;
        }
        
        return balance == 0;
    }
    
    // Solution 2: Backtracking without trying all possible combinations
    // Check for impossible conditions, don't generate that combination.
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    // backtrack helper 
    // keep track of # of open, close brackets and check for base case and 2 conditions
    // O(2 ^ (2n))
    // O(2 ^ (2n))
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // base case: if cur is at max length, add to the result. No need to check because 
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // if there are more open brackets to be placed
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            // remove the last added character
            cur.deleteCharAt(cur.length() - 1);
        }
        
        // if there can be more closing brackets
        if (open > close) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}