import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        
        Integer[] freqBoxed = new Integer[26];
        for (int i = 0; i < 26; i++) {
            freqBoxed[i] = freq[i];
        }
        Arrays.sort(freqBoxed, Collections.reverseOrder());

        
        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            if (freqBoxed[i] == 0) break;
            int costMultiplier = (i / 8) + 1; 
            totalPushes += costMultiplier * freqBoxed[i];
        }

        return totalPushes;
    }
}