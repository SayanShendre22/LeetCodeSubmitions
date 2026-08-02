class Solution {
    int dp[][];

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return game(piles, 0, n - 1) > 0;
    }

    public int game(int[] p, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return p[l];
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }

        int take_l = p[l] - game(p, l + 1, r);
        int take_r = p[r] - game(p, l, r - 1);

        return dp[l][r] = Math.max(take_l, take_r);

    }
}