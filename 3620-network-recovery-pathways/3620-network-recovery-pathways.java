class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int[] ed : edges) {
            int a = ed[0];
            int b = ed[1];
            int cost = ed[2];

            if (!online[b] || !online[a]) {
                continue;
            }
            adjList.get(a).add(new int[] { b, cost });
            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }

        if (!check(adjList, l, k, n)) {
            return -1;
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(adjList, mid, k, n)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(List<List<int[]>> adj, int mid, long k, int n) {
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));

        dis[0] = 0;
        pq.offer(new long[] { 0, 0 }); // cost , node

        while (!pq.isEmpty()) {
            long cur[] = pq.poll();
            long cost = cur[0];
            int node = (int) cur[1];

            if (cost > k) {
                return false;
            }
            // end of path
            if (node == n - 1) {
                return true;
            }

            if(cost>dis[node]){
                continue;
            }

            for (int[] nb : adj.get(node)) {
                int v = nb[0];
                int w = nb[1];

                if (w < mid) {
                    continue;
                }

                if (dis[v] > dis[node] + w) {
                    dis[v] = dis[node] + w;
                    pq.offer(new long[] { dis[v], v });
                }
            }
        }
        return false;
    }
}