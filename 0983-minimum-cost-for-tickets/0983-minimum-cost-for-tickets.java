class Solution {
    int n;
    int dp[];

    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0);
    }

    public int solve(int[] days, int[] costs, int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // day 1
        int day1 = costs[0] + solve(days, costs, i + 1);

        // day 7
        int j = i;

        int maxDay = days[i] + 7;
        while (j < n && days[j] < maxDay) {
            j++;
        }

        int day2 = costs[1] + solve(days, costs, j);

        // day 30

        j = i;

        maxDay = days[i] + 30;
        while (j < n && days[j] < maxDay) {
            j++;
        }

        int day3 = costs[2] + solve(days, costs, j);

        return dp[i] = Math.min(day1, Math.min(day2, day3));
    }
}