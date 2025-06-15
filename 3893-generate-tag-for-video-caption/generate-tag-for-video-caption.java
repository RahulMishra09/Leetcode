class Solution {
    public String generateTag(String str){
        
        String[] arr= str.trim().split(" ");
        if (arr.length < 1) return "#";
        
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        sb.append(arr[0].toLowerCase());

        for(int i=1; i<arr.length; i++){
            int wordlen=arr[i].length();
            if(wordlen==0) continue;
            sb.append(arr[i].substring(0,1).toUpperCase());
            sb.append(arr[i].substring(1).toLowerCase());
            if(sb.length()>=100) break;
        }

        String ans= sb.toString();

     
        if(ans.length()>=100){
            return ans.substring(0, 100);
        }
        
        return ans;
    }
}