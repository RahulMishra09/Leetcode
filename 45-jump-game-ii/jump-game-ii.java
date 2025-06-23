class Solution {
    public int jump(int[] nums) {
        int jumps = 0;           // Number of jumps made
        int end = 0;             // End of the current range
        int farthest = 0;        // Farthest point we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            // Always try to get the furthest we can
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range
            if (i == end) {
                jumps++;            // We must make a jump
                end = farthest;     // Move range end to the furthest point
            }
        }

        return jumps;
    }
}
