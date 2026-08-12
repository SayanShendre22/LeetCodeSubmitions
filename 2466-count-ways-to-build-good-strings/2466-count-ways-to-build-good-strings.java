class Solution {
    long dp[];
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new long[high + 1];

        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }

            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one] % MOD);
            }
        }

        long res = 0;
        for (int i = low; i <= high; i++) {
            res = (res + dp[i]) % MOD;
        }

        return (int) res;

        // Arrays.fill(dp, -1);
        // return solve(0, zero, one, low, high);
    }

    // public int solve(int len, int z, int o, int low, int high) {
    //     if (len > high)
    //         return 0;

    //     if (dp[len] != -1) {
    //         return dp[len];
    //     }

    //     if (len < low) {
    //         return dp[len] = (solve(len + z, z, o, low, high) % MOD + solve(len + o, z, o, low, high) % MOD) % MOD;
    //     }

    //     return dp[len] = (1 + solve(len + z, z, o, low, high) % MOD + solve(len + o, z, o, low, high) % MOD) % MOD;
    // }
}