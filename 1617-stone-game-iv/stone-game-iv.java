class Solution {
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        return winnerUtil(n, map);
    }
    private boolean winnerUtil(int n, HashMap<Integer, Boolean> map) {
        
        if(n<=0)
            return false;
        
        if(map.containsKey(n))
            return map.get(n);
        
        
        for(int i=1;i*i<=n;i++) {
            
            int opponent = n-i*i;
            if(!winnerUtil(opponent, map))
            {
                map.put(n, true);
                return true;
            }
        }
        map.put(n, false);
        return false;
    }
}