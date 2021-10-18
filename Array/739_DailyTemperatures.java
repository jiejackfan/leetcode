class Solution {
    // Approach 1: Monotonic stack
    // Use a stack to keep track of days without an answer yet. Move on to later days, and check top of stack to
    // calculate answer.
    // O(n) O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currDay = 0; currDay < n; currDay++) {
            int currTemp = temperatures[currDay];
            
            // check stack, put answers in the prevDays that have lower temperature than currTemp
            // == pop when prevDay temp < currTemp
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                System.out.println(stack.peek());
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            
            stack.push(currDay);
        }
        return answer;
    }
    
    // Approach 2: 
    // Going back to front. At each day, use the days information from the later days to find the answer, we can skip
    // days with lower temeprature. 
    // O(n) O(1)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;   
        int answer[] = new int[n]; // initialized to 0?
        
        // going from the back, 
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currTemp = temperatures[currDay];
            
            // if currTemp is greater than hottest, no point checking answer. Put down 0
            if (currTemp >= hottest) {
                hottest = currTemp;
                continue;
            }
            
            // init days
            int days = 1;
            while (temperatures[currDay + days] <= currTemp){
                // use currDay and days to find the next warmer day
                days += answer[currDay + days];
            }
            
            answer[currDay] = days;
        }
        
        return answer;
    }
}