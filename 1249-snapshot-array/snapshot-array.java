import java.util.*;

class SnapshotArray {
    List<List<int[]>> history;
    int snapId = 0;

    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{0, 0});
            history.add(list);
        }
    }
    
    public void set(int index, int val) {
        List<int[]> list = history.get(index);
        if (list.get(list.size() - 1)[0] == snapId) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = history.get(index);
        int l = 0, r = list.size() - 1, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[0] == snap_id) {
                return list.get(mid)[1];
            } else if (list.get(mid)[0] < snap_id) {
                res = list.get(mid)[1];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}