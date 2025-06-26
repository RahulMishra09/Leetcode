class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1;
        long end = x;
        long ans = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == x) {
                return (int)mid; // Exact sqrt found
            } else if (mid * mid < x) {
                ans = mid;        // Potential answer
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int)ans; // Closest integer sqrt
    }
}
