class Solution {
    private boolean check(char curr, char last) {
    return (last == '(' && curr == ')') || 
           (last == '{' && curr == '}') || 
           (last == '[' && curr == ']');
}

    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(!stack.isEmpty()){
                char last =stack.peek();
                if(check(curr,last)){
                    stack.pop();
                    continue;
                }

            }
            stack.push(curr);
        }
        return stack.isEmpty();
        
    }
}