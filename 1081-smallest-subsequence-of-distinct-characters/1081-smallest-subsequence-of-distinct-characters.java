
class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];
        boolean vis[] = new boolean[26];

        Stack<Character> stack = new Stack<>();

        int i = 0;
        for (char c : s.toCharArray()) {
            last[c - 'a'] = i;
            i++;
        }

        for (i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (vis[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                char p = stack.peek();
                if (last[p - 'a'] > i) {
                    vis[p - 'a'] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(c);
            vis[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    };
}