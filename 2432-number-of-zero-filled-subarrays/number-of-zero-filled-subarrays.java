class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long set=0;
        long wet=0;
        for(int num:nums){
            set=(num == 0)?set+1:0;
            wet+=set;
        }
        return wet;
        
    }
}