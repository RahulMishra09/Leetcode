class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the slope is rising, peak must be on the right
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } 
            // Otherwise, peak is at mid or to the left
            else {
                right = mid;
            }
        }

        // left == right will be the peak
        return left;
    }
}
