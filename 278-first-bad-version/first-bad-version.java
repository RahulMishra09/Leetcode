public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // Bad version found, but could be earlier
                right = mid;
            } else {
                // Mid is good, so first bad must be after mid
                left = mid + 1;
            }
        }

        return left; // or right, since left == right at the end
    }
}
