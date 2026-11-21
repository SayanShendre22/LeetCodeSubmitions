class Solution {
    int n;
    int dp[][];

    public int maxValue(int[][] events, int k) {
        n = events.length;
        dp = new int[n + 1][k + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        return helper(0, events, k);
    }

    public int helper(int i, int[][] e, int k) {
        if (k == 0 || i == n)
            return 0;

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int value = e[i][2];

        int skip = helper(i + 1, e, k);

        int j = bs(e[i][1], i + 1, e);

        int take = value + helper(j, e, k - 1);

        return dp[i][k] = Math.max(skip, take);
    }

    public int bs(int tg, int i, int[][] e) {
        int res = n;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (e[mid][0] > tg) {
                res = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }
}