class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();

        if (grid.get(0).get(0) == 1 || grid.get(m - 1).get(n - 1) == 1)
            return 0;

        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        // Multi-source BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                int i = cur[0];
                int j = cur[1];

                dist[i][j] = level;

                if (i > 0 && !vis[i - 1][j]) {
                    vis[i - 1][j] = true;
                    q.offer(new int[] { i - 1, j });
                }

                if (i < m - 1 && !vis[i + 1][j]) {
                    vis[i + 1][j] = true;
                    q.offer(new int[] { i + 1, j });
                }

                if (j > 0 && !vis[i][j - 1]) {
                    vis[i][j - 1] = true;
                    q.offer(new int[] { i, j - 1 });
                }

                if (j < n - 1 && !vis[i][j + 1]) {
                    vis[i][j + 1] = true;
                    q.offer(new int[] { i, j + 1 });
                }
            }

            level++;
        }

        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);

        vis = new boolean[m][n];

        pq.offer(new int[] { dist[0][0], 0, 0 });
        vis[0][0] = true;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int i = cur[1];
            int j = cur[2];

            if (i == m - 1 && j == n - 1)
                return safe;

            if (i > 0 && !vis[i - 1][j]) {
                vis[i - 1][j] = true;
                pq.offer(new int[] {
                        Math.min(safe, dist[i - 1][j]),
                        i - 1,
                        j
                });
            }

            if (i < m - 1 && !vis[i + 1][j]) {
                vis[i + 1][j] = true;
                pq.offer(new int[] {
                        Math.min(safe, dist[i + 1][j]),
                        i + 1,
                        j
                });
            }

            if (j > 0 && !vis[i][j - 1]) {
                vis[i][j - 1] = true;
                pq.offer(new int[] {
                        Math.min(safe, dist[i][j - 1]),
                        i,
                        j - 1
                });
            }

            if (j < n - 1 && !vis[i][j + 1]) {
                vis[i][j + 1] = true;
                pq.offer(new int[] {
                        Math.min(safe, dist[i][j + 1]),
                        i,
                        j + 1
                });
            }
        }

        return 0;
    }
}