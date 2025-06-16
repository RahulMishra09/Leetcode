class Solution {
    public int maximumDifference(int[] nums) {
        int number = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    number = Math.max(number, nums[j] - nums[i]);
                }
            }
        }

        return number;
    }
}
