// 9/7/2021
// 10/22/2021
class MedianFinder {
    // Approach 1: Two Heap
    // Keep two halves of the list in one max heap and one min heap. "Small" heap is maxheap and stores
    // the median in poll() if odd, "large" heap is minheap and stores 1 medium in poll() if even.
    // findMedian() is O(1)
    // add() is O(logn)
    
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // ordered from large to small {5, 4, 3, 2, 1}
        small = new PriorityQueue<>(Collections.reverseOrder());
        
        // ordered from small to large {6, 7, 8, 9}
        large = new PriorityQueue<>();
        even = true;
    }
    
    // small is max heap (max at front), large is min heap (min at front)
    // design so that when odd, answer is the first in small.
    // if odd and we want to add, put in small heap, then move first of small to large
    // if even and want to add, put in large and move first of large into small
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        }
        else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        // if even, we poll small and large to find the average
        if (even) {
            return (double) (small.peek() + large.peek()) / 2.0;
        }
        // if odd, we poll only small because it has the extra element
        else {
            return (double) small.peek();   
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */