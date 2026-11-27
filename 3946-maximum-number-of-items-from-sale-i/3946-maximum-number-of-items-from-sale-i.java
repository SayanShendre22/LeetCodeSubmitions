
class Solution {
    int[] free;
    int[][][] dp;
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        free = new int[n];

        // Calculate free items
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                if (items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        dp = new int[n][budget + 1][2];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return helper(items, 0, budget, 0);
    }

    public int helper(int[][] items, int idx, int budget, int bought) {

        if (idx == items.length)
            return 0;

        if (dp[idx][budget][bought] != -1)
            return dp[idx][budget][bought];

        // Skip current item type
        int skip = helper(items, idx + 1, budget, 0);

        int take = 0;
        int price = items[idx][1];

        if (budget >= price) {

            if (bought == 0) {
                // First purchase: count free items
                take = 1 + free[idx] +
                       helper(items, idx, budget - price, 1);

            } else {
                // Additional purchase: no free bonus
                take = 1 +
                       helper(items, idx, budget - price, 1);
            }
        }
        return dp[idx][budget][bought] = Math.max(skip, take);
    }
}
