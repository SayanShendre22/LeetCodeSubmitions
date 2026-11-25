class Solution {

    static final long BASE = 100006;
    static final long MOD = 1_000_000_007L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (minLen(mid, nums))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public boolean minLen(int len, int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        long hash = 0;
        long power = 1;

        // BASE^(len - 1)
        for (int i = 1; i < len; i++) {
            power = (power * BASE) % MOD;
        }

        // First window
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + nums[i]) % MOD;
        }

        map.put(hash, 1);

        // Remaining windows
        for (int i = len; i < nums.length; i++) {

            hash = (hash - (nums[i - len] * power) % MOD + MOD) % MOD;
            hash = (hash * BASE + nums[i]) % MOD;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1)
                return true;
        }

        return false;
    }
}
