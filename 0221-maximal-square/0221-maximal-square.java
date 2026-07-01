class Solution {
    public int maximalSquare(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = mat[i][0] - '0';
            res = Math.max(res, dp[i][0]);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = mat[0][i] - '0';
            res = Math.max(res, dp[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(
                                    dp[i - 1][j],
                                    dp[i][j - 1]));
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }
}