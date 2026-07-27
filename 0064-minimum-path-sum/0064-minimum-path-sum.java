class Solution {
    public int minPathSum(int[][] g) {
        int m = g.length;
        int n = g[0].length;

        for (int i = 1; i < m; i++) {
            g[i][0] = g[i - 1][0] + g[i][0];
        }

        for (int i = 1; i < n; i++) {
            g[0][i] = g[0][i - 1] + g[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                g[i][j] = g[i][j] + Math.min(g[i][j - 1], g[i - 1][j]);
            }
        }
        return g[m - 1][n - 1];
    }
}