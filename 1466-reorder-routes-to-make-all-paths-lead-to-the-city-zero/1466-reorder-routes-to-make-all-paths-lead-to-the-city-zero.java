class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> newAdjList = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            newAdjList.add(new ArrayList<>());
        }

        for (int[] road : connections) {
            int a = road[0];
            int b = road[1];
            // two way Adj-List
            newAdjList.get(a).add(b);
            newAdjList.get(b).add(-a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            vis[Math.abs(cur)] = true;

            for (int nb : newAdjList.get(Math.abs(cur))) {

                if (vis[Math.abs(nb)])
                    continue;

                count += nb > 0 ? 1 : 0;

                q.add(nb);
            }
        }

        return count;
    }
}