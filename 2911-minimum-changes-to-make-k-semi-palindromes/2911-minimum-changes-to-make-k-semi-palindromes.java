class Solution {
    int n;
    String str;
    int[][] dp;
    int[][] cost;

    public int minimumChanges(String s, int k) {
        n = s.length();
        str = s;

        dp = new int[n][k + 1];
        cost = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int[] row : cost)
            Arrays.fill(row, -1);

        return helper(0, s, k);
    }

    public int helper(int i, String s, int k) {
        if (k == 0)
            return i == n ? 0 : Integer.MAX_VALUE;

        if (i + 2 * k > n)
            return Integer.MAX_VALUE;

        if (dp[i][k] != -1)
            return dp[i][k];

        int minCost = Integer.MAX_VALUE;

        for (int idx = i + 1; idx <= n - 2 * (k - 1) - 1; idx++) {
            int rem = helper(idx + 1, s, k - 1);

            if (rem == Integer.MAX_VALUE)
                continue;

            minCost = Math.min(minCost, getCost(i, idx) + rem);
        }

        return dp[i][k] = minCost;
    }

    public int getCost(int i, int j) {
        if (cost[i][j] != -1)
            return cost[i][j];

        int len = j - i + 1;
        int min = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {
            if (len % d != 0)
                continue;

            int changes = 0;

            for (int group = 0; group < d; group++) {
                int l = i + group;
                int r = i + group + (len / d - 1) * d;

                while (l < r) {
                    if (str.charAt(l) != str.charAt(r))
                        changes++;

                    l += d;
                    r -= d;
                }
            }

            min = Math.min(min, changes);
        }

        return cost[i][j] = min;
    }
}