import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> res = new HashMap<>();
        
        
        for (int num : nums) {
            res.put(num, res.getOrDefault(num, 0) + 1);
        }

        
        for (int key : res.keySet()) {
            if (res.get(key) > n) {
                return key;  
            }
        }

        return -1;
    }
}