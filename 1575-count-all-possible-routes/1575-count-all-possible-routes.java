class Solution {
    int[][] dp;
    int MOD = 1_000_000_007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new int[locations.length][fuel + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(start, locations, finish, fuel);
    }

    public int helper(int i, int[] l, int tg, int f) {
        if (dp[i][f] != -1)
            return dp[i][f];

        int ways = (i == tg) ? 1 : 0;

        for (int idx = 0; idx < l.length; idx++) {
            if (idx == i)
                continue;

            int cost = Math.abs(l[i] - l[idx]);

            if (cost <= f) {
                ways = (ways + helper(idx, l, tg, f - cost)) % MOD;
            }
        }

        return dp[i][f] = ways;
    }
}