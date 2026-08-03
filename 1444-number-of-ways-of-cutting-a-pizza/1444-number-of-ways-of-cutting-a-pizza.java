class Solution {
    int n;
    int m;
    int MOD = 1000000007;
    Integer dp[][][];

    public int ways(String[] pizza, int k) {
        n = pizza.length;
        m = pizza[0].length();

        dp = new Integer[15][55][55];

        int prefix[][] = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                prefix[i][j] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i + 1][j + 1]
                        + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        return solve(0, 0, k, prefix);
    }

    public int solve(int i, int j, int k, int[][] pre) {
        if (pre[i][j] == 0)
            return 0;
        if (k == 1)
            return pre[i][j] > 0 ? 1 : 0;

        if (dp[k][i][j] != null)
            return dp[k][i][j];

        int ans = 0;

        // horizontal
        for (int ni = i + 1; ni < n; ni++) {
            if (pre[i][j] - pre[ni][j] >= 1) {
                ans = (ans + solve(ni, j, k - 1, pre)) % MOD;
            }
        }

        // vertial
        for (int nj = j + 1; nj < m; nj++) {
            if (pre[i][j] - pre[i][nj] >= 1) {
                ans = (ans + solve(i, nj, k - 1, pre)) % MOD;
            }
        }

        return dp[k][i][j] = ans;
    }
}