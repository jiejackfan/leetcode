// 9/4/2021
class MyHeapNode {
    int row;
    int col;
    int val;
    
    public MyHeapNode(int v, int r, int c) {
        this.row = r;
        this.val = v;
        this.col = c;
    }
    
    public int getVal() {
        return this.val;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
}

class MyHeapComparator implements Comparator<MyHeapNode> {
    // comparator should return the heap element with the smaller value
    @Override
    public int compare(MyHeapNode x, MyHeapNode y) {
        return x.getVal() - y.getVal();
    }
}

class Solution {
    
    // Approach 1: Min Heap and Custom Heap Node
    // Design a min heap that is based on min value of the node
    // Iterate k times, deleting/updating the min node each time
    // O(X + klogX) let X = min(k,N) 
    // O(X)
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        
        // build a min heap with custom node and custom comparator
        PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Math.min(N, k), new MyHeapComparator());
        
        // add the first batch of nodes in our min heap
        for (int r = 0; r < Math.min(N, k); r++) {
            minHeap.offer(new MyHeapNode(matrix[r][0], r, 0));
        }
        
        // loop until we exhaust k min elements
        // for each min, we delete its information and put the next val (row, col+1) in
        MyHeapNode element = minHeap.peek();
        while (k-- > 0) {
            // extract/delete the curret min heap
            element = minHeap.poll();
            int row = element.getRow();
            int col = element.getCol();
            // if this row still has elements, add the next col value into the heap
            if (col < N - 1) {
                minHeap.offer(new MyHeapNode(matrix[row][col+1], row, col+1));
            }
        }
        
        // return the last of k elements as the answer 
        return element.getVal();
    }
}