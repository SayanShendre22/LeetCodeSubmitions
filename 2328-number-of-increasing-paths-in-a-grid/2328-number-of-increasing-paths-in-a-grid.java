class Solution {
    int m, n;
    int MOD = 1000000007;
    int dp[][];
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];

        long ways = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ways = (ways + helper(i, j, grid)) % MOD;
            }
        }
        return (int) ways % MOD;
    }

    public int helper(int i, int j, int[][] g) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int cur = g[i][j];

        int ways = 1;

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni == m || nj == n || ni < 0 || nj < 0 || cur >= g[ni][nj]) {
                continue;
            }
            ways = (ways + helper(ni, nj, g)) % MOD;
        }

        return dp[i][j] = ways;
    }
}