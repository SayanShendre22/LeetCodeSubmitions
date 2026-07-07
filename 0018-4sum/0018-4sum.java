class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 4)
            return result;

        Arrays.sort(nums);

        for (int f = 0; f < n - 3; f++) {
            if (f > 0 && nums[f] == nums[f - 1])
                continue;
            for (int i = f + 1; i < nums.length - 2; i++) {

                if (i > f + 1 && nums[i] == nums[i - 1])
                    continue;

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum =  (long) nums[f] + nums[i] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[f], nums[i], nums[left], nums[right]));

                        // Skip duplicate left
                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        // Skip duplicate right
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}