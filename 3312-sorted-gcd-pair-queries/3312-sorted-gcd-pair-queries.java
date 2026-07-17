class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int max = 0;

        for (int i : nums) {
            max = Math.max(max, i);
        }

        long[] cnt = new long[max + 1];

        for (int num : nums) {
            cnt[num]++;
        }

        for (int i = 1; i <= max; i++) {
            for (int j = i * 2; j <= max; j += i) {
                cnt[i] += cnt[j];
            }
        }

        for (int i = 1; i <= max; i++) {
            cnt[i] = (cnt[i] * (cnt[i] - 1)) / 2; // nc2
        }

        for (int i = max; i >= 1; i--) {
            for (int j = i * 2; j <= max; j += i) {
                cnt[i] -= cnt[j];
            }
        }

        for (int i = 1; i <= max; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            long q = queries[k] + 1;
            int left = 1;
            int right = max;

            while (left < right) {
                int mid = (left + right) / 2;
                if (cnt[mid] >= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[k] = left;
        }
        return ans;
    }
}