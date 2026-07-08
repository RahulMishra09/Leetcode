class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digit = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digit.add(d);
            }
        }

        int m = pos.size();

        long[] pow = new long[m + 1];
        pow[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        long[] hash = new long[m + 1];
        long[] sum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            hash[i + 1] = (hash[i] * 10 + digit.get(i)) % MOD;
            sum[i + 1] = sum[i] + digit.get(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = lowerBound(pos, queries[i][0]);
            int r = upperBound(pos, queries[i][1]) - 1;

            if (l > r) {
                ans[i] = 0;
                continue;
            }

            int len = r - l + 1;

            long num = (hash[r + 1] - hash[l] * pow[len]) % MOD;
            if (num < 0) num += MOD;

            long digitSum = sum[r + 1] - sum[l];

            ans[i] = (int) ((num * (digitSum % MOD)) % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}