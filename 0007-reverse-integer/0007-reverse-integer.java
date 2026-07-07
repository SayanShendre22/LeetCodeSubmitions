class Solution {
    public int reverse(int x) {
        long res = 0;
        int n = Math.abs(x);
        while (n > 0) {
            int last = n % 10;
            res = res * 10 + last;
            n = n / 10;
        }

        if (res > Integer.MAX_VALUE) {
            return 0;
        }

        res = x < 0 ? res - (res * 2) : res;

        return (int) res;
    }
}