class Solution {
    int dp[];

    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0 || n == 1)
            return 0;

        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < n; i++) {

            dp[i] = dp[i - 1]; // skip selling on day i

            for (int j = 0; j < i; j++) {

                int prev = j >= 2 ? dp[j - 2] : 0;

                dp[i] = Math.max(
                        dp[i], // skip;
                        prices[i] - prices[j] + prev);
            }
        }

        return dp[n - 1];
    }
}