class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE; // Minimum length of the subarray
        int left = 0;                   // Left pointer of the sliding window
        int sum = 0;                    // Current sum of the sliding window

        // Iterate with the right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Add current number to the window sum

            // As long as the window satisfies the target, try to shrink it
            while (sum >= target) {
                // Update the minimal length if the current window is smaller
                minLen = Math.min(minLen, right - left + 1);
                // Subtract the leftmost number from sum to shrink the window
                sum -= nums[left];
                // Move the left pointer forward
                left++;
            }
        }

        // If no valid subarray was found, return 0, otherwise return the minimal length
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
