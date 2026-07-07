class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        long sum = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int temp = n % 10;
            if (temp > 0) {
                sum += temp;
                sb.append(temp);
            }
            n=n/10;
        }
        long res = Integer.parseInt(sb.reverse().toString()) *sum;
        return res;
    }
}