class Solution {
    public int minSumOfLengths(int[] nums, int tg) {
        int n = nums.length;
        if (n == 1)
            return -1;

        int i = 0, j = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        int bestLen = Integer.MAX_VALUE;
        int[] minLen = new int[n];

        while (j < n) {
            cur += nums[j];

            while (i < j && cur > tg) {
                cur -= nums[i++];
            }

            if (cur == tg) {
                int len = j - i + 1;

                if (i > 0 && minLen[i - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + minLen[i - 1]);
                }

                bestLen = Math.min(bestLen, len);
            }
            minLen[j++] = bestLen;
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }
}