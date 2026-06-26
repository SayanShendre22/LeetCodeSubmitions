class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        generateSubSet(nums, 0, new ArrayList<>(), subset);

        int res = 0;

        for (List<Integer> lis : subset) {
            int xor = 0;
            for (int i : lis) {
                xor = xor ^ i;
            }
            res += xor;
        }

        return res;
    }

    public void generateSubSet(int nums[], int i, List<Integer> temp, List<List<Integer>> subset) {
        if (i == nums.length) {
            subset.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        generateSubSet(nums, i + 1, temp, subset);
        temp.remove(temp.size() - 1);
        generateSubSet(nums, i + 1, temp, subset);

    }
}