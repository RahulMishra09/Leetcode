class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        
        String prev = "";  // added folder
        for (String path : folder) {
            if (prev.isEmpty() || !path.startsWith(prev + "/")) {
                result.add(path);
                prev = path;
            }
        }
        
        return result;
    }
}
