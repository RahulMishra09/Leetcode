class Solution {
    public int subsetXORSum(int[] nums) {
        int total=0;
        for(int num:nums){
            total|=num;//Compute bitwise OR of all numbers
        }
        return total*(1<<(nums.length-1));//mutiplying by 2^(n-1)
    }
}