class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums); 
        int count = 0;
        int pair = nums.length / 2;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
                i++;
            }
        }

        return count == pair;
    }
}
