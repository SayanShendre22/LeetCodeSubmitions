class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n = days.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i : days) {
            set.add(i);
        }

        int lastDay = days[n - 1];
        int dp[] = new int[lastDay + 1];
        dp[0] = 0;

        for (int i = 1; i <= lastDay; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = Integer.MAX_VALUE;

            int day1 = cost[0] + dp[Math.max(0, i - 1)];

            int day7 = cost[1] + dp[Math.max(0, i - 7)];

            int day30 = cost[2] + dp[Math.max(0, i - 30)];

            dp[i] = Math.min(day1, Math.min(day7, day30));
        }

        return dp[lastDay];

    }
}