class Solution {
    public char findTheDifference(String s, String t) {
        int ans=0;
        
        for(char num : s.toCharArray() ){
            ans^=num;
        }
        for(char nums :t.toCharArray()){
            ans^=nums;

        }
        return (char)ans;
        
    }
}