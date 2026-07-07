class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        int s = 0;

        for (int i = 1; i < n; i++) {
            if (nums[s] == nums[i])
                continue;
            int temp = nums[i];
            nums[s + 1] = temp;
            s++;
        }

        return s+1;
    }
}