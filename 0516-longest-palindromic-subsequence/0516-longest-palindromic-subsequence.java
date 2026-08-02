class Solution {
    int dp[][];

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(s, 0, n - 1);
    }

    public int solve(String s, int l, int r) {
        if (l > r)
            return 0;

        if (l == r)
            return 1;

        if (dp[l][r] != -1)
            return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = 2 + solve(s, l + 1, r - 1);
        } else {
            return dp[l][r] = Math.max(solve(s, l + 1, r), solve(s, l, r - 1));
        }
    }
}