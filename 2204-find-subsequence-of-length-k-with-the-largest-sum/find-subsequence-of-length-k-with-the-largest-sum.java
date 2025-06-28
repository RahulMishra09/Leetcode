class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Min-heap that stores [value, index]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]  
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        // Store the k elements we kept
        List<int[]> topK = new ArrayList<>(minHeap);

        // Sort by original index to preserve subsequence order
        Collections.sort(topK, (a, b) -> a[1] - b[1]);

        // Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
