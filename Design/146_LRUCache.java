// March 27, 2021
// tag: Design

// Use LinkedHashmap structure to mimic behavior or LRU cache. Need to use a specific
// constructor to make the LinkedHashMap access ordered. Can use the parent class's get and
// put methods. Need to override removeEldestEntry function so LinkedHashMap will delete
// element if over capacity.
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override 
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
    
}