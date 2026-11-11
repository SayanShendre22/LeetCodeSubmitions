class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
          if (need1 == need2 && need1 == 0)
            return 0;
            
        long both = Math.min(need1, need2);

        long res = both * Math.min(costBoth, (long) cost1 + cost2);

        need1 -= both;
        need2 -= both;

        res += (long) need1 * Math.min(cost1, costBoth);
        res += (long) need2 * Math.min(cost2, costBoth);

        return res;
    }
}