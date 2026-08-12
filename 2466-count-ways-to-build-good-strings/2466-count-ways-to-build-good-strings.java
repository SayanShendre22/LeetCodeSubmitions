class Solution {
    int dp[];
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return solve(0, zero, one, low, high);
    }

    public int solve(int len, int z, int o, int low, int high) {
        if (len > high)
            return 0;

        if (dp[len] != -1) {
            return dp[len];
        }

        if (len < low) {
            return dp[len] = (solve(len + z, z, o, low, high) % MOD + solve(len + o, z, o, low, high) % MOD) % MOD;
        }

        return dp[len] = (1 + solve(len + z, z, o, low, high) % MOD + solve(len + o, z, o, low, high) % MOD) % MOD;
    }
}