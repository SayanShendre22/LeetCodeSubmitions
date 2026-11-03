class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max])
                max = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == max)
                continue;

            res += (nums[max] - nums[i]);
        }

        return res;
    }
}