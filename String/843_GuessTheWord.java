/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    // Approach 1: Random
    // Give random word to master, and delete all words with less matches than cur word
    // eventually will lead to answer
//     public void findSecretWord(String[] wordlist, Master master) {
//         Random random = new Random();
        
//         // loop 10 times or until we found the secret word
//         for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
//             // draws random word from the wordlist
//             String guess = wordlist[random.nextInt(wordlist.length)];
        
//             matches = master.guess(guess);
//             List<String> candidates = new ArrayList<>();
            
//             // if have same # of matches, add to new wordlist
//             for (String word : wordlist) {
//                 if (matches == getMatches(guess, word)) {
//                     candidates.add(word);
//                 }
//             }
            
//             // convert the new wordlist from arraylist to array
//             wordlist = candidates.toArray(new String[0]);
//         }
//     }
    
    private int getMatches(String word1, String word2) {
        int matches = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) 
                matches++;
        }
        return matches;
    }
    
    // Approach 2 : minmax
//     public void findSecretWord(String[] wordlist, Master master) { 
//         for (int i = 0, x = 0; i < 10 && x < 6; i++) {
//             // hashmap: word, number of words that have 0 matches in the list
//             HashMap<String, Integer> count = new HashMap<>();
            
//             // fillup count hashtable
//             for (String w1:wordlist) 
//                 for (String w2:wordlist) 
//                     if (getMatches(w1,w2) == 0)
//                         count.put(w1, count.getOrDefault(w1, 0) + 1);
        
//             String guess = "";
//             int min0 = 100;
//             for (String w : wordlist)
//                 if (count.getOrDefault(w, 0) < min0) {
//                     guess = w;
//                     min0 = count.getOrDefault(w, 0);
//                 }
            
            
//             x = master.guess(guess);
//             List<String> wordlist2 = new ArrayList<String>();
//             for(String w : wordlist)
//                 if (getMatches(guess, w) == x)
//                     wordlist2.add(w);
//             wordlist = wordlist2.toArray(new String[0]);
//         }
//     }
    
    public void findSecretWord(String[] wordlist, Master master) { 
        for (int t = 0, x = 0; t < 10 && x < 6; ++t) {
            int count[][] = new int[6][26], best = 0;
            for (String w : wordlist) 
                for (int i = 0; i < 6; i++)
                    count[i][w.charAt(i) - 'a']++;
        
            String guess = wordlist[0];
            for (String w : wordlist) {
                int score = 0;
                // for a word, the score if the total number of occurance of all characters at its index
                for (int i = 0; i < 6; i++)
                    score += count[i][w.charAt(i) -'a'];
                if (score > best) {
                    guess = w;
                    best = score;
                }
            }
            
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<String>();
            for(String w : wordlist)
                if (getMatches(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
}