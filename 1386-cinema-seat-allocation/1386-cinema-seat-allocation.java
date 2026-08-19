class Solution {
    public int maxNumberOfFamilies(int n, int[][] reser) {
        int r = reser.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int res[] : reser) {
            int row = res[0];
            int col = res[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int ans = (n - map.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> mp : map.entrySet()) {
            Set<Integer> cols = mp.getValue();

            boolean left = !cols.contains(2) &&
                    !cols.contains(3) &&
                    !cols.contains(4) &&
                    !cols.contains(5);

            boolean middle = !cols.contains(4) &&
                    !cols.contains(5) &&
                    !cols.contains(6) &&
                    !cols.contains(7);

            boolean right = !cols.contains(6) &&
                    !cols.contains(7) &&
                    !cols.contains(8) &&
                    !cols.contains(9);

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;

    }
}