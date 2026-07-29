class Solution {
    int dp[][];

    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        int n = sat.length;
        dp = new int[n + 1][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solve(sat, 0, 1);
    }

    public int solve(int[] s, int idx, int cnt) {
        if (idx == s.length) {
            return 0;
        }

        if (dp[idx][cnt] != -1) {
            return dp[idx][cnt];
        }

        // skip
        int skip = solve(s, idx + 1, cnt);

        // take
        int take = cnt * s[idx] + solve(s, idx + 1, cnt + 1);

        return dp[idx][cnt] = Math.max(skip, take);
    }
}