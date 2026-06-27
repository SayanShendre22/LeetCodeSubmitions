class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long) x, map.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        for (long start : map.keySet()) {
            long cur = start;
            int len = 0;

            while (map.containsKey(cur)) {

                int freq = map.get(cur);

                //  case for 1
                if (cur == 1) {
                    len += (freq % 2 == 0) ? freq - 1 : freq;
                    break;
                }

                if (freq == 1) {
                    len++;
                    break;
                }

                // freq >= 2
                len += 2;

                //  overflow
                if (cur > (long) Math.sqrt(Long.MAX_VALUE)) {
                    break;
                }

                cur = cur * cur;
            }

            // If chain ended because next square doesn't exist,
            // remove one from the end (last node should contribute only one).
            if (!map.containsKey(cur) && len > 0) {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}