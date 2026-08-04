class Solution {
    int dp[][];

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size() + 1][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solve(piles, 0, k);
    }

    public int solve(List<List<Integer>> p, int i, int k) {
        if (i >= p.size() || k == 0) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        // skip
        int skip = solve(p, i + 1, k);

        // take
        int take = 0;
        int sum = 0;
        for (int j = 0; j < Math.min(k, p.get(i).size()); j++) {
            sum += p.get(i).get(j);
            take = Math.max(take, sum + solve(p, i + 1, k - (j + 1)));
        }

        return dp[i][k] = Math.max(take, skip);
    }
}