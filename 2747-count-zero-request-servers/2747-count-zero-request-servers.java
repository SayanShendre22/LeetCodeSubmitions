class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] qu) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = qu.length;
        Integer[] ids = new Integer[m];
        for (int i = 0; i < m; i++)
            ids[i] = i;

        Arrays.sort(ids, (i, j) -> Integer.compare(qu[i], qu[j]));

        int[] ans = new int[m];
        int[] cnt = new int[n + 1];

        int left = 0,
                right = 0,
                active = 0;

        for (int i : ids) {
            int q = qu[i];
            while (right < logs.length && logs[right][1] <= q) {
                int id = logs[right++][0];
                if (cnt[id]++ == 0) {
                    ++active;
                }
            }
            while (left < right && logs[left][1] < q - x) {
                int id = logs[left++][0];
                if (--cnt[id] == 0) {
                    --active;
                }
            }
            ans[i] = n - active;
        }
        return ans;
    }
}