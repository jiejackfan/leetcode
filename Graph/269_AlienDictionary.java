// 9/8/2021
class Solution {
    
    // Approach 1: BFS:
    // Keep an adjacency list, and also a indegree hashmap
    // Put nodes with 0 in-degree in answer first, then process the ones that become 0 indegree
    // if at the end, still nodes have indegree, we know theres a cycle and not valid alien vocab
    // O(c) length of all words added together
    // O(1) 26 alphabets adjcency list
    public String alienOrder(String[] words) {
        // Step 1: create DS and find unique letters
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        // Step 2: fill in the adjList and also counts array
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            // check that word2 is not prefix of word1. This is wrong order
            if (word1.length() > word2.length() && word1.startsWith(word2)) 
                return "";
            
            // find first non-matching character between word1 and word2
            // insert corresponding relationship into adjList
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        // Step 3: Start BFS, continuously put nodes with 0 indegree into the answer
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // add inital nodes with 0 indegree.
        for (Character c:counts.keySet()) {
            if (counts.get(c).equals(0))
                queue.add(c);
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            // reduce the indegree of all neighboring node
            for (Character neighbor : adjList.get(c)) {
                counts.put(neighbor, counts.get(neighbor) - 1);
                if (counts.get(neighbor).equals(0))
                    queue.add(neighbor);
            }
        }
        
        if (sb.length() < counts.size()) {
            return "";
        }
        
        return sb.toString();
        
    }
}