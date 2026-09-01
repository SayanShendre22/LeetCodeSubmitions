class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> queue = new ArrayDeque<>();

        queue.offer(
                new State(
                        startR,
                        startC,
                        energy,
                        fullMask));

        visited[startR][startC][energy][fullMask] = true;

        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level = one number of moves.
            while (size-- > 0) {

                State cur = queue.poll();

                int r = cur.r;
                int c = cur.c;
                int e = cur.energy;
                int mask = cur.mask;

                // All litter collected.
                if (mask == 0) {
                    return moves;
                }

                /*
                 * If energy is 0, we cannot make another move.
                 *
                 * This is okay if we are already done,
                 * which was checked above.
                 */
                if (e == 0) {
                    continue;
                }

                for (int[] d : directions) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                            nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    /*
                     * Moving to the next cell costs one energy.
                     */
                    int newEnergy = e - 1;

                    /*
                     * R resets energy immediately to full.
                     */
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    /*
                     * If this is an uncollected litter,
                     * clear its bit.
                     */
                    if (classroom[nr].charAt(nc) == 'L') {

                        int id = litterId[nr][nc];

                        newMask &= ~(1 << id);
                    }

                    /*
                     * If we have already reached exactly the same
                     * state, there is no reason to visit it again.
                     */
                    if (visited[nr][nc][newEnergy][newMask]) {
                        continue;
                    }

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(
                            new State(
                                    nr,
                                    nc,
                                    newEnergy,
                                    newMask));
                }
            }

            moves++;
        }

        return -1;
    }

    static class State {

        int r;
        int c;
        int energy;
        int mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }
}