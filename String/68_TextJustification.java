class Solution {
    // O(n) n = number of characters
    // O(n + k) k = number of spaces
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        
        // form the result (justify and add) line by line
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }
    
    // find the last word position of this line
    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();
        
        return right - 1;
    }
    
    // take a line and add spaces based on requirement
    // 1. one word -> result is that word
    // 2. last line -> words seperated by spaces
    // 3. else -> calculate size of space evenly, distribute extra space until none left
    private String justify(int left, int right, String[] words, int maxWidth) {
        // if just one word
        if (right - left == 0) 
            return padResult(words[left], maxWidth);
        
        // checks if we are at last line
        boolean isLastLine = right == words.length - 1;
        // the number of space is the space in between the left and right word
        // don't count the right of right word
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        StringBuilder result = new StringBuilder();
        // loop to add spaces after each word
        // right side of last word also added but will be removed later
        for (int i = left; i <= right; i++) {
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        }
        
        // return a padded result, for the last line only
        return padResult(result.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) 
            wordsLength += words[i].length();
        return wordsLength;
    }
    
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

}