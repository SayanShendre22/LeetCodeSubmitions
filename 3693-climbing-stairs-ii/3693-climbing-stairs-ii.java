class Solution {
    int dp[];

    public int climbStairs(int n, int[] cost) {
        int res[] = new int[n + 1];
        res[n] = 0;
        for (int i = n - 1; i >= 0; i--) {

            int one = Integer.MAX_VALUE;
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if (i + 1 <= n)
                one = cost[i] + 1 + res[i + 1];

            if (i + 2 <= n)
                two = cost[i + 1] + 4 + res[i + 2];

            if (i + 3 <= n)
                three = cost[i + 2] + 9 + res[i + 3];

            res[i] = Math.min(one, Math.min(two, three));
        }

        return res[0];

        // Arrays.fill(dp, -1);
        // return helper(n, 0, costs);
    }

    public int helper(int n, int i, int[] cost) {
        if (i == n)
            return 0;

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;

        if (dp[i] != -1) {
            return dp[i];
        }

        if (i + 1 <= n)
            one = cost[i] + 1 + helper(n, i + 1, cost);

        if (i + 2 <= n)
            two = cost[i + 1] + 4 + helper(n, i + 2, cost);

        if (i + 3 <= n)
            three = cost[i + 2] + 9 + helper(n, i + 3, cost);

        return dp[i] = Math.min(one, Math.min(two, three));
    }
}