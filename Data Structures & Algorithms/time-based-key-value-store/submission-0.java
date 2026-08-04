class TimeMap {
    private HashMap<String, TreeMap<Integer,String>> map; 

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tree = map.get(key);

        if(tree  == null){
            return "";
        }

        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
