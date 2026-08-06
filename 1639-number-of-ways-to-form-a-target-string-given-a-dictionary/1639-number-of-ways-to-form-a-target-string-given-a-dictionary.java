class Solution {
    int m;
    int k;
    int MOD = 1_000_000_007;
    int[][] dp;

    public int numWays(String[] words, String target) {
        m = target.length();
        k = words[0].length();

        int[][] freq = new int[26][k];

        dp = new int[m + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int col = 0; col < k; col++) {
            for (String w : words) {
                freq[w.charAt(col) - 'a'][col]++;
            }
        }

        return solve(0, 0, freq, target);
    }

    public int solve(int i, int j, int[][] freq, String target) {

        if (i == m)
            return 1;

        if (j == k)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int notTake = solve(i, j + 1, freq, target);

        int take = (int) (
                (1L * freq[target.charAt(i) - 'a'][j]
                        * solve(i + 1, j + 1, freq, target))
                        % MOD);

        return dp[i][j] = (take + notTake) % MOD;
    }
}