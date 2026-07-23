class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int prevCnt = dp[j].getOrDefault(diff, 0);
               dp[i].put(diff, dp[i].getOrDefault(diff, 0) + prevCnt + 1);

                res += prevCnt;
            }
        }
        return res;
    }
}