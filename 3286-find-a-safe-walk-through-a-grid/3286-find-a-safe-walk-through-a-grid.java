class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int dist[][] = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new LinkedList<>();

        dq.offer(new int[] { grid.get(0).get(0), 0, 0 });
        dist[0][0] = grid.get(0).get(0);

        while (!dq.isEmpty()) {

            int cur[] = dq.poll();
            int cost = cur[0];
            int i = cur[1];
            int j = cur[2];

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

                    if (grid.get(ni).get(nj) == 0) {
                        dq.offerFirst(new int[] {
                                newCost,
                                ni,
                                nj
                        });
                    } else {
                        dq.offerLast(new int[] {
                                newCost,
                                ni,
                                nj
                        });
                    }

                }
            }
        }
        return false;
    }
}