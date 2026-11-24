class Solution {
    public int maxLength(int[] nums) {
        int res = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                int cur = nums[j];

                prod *= cur;
                g = gcd(g, cur);
                l = lcm(l, cur);

                if (prod == g * l) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}