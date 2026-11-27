class Solution {
    int[] free;
    int dp[][][];

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        free = new int[n];
        dp = new int[n][budget + 1][2];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (items[j][0] % items[i][0] == 0) {
                    free[i] += 1;
                }
            }
        }

        return helper(items, 0, budget, 0);
    }

    public int helper(int[][] items, int idx, int budget, int took) {
        if (idx >= items.length)
            return 0;

        if (dp[idx][budget][took] != -1) {
            return dp[idx][budget][took];
        }

        // Skip
        int skip = helper(items, idx + 1, budget, 0);

        // Take
        int take = 0;
        if (budget >= items[idx][1]) {
            if (took == 0) {
                take = 1 + free[idx] + helper(items, idx, budget - items[idx][1], 1);
            } else {
                take = 1 + helper(items, idx, budget - items[idx][1], took);
            }
        }
        return dp[idx][budget][took] = Math.max(skip, take);
    }
}