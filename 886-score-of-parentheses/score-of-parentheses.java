class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> num= new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                num.push(ans);
                ans=0;
            }else{
                ans=num.pop()+Math.max(2*ans,1);
            }
        }
        return ans;
        
    }
}