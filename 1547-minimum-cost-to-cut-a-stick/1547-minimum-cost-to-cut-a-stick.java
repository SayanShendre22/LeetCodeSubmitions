class Solution {
    int dp[][];

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int cut[] = new int[cuts.length + 2];
        cut[0] = 0;
        cut[cut.length - 1] = n;

        dp = new int[cut.length + 1][cut.length + 1];

        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }

        for (int i = 0; i < cuts.length; i++) {
            cut[i + 1] = cuts[i];
        }

        return solve(cut, 0, cut.length - 1);
    }

    public int solve(int[] cut, int l, int r) {
        if (r - l < 2) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int res = Integer.MAX_VALUE;

        for (int i = l + 1; i <= r - 1; i++) {
            res = Math.min(res, (cut[r] - cut[l]) + solve(cut, l, i) + solve(cut, i, r));
        }

        return dp[l][r] = res;
    }
}