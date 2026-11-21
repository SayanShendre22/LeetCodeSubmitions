class Solution {

    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    int res[];
    int last[];

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        res = new int[n];
        last = new int[26];

        Arrays.fill(res, 1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;
            adj.get(u).add(v);
        }

        bfs(0, s, parent);
        return res;
    }

    public void bfs(int cur, String s, int[] p) {
        int c = s.charAt(cur) - 'a';

        int nearAns = last[c];

        last[c] = cur;

        for (int a : adj.get(cur)) {
            bfs(a, s, p);
        }

        last[c] = nearAns;

        if (cur != 0) {
            int newP = p[cur];
            if (nearAns != -1) {
                newP = nearAns;
            }
            p[cur] = newP;
            res[newP] += res[cur];
        }

    }
}