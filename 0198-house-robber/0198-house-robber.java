class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int second = nums[0];
        int first = Math.max(nums[0], nums[1]);

        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(first, nums[i] + second);
            second = first;
            first = res;
        }
        return res;
    }
}