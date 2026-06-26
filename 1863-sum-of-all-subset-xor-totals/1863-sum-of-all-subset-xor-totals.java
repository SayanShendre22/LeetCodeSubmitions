class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int or =0;
        for(int i:nums){
            or |= i;
        }
        return or<<(n-1);
    }
}