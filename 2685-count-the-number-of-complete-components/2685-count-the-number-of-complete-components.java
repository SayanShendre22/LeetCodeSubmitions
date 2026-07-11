class Solution {
    boolean vis[];
    int count = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            var l1 = map.get(a);
            l1.add(b);
            map.put(a, l1);
            var l2 = map.get(b);
            l2.add(a);
            map.put(b, l2);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;

            int ve[] = new int[] { 0, 0 };
            BFS(map, i, ve);

            if (ve[0] * (ve[0] - 1) == ve[1]) {
                count++;
            }

        }
        return count;
    }

    public void BFS(Map<Integer, List<Integer>> map, int i, int ve[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            ve[0] += 1;
            ve[1] += map.get(cur).size();

            for (int ad : map.get(cur)) {
                if (!vis[ad]) {
                    BFS(map, ad, ve);
                }
            }
        }
    }

    public void DFS(Map<Integer, List<Integer>> map, int i, int ve[]) {
        vis[i] = true;
        ve[0] += 1;
        ve[1] += map.get(i).size();

        for (int ad : map.get(i)) {
            if (!vis[ad]) {
                DFS(map, ad, ve);
            }
        }

    }
}