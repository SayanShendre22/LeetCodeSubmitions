class Solution {
    int[] parent;
    int[] minV;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        minV = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            minV[i] = Integer.MAX_VALUE;
        }

        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            int w = r[2];

            union(a, b, w);
        }

        return minV[findP(1)];
    }

    public void union(int a, int b, int w) {
        int pa = findP(a);
        int pb = findP(b);

        if (pa != pb) {
            parent[pb] = pa;
            minV[pa] = Math.min(minV[pa], Math.min(minV[pb], w));
        } else {
            minV[pa] = Math.min(minV[pa], w);
        }
    }

    public int findP(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findP(parent[a]);
    }
}