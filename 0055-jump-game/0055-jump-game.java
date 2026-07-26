class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return true;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        int e = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= e - i) {
                dp[i] = true;
                e = i;
            }
        }

        return dp[0];
    }
}