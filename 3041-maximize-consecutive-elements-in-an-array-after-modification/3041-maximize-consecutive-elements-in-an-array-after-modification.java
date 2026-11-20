class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            int same = dp.getOrDefault(num - 1, 0) + 1;
            int inc = dp.getOrDefault(num, 0) + 1;

            dp.put(num, Math.max(dp.getOrDefault(num, 0), same));
            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), inc));

            res = Math.max(res, Math.max(dp.get(num), dp.get(num + 1)));
        }

        return res;
    }
}