class Solution {
    Set<String> set = new HashSet<>();
    int max = 0;

    public List<String> removeInvalidParentheses(String s) {
        solve(0, new StringBuilder(), 0, s);
        return new ArrayList<String>(set);
    }

    public void solve(int i, StringBuilder sb, int count, String s) {
        if(count<0) return;

        if (i == s.length()) {
            if (count == 0) {

                if (max < sb.length()) {
                    max = sb.length();
                    set.clear();
                }

                if (sb.length() == max) {
                    set.add(sb.toString());
                }
            }
            return;
        }

        if (s.charAt(i) != ')' && s.charAt(i) != '(') {
            int len = sb.length();
            sb.append(s.charAt(i));
            solve(i + 1, sb, count, s);
            sb.setLength(len);
            return;
        }

        int len = sb.length();
        sb.append(s.charAt(i));
        solve(i + 1, sb, count + (s.charAt(i) == ')' ? -1 : 1), s);
        sb.setLength(len);

        solve(i + 1, sb, count, s);
    }
}