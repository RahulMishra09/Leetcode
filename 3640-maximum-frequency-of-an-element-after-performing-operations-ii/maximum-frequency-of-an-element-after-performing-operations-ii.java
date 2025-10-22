class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        TreeMap<Integer, Integer> prefixMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            prefixMap.put(num, prefixMap.getOrDefault(num, 0));
            prefixMap.put(num + k + 1, prefixMap.getOrDefault(num + k + 1, 0) - 1);
            prefixMap.put(num - k, prefixMap.getOrDefault(num - k, 0) + 1);
        }
        int maxFreq = 0, prefixSum = 0;
        for (Map.Entry<Integer, Integer> entry : prefixMap.entrySet()) {
            prefixSum += entry.getValue();
            int freq = freqMap.getOrDefault(entry.getKey(), 0);
            maxFreq = Math.max(maxFreq, Math.min(prefixSum - freq, numOperations) + freq);
        }
        return maxFreq;
    }
}