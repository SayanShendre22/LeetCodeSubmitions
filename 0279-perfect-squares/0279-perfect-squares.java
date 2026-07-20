class Solution {

    int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] !=  Integer.MAX_VALUE)
            return dp[n];

        int minRes = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            minRes = Math.min(minRes, 1 + helper(n - (i * i)));
        }

        return dp[n] = minRes;
    }

}