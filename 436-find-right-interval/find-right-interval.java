class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];  // [start, index]
        
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        
        // sort by start
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // Binary search in starts for the smallest start >= end
            int l = 0, r = n - 1, idx = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (starts[mid][0] >= end) {
                    idx = starts[mid][1];
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            
            result[i] = idx;
        }
        
        return result;
    }
}
