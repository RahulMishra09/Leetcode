class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // sort (value, index) pairs
        long[] enc = new long[n];
        for (int i = 0; i < n; i++) enc[i] = ((long) nums[i] << 20) | i;
        java.util.Arrays.sort(enc);

        int[] pos = new int[n];      // original node -> sorted position
        int[] sorted = new int[n];   // sorted values
        for (int i = 0; i < n; i++) {
            int idx = (int) (enc[i] & 0xFFFFF);
            pos[idx] = i;
            sorted[i] = (int) (enc[i] >> 20);
        }

        // far[i] = farthest sorted position reachable in ONE step from i (to the right)
        int[] far = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sorted[j + 1] - sorted[i] <= maxDiff) j++;
            far[i] = j;
        }

        // binary lifting: up[k][i] = position after 2^k greedy jumps
        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        int[][] up = new int[LOG + 1][];
        up[0] = far;
        for (int k = 1; k <= LOG; k++) {
            up[k] = new int[n];
            for (int i = 0; i < n; i++) up[k][i] = up[k - 1][up[k - 1][i]];
        }

        int[] ans = new int[queries.length];
        for (int t = 0; t < queries.length; t++) {
            int u = queries[t][0], v = queries[t][1];
            if (u == v) { ans[t] = 0; continue; }

            int a = pos[u], b = pos[v];
            if (a > b) { int tmp = a; a = b; b = tmp; }

            if (far[a] >= b) { ans[t] = 1; continue; }

            int steps = 0, cur = a;
            for (int k = LOG; k >= 0; k--) {
                int nxt = up[k][cur];
                if (nxt < b && nxt > cur) {   // take jump only if it progresses but stays short of b
                    steps += 1 << k;
                    cur = nxt;
                }
            }
            ans[t] = (far[cur] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}