class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++)
            ans = Math.max(ans, Math.abs(nums[i + 1] - nums[i]));
        ans = Math.max(ans, Math.abs(nums[nums.length - 1] - nums[0]));
        return ans;
    }
}