class Solution {
    
    // Approach 1 : Stack
    // O(N) O(N)
    // A list of astroid is stable, add new astroid in to make stable again.
    // Good example of using a stack for this situation
    // If top astroid and new astroid will collide, solve collision
    // If abs(top) > abs(new) new will blow, if abs(top) == abs(new) both will blow,
    // if abs(top) < abs(new) top will blow, we need to check top-1 as well
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            
            // decide whether to add new asteroid into stack
            boolean addNew = true;
            
            // collision may only happen if top asteroid going right && new asteroid going left
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

                // if abs(top) < abs(new), remove top and continue collision
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }

                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                    addNew = false;
                    break;
                }
                else {
                    addNew = false;
                    break;  
                }

            }
            
            // stack now balanced, add new asteroid to top
            if (addNew)
                stack.push(asteroid);
        
        }
        
        // put answer in array
        int[] ans = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0 ; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}