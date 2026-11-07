class Solution {
    public int[] assignTasks(int[] s, int[] t) {
        int n = s.length, m = t.length;

        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        PriorityQueue<long[]> occupied = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) :
                      a[2] != b[2] ? Long.compare(a[2], b[2]) : 0
        );

        for (int i = 0; i < n; i++)
            free.offer(new int[]{s[i], i});

        int[] res = new int[m];
        long time = 0;

        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);

            while (!occupied.isEmpty() && occupied.peek()[0] <= time) {
                long[] cur = occupied.poll();
                free.offer(new int[]{(int)cur[1], (int)cur[2]});
            }

            if (free.isEmpty()) {
                time = occupied.peek()[0];

                while (!occupied.isEmpty() && occupied.peek()[0] <= time) {
                    long[] cur = occupied.poll();
                    free.offer(new int[]{(int)cur[1], (int)cur[2]});
                }
            }

            int[] cur = free.poll();
            int wt = cur[0], idx = cur[1];

            res[i] = idx;
            occupied.offer(new long[]{time + t[i], wt, idx});
        }

        return res;
    }
}