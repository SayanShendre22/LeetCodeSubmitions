class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] edges = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];

        for (int[] in : invocations) {
            edges[in[0]].add(in[1]);
            inDegree[in[1]]++;
        }

        boolean[] suspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int v : edges[cur]) {
                inDegree[v]--;

                if (!suspicious[v]) {
                    queue.offer(v);
                    suspicious[v] = true;
                }
            }
        }

        boolean remove = true;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                remove = false;
                break;
            } else if (!suspicious[i]) {
                res.add(i);
            }
        }

        if (!remove) {
            List<Integer> allNode = new ArrayList<>();
            for (int i = 0; i < n; i++)
                allNode.add(i);

            return allNode;
        }

        return res;

    }
}