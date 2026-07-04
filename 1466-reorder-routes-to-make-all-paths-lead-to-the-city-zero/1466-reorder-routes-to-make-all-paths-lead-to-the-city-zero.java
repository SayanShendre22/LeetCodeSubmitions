class Solution {

    int count = 0;

    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            // original direction
            adj.get(u).add(v);

            // reverse direction (mark with negative)
            adj.get(v).add(-u);
        }

        boolean[] vis = new boolean[n];

        dfs(0, adj, vis);

        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {

        vis[node] = true;

        for (int next : adj.get(node)) {

            int actual = Math.abs(next);

            if (vis[actual])
                continue;

            // original edge, needs reversal
            if (next >= 0)
                count++;

            dfs(actual, adj, vis);
        }
    }
}