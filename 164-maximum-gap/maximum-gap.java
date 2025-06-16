class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int difference=0;
        if(n>=2){
            for(int i=1;i<n;i++){
                difference=Math.max(difference,nums[i]-nums[i-1]);
            }
            return difference;

        }
        return difference;
        

        
    
    }
}