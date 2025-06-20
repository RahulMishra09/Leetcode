class Solution {
    public int maxDistance(String s, int k) {
        int manhattan=0;
        int north=0;int south =0;
        int east =0;int west =0;
        for(int i =0;i<s.length();i++){
            char c=s.charAt(i);
            if (c == 'N') north++;
            else if (c == 'S') south++;
            else if (c == 'E') east++;
            else if (c == 'W') west++;
            int x=Math.abs(north-south);
            int y=Math.abs(east-west);
            int MD=x+y;//Manhattan Distance
            int dis=MD+Math.min(2*k,i+1-MD); // Ensure changes are at most k
            manhattan=Math.max(manhattan,dis);
        }
        return manhattan;
        
    }
}