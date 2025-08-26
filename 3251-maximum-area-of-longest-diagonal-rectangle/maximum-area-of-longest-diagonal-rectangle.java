class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        int area=0;
        int diag=0;
        if(dimensions.length == 0){
            return 0;
        }
        for(int i=0;i<n;i++){
            int len=dimensions[i][0];
            int width=dimensions[i][1];
            int dhruvdiagon= len*len+width*width;

            if(dhruvdiagon > diag || dhruvdiagon == diag && len * width > area){
                diag= dhruvdiagon;
                area=len*width;
            }
        }
        return area;
        
    }
}