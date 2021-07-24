// 7/24/2021

class Solution {
    
    // Approach 1: Modify comparator
    // This question is to practice using the comparactor interface.
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split log into 2 parts, identifier and content
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                // boolean to check if it is a digit log or not
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // case 1: both logs are letters
                if (!isDigit1 && !isDigit2) {
                    // compare content using compareTo()
                    int cmp = split1[1].compareTo(split2[1]);
                    // if there is a difference found, we return comp and let comparactor class reorder
                    // if cmp < 0 then 1st will be before the 2nd
                    // if cmp > 0 then 2nd will be before 1st
                    if (cmp != 0)
                        return cmp;
                    
                    // same content, compare identifier instead
                    return split1[0].compareTo(split2[0]);
                    
                }
                
                // case 2: if one log is digits log
                if (!isDigit1 && isDigit2)
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                
                // case 3: if both logs are digits
                else
                    return 0;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}