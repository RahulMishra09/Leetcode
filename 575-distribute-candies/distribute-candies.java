class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        int m=n/2;
        Set<Integer> store= new HashSet<>();

        for(int num:candyType){
            store.add(num);

        }
        if(store.size()==m){
            return m;
        }else if(store.size()<m){
            return store.size();
        }
        return m;
        
    }
}