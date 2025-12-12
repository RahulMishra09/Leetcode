class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> ans= new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int comp=target-nums[i];
        if(ans.containsKey(comp)){
            return new int[]{ans.get(comp),i};
        }
        ans.put(nums[i],i);
       }
       return new int[]{0,0};
    }
     
}