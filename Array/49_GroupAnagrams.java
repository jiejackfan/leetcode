// 6/14/2021
// First leetcode back from vacation

class Solution {
    // Categorize by Sorted String
    // O(n klogk) n is the length of string array, klogk is time to sort longest string
    // O(nk)
    // Create a hashtable to store results
    // Key is the different sorted anagrams, value is the array of anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        
        for (String s: strs) {
            //convert this string into char array and sort using Arrays.sort()
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            
            // convert back to string to be stored as hashtable key
            String key = String.valueOf(ca);
            
            // put key into hashtable
            // if key does not exist add new key and arraylist
            // if key exists, add original string in to value array
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
    
    // Categorize by Count
    // o(nk)
    // O(nk)
    // Create a hashtable to store. Key=string of character count, value=arraylist of string
    public List<List<String>> groupAnagrams(String[] strs) {
        // if not str given, return empty arrayList
        if (strs.length == 0) return new ArrayList();
        
        // create hashmap
        Map<String, List> ans = new HashMap<String, List>();
        
        // for each string
        for (String s : strs) {
            //create an array of size 26
            int[] count = new int[26];
            
            // read string char by char and fill the count array
            Arrays.fill(count, 0);
            for (char c: s.toCharArray()){
                count[c - 'a']++;
            }
            
            // use StringBuilder to build key
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            
            // convert key into string
            String key = sb.toString();
            
            // fill in hashtable
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        
        return new ArrayList(ans.values());
    }
}