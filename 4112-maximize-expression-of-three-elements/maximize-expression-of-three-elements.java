class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int a=nums[nums.length-1];
        int b=nums[nums.length-2];
        int c=nums[0];
        return a+b-c;
        
    }
}