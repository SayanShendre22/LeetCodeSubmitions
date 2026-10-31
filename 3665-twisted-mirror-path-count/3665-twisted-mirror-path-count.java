class Solution {
    int n, m;
    int MOD = 1000000007;
    int[][] nums;
    long[][][] dp;

    public long dfs(int i, int j, int dir) {
        if (i >= n || j >= m)
            return 0;

        if (i == n - 1 && j == m - 1)
            return 1;

        if (dp[i][j][dir] != -1)
            return dp[i][j][dir];

        if (nums[i][j] == 1) {
            if (dir == 0) {
                dp[i][j][dir] = dfs(i + 1, j, 1);
            } else {
                dp[i][j][dir] = dfs(i, j + 1, 0);
            }
        } else {
            dp[i][j][dir] = (dfs(i, j + 1, 0) + dfs(i + 1, j, 1)) % MOD;
        }

        return dp[i][j][dir];
    }

    public int uniquePaths(int[][] grid) {
        nums = grid;
        n = grid.length;
        m = grid[0].length;

        dp = new long[n][m][2];

        for (long[][] row : dp) {
            for (long[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        return (int) dfs(0, 0, 0);
    }
}