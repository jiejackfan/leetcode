// 6/20/2021

class Solution {
    // Approach 1: Sort by row
    // Setup a list of StringBuilders to store contents for each row. Use 2 variables (curRow and goingDown) to keep
    // track of current row and direction. Add characters one by one to the list and create an answer.
    // O(len(s)) going through every character once when processing
    // O(len(s)) space needed to store characters
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        // setup an ArrayList of StringBuilder to store content for each row
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        
        // create a variable to keep track of which row we are adding to
        int curRow = 0;
        boolean goingDown = false;
        
        // Add characters one by one into the list.
        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 ||  curRow == numRows-1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        
        String ans = "";
        // combine list<StringBuilder> into a string final answer
        for (StringBuilder row : rows) {
            ans += row.toString();
        }
        return ans;
    }
    
}