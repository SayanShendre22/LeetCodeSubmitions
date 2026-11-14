class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int pre[] = new int[n + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums.get(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = l; j <= r && i + j <= n; j++) {
                int sum = pre[i + j] - pre[i];

                if (sum > 0)
                    res = Math.min(res, sum);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}