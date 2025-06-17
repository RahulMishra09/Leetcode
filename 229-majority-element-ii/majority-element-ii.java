class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> store = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (store.containsKey(nums[i])) {
                store.put(nums[i], store.get(nums[i]) + 1);
            } else {
                store.put(nums[i], 1);
            }
        }

        Set<Integer> keyset = store.keySet();
        List<Integer> majorityElements = new ArrayList<>();
        
        for (int key : keyset) {
            if (store.get(key) > n / 3) {
                majorityElements.add(key);
            }
        }

        return majorityElements;       
    }
}
