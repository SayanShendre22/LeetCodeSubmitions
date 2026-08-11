class Solution {

    int l1, l2;
    int dp[][];

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        l1 = nums1.length;
        l2 = nums2.length;
        dp = new int[l1 + 1][l2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solve(nums1, nums2, 0, 0);
    }

    public int solve(int[] n1, int[] n2, int i, int j) {

        if (i >= l1 || j >= l2)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (n1[i] == n2[j]) {
            return dp[i][j] = 1 + solve(n1, n2, i + 1, j + 1);
        } else {
            int fixi = solve(n1, n2, i, j + 1);
            int fixj = solve(n1, n2, i + 1, j);
            return dp[i][j] = Math.max(fixi, fixj);
        }
    }
}