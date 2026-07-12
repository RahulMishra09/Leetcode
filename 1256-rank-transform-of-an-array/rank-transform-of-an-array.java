class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int ans[]=arr.clone();
        Arrays.sort(ans);
        HashMap<Integer, Integer> mapping=new HashMap<>();
        int rank=1;
        for(int nums:ans){
            if(!mapping.containsKey(nums)){
                mapping.put(nums,rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=mapping.get(arr[i]);
        }
        return arr;
        
    }
}