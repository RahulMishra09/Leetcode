class NumArray {
    int[] presum;

    public NumArray(int[] nums) {
        presum=nums;
        for(int i=1;i<presum.length;i++){
            presum[i]+=presum[i-1];
        }
        
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return presum[right];
        return presum[right] - presum[left-1];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */