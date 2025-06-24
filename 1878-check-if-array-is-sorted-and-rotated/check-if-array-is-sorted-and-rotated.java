class Solution {
    public boolean check(int[] nums) {
        int count = 0;

        // Count the number of places where the array "drops"
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        // Final drop point: compare last and first elements
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }

        // True if at most 1 drop point
        return count <= 1;
    }
}
