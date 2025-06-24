class Solution {
    public String simplifyPath(String path) {
          Stack<String> stack = new Stack<>();
        String[] s=path.split("/");
        for(String com:s){
            if(com.equals("")||com.equals(".")){
                continue;
            }
            if(com.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(com);
            }

        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,"/"+stack.pop());
        }
        return sb.length()==0?"/":sb.toString();
        
    }
}