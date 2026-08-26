class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int one = 0;
        String ans = "";

        int start = 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);

            if (c == '1') {
                one++;
            }

            while (one > k) {
                if (s.charAt(start) == '1') {
                    one--;
                }
                start++;
            }

            while (one == k && s.charAt(start) == '0') {
                start++;
            }

            if (one == k) {
                String cur = s.substring(start, end + 1);

                if (ans.isEmpty()
                        || ans.length() > cur.length()
                        || ans.length() == cur.length() && cur.compareTo(ans) < 0) {
                    ans = cur;
                }

            }
        }
        return ans;
    }
}