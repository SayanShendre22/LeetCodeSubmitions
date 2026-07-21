class Solution {
    int dp[];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        int[][] jobs = new int[n][3];

        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        for (int i = n - 1; i >= 0; i--) {

            int next = BS(jobs, i + 1, jobs[i][1]);

            int take = jobs[i][2];

            if (next != -1)
                take += dp[next];

            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    public int helper(int idx, int[][] jobs) {

        if (idx == jobs.length)
            return 0;

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Skip
        int skip = helper(idx + 1, jobs);

        // Find first compatible job
        // int next = idx + 1;
        // while (next < jobs.length && jobs[next][0] < jobs[idx][1])
        //     next++;

        // Take
        int next = BS(jobs, idx + 1, jobs[idx][1]);
        int take = jobs[idx][2];

        if (next != -1) {
            take += helper(next, jobs);
        }

        return dp[idx] = Math.max(skip, take);
    }

    public int BS(int[][] jobs, int l, int tg) {
        int e = jobs.length - 1;
        int ans = -1;

        while (l <= e) {
            int mid = l + (e - l) / 2;

            if (jobs[mid][0] >= tg) {
                ans = mid;
                e = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

}