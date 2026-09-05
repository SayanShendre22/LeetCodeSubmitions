class Solution {
    node[] seg;

    public class node {
        int maxLen;
        int pre;
        int suff;
        char preCh;
        char sufCh;

        public node() {
            // defualt constructor
        }

        public node(int m, int p, int s, char pc, char sc) {
            maxLen = m;
            pre = p;
            suff = s;
            preCh = pc;
            sufCh = sc;
        }

    }

    public void build(int i, int l, int r, String s) {
        if (l == r) {
            seg[i] = new node(1, 1, 1, s.charAt(l), s.charAt(l));
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * i + 1, l, mid, s);
        build(2 * i + 2, mid + 1, r, s);

        seg[i] = merge(seg[2 * i + 1], seg[2 * i + 2], mid - l + 1, r - mid);
    }

    public node merge(node left, node right, int leftL, int rightL) {
        node res = new node();

        res.preCh = left.preCh;
        res.sufCh = right.sufCh;

        res.pre = left.pre;
        if (leftL == left.pre && left.sufCh == right.preCh) {
            res.pre = left.pre + right.pre;
        }

        res.suff = right.suff;
        if (rightL == right.suff && left.sufCh == right.preCh) {
            res.suff = right.suff + left.suff;
        }

        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.sufCh == right.preCh) {
            res.maxLen = Math.max(res.maxLen, left.suff + right.pre);
        }
        return res;
    }

    public void update(int i, int l, int r, int idx, char ch) {
        if (l == r) {
            seg[i] = new node(1, 1, 1, ch, ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            update(2 * i + 1, l, mid, idx, ch);
        } else {
            update(2 * i + 2, mid + 1, r, idx, ch);
        }

        seg[i] = merge(seg[2 * i + 1], seg[2 * i + 2], mid - l + 1, r - mid);
    }

    public int[] longestRepeating(String s, String qc, int[] qi) {
        int n = s.length();
        seg = new node[4 * n];

        build(0, 0, n - 1, s);

        int res[] = new int[qi.length];

        for (int i = 0; i < qi.length; i++) {
            int idx = qi[i];
            char ch = qc.charAt(i);

            update(0, 0, n - 1, idx, ch);

            res[i] = seg[0].maxLen;
        }
        return res;
    }
}