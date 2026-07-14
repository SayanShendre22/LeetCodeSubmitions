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
        dp = new int[prices.length][2][3];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return solve(0, 1, 2, prices);
    }
}