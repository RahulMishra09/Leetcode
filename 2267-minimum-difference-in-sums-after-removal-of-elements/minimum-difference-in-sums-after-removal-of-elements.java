class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] leftSum = new long[len];
        long[] rightSum = new long[len];

        // Left: max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long left = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.add(nums[i]);
            left += nums[i];
            if (maxHeap.size() > n) {
                left -= maxHeap.poll(); // remove largest
            }
            if (maxHeap.size() == n) {
                leftSum[i] = left;
            } else {
                leftSum[i] = Long.MAX_VALUE;
            }
        }

        // Right: min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long right = 0;
        for (int i = len - 1; i >= n; i--) {
            minHeap.add(nums[i]);
            right += nums[i];
            if (minHeap.size() > n) {
                right -= minHeap.poll(); // remove smallest
            }
            if (minHeap.size() == n) {
                rightSum[i] = right;
            } else {
                rightSum[i] = Long.MAX_VALUE;
            }
        }

        // Find minimum difference between leftSum and rightSum.
        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (rightSum[i + 1] != Long.MAX_VALUE) {
                result = Math.min(result, leftSum[i] - rightSum[i + 1]);
            }
        }

        return result;
    }
}
