class Solution {
    public int differenceOfSums(int n, int m) {
        int nums1=0;
        int nums2=0;
        for(int i=1;i<=n;i++){
            if(i%m == 0){
                nums2+=i;
            }else{
                nums1+=i;
            }

        }
        int result=nums1-nums2;
        return result;

    }
}