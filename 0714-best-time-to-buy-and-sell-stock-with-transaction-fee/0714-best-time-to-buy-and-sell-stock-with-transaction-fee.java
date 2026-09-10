class Solution {
    int dp[][];

    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return helper(0, prices, fee, 0);
    }

    public int helper(int idx, int[] p, int fee, int op) {
        if (idx >= p.length)
            return 0;

        if (dp[idx][op] != -1) {
            return dp[idx][op];
        }

        // skip 
        int skip = helper(idx + 1, p, fee, op);

        // take
        int take = 0;
        if (op == 0) {
            // buy
            take = -p[idx] + helper(idx + 1, p, fee, 1);
        } else {
            take = p[idx] + helper(idx + 1, p, fee, 0) - fee;
        }

        return dp[idx][op] = Math.max(skip, take);
    }
}