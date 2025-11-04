class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> store =new HashSet<>();
        for(int num:nums){
            if(store.contains(num)){
                return true;
            }else{
                store.add(num);
            }
        }
        return false;
        
    }
}