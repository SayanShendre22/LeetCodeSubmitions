class Solution {
    List<List<Integer>> it;
    long[][] dp;
    int[][][] path;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        it = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> x = new ArrayList<>(intervals.get(i));
            x.add(i);
            it.add(x);
        }

        it.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0)))
                return Integer.compare(a.get(0), b.get(0));
            if (!a.get(1).equals(b.get(1)))
                return Integer.compare(a.get(1), b.get(1));
            return Integer.compare(a.get(3), b.get(3));
        });

        dp = new long[n + 1][5];
        path = new int[n + 1][5][4];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j < 5; j++)
                Arrays.fill(path[i][j], -1);

        for (int i = n - 1; i >= 0; i--) {
            for (int cnt = 0; cnt < 5; cnt++) {
                dp[i][cnt] = dp[i + 1][cnt];
                path[i][cnt] = path[i + 1][cnt].clone();

                if (cnt == 4)
                    continue;

                int next = nextInt(i + 1, n, it.get(i).get(1));

                long take = it.get(i).get(2) + dp[next][cnt + 1];

                int[] takePath = path[next][cnt + 1].clone();
                takePath[cnt] = it.get(i).get(3);

                if (take > dp[i][cnt] ||
                    (take == dp[i][cnt] && smaller(takePath, path[i][cnt]))) {

                    dp[i][cnt] = take;
                    path[i][cnt] = takePath;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int x : path[0][0]) {
            if (x != -1)
                ans.add(x);
        }

        Collections.sort(ans);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }

    public boolean smaller(int[] a, int[] b) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int v : a)
            if (v != -1)
                x.add(v);

        for (int v : b)
            if (v != -1)
                y.add(v);

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i)))
                return x.get(i) < y.get(i);
        }

        return x.size() < y.size();
    }

    public int nextInt(int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (it.get(mid).get(0) > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}