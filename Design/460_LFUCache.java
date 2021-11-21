final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    // Each frequency has a list of nodes to remove.
    Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = 0;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    // get node, update frequency, relocate that node
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null)
            return -1;
        
        updateNode(curNode);
        return curNode.val;
    }
    
    // add new node to LFU cache, and doubly linked list
    // condition 1: if cache contains this key, update value and its position/frequency
    // condition 2: if cache does not have input key
    //  sub 1: if no space, remove the LRU in min freq list, then add new node
    //  sub 2: if has space, add node directly
    public void put(int key, int value) {
        // corner case: check capacity
        if (capacity == 0)
            return;
        
        // if contains key, update
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            curSize++;
            // remove if overspace
            if (curSize >capacity) {
                // get min frq list
                // delete node from minfreq list and cache
                // decrease size
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                curSize--;
            }
            
            // add new node
            // reset min frequency to 1 because adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            
            // add the new node into DLL for min frequency list
            // add  node into cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
    
    // helper to update frequency and relocate that node
    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        
        // if last element in this frequency, move on to next freq level
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }   
        curNode.frequency++;
        
        // add current node to another list that has current freq+1
        // if we don't have the list, create it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
    
    class DLLNode {
        int key, val;
        int frequency;
        DLLNode prev, next;
        
        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }
    
    // DLL used to store the list order at a certain frequency
    class DoubleLinkedList {
        int listSize;
        DLLNode head, tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        // add new node into head and increase list size by 1
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            
            head.next = curNode;
            nextNode.prev = curNode;
            
            listSize++;
        }
        
        // remove node, decrease list size by 1
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
        
        public DLLNode removeTail() {
            if (listSize > 0) {
                DLLNode tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }