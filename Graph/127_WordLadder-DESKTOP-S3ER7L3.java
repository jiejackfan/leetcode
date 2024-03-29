// 7/19/2021

class Solution {
    // Approach 1: BST
    // O(m^2 * n) m * n to create hashmap, each entry requires o(m) for substring operation
    // O(m^2 * n) m^2 possible combinations for every word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        
        // dictionary (hashtable) to hold combinations of words that can be formed by any given word, one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();
        
        wordList.forEach(
            word -> {
                for (int i = 0; i < L; i++) {
                    // key is generic word, value is a list of words which have the same intemediate generic content
                    String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                    List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                    transformations.add(word);
                    allComboDict.put(newWord, transformations);
                }
            }
        );
        
        // Declare queues for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        
        // Visited to make sure we don't repeat processing same word
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        // while queue is not empty, we keep processing
        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            
            for (int i = 0; i < L; i++) {
                // intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                
                // add next level words into the queue
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // if we find the end word, return this answer
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    
                    // add more nodes into the BFS queue. mark current word as visted
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level+1));
                    }
                }
            }
        }
        
        return 0;
    }

     // BFS: Use BFS because we are finding the shortest
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        int level = 0;
        // add to the queue and start the bfs
        words.remove(beginWord);
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                
                if (curWord.equals(endWord))
                    return level;
                
                // find all the neighbors for this word
                List<String> neighbors = findNeighbors(curWord);
                for (String neighbor : neighbors) {    
                    // if neighbor is in  words list then add to next queue iteration
                    if (words.contains(neighbor)) {
                        words.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        return 0;
    }
    
    public List<String> findNeighbors(String word) {
        char[] chars = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                neighbors.add(new String(chars));
            }
            chars[i] = temp;
        }
        return neighbors;
    }
    
    // Approach 2: bidirectional bfs
    // will be implemented later
    
}