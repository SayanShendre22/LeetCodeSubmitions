class Solution {

    int dp[];

    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(0, nums);
    }

    public int helper(int idx, int[] nums) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // skip
        int skip = helper(idx + 1, nums);

        // take
        int take = nums[idx] + helper(idx + 2, nums);

        return dp[idx] = Math.max(skip, take);
    }
}