class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if (nums[0] == nums[n - 1])
            return 0;

        if (n == 2) {
            return Math.abs(nums[0] - nums[1]);
        }

        int l = 0, r = n - 1;
        int i = 1;
        int moves = 0;

        while (l < r) {

            if (r - l == 1) {
                moves += Math.abs(nums[l] - nums[l + 1]) * i;
                r--;
                l++;
                i++;
                continue;
            }

            if (nums[l] < nums[l + 1]) {
                moves += Math.abs(nums[l] - nums[l + 1]) * i;
            }

            if (nums[r] > nums[r - 1]) {
                moves += Math.abs(nums[r] - nums[r - 1]) * i;
            }

            l++;
            r--;
            i++;
        }

        return moves;

    }
}