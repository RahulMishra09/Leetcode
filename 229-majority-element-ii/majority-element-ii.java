class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> store=new HashMap<>();
        for (int num : nums) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        for (int key : store.keySet()) {
            if (store.get(key) > n / 3) {
                ans.add(key);
            }
        }
        return ans;
    
    }
}