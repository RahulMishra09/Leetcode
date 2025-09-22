import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
      
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
     
        int maxFreq = Collections.max(freq.values());
        
 
        int total = 0;
        for (int val : freq.values()) {
            if (val == maxFreq) {
                total += val;
            }
        }
        
        return total;
    }
}