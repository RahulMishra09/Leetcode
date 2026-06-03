class Solution {
    public int maxSubArray(int[] nums) {
        long sum=0;
        long ans=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>ans){
                ans=sum;
            }
            if(sum<0){
                sum=0;
            }

        }
        return (int) ans;
        
    }
}