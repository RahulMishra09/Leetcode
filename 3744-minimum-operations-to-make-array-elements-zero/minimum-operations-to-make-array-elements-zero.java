class Solution {
    // Count steps needed for a single number
    private long steps(long x) {
        long cnt = 0;
        while (x > 0) {
            x /= 4;
            cnt++;
        }
        return cnt;
    }

    // Sum of steps(1…n) using decomposition
    private long prefixSteps(long n) {
        if (n <= 0) return 0;
        long res = 0;
        long base = 1;
        while (base <= n) {
            long next = base * 4;
            // numbers in [base, min(n, next-1)] need at least (cnt+1) steps
            long high = Math.min(n, next - 1);
            long count = high - base + 1;
            res += count * (long)(Math.log(base) / Math.log(4) + 1); // step depth
            base = next;
        }
        return res;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long totalSteps = prefixSteps(r) - prefixSteps(l - 1);
            ans += (totalSteps + 1) / 2; // ceil division
        }
        return ans;
    }
}