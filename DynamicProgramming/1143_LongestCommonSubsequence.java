// 7/11/2021

class Solution {
    // Approach 1: memoization
    // O(m * n * n) m * n combinations, and each combinations may require a string search of n characters
    // O(m*n)  
    // We can do a total of m * n (length of text1 and text2) different combinations using them as starting index
    // for each combination, the pair (starting index of text1 and its match in text2) is either a optimal combination or not
    // use recursion to find out the best case and find maximum 
//     private int[][] memo;
//     private String text1;
//     private String text2;
//     public int longestCommonSubsequence(String text1, String text2) {
//         //make memo 1 size bigger so it can cover when pointer go over the edge of string
//          this.memo = new int[text1.length() + 1][text2.length() + 1];
//         // initalize all elements in the memo as -1 as default for memoization later
//         // except leave the base cases as 0 so we can use it to stop the recursion
//         for (int i = 0; i < text1.length(); i++) {
//             for (int j = 0; j < text2.length(); j++) {
//                 memo[i][j] = -1;    
//             }
//         }
        
//         this.text1 = text1;
//         this.text2 = text2;
//         // start recursion using the starting index of both strings
//         return memoSolve(0, 0);
//     }
    
//     private int memoSolve(int p1, int p2) {
//         // check memo and also check for base case
//         // base case when p1 == text1.length or p2 == text2.length
//         if (memo[p1][p2] != -1) {
//             return memo[p1][p2];
//         }
        
//         // pick between 2 options that will produce the better result
//         // option 1: don't include text1[p1]
//         int option1 = memoSolve(p1 + 1, p2);
        
//         // option 2: we include text1[p1] as long as a match for it in text2 at or after p2 exists.
//         int firstOccurence = text2.indexOf(text1.charAt(p1), p2);
//         int option2 = 0;
//         if (firstOccurence != -1) {
//             option2 = 1 + memoSolve(p1 + 1, firstOccurence + 1);
//         }
        
//         memo[p1][p2] = Math.max(option1, option2);
//         return memo[p1][p2];
//     }
    
    
    // Approach 2: improved memoization
    // O(m * n) 
    // O(m * n)
    // memoization and try 2 approach by deleting either first from text1 or first from text2 or both out from the string
//     private int[][] memo;
//     private String text1;
//     private String text2;
//     public int longestCommonSubsequence(String text1, String text2) {
//         this.memo = new int[text1.length() + 1][text2.length() + 1];
//         for (int i = 0; i < text1.length(); i++) {
//             for (int j = 0; j < text2.length(); j++) {
//                 memo[i][j] = -1;
//             }
//         }
//         this.text1 = text1;
//         this.text2 = text2;
//         return memoSolve(0, 0);
//     }
    
//     private int memoSolve(int p1, int p2) {
//         // base case and memo
//         if (memo[p1][p2] != -1) {
//             return memo[p1][p2];
//         }
        
//         int answer = 0;
//         if (text1.charAt(p1) == text2.charAt(p2)) {
//             answer = 1 + memoSolve(p1+1, p2+1);
//         } else {
//             answer = Math.max(memoSolve(p1+1, p2), memoSolve(p1, p2+1));
//         }
        
//         memo[p1][p2] = answer;
//         return memo[p1][p2];
//     }
    
    // Approach 3: dynamic programming
    // O(m * n)
    // O(m * n)
    // Like approach 2 but buttom up. Solve the small problems from the back of the string to the entire stirng
//     public int longestCommonSubsequence(String text1, String text2) {
//         // make a grid of 0s, initialize default to 0
//         int[][] dpGrid = new int[text1.length()+1][text2.length()+1];
        
//         // iterate up each column, starting from the last
//         for (int col = text2.length()-1; col >= 0; col--) {
//             for (int row = text1.length()-1; row >= 0; row--) {
//                 // if pair are same, then the value is 1 + bottom right diagonol
//                 if (text2.charAt(col) == text1.charAt(row)) {
//                     dpGrid[row][col] = 1 + dpGrid[row+1][col+1];
//                 } else {
//                     dpGrid[row][col] = Math.max(dpGrid[row+1][col], dpGrid[row][col+1]);
//                 }
//             }
//         }
        
//         return dpGrid[0][0]; 
//     }
    
    // Approach 4: dynamic programming but with only 2 col from the dpGrid table.
    // O(m * n)
    // O(min(m, n))
    public int longestCommonSubsequence(String text1, String text2) {
        // let text1 be the shorter string
        if (text1.length() > text2.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        
        // each column is a character in text2
        // each row is a character in text1
        // set up prev column. starts with all 0 at the index of text2.length() + 1;
        // so column length should be text1's length
        int[] previous = new int[text1.length() + 1];
        
        // iterate through each combination between text1 and text2
        for (int col = text2.length() - 1; col >= 0; col--) {
            // setup current column
            int[] current = new int[text1.length() + 1];
            for (int row = text1.length() - 1; row >= 0; row--) {
                // follow the same steps as dp approach 3
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = previous[row + 1] + 1;
                } else {
                    current[row] = Math.max(current[row + 1], previous[row]);
                }
            } 
            previous = current;
        }
        
        return previous[0];
        
    }
}