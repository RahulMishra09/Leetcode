class Solution {
    public int addDigits(int num) {
        if(num==0){
            return 0;
        }
        int n=num;
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n=n/10;
            
        }
        if(sum<10){
            return sum;
        }else{
            return addDigits(sum);
        }
        
    }
}