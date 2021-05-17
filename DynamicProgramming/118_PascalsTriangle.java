// May 16, 2021

class Solution {
    // Dynammic programming problem. The next row is constructed based on the previous row. 
    // O(numRows ^ 2) out for loop plus inner for loop 
    // O(numRows ^ 2) same as time complexity
    // The first row and the first/last element on each row is set so we can pre-set them
    // First for loop is to construct each row. Second for loop is to construct elements in each row
    public List<List<Integer>> generate(int numRows) {
        //need to return as list of list, we use array list
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // check null case when numRows == 0
        if (numRows == 0) return result;
        
        // add for the first row
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        result.add(row);
        
        // add the next rows in a for loop
        for (int i = 1; i < numRows; i++) {
            // create new row
            row = new ArrayList<Integer>();
            // gain access to previous row for calculation
            List<Integer> prev = result.get(i - 1);
            
            // first element in the new row is always 1
            row.add(1);
            
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            
            // last element in the new row is always 1
            row.add(1);
            
            // add new row into result
            result.add(row);
        }
        
        return result;
    }
}