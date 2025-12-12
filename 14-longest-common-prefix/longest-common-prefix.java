class Solution {
    public String longestCommonPrefix(String[] strs) {
        String start=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(start)){
                start=start.substring(0,start.length()-1);
            }
            if(start.isEmpty()){
                return "";
            }
        }
        return start;
    }
}