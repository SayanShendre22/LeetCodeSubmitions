class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (f[i] <= b[j]) {
                    b[j] = -1;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                res++;
        }
        return res;
    }
}