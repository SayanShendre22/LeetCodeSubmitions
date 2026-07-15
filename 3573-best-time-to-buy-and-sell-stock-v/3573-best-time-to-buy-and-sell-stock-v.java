class Solution {

    int n;
    long dp[][][];

    public long solve(int[] prices, int idx, int state, int k) {

        // state:
        // 0 -> no open transaction
        // 1 -> holding a normal stock (bought)
        // 2 -> holding a short position (sold first)

        if (idx == n) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }

        if (k == 0) {
            return state == 0 ? 0 : Long.MIN_VALUE / 2;
        }

        if (dp[idx][state][k] != -1) {
            return dp[idx][state][k];
        }

        if (state == 0) {

            // Skip
            long skip = solve(prices, idx + 1, 0, k);

            // Open a normal transaction (buy)
            long buy = -prices[idx] + solve(prices, idx + 1, 1, k);

            // Open a short transaction (sell first)
            long sellFirst = prices[idx] + solve(prices, idx + 1, 2, k);

            return dp[idx][state][k] = Math.max(skip, Math.max(buy, sellFirst));
        }

        else if (state == 1) {

            // Hold
            long hold = solve(prices, idx + 1, 1, k);

            // Sell (complete transaction)
            long sell = prices[idx] + solve(prices, idx + 1, 0, k - 1);

            return dp[idx][state][k] = Math.max(hold, sell);
        }

        else {

            // Hold short position
            long hold = solve(prices, idx + 1, 2, k);

            // Buy back (complete transaction)
            long buyBack = -prices[idx] + solve(prices, idx + 1, 0, k - 1);

            return dp[idx][state][k] = Math.max(hold, buyBack);
        }
    }

    public long maximumProfit(int[] prices, int k) {
        n = prices.length;
        dp = new long[n+1][4][k+1];

        for (long[][] a : dp) {
            for (long[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(prices, 0, 0, k);
    }
}