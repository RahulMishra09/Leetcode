import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Add all elements from nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check elements of nums2 in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num); 
            }
        }

        
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }
}
