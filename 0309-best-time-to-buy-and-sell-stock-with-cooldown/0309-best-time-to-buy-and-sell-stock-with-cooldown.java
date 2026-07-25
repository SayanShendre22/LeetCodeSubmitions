class Solution {
    int dp[][];

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(prices, 0, 0);
    }

    public int helper(int[] p, int idx, int buy) {
        if (idx >= p.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        // skip 
        int skip = helper(p, idx + 1, buy);
        // take
        int take = 0;
        if (buy == 0) {
            take = -p[idx] + helper(p, idx + 1, 1);
        } else {
            take = p[idx] + helper(p, idx + 2, 0);
        }

        return dp[idx][buy] = Math.max(take, skip);

    }
}