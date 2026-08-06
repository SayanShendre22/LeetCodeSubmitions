class Solution {
    int m;
    int k;
    int MOD = 1000000007;
    int dp[][];

    public int numWays(String[] words, String target) {
        m = target.length();
        k = words[0].length();

        int freq[][] = new int[26][k];
        dp = new int[1001][1001];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        for (int col = 0; col < k; col++) {
            for (String w : words) {
                char ch = w.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }

        return solve(0, 0, freq, target);
    }

    public int solve(int i, int j, int freq[][], String tg) {
        if (i == m)
            return 1;

        if (j == k)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int not_taken = solve(i, j + 1, freq, tg) % MOD;

        int taken = (int) ((1L * freq[tg.charAt(i) - 'a'][j] * solve(i + 1, j + 1, freq, tg))
                % MOD);

        return dp[i][j] = (taken + not_taken) % MOD;
    }
}
