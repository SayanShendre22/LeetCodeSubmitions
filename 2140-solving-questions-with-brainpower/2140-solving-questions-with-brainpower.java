class Solution {
    int n;
    long dp[];

    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return solve(questions, 0);
    }

    public long solve(int[][] q, int i) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // skip
        long skip = solve(q, i + 1);

        // take
        long take = q[i][0] + solve(q, i + q[i][1] + 1);

        return dp[i] = Math.max(skip, take);
    }
}