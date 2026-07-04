class Solution {
    public int minReorder(int n, int[][] connections) {

        List<Set<Integer>> adjList = new ArrayList<>();
        List<Set<Integer>> newAdjList = new ArrayList<>();

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
            newAdjList.add(new HashSet<>());
        }

        for (int[] road : connections) {
            int a = road[0];
            int b = road[1];

            // original Adj-list
            adjList.get(a).add(b);

            // two way Adj-List
            newAdjList.get(a).add(b);
            newAdjList.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            vis[cur] = true;

            for (int nb : newAdjList.get(cur)) {

                if (vis[nb])
                    continue;

                if (!adjList.get(nb).contains(cur)) {
                    count++;
                }
                q.add(nb);
            }

        }

        return count;
    }
}