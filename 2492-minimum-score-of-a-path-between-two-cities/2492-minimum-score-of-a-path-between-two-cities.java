class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int w = road[2];

            adj.get(a).add(new int[] { b, w });
            adj.get(b).add(new int[] { a, w });
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int[] nb : adj.get(node)) {
                int next = nb[0];
                int wt = nb[1];
                res = Math.min(res, wt);

                if (!vis[next]) {
                    vis[next] = true;
                    q.add(next);
                }
            }
        }
        return res;
    }
}