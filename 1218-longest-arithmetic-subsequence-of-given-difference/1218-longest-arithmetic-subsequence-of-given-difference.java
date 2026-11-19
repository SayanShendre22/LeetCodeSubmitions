class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 0;

        for (int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, dp.get(num));
        }

        return res;
    }
}