// copied but understood the logic
class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
                adj.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            long time = edges[i][2];

            adj.get(u).add(new Pair(v, time, 0l));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            if(a.time != b.time)
                return Long.compare(a.time, b.time);
            return Long.compare(b.power, a.power);
        });

        long[][] status = new long[n][2];
        for(int i=0; i<n; i++){
            status[i][0] = Integer.MAX_VALUE;
            status[i][1] = Integer.MIN_VALUE;
        }

        pq.add(new Pair(source, 0, power));
        status[source][0] = 0;
        status[source][1] = power;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if(p.node == target)
                return new long[]{p.time, p.power};

            if(status[p.node][0] < p.time && status[p.node][1] >= p.power)
                continue;

            for(Pair nbr: adj.get(p.node)){
                long time = p.time + nbr.time;
                long currPower = p.power - cost[p.node];

                if(time < status[nbr.node][0] && currPower >= 0){
                    status[nbr.node][0] = time;
                    status[nbr.node][1] = currPower;
                    pq.add(new Pair(nbr.node, time, currPower));
                }else if(currPower>=0 && currPower > status[nbr.node][1]){
                    
                    status[nbr.node][0] = time;
                    status[nbr.node][1] = currPower;
                    pq.add(new Pair(nbr.node, time, currPower));
                }
            }
        }

        return new long[]{-1, -1};
    }
}

class Pair{
    int node;
    long time, power;
    public Pair(int node, long time, long power){
        this.node = node;
        this.time = time;
        this.power = power;
    }
}