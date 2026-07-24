class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;

        if (n == 1) {
            return mat[0][0];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int left = Integer.MAX_VALUE;
                int mid = mat[i + 1][j];
                int right = Integer.MAX_VALUE;

                if (j > 0) {
                    left = mat[i + 1][j - 1];
                }

                if (j < n - 1) {
                    right = mat[i + 1][j + 1];
                }

                mat[i][j] = mat[i][j] + Math.min(left, Math.min(mid, right));
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            res = Math.min(mat[0][i], res);
        }
        return res;
    }
}