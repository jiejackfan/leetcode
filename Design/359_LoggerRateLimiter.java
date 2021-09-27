class Logger {
    private HashMap<String, Integer> msgDict;
    
    public Logger() {
        //
        msgDict = new HashMap<>();
    }
    
    // O(1) O(n)
    public boolean shouldPrintMessage(int timestamp, String message) {
        // if new message, add to the dict
        if (!msgDict.containsKey(message)) {
            msgDict.put(message, timestamp);
            return true;
        }
        
        // if old message, update dict with new time if 10 second has passed
        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            msgDict.put(message, timestamp);
            return true;
        }
        else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */