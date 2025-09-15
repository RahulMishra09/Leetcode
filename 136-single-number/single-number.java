class Solution {
    public int singleNumber(int[] nums) {
        int lol=0;
        for(int i =0;i<nums.length;i++){
            
            lol=lol^nums[i];

        }
        return lol;
    }
}