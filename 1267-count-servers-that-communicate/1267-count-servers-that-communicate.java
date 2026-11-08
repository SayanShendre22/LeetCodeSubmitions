class Solution {
    Set<String> set = new HashSet<>();

    public int countServers(int[][] g) {
        int m = g.length;
        int n = g[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    int row = 1;
                    for (int x = j + 1; x < n; x++) {
                        if (g[i][x] == 1) {
                            row++;
                            set.add(i * n + x + "");
                        }
                    }
                    if (row > 1)
                        set.add(i * n + j + "");

                    int col = 1;
                    for (int x = i + 1; x < m; x++) {
                        if (g[x][j] == 1) {
                            col++;
                            set.add(x * n + j + "");
                        }
                    }
                    if (col > 1)
                        set.add(i * n + j + "");
                }
            }
        }

        return set.size();
    }
}