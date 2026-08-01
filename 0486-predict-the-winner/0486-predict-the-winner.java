class Solution {
    int dp[];

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n];

        // for (int[] a : dp) {
        //     Arrays.fill(a, -1);
        // }

        if ((n & 1) == 0)
            return true;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
        // return solve(0, n - 1, nums) >= 0;
    }

    // public int solve(int i, int j, int[] nums) {
    //     if (i > j)
    //         return 0;

    //     if (i == j)
    //         return nums[i];

    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     int take_i = nums[i] - solve(i + 1, j, nums);
    //     int take_j = nums[j] - solve(i, j - 1, nums);

    //     return dp[i][j] = Math.max(take_i, take_j);
    // }
}