class Solution {
    int dp[][] = new int[21][10001];

    public int solve(int idx, int diff, int[] r) {
        if (idx >= r.length) {
            if (diff == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if (dp[idx][diff + 5000] != -1) {
            return dp[idx][diff + 5000];
        }

        int skip = solve(idx + 1, diff, r);

        int left = r[idx] + solve(idx + 1, diff + r[idx], r);

        int right = r[idx] + solve(idx + 1, diff - r[idx], r);

        return dp[idx][diff + 5000] = Math.max(skip, Math.max(left, right));
    }

    public int tallestBillboard(int[] rods) {
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, rods) / 2;
    }
}