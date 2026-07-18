class Solution {
    int[][] dp;

    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;

        if (n < d) {
            return -1;
        }

        dp = new int[n][d + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(jd, n, 0, d);
    }

    public int solve(int[] jd, int n, int idx, int d) {

        if (dp[idx][d] != -1)
            return dp[idx][d];

        if (d == 1) {
            int max = 0;
            for (int i = idx; i < n; i++)
                max = Math.max(max, jd[i]);

            return dp[idx][d] = max;
        }

        int maxD = jd[idx];
        int finalAns = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);

            int result = maxD + solve(jd, n, i + 1, d - 1);
            finalAns = Math.min(finalAns, result);
        }

        return dp[idx][d] = finalAns;

    }
}