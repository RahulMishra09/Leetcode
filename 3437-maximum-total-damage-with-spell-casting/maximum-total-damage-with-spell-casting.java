class Solution {

    private int findLastNonConflicting(List<Integer> keys, int i) {
        int lo = 0, hi = i - 1, ans = -1;
        int target = keys.get(i) - 3;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (keys.get(mid) <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    public long maximumTotalDamage(int[] power) {
      if (power == null || power.length == 0) return 0;

        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + (long)p);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = map.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long currTotal = map.get(keys.get(i));
            int j = findLastNonConflicting(keys, i);
            long include = currTotal + (j >= 0 ? dp[j] : 0L);
            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
        
    }
}