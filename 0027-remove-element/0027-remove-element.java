class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        Arrays.sort(nums);

        int s = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                res++;
            }
            if (nums[i] == val && s == -1) {
                s = i;
            }
            if (s != -1 && nums[i] != val) {
                nums[s] = nums[i];
                s++;
            }
        }
        return n - res;
    }
}