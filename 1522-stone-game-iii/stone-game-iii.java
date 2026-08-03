class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int tot=0;
        for(int i : stoneValue){
            tot+=i;
        }
        int dp[] = new int[stoneValue.length];
        Arrays.fill(dp,1000000000);
        
        int ans = helper(0,stoneValue,dp);
        System.out.println(tot);
        System.out.println(ans);
        if(tot%2==0 && tot/2 == ans)return "Tie";
        else if(tot-ans < ans) return "Alice";
        return "Bob";
    }

    public int helper(int i, int arr[], int dp[]){
        if(i>=arr.length)return 0;

        if(dp[i]!=1000000000)return dp[i];

        int ans = arr[i] + Math.min(helper(i+2,arr,dp), Math.min(helper(i+3,arr,dp), helper(i+4,arr,dp)));

        if(i+1<arr.length){
            int opt2 = arr[i]+arr[i+1]+ Math.min(helper(i+3,arr,dp), Math.min(helper(i+4,arr,dp), helper(i+5,arr,dp)));
            ans = Math.max(ans, opt2);
        } 

        if(i+2<arr.length){
            int opt3 = arr[i]+arr[i+1]+arr[i+2]+ Math.min(helper(i+4,arr, dp), Math.min(helper(i+5,arr,dp), helper(i+6,arr,dp)));
            ans = Math.max(ans, opt3);
        } 

        return dp[i]=ans;
    }
}