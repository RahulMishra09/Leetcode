class Solution {
    double[][] dp = new double[201][201]; 

    public double soupServings(int n) {
        
        if (n > 5000) return 1.0;

       
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                dp[i][j] = -1.0;
            }
        }

 
        int N = (int) Math.ceil(n / 25.0);
        return dfs(N, N);
    }

    private double dfs(int A, int B) {
        // Base cases
        if (A <= 0 && B > 0) return 1.0;  
        if (A <= 0 && B <= 0) return 0.5;  
        if (A > 0 && B <= 0) return 0.0;   

       
        if (dp[A][B] != -1.0) return dp[A][B];

        
        double ans = 0.25 * (dfs(A - 4, B) + dfs(A - 3, B - 1) + dfs(A - 2, B - 2) + dfs(A - 1, B - 3));

        dp[A][B] = ans;
        return ans;
    }
}
