/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    
    // Approach 1: Flatten list in contructor using recursion.
    // build answer array
    private List<Integer> integers = new ArrayList<Integer>();
    
    // build pointer of current integer position
    private int position = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }
    
    // recursively 
    private void flattenList (List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger: nestedList) {
            if (nestedInteger.isInteger()) 
                integers.add(nestedInteger.getInteger());
            else 
                flattenList(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        // if no next, then throw exception
        if (!hasNext()) throw new NoSuchElementException();
        // get the integer at current position and increase pointer
        return integers.get(position++);
    }

    @Override
    public boolean hasNext() {
        return position < integers.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */