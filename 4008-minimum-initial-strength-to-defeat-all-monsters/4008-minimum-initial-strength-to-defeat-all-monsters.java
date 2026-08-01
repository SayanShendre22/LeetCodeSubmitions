class Solution {
    public long minInitialStrength(int[] mon, int[][] boosts) {
        int n = mon.length;
        long diff[] = new long[n];

        for (int[] b : boosts) {
            int s = b[0];
            int e = b[1];
            int val = b[2];

            diff[s] += val;

            if (e + 1 < n) {
                diff[e + 1] -= val;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }

        long start = 0;
        long end = 0;

        for (int i : mon) {
            end += i;
        }

        while (start < end) {
            long mid = start + (end - start) / 2;
            if (check(mid, mon, diff)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public boolean check(long snt, int[] mon, long[] diff) {
        for (int i = 0; i < mon.length; i++) {
            if (snt + diff[i] < mon[i]) {
                return false;
            } else {
                snt -= mon[i];
                if (snt < 0) {
                    snt = 0;
                }
            }
        }
        return true;
    }
}