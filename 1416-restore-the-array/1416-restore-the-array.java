class Solution {
    int MOD = 1000000007;
    int dp[];

    public int numberOfArrays(String s, int k) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return solve(0, s, k);
    }

    public int solve(int idx, String s, int k) {
        if (idx == s.length())
            return 1;

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        long num = 0;
        int take = 0;

        for (int i = idx; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');

            if (num > k)
                break;

            take = (take + solve(i + 1, s, k)) % MOD;
        }

        return dp[idx] = take % MOD;

    }
}