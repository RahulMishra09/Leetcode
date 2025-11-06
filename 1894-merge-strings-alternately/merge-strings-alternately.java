class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res= new StringBuilder();
        int n=Math.max(word1.length(),word2.length());
        for(int i=0;i<n;i++){
            if(word1.length()>i){
                res.append(word1.charAt(i));
            }
            if(word2.length()>i){
                res.append(word2.charAt(i));
            }
        }
        return res.toString();
        
    }
}