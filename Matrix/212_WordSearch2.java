// 7/29/2021
// Backtracking, trie problem


// Approach 1: 
// Build a trie that contains all the given words, then loop through all cells to find if the board contains any given words
// O(M * 4 * 3 ^(L-1)) M=# of cells, L = max length of word
// O(n)
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    // act as the end tag, which signified we have reach the end of a given word
    // Optimization: keep words in trie
    String word = null;
    public TrieNode() {};
}

class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Construct the trie from given board
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode node = root;
            for (Character letter: word.toCharArray()) {
                // if next character is already in the current char's children
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this._board = board;
        
        // Step 2: Backtracking for each cell in the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        
        return this._result;
    }
    
    // passing in the parent node because the cur node does not store the character information
    // Optimization: backtrack along the nodes in Trie
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode curNode = parent.children.get(letter);
        
        // check if there is a match, and clear this match for later iteration so no duplicate result
        if (curNode.word != null) {
            this._result.add(curNode.word);
            // Optimization: remove matched words from the Trie
            curNode.word = null;
        }
        
        // mark current letter as visited before the exploration
        this._board[row][col] = '#';
        
        // explore the neighbors: up right down left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int newRow =  row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
                continue;
            }
            if (curNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, curNode);
            }
        }
        
        // End of exploration, restore the original letter in the board
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        // gradually prune the nodes in Trie
        if (currNode.children.isEmpty()) {
          parent.children.remove(letter);
        }
    }
}