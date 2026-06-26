class Solution {
    public int[] xorQueries(int[] arr, int[][] qs) {
        int n = arr.length;
        int pre[] = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }

        int res[] = new int[qs.length];

        for (int k = 0; k < qs.length; k++) {
            int i = qs[k][0];
            int j = qs[k][1];
            if (i == 0) {
                res[k] = pre[j];
            } else {
                res[k] = pre[i - 1] ^ pre[j];
            }
        }
        return res;
    }
}