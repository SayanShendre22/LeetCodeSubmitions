class Solution {
    Integer dp[][][] ;
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        dp = new Integer[N][m+1][n+1];
        return helper(strs, m, n, 0);
    }

    public int helper(String[] s, int m, int n, int idx) {
        if (idx == s.length) {
            return 0;
        }

        if (dp[idx][m][n] != null)
            return dp[idx][m][n];

        // take
        int o = 0, z = 0;

        for (char c : s[idx].toCharArray()) {
            if (c == '0') {
                z++;
            } else {
                o++;
            }
        }
        int take = 0;
        if (m - z >= 0 && n - o >= 0) {
            take = 1 + helper(s, m - z, n - o, idx + 1);
        }

        // skip
        int skip = helper(s, m, n, idx + 1);

        return dp[idx][m][n] = Math.max(take, skip);
    }
}