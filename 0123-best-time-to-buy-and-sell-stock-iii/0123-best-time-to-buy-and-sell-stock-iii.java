class Solution {
    int dp[][][];

    public int solve(int idx, int buy, int cap, int[] p) {
        if (idx == p.length || cap == 0) {
            return 0;
        }

        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        if (buy == 1) {
            return dp[idx][buy][cap] = Math.max(
                    -p[idx] + solve(idx + 1, 0, cap, p),
                    0 + solve(idx + 1, 1, cap, p));
        }

        return dp[idx][buy][cap] = Math.max(
                p[idx] + solve(idx + 1, 1, cap - 1, p),
                0 + solve(idx + 1, 0, cap, p));

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 1; c < 3; c++) {

                dp[i][1][c] = Math.max(
                        -prices[i] + dp[i + 1][0][c],
                        dp[i + 1][1][c]);

                dp[i][0][c] = Math.max(
                        prices[i] + dp[i + 1][1][c - 1],
                        dp[i + 1][0][c]);
            }
        }

        return dp[0][1][2];
    }
}