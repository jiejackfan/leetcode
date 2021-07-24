// 07/24/2021
class RandomizedSet {
    // key = element value key = index
    Map<Integer, Integer> dict;
    // stores elements by order
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) 
            return false;
        
        // if not present, add val to hashtable and list
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dict.containsKey(val))
            return false;
        
        // find index in hashtable, replace this index with the last element in list and pop list
        int index = dict.get(val);
        int temp = list.get(list.size() - 1);
        list.set(index, temp);
        dict.put(temp, index);
        
        // delete the val
        list.remove(list.size()-1);
        dict.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // nextInt is inclusive to exclusive
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */