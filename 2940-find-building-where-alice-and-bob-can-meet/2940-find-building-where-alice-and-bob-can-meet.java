class Solution {
    int[] seg;
    int n;

    public void construtSeg(int i, int l, int r, int h[]) {
        if (l == r) {
            seg[i] = l;
            return;
        }

        int mid = l + (r - l) / 2;

        construtSeg(2 * i + 1, l, mid, h);
        construtSeg(2 * i + 2, mid + 1, r, h);

        seg[i] = h[seg[2 * i + 1]] > h[seg[2 * i + 2]] ? seg[2 * i + 1] : seg[2 * i + 2];
    }

    public int RMIQ(int i, int l, int r, int start, int end, int[] h) {
        if (l > end || r < start)
            return -1;

        if (l >= start && r <= end)
            return seg[i];

        int mid = l + (r - l) / 2;

        int left = RMIQ(2 * i + 1, l, mid, start, end, h);
        int right = RMIQ(2 * i + 2, mid + 1, r, start, end, h);

        if (left == -1)
            return right;

        if (right == -1)
            return left;

        return h[left] >= h[right] ? left : right;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        seg = new int[4 * n];

        construtSeg(0, 0, n - 1, heights);
        int ans[] = new int[queries.length];
        int x = 0;
        for (int[] q : queries) {
            int l = Math.min(q[0], q[1]);
            int r = Math.max(q[0], q[1]);

            if (l == r) {
                ans[x++] = l;
                continue;
            }

            if (heights[l] < heights[r]) {
                ans[x++] = r;
                continue;
            }

            int start = r + 1;
            int end = n - 1;
            int res = -1;

            while (start <= end) {

                int mid = start + (end - start) / 2;

                int idx = RMIQ(0, 0, n - 1, start, mid, heights);

                if (idx != -1 && heights[idx] > heights[l]) {
                    res = idx;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            ans[x++] = res;

        }
        return ans;
    }
}