class Solution {
    // Approach 1: Top Down Recursion Memoization
    // O(L^2 * N)
    // O(N)
    // Go through each word, remove a character see if new word is in our list, if so dfs down until no char left
    // Use memoization so make sure each word visit once. 
    public int longestStrChain(String[] words) {
        // For memoization, key=String of curr config, value = Integer length
        Map<String, Integer> memo = new HashMap<>();
        
        // Set of all words present, used to check if word exist
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        
        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }
    
    private int dfs(Set<String> words, Map<String, Integer> memo, String currentWord) {
        // if present in memo, return
        if (memo.containsKey(currentWord))
            return memo.get(currentWord);
        
        // this stores max length of words sequence possible with currentWord
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        
        // create all possible strings, take out 1 char at a time from currentWord
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            // if new word formed is present in the words list, we do dfs search with new word
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        
        memo.put(currentWord, maxLength);
        return maxLength;
    }
    
    // Approach 2: DP
    // Sort list in ascending order of word length
    // Go through each word, delete one char and see if the new word is seen before
    // if so, add 1 to previous result and store in dp table
    // dp table key = word, val = max length for that word downwards
    public int longestStrChain(String[] words) { 
        Map<String, Integer> dp = new HashMap<>();
        
        // sort in ascending order of word length
        Arrays.sort(words, (a, b)-> a.length() - b.length());
        
        // answer
        int longestWordSequenceLength = 1;
        
        // for each word, remove char at each index to find longest length of sequence
        for (String word: words) {
            // tracks longest length of sequence from this word -> 0 char
            int presentLength = 1;
                for (int i = 0; i < word.length(); i++) {
                    // remove char, see if new word is in dp before (exist)
                    // if so update presentLength
                    StringBuilder temp = new StringBuilder(word);
                    temp = temp.deleteCharAt(i);
                    String previousWord = temp.toString();
                    int previousLength = dp.getOrDefault(previousWord, 0);
                    presentLength = Math.max(presentLength, previousLength + 1);
                }
            
            // record oresentLength and update answer
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(presentLength, longestWordSequenceLength);
        }
        
        return longestWordSequenceLength;
    }
}