class Solution {
    public int scoreOfParentheses(String s) {
        int d = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                d++;
            } else {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    res += 1 << (d - 1);
                }
                d--;
            }
        }
        return res;
    }
}