class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                count = 1;
                i = i + 1;
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}