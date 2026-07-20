class Solution {

    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int minRes = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minRes = Math.min(minRes, 1 + dp[i - j * j]);
            }
            dp[i] = minRes;
        }

        return dp[n];
    }

    public int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1)
            return dp[n];

        int minRes = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            minRes = Math.min(minRes, 1 + helper(n - (i * i)));
        }

        return dp[n] = minRes;
    }

}