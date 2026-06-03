class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int ans=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix=nums[i]*prefix;
            suffix=nums[n-i-1]*suffix;
            ans=Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
}