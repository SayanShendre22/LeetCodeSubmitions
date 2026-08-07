class Solution {
    int dp[][][];
    int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[group.length + 1][n + 1][minProfit + 1];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(0, n, minProfit, group, profit);
    }

    public int solve(int idx, int n, int minP, int[] g, int[] p) {

        if (idx == g.length) {
            return minP == 0 ? 1 : 0;
        }

        if (dp[idx][n][minP] != -1) {
            return dp[idx][n][minP];
        }

        // skip
        int skip = solve(idx + 1, n, minP, g, p) % MOD;

        int take = 0;

        if (n >= g[idx]) {
            take = solve(idx + 1, n - g[idx], Math.max(0, minP - p[idx]), g, p) % MOD;
        }

        return dp[idx][n][minP] = (skip + take) % MOD;
    }
}