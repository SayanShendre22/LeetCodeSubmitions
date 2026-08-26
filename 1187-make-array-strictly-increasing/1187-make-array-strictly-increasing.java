class Solution {
    Map<Integer, Integer>[] dp;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);

        dp = new HashMap[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            dp[i] = new HashMap<>();
        }

        int res = solve(0, arr1, arr2, Integer.MIN_VALUE);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int solve(int i, int[] a, int[] b, int prev) {

        if (i == a.length)
            return 0;

        if (dp[i].containsKey(prev))
            return dp[i].get(prev);

        int res = Integer.MAX_VALUE;

        // Keep
        if (a[i] > prev) {
            res = solve(i + 1, a, b, a[i]);
        }

        // Replace
        int next = upperBound(prev, b);

        if (next != -1) {

            int replace = solve(
                i + 1,
                a,
                b,
                b[next]
            );

            // IMPORTANT: don't overflow MAX_VALUE
            if (replace != Integer.MAX_VALUE) {
                res = Math.min(res, replace + 1);
            }
        }

        dp[i].put(prev, res);

        return res;
    }

    public int upperBound(int target, int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}