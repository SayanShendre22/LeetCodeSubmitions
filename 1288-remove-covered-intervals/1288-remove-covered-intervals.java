class Solution {
    public int removeCoveredIntervals(int[][] itv) {
        int n = itv.length;
        boolean scan[] = new boolean[n];

        Arrays.sort(itv, (a, b) -> {
            if(a[0]!=b[0]) return a[0] - b[0];
            return b[1]-a[1];
        });

        for (int i = 0; i < n - 1; i++) {
            if (scan[i]) {
                continue;
            }
            int a = itv[i][0];
            int b = itv[i][1];
            for (int j = i + 1; j < n; j++) {
                if (scan[j]) {
                    continue;
                }
                int c = itv[j][0];
                int d = itv[j][1];

                if (a <= c && b >= d) {
                    // System.out.println(i + " " + j);
                    scan[j] = true;
                }
            }
        }

        int res = 0;
        for (boolean b : scan) {
            if (b)
                res++;
        }

        return n-res;
    }
}