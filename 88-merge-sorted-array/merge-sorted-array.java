class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr3 = new int[m + n];
        int p1 = 0, p2 = 0, k = 0;

        
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                arr3[k++] = nums1[p1++];
            } else {
                arr3[k++] = nums2[p2++];
            }
        }

       
        while (p1 < m) {
            arr3[k++] = nums1[p1++];
        }

        
        while (p2 < n) {
            arr3[k++] = nums2[p2++];
        }

        
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr3[i];
        }
    }
}