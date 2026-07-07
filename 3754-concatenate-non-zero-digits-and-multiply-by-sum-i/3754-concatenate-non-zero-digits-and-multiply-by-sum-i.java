class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0)
            return 0;
        long sum = 0;
        long ans = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            if (c != '0') {
                sum += c - '0';
                ans = ans * 10 + c - '0';
            }
        }
        return ans * sum;
    }
}