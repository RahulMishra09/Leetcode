class Solution {
    public int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i : nums)
            if (i < k){
                return -1;
            } else if (i > k){
                ans.put(i, ans.getOrDefault(i, 0) + 1);

            }
        return ans.size();
    }
}