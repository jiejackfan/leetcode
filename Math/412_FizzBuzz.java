// April 24, 2021

class Solution {
    // brute force
    // O(n) O(1)
    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) arr.add("FizzBuzz");
            else if (i % 3 == 0) arr.add("Fizz");
            else if (i % 5 == 0) arr.add("Buzz");
            else arr.add(String.valueOf(i));
        }     
        return arr;
    }
    
    // Approach 2: string concat, reduce if cases for FizzBuzzJazz (more complex FizzBuzz).
    // O(n) O(1)
    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String ansStr = "";
            if (i % 3 == 0) ansStr += "Fizz";
            if (i % 5 == 0) ansStr += "Buzz";
            if (ansStr == "") ansStr += Integer.toString(i);
            arr.add(ansStr);
        }     
        return arr;
    }
    
    // Approach 3: 
    // O(n) O (1)
    // Use HashMap to store mappings. This way the code can be reused when new mappings are added.
    public List<String> fizzBuzz(int n) {
        HashMap<Integer, String> table = new HashMap<Integer, String>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        List<String> ans = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
            String ansStr = "";
            for (Integer key:table.keySet()) {
                if (i % key == 0) {
                    ansStr += table.get(key);
                }
            }
            if (ansStr == "") ansStr += Integer.toString(i);
            ans.add(ansStr);
        }
        
        return ans;
    }
}