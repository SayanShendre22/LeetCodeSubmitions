class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;

        for (int i = 2; i <= n; i++) {

            int pf2 = dp[i2] * 2;
            int pf3 = dp[i3] * 3;
            int pf5 = dp[i5] * 5;

            int minPf = Math.min(pf2, Math.min(pf3, pf5));
            dp[i] = minPf;

            if (pf2 == minPf) {
                i2++;
            }
            if (pf3 == minPf) {
                i3++;
            }
            if (pf5 == minPf) {
                i5++;
            }
        }
        return dp[n];
    }
}