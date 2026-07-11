class Solution {
    int parent[];
    int size[];

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] ed : edges) {
            int a = ed[0];
            int b = ed[1];
            union(a, b);
        }

        for (int[] ed : edges) {
            int a = ed[0];
            int pv = find(a);
            map.put(pv, map.getOrDefault(pv, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                int node = size[i];
                int edge = map.getOrDefault(i, 0);
                if ((node * (node - 1)) / 2 == edge) {
                    res++;
                }
            }
        }
        return res;
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (size[pa] > size[pb]) {
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
        }
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}