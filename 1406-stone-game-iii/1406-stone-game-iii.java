class Solution {
    int n;
    int dp[];

    public String stoneGameIII(int[] s) {
        n = s.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        int diff = solve(s, 0);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        return "Tie";
    }

    public int solve(int[] s, int i) {
        if (i >= n)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int res = s[i] - solve(s, i + 1);

        if (i + 1 < n) {
            res = Math.max(res, s[i] + s[i + 1] - solve(s, i + 2));
        }

        if (i + 2 < n) {
            res = Math.max(res, s[i] + s[i + 1] + s[i + 2] - solve(s, i + 3));
        }

        return dp[i] = res;
    }
}