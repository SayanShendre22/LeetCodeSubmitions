class Solution {
    int n;
    int dp[][];

    public int minFlipsMonoIncr(String s) {
        n = s.length();
        dp = new int[n + 1][2];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solve(s, 0, 0);
    }

    public int solve(String s, int idx, int prev) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }

        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;

        if (s.charAt(idx) == '0') {
            if (prev == 1) {
                flip = 1 + solve(s, idx + 1, 1);
            } else {
                flip = 1 + solve(s, idx + 1, 1);
                noFlip = solve(s, idx + 1, 0);
            }
        } else {
            if (prev == 1) {
                noFlip = solve(s, idx + 1, 1);
            } else {
                flip = 1 + solve(s, idx + 1, 0);
                noFlip = solve(s, idx + 1, 1);
            }
        }

        return dp[idx][prev] = Math.min(flip, noFlip);
    }
}