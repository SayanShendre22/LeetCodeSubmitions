class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int max = 0;

        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, nums1[i]);
            sum += nums1[i];
        }

        if (sum <= k) {
            return 0;
        }

        long[] freq = new long[max + 1];

        for (int x : nums1)
            freq[x]++;

        for (int i = max; i > 0 && k > 0; i--) {
            long take = Math.min(k, freq[i]);
            freq[i] -= take;
            freq[i - 1] += take;
            k -= take;
        }

        long res = 0;

        for (int i = 0; i <= max; i++)
            res += freq[i] * i * i;

        return res;
    }
}