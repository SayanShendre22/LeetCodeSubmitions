class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { 0, 0 });

        int dir[][] = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
                { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }
        };

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int x = 0; x < size; x++) {
                int cur[] = q.poll();
                int i = cur[0];
                int j = cur[1];

                if (i == n - 1 && j == n - 1) {
                    return level + 1;
                }

                for (int d[] : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || nj < 0 || ni == n || nj == n) {
                        continue;
                    }

                    if (grid[ni][nj] == 0) {
                        grid[ni][nj] = 1;
                        q.offer(new int[] { ni, nj });
                    }

                }
            }
            level++;
        }

        return -1;
    }
}