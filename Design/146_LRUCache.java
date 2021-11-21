// March 27, 2021
// tag: Design

// Approach 1: LinkedHashMap (Not for interview)
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



// Approach 2: HashMap & Double Linked List
// O(1) Get/put data in hashmap O(1). Insert/delete in doubly linked list at head/tail O(1)
// O(capacity) Physical storage
class LRUCache {
    
    class DLinkedNode {
        int key, value;
        DLinkedNode prev, next;
    }
    
    // always insert node at the beginning right after head
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    // remove existing node from linked list
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    // move a node to head position
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    
    // delete node at tail
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    // return key if in cache map, otherwise return -1
    // when accessed, move the node to front so it is more recently used
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) 
            return -1;
        
        moveToHead(node);
        return node.value;
    }
    
    // if node not in cache, create new node. if size exceeds capacity, remove tail
    // else update the value
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            
            ++size;
            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
