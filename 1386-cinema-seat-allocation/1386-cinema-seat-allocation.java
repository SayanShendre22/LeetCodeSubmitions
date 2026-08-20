class Solution {
    public int maxNumberOfFamilies(int n, int[][] reser) {
        int r = reser.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int res[] : reser) {
            int row = res[0];
            int col = res[1];
            map.put(row, map.getOrDefault(row, 0) | 1 << col);
        }

        int ans = (n - map.size()) * 2;

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int mask = mp.getValue();

            int maskA = 1 << 2 | 1 << 3 | 1 << 4 | 1 << 5;
            int maskB = 1 << 4 | 1 << 5 | 1 << 6 | 1 << 7;
            int maskC = 1 << 6 | 1 << 7 | 1 << 8 | 1 << 9;

            boolean left = (mask & maskA) == 0;

            boolean middle = (mask & maskB) == 0;

            boolean right = (mask & maskC) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;

    }
}