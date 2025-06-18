class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> duplicate=new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            int val=nums[i];

            if(duplicate.containsKey(val) && i-duplicate.get(val)<=k){
                return true;
            }
            duplicate.put(val,i);
            
            
        }
        return false;

        
    }
}