class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 0;

        // increasing 
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > curr) {
                    curr = nums[j];
                    cnt++;
                } else {
                    break;
                }
            }
            res = Math.max(res, cnt);
        }

        // decreasing 
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < curr) {
                    curr = nums[j];
                    cnt++;
                } else {
                    break;
                }
            }
            res = Math.max(res, cnt);
        }

        return res;
    }
}