class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return true;

        int e = n - 1;
        int cur = n - 2;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= e - i) {
                e = i;
            }
        }

        return e == 0;
    }
}