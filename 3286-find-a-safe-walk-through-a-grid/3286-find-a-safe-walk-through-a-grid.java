class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int dist[][] = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        pq.offer(new int[] { grid.get(0).get(0), 0, 0 });
        dist[0][0] = grid.get(0).get(0);

        while (!pq.isEmpty()) {

            int cur[] = pq.poll();
            int cost = cur[0];
            int i = cur[1];
            int j = cur[2];

            // if (cost != dist[i][j])
            //     continue;

            if (i == m - 1 && j == n - 1)
                return cost < health;

            int dir[][] = {
                    { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }
            };

            for (int[] d : dir) {
                int ni = d[0] + i;
                int nj = d[1] + j;

                if (ni < 0 || ni == m || nj < 0 || nj == n) {
                    continue;
                }

                int newCost = cost + grid.get(ni).get(nj);

                if (dist[ni][nj] > newCost) {
                    dist[ni][nj] = newCost;

                    pq.offer(new int[] {
                            newCost,
                            ni,
                            nj
                    });

                }
            }
        }
        return false;
    }
}