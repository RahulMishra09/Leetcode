class Solution {
    public int maxFreeTime(int endpoint, int[] st, int[] et) {
        int n = st.length;
        TreeMap<Integer, Integer> multiset = new TreeMap<>();

        // simulate multiset
        add(multiset, st[0]);
        for (int i = 1; i < n; i++) {
            int cur_st = st[i];
            int prev_end = et[i - 1];
            int calc = cur_st - prev_end;
            add(multiset, calc);
        }

        add(multiset, endpoint - et[n - 1]);

        int mx = 0;
        for (int i = 0; i < n; i++) {
            int cur_st = st[i];
            int cur_end = et[i];
            int cur_time = cur_end - cur_st;

            int prev_end = (i == 0) ? 0 : et[i - 1];
            int prev_free = cur_st - prev_end;

            int nxt_st = (i == n - 1) ? endpoint : st[i + 1];
            int nxt_free = nxt_st - cur_end;

            remove(multiset, prev_free);
            remove(multiset, nxt_free);

            if (multiset.ceilingKey(cur_time) != null) {
                int endpoint_free = prev_free + nxt_free + cur_time;
                mx = Math.max(mx, endpoint_free);
            }

            mx = Math.max(mx, prev_free + nxt_free);

            add(multiset, prev_free);
            add(multiset, nxt_free);
        }

        return mx;
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        if (map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val) - 1);
    }
}