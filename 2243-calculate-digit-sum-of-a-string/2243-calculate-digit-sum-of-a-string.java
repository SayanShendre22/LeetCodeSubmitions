class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {

            int n = s.length();
            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < n; i += k) {
                int sum = 0;
                for (int j = i; j < Math.min(n, i + k); j++) {
                    sum += Integer.parseInt(s.charAt(j) + "");
                }
                cur.append(sum);
            }
            s=cur.toString();
        }
        return s;
    }
}