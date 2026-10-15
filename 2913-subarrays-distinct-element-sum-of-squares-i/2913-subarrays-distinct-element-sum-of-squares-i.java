class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt[] = new int[101];
            int dst = 0;
            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (cnt[num] == 0) {
                    dst += 1;
                }
                cnt[num] += 1;
                res += (dst * dst);
            }
        }
        return res;
    }
}