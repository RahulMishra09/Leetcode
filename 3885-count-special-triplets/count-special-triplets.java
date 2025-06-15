import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> leftFreq = new HashMap<>();
        Map<Integer, Integer> rightFreq = new HashMap<>();

    
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }

        long count = 0;

        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            rightFreq.put(num, rightFreq.get(num) - 1); 

            int target = num * 2;
            int left = leftFreq.getOrDefault(target, 0);
            int right = rightFreq.getOrDefault(target, 0);

            count = (count + (long) left * right) % MOD;

     
            leftFreq.put(num, leftFreq.getOrDefault(num, 0) + 1);
        }

        return (int) count;
    }
}
