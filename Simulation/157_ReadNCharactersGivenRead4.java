//8/16/2021

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    // Approach 1: Using internal buffer of 4 characters
    // Double copy: copy into buf4 array and then copy into buf array
    // O(n) go through each character once
    // O(1) keeps a buf4 const size array
    public int read(char[] buf, int n) {
        // copiedChars will be return answer, if exceeds our n, we return ans
        // readChars will check buf4() result, if result < 4 then return ans
        int copiedChars = 0, readChars = 4;
        
        char[] buf4 =new char[4];
        
        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);
            
            for (int i = 0; i < readChars; i++) {
                if (copiedChars == n)
                    return copiedChars;
                buf[copiedChars] = buf4[i];
                ++copiedChars;
            }
        }
        return copiedChars;
    }
    
}