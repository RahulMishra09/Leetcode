class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums); // Sort so we can use two pointers
        int n = nums.length;

        // Precompute powers of 2 up to n
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences between left and right are valid
                result = (result + pow[right - left]) % mod;
                left++;
            } else {
                right--; // Try smaller max value
            }
        }

        return result;
    }
}
