/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
    
        // Approach 1: brute force
        // For each user, check if he knows none and everyone knows him
        // O(n ^ 2) n for loop of each, n for checking if everyone knows him
        // O(1)
        private int numberOfPeople;
        
        public int findCelebrity(int n) {
            numberOfPeople = n;
            for (int i = 0; i < n; i++) {
                if (isCelebrity(i)) 
                    return i;
            }
            return -1;
        }
        
        // For this particular person, check if all of its neighbors knows him/her and check if she doesn't know 
        // each neighbor. Skip the case where (i == j) same person.
        private boolean isCelebrity(int i) {
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == j) continue;
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
            return true;
        }
        
        // Approach 2: Logical Deduction
        // O(n)
        // O(1)
        // Narrow the choice of celebrity down to 1 candidate, then check if this candidate is complete celebrity.
        private int numberOfPeople;
        
        public int findCelebrity(int n) {
            numberOfPeople = n;
            // assume celebrity is 0
            int celebrityCandidate = 0;
            
            // loop through 1 by 1 to find the only celebrity candidate thats possible
            for (int i = 0; i < n; i++) {
                if (knows(celebrityCandidate, i)) {
                    celebrityCandidate = i;
                }    
            }
            
            // check if this is the actual celebrity
            if (isCelebrity(celebrityCandidate)) 
                return celebrityCandidate;
            return -1;
        }
        
        private boolean isCelebrity(int i) {
            // check to know all people know i but i does not know anyone
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == j)
                    continue;
                if (knows(i, j) || !knows(j, i))
                    return false;
            }
            return true;
        }
        
        // Approach 3: Logical deduction with caching.
        // O(n) O(1)
        // We repeat some knows() calls in last approach, we can cache results to eliminate this redundency.
        // Caching is always less expensive than retrieving. We also don't know the cost of knows() to be sure.
        // Store cache in a hashmap
        private int numberOfPeople;
        private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
        
        // overide the knows function, add cache functionality
        @Override
        public boolean knows(int a, int b) {
            // if this relationship is not yet stored in cache
            if (!cache.containsKey(new Pair(a, b))) {
                // put result into cache
                cache.put(new Pair(a, b), super.knows(a, b));
            }
            
            return cache.get(new Pair(a, b));
        }
        
        public int findCelebrity(int n) {
            numberOfPeople = n;
            int celebrityCandidate = 0;
            
            for (int i = 0; i < n; i++) {
                if (knows(celebrityCandidate, i))
                    celebrityCandidate = i;
            }
            
            if (isCelebrity(celebrityCandidate))
                return celebrityCandidate;
            
            return -1;
        }
        
        private boolean isCelebrity(int i) {
            for (int j = 0; j < numberOfPeople; j++) {
                if (i==j) continue;
                if (knows(i, j) || !knows(j,i))
                    return false;
            }
            return true;
        }
    }