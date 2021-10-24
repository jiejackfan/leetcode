class Solution {
    // Approach 1 : Max Heap 
    // Create a map heap that stores minimum distance 
    // Only keep k nodes in the heap
    // O(nlogk) O(k)
    public int[][] kClosest(int[][] points, int k) {
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] left, int[] right) {
                    // return <0 to pick left
                    // return >0 to pick right
                    // building max heap so right - left
                    return (right[0]*right[0] + right[1]*right[1] -
                            left[0]*left[0] - left[1]*left[1]);
                }
            }    
        );

        // pq declaration with lambda
        // PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
        //     (a, b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));
            
        // add each node into max heap, remove max if exceeds k
        for (int[] point : points) {
            pq.add(point);
            // kick out the current max if the size exceeds k
            if (pq.size() > k)
                pq.poll();
        }
        
        // put result into array and return
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        
        return result;
    }
}