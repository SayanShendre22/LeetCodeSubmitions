class Solution {
    int parent[];

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff) {
                union(i, i + 1);
            }
        }

        boolean res[] = new boolean[queries.length];
        int x = 0;
        for (int q[] : queries) {
            int i = q[0];
            int j = q[1];
            if (find(i) == find(j)) {
                res[x] = true;
            }
            x++;
        }
        return res;
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}