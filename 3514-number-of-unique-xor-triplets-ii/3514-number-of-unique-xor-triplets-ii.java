class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 2048;

        boolean[] first = new boolean[max + 1];
        boolean[] second = new boolean[max + 1];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                first[nums[i] ^ nums[j]] = true;
            }
        }

        for (int i = 0; i < max; i++) {
            if (!first[i])
                continue;

            for (int v : nums) {
                second[i ^ v] = true;
            }
        }

        int count = 0;

        for (boolean x : second) {
            if (x)
                count++;
        }

        return count;
    }
}