import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> store = new HashSet<>();
        for (int i : nums) {
            if (store.contains(i)) {
                return i;   
            } else {
                store.add(i);
            }
        }
        return -1; 
    }
}