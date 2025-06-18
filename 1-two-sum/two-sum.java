class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> store=new HashMap<>();
        int length=nums.length;

        for(int i =0;i<length;i++){
            int complement=target-nums[i];
            if(store.containsKey(complement)){
                return new int[]{store.get(complement),i};
            }
            store.put(nums[i],i);//storing or mapping
        }
        return new int[]{};// No solution 
        
    
    }
}