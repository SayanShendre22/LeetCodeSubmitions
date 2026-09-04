class Solution {
    int[] seg;
    int n = 50000;

    public void update(int i, int l, int r, int idx, int val) {
        if (l == r) {
            seg[i] = val;
            return;
        }
        int mid = l + (r - l) / 2;

        if (idx <= mid)
            update(2 * i, l, mid, idx, val);
        else
            update(2 * i + 1, mid + 1, r, idx, val);

        seg[i] = Math.max(seg[2 * i], seg[2 * i + 1]);
    }

    public int query(int i, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return 0;

        if (ql <= l && r <= qr)
            return seg[i];

        int mid = l + (r - l) / 2;

        return Math.max(query(2 * i, l, mid, ql, qr), query(2 * i + 1, mid + 1, r, ql, qr));
    }

    public List<Boolean> getResults(int[][] que) {
        seg = new int[4 * (n + 1)];

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int[] q : que)
            if (q[0] == 1)
                set.add(q[1]);

        List<Integer> obs = new ArrayList<>(set);

        for (int i = 1; i < obs.size(); i++) {
            int cur = obs.get(i), prev = obs.get(i - 1);
            update(1, 0, n, cur, cur - prev);
        }

        List<Boolean> res = new ArrayList<>();

        for (int i = que.length - 1; i >= 0; i--) {
            if (que[i][0] == 2) {

                int x = que[i][1], len = que[i][2];

                Integer prev = set.floor(x);

                int best = query(1, 0, n, 0, prev);
                best = Math.max(best, x - prev);

                res.add(best >= len);
            } else {
                int ob = que[i][1];

                Integer prev = set.lower(ob);
                Integer higher = set.higher(ob);

                update(1, 0, n, ob, 0);

                if (higher != null)
                    update(1, 0, n, higher, higher - prev);

                set.remove(ob);
            }
        }
        Collections.reverse(res);
        return res;
    }
}