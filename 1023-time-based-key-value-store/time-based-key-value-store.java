class TimeMap {
    private Map<String, String> storage;
    private Map<String, TreeSet<Integer>> timestamps;
    private static final String SENTINEL = "\uD83D\uDC07"; // \U0001f407
    private static final String EMPTY = "";

    public TimeMap() {
        this.storage = new HashMap<>();
        this.timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Construct unique key (key + delimiter + timestamp)
        String constructedKey = constructKey(key, timestamp);

        // Store value in storage
        storage.put(constructedKey, value);

        // Track timestamps
        timestamps.putIfAbsent(key, new TreeSet<>());
        timestamps.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {
        // Get timestamps for this key
        TreeSet<Integer> retrievedTimestamps = timestamps.get(key);
        if (retrievedTimestamps == null) {
            return EMPTY;
        }

        // Find closest timestamp <= given timestamp
        Integer maxTimestamp = retrievedTimestamps.floor(timestamp);
        if (maxTimestamp == null) {
            return EMPTY;
        }

        // Return stored value
        String constructedKey = constructKey(key, maxTimestamp);
        return storage.getOrDefault(constructedKey, EMPTY);
    }

    private String constructKey(String key, int timestamp) {
        return key + SENTINEL + timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
