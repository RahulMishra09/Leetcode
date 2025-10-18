class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);                 // sort first
        long curr = Long.MIN_VALUE;        // smallest next usable number
        int ans = 0;
        for (int x : nums) {
            long start = x - (long)k;
            long end = x + (long)k;
            long pick = Math.max(start, curr); // pick smallest ≥ curr
            if (pick <= end) {
                ans++;
                curr = pick + 1;           // shift to next available
            }
        }
        return ans;
    }
}