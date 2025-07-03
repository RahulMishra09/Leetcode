class Solution {
    public int calPoints(String[] s) {
        Stack<String> st = new Stack<>();
        int sum = 0;
        for(int i=0;i<s.length;i++){
            if(s[i].equals("C")){
                st.pop();
            }
            else if(s[i].equals("D")){
                int n = 2*Integer.parseInt(st.peek());
                st.push(Integer.toString(n));
            }
            else if(s[i].equals("+")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.peek());
                int n = a+b;
                String e=Integer.toString(n);
                st.push(Integer.toString(a));
                st.push(e);
            }
            else{
                st.push(s[i]);
            }

        }

        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }

        return sum;
        
    }
}