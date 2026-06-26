class Solution {
    public long countMajoritySubarrays(int[] nums, int tg) {
        int n = nums.length;

        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long res = 0;
        long presum = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == tg) {
                presum += pre[cnt];
                cnt++;
                pre[cnt]++;
            } else {
                cnt--;
                presum -= pre[cnt];
                pre[cnt]++;
            }
            res += presum;
        }
        return res;
    }
}