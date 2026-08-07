class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 1;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int count = 1;
                int x = n;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}