class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int res[] = new int[n + 1];
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        for (int ad[] : times) {
            int u = ad[0];
            int v = ad[1];
            int t = ad[2];
            adj.get(u).add(new int[] { v, t });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return a[0] - b[0];
                    return a[1] - b[1];
                });

        res[k] = 0;
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int v = cur[1];
            int t = cur[0];

            for (int[] nb : adj.get(v)) {
                int nextV = nb[0];
                int nextT = nb[1];

                if (res[nextV] > nextT + t) {
                    res[nextV] = nextT + t;
                    pq.offer(new int[] { res[nextV], nextV });
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, res[i]);
        }
        return ans;
    }
}