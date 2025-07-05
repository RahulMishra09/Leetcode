class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> store=new HashMap<>();
        for(int num: arr){
            store.put(num,store.getOrDefault(num,0)+1);

        } 
        int ans =-1;
        for(int num:store.keySet()){
            if(num == store.get(num))

            ans=num;
        } 
        return ans;    
    }
}