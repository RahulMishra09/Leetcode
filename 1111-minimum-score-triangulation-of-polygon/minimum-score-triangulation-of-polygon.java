class Solution {
    int[][] dp;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(values, 0, n - 1);
    }

    private int solve(int[] values, int i, int j) {
        
        if (j - i < 2) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int score = values[i] * values[k] * values[j]
                        + solve(values, i, k)
                        + solve(values, k, j);
            ans = Math.min(ans, score);
        }
        return dp[i][j] = ans;
    }
}