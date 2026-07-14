class Solution {
    int[][][] dp;

    long MOD = 1_000_000_000 + 7;

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int solve(int[] nums, int idx, int gcd1, int gcd2) {
        if (idx == nums.length) {
            if (gcd1 == gcd2 && gcd1 != 0) {
                return 1;
            }
            return 0;
        }

        if (dp[idx][gcd1][gcd2] != -1) {
            return dp[idx][gcd1][gcd2];
        }

        // skip
        long skip = solve(nums, idx + 1, gcd1, gcd2);

        // take 1
        long take1 = solve(nums, idx + 1, gcd(gcd1, nums[idx]), gcd2);

        // take 2
        long take2 = solve(nums, idx + 1, gcd1, gcd(gcd2, nums[idx]));

        return dp[idx][gcd1][gcd2] = (int) ((skip + take1 + take2) % MOD);
    }

    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];
        for (int[][] dp1 : dp) {
            for (int[] d : dp1) {
                Arrays.fill(d, -1);
            }
        }
        return solve(nums, 0, 0, 0);
    }
}