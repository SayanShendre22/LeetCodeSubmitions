class Solution {
    int MOD = 1_000_000_000 + 7;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int ql = queries.length;
        long[] prefix = new long[n + 1];
        long[] concat = new long[n + 1];
        long[] lenCon = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 10) % MOD;
        }
        int x = 0;
        for (char c : s.toCharArray()) {
            int cur = c - '0';
            if (x == 0) {
                prefix[x] = cur;
                concat[x] = cur;
                if (cur > 0) {
                    lenCon[x] = 1;
                }
            } else {
                prefix[x] = (prefix[x - 1] + cur) % MOD;
                if (cur > 0) {
                    concat[x] = (concat[x - 1] * 10 + cur) % MOD;
                    lenCon[x] = lenCon[x - 1] + 1;
                } else {
                    concat[x] = concat[x - 1];
                    lenCon[x] = lenCon[x - 1];
                }
            }
            x++;
        }

        int res[] = new int[ql];

        for (int i = 0; i < ql; i++) {
            int[] q = queries[i];
            int st = q[0];
            int end = q[1];

            if (st > 0) {

                long fsum = prefix[end] - prefix[st - 1];
                long len = lenCon[end] - lenCon[st - 1];
                long fconcat = (concat[end]
                        - (concat[st - 1] * power[(int) len]) % MOD
                        + MOD) % MOD;

                res[i] = (int) ((fconcat * fsum) % MOD);
            } else {

                long fsum = prefix[end];
                long len = lenCon[end];
                long fconcat = concat[end];

                res[i] = (int) ((fconcat * fsum) % MOD);
            }

        }

        return res;
    }
}