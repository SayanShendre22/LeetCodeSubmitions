class Solution {
    int n;
    int col;
    List<List<Integer>> adj;
    int[][] up;
    int[] depth;
    int[] pow;

    final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        n = edges.length + 1;
        col = (int) (Math.log(n) / Math.log(2)) + 1;

        adj = new ArrayList<>();
        up = new int[n][col];
        depth = new int[n];
        pow = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            Arrays.fill(up[i], -1);
        }

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1);

        buildLifting();

        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (int) ((2L * pow[i - 1]) % MOD);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;

            int lca = findLCA(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            if (dist == 0)
                ans[i] = 0;
            else
                ans[i] = pow[dist - 1];
        }

        return ans;
    }

    private void dfs(int node, int parent) {

        up[node][0] = parent;

        for (int nxt : adj.get(node)) {

            if (nxt == parent)
                continue;

            depth[nxt] = depth[node] + 1;
            dfs(nxt, node);
        }
    }

    private void buildLifting() {

        for (int j = 1; j < col; j++) {

            for (int i = 0; i < n; i++) {

                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
    }

    private int findLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < col; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v)
            return u;

        for (int j = col - 1; j >= 0; j--) {

            if (up[u][j] != -1 && up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}