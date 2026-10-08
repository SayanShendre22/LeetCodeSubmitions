class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][1001];
        int max = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i] + 500;

                if (dp[j][diff] > 0) {
                    dp[i][diff] = dp[j][diff] + 1;
                } else {
                    dp[i][diff] = 2;
                }

                max = Math.max(max, dp[i][diff]);
            }
        }
        return max;
    }
}