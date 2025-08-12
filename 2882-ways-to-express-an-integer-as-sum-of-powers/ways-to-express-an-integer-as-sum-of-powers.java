import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        List<Integer> powers = new ArrayList<>();
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            powers.add((int) Math.pow(i, x));
        }

        for (int p : powers) {
            for (int s = n; s >= p; s--) {
                dp[s] = (dp[s] + dp[s - p]) % MOD;
            }
        }
        return (int) dp[n];
    }
}
