class Solution {
    public int subarrayBitwiseORs(int[] arr) {
    Set<Integer> allORs = new HashSet<>();
    Set<Integer> currentORs = new HashSet<>();
    
    for (int num : arr) {
        Set<Integer> newORs = new HashSet<>();
        
        // Add current number itself
        newORs.add(num);
        
        // OR with all previous OR values
        for (int prevOR : currentORs) {
            newORs.add(prevOR | num);
        }
        
        currentORs = newORs;
        allORs.addAll(currentORs);
    }
    
    return allORs.size();
}
}