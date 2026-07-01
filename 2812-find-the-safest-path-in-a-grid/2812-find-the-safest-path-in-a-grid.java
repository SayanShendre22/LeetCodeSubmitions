class Solution {
    public int maximumSafenessFactor(List<List<Integer>> g) {
        int m = g.size();
        int n = g.get(0).size();

        if (g.get(0).get(0) == 1 || g.get(m - 1).get(n - 1) == 1) {
            return 0;
        }

        int risGrid[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                risGrid[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> thief = new LinkedList<>();

        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g.get(i).get(j) == 1) {
                    vis[i][j] = true;
                    thief.add(new int[] { i, j });
                }
            }
        }

        int level = 0;
        while (!thief.isEmpty()) {
            int size = thief.size();
            for (int x = 0; x < size; x++) {

                int[] cur = thief.poll();
                int i = cur[0];
                int j = cur[1];

                risGrid[i][j] = level;

                if (j < n - 1 && !vis[i][j + 1]) {
                    thief.offer(new int[] { i, j + 1 });
                    vis[i][j + 1] = true;
                }
                if (j > 0 && !vis[i][j - 1]) {
                    thief.offer(new int[] { i, j - 1 });
                    vis[i][j - 1] = true;
                }
                if (i < m - 1 && !vis[i + 1][j]) {
                    thief.offer(new int[] { i + 1, j });
                    vis[i+1][j] = true;
                }
                if (i > 0 && !vis[i - 1][j]) {
                    thief.offer(new int[] { i - 1, j });
                    vis[i - 1][j] = true;
                }

            }
            level++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0]-a[0]
                );

        pq.offer(new int[] { risGrid[0][0], 0, 0 });
        vis[0][0] = true;
        vis = new boolean[m][n];

        while (!pq.isEmpty()) {

            int cur[] = pq.poll();

            int safe = cur[0];
            int i = cur[1];
            int j = cur[2];

            if (i == m - 1 && j == n - 1)
                return safe;

            if (j < n - 1 && !vis[i][j + 1]) {
                pq.offer(new int[] { Math.min(safe, risGrid[i][j + 1]), i, j + 1 });
                vis[i][j + 1] = true;
            }
            if (j > 0 && !vis[i][j - 1]) {
                pq.offer(new int[] { Math.min(safe, risGrid[i][j - 1]), i, j - 1 });
                vis[i][j - 1] = true;
            }
            if (i < m - 1 && !vis[i + 1][j]) {
                pq.offer(new int[] { Math.min(safe, risGrid[i + 1][j]), i + 1, j });
                vis[i + 1][j] = true;
            }
            if (i > 0 && !vis[i - 1][j]) {
                pq.offer(new int[] { Math.min(safe, risGrid[i - 1][j]), i - 1, j });
                vis[i - 1][j] = true;
            }

        }

        return 0;

    }
}